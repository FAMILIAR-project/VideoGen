package videogen;

import org.eclipse.emf.common.util.EList;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

import playlist.Media;
import playlist.Playlist;
import playlist.util.PlaylistSwitch;

public class Q3ModelPlaylistToM3USwitch extends PlaylistSwitch<Boolean>{

	private StringBuffer textBuffer = null;

	public StringBuffer getTextBuffer() {
		return textBuffer;
	}

	public Q3ModelPlaylistToM3USwitch() {
		super();
		textBuffer = new StringBuffer();
	}

	public static String modelToText(Playlist playlist){
		Q3ModelPlaylistToM3USwitch m2t = new Q3ModelPlaylistToM3USwitch();
 		m2t.doSwitch(playlist);
 		String text = m2t.getTextBuffer().toString();
 		return text;
	}
	
	@Override
	public Boolean casePlaylist(Playlist playlist) {
		EList<Media> medias = playlist.getMedia();
		for (Media media : medias) {
			doSwitch(media);
		}
		return true;
	}
	
	@Override
	public Boolean caseMedia(Media media) {
		String location = media.getLocation();
		textBuffer.append(location + "\n");
		return true;
	}
}
