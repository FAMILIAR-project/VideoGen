package videogen;

import java.io.File;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import org.xtext.example.mydsl.videoGen.util.VideoGenSwitch;

import videogen.vignette.FFMPEGHelper;

/**
 * Warning : as of now, this generator only works for AVI specified video files
 *
 * @author annaig
 *
 */
public class RandomVideoGeneratorSwitch extends VideoGenSwitch<Boolean> {

	public static VideoGeneratorModel loadVideoGenerator(URI uri) {
		VideoGenStandaloneSetupGenerated videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated();
		videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource resource = resourceSetImpl.getResource(uri, true);
		EObject eObject = resource.getContents().get(0);
		return (VideoGeneratorModel) eObject;
	}

	public static void main(String[] args) {

		URI createURI = URI.createURI("foo2_avi_only.videogen");
		VideoGeneratorModel videoGen = loadVideoGenerator(createURI);
		new RandomVideoGeneratorSwitch().doSwitch(videoGen);

	}
	@Override
	public Boolean caseVideoGeneratorModel(VideoGeneratorModel videoGenModel) {
		EList<VideoSeq> videoseqs = videoGenModel.getVideoseqs();
		for (VideoSeq videoseq : videoseqs) {
			doSwitch(videoseq);
		}
		return true;

	}

	@Override
	public Boolean caseVideoDescription(VideoDescription videoDesc) {
		String location = videoDesc.getLocation();
		generateRandomVideo(location);
		return true;
	}

	private void generateRandomVideo(String location) {
		File file = new File(location);
		if (file.exists())
			return;

		File parentFile = file.getParentFile();
		String parentPath = ".";
		if (parentFile != null) {
			parentPath = parentFile.getPath();
		}

		// if (file.exists()) {
		// try {
		// FileUtils.forceDelete(file);
		// } catch (IOException e) {
		// throw new RuntimeException(e);
		// }
		// }

		new File(parentPath).mkdirs();
		int duration = Utils.genRandomInt(10);
		System.out.println(String.format("Generating [%s] with duration = %d", location, duration));
		FFMPEGHelper.randomGenerationVideo(location, duration);
		System.out.println(" --> done");
	}

	@Override
	public Boolean caseMandatoryVideoSeq(MandatoryVideoSeq mandatoryVideoseq) {
		VideoDescription description = mandatoryVideoseq.getDescription();
		doSwitch(description);
		return true;
	}

	@Override

	public Boolean caseOptionalVideoSeq(OptionalVideoSeq optionalVideoseq) {
		VideoDescription description = optionalVideoseq.getDescription();
		doSwitch(description);
		return true;
	}

	@Override
	public Boolean caseAlternativeVideoSeq(AlternativeVideoSeq alternativeVideoseq) {
		EList<VideoDescription> videodescs = alternativeVideoseq.getVideodescs();
		for (VideoDescription desc : videodescs) {
			doSwitch(desc);
		}
		return true;
	}
}
