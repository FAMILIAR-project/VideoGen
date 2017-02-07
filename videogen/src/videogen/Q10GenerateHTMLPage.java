package videogen;

import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

import videogen.vignette.FFMPEGHelper;

public class Q10GenerateHTMLPage extends Q7VideoDurationSetterSwitch {

	public Q10GenerateHTMLPage() {
		super();
		this.htmlBuffer = new StringBuffer();
	}

	/**
	 *
	 * @param videoGenModel
	 * @return
	 */
	public static String generateHTML(VideoGeneratorModel videoGenModel){
		Q10GenerateHTMLPage m2t = new Q10GenerateHTMLPage();
 		m2t.doSwitch(videoGenModel);
 		return m2t.getHtmlBuffer().toString();
	}

	private StringBuffer getHtmlBuffer() {
		return this.htmlBuffer;
	}

	private StringBuffer htmlBuffer = null;

	@Override
	public Boolean caseVideoGeneratorModel(VideoGeneratorModel videoGenModel) {
			htmlBuffer.append("<html>"
//					+ "<head></head>"
					+ "<body>\n");

			super.caseVideoGeneratorModel(videoGenModel);

			htmlBuffer.append("</body></html>\n");
		return true;
	}

	@Override
	public Boolean caseMandatoryVideoSeq(MandatoryVideoSeq mandatoryVideoseq) {
		htmlBuffer.append("<br/>\n");
		return super.caseMandatoryVideoSeq(mandatoryVideoseq);
	}

	@Override
	public Boolean caseOptionalVideoSeq(OptionalVideoSeq optionalVideoseq) {
		htmlBuffer.append("<br/>\n");
		return super.caseOptionalVideoSeq(optionalVideoseq);
	}

	@Override
	public Boolean caseAlternativeVideoSeq(AlternativeVideoSeq alternativeVideoseq) {
		htmlBuffer.append("<br/>\n");
		return super.caseAlternativeVideoSeq(alternativeVideoseq);
	}


	@Override
	public Boolean caseVideoDescription(VideoDescription videoDesc) {
		String location = videoDesc.getLocation();
		String thumbnailPath = FFMPEGHelper.generateThumbnail(location);
		htmlBuffer.append("<img src=\"" + thumbnailPath + "\"  style=\"width:120px;height:80px;\"  >\n");
		return true;
	}

}
