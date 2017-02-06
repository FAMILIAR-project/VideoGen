package videogen;

import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

public class Q9GenerateTBSwitch extends Q7VideoDurationSetterSwitch {

	public Q9GenerateTBSwitch() {
		super();
	}

	/**
	 *
	 * @param videoGenModel
	 * @return
	 */
	public static void generateThumbnails(VideoGeneratorModel videoGenModel){
		Q9GenerateTBSwitch m2t = new Q9GenerateTBSwitch();
 		m2t.doSwitch(videoGenModel);
	}

	@Override
	public Boolean caseVideoDescription(VideoDescription videoDesc) {
		String location = videoDesc.getLocation();
		FFMPEGHelper.generateThumbnail(location);
		return true;
	}

}
