package videogen;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import org.xtext.example.mydsl.videoGen.util.VideoGenSwitch;

public class Q11VideoGenCheckerSwitch extends VideoGenSwitch<Boolean> {

	Set<String> encouteredIdentifiers;
	Set<String> encouteredLocations;

	public Q11VideoGenCheckerSwitch() {
		encouteredIdentifiers = new HashSet<String>();
		encouteredLocations = new HashSet<String>();
	}

	/**
	 *
	 * @param videoGenModel
	 * @return
	 */
	public static void check(VideoGeneratorModel videoGenModel){
		Q11VideoGenCheckerSwitch m2t = new Q11VideoGenCheckerSwitch();
 		m2t.doSwitch(videoGenModel);
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
		String videoid = videoDesc.getVideoid();
		if (videoid != null) {
			if (encouteredIdentifiers.contains(videoid)) {
				throw new VideoCheckException(videoid + " is present multiple times.");
			}
			encouteredIdentifiers.add(videoid);
		}

		String location = videoDesc.getLocation();
		if (location != null) {
			if (encouteredLocations.contains(location)) {
				throw new VideoCheckException(location + " is present multiple times.");
			}
			encouteredLocations.add(location);
		} else {
			throw new VideoCheckException("video location cannot be null");
		}
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
		doSwitch(description);
		int probability = description.getProbability();
		if (probability > 100 || probability < 0) {
			throw new VideoCheckException("probability of optional videos should be between 1 and 100");
		}
		return true;
	}

	@Override
	public Boolean caseAlternativeVideoSeq(AlternativeVideoSeq alternativeVideoseq) {
		EList<VideoDescription> videodescs = alternativeVideoseq.getVideodescs();

		int total = 0;
		for (VideoDescription videoDesc : videodescs) {
			doSwitch(videoDesc);
			int probability = videoDesc.getProbability();
			total += probability;
		}
		if (total > 100) {
			throw new VideoCheckException("sum of alternatives probability should not exceed 100");
		}
		return true;
	}

}
