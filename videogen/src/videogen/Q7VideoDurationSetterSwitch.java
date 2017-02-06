package videogen;

import org.eclipse.emf.common.util.EList;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import org.xtext.example.mydsl.videoGen.util.VideoGenSwitch;

public class Q7VideoDurationSetterSwitch extends VideoGenSwitch<Boolean> {

	/**
	 *
	 * @param videoGenModel
	 * @return
	 */
	public static void assignDuration(VideoGeneratorModel videoGenModel){
		Q7VideoDurationSetterSwitch m2t = new Q7VideoDurationSetterSwitch();
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
		int duration = videoDesc.getDuration();
		if (duration == 0) {
			// only cmopute duration if not present (that is == 0)
			String location = videoDesc.getLocation();
			int computeDuration = FFMPEGHelper.computeDuration(location);
			videoDesc.setDuration(computeDuration);
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
		return true;
	}

	@Override
	public Boolean caseAlternativeVideoSeq(AlternativeVideoSeq alternativeVideoseq) {
		EList<VideoDescription> videodescs = alternativeVideoseq.getVideodescs();
		for (VideoDescription videoDesc : videodescs) {
			doSwitch(videoDesc);
		}
		return true;
	}

}
