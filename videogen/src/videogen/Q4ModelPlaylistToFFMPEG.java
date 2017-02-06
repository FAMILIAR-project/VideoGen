package videogen;

import org.eclipse.emf.common.util.EList;

import playlist.Media;
import playlist.Playlist;
import playlist.util.PlaylistSwitch;

public class Q4ModelPlaylistToFFMPEG extends PlaylistSwitch<Boolean>{
	private StringBuffer textBuffer = null;

	public StringBuffer getTextBuffer() {
		return textBuffer;
	}

	public Q4ModelPlaylistToFFMPEG() {
		super();
		textBuffer = new StringBuffer();
	}

	public static String modelToText(Playlist playlist){
		Q4ModelPlaylistToFFMPEG m2t = new Q4ModelPlaylistToFFMPEG();
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
		textBuffer.append("file '" + location + "'\n");
		return true;
	}
}
