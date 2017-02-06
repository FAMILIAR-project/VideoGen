package videogen;

import org.eclipse.emf.common.util.EList;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import org.xtext.example.mydsl.videoGen.util.VideoGenSwitch;

public class Q1ModelToTextSwitch extends VideoGenSwitch<Boolean> {

	private StringBuffer textBuffer = null;

	public StringBuffer getTextBuffer() {
		return textBuffer;
	}

	public Q1ModelToTextSwitch() {
		super();
		textBuffer = new StringBuffer();
	}

	/**
	 *
	 * @param videoGenModel
	 * @return
	 */
	public static String modelToText(VideoGeneratorModel videoGenModel){
		Q1ModelToTextSwitch m2t = new Q1ModelToTextSwitch();
 		m2t.doSwitch(videoGenModel);
 		String text = m2t.getTextBuffer().toString();
 		return text;
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
		textBuffer.append("file '" + location + "'\n");
		return true;
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
		int probability = description.getProbability();
		int nombreAleatoire = Utils.genRandomInt(100);
		if (probability == 0) {
			probability = 50;
		}
		if (nombreAleatoire < probability) {
			doSwitch(description);
		}
		return true;
	}

	@Override
	public Boolean caseAlternativeVideoSeq(AlternativeVideoSeq alternativeVideoseq) {
		EList<VideoDescription> videodescs = alternativeVideoseq.getVideodescs();
		int nbAlternative = videodescs.size();
		int nombreAleatoire = Utils.genRandomInt(nbAlternative) - 1;
		VideoDescription alternativeSelectionnee = videodescs.get(nombreAleatoire);
		doSwitch(alternativeSelectionnee);
		return true;
	}

}
