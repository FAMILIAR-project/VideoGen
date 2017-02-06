package videogen;

import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

public class Q8ModelToXM3USwitch extends Q1ModelToTextSwitch {

	public Q8ModelToXM3USwitch() {
		super();
	}

	/**
	 *
	 * @param videoGenModel
	 * @return
	 */
	public static String modelToXM3U(VideoGeneratorModel videoGenModel){
		// make sure all duartions are computed first.
		Q7VideoDurationSetterSwitch.assignDuration(videoGenModel);
		// then generate the extended M3U
		Q8ModelToXM3USwitch m2t = new Q8ModelToXM3USwitch();
 		m2t.doSwitch(videoGenModel);
 		String text = m2t.getTextBuffer().toString();
 		return text;
	}

	@Override
	public Boolean caseVideoGeneratorModel(VideoGeneratorModel videoGenModel) {
		getTextBuffer().append("#EXTM3U \n");
		super.caseVideoGeneratorModel(videoGenModel);
		getTextBuffer().append("#EXT-X-ENDLIST \n");
		return true;
	}

	@Override
	public Boolean caseVideoDescription(VideoDescription videoDesc) {
		String location = videoDesc.getLocation();
		int duration = videoDesc.getDuration();
		getTextBuffer().append("#EXT-X-DISCONTINUITY \n");
		getTextBuffer().append("#EXTINF:" + duration + "\n");
		getTextBuffer().append(location + "\n");
		return true;
	}

}
