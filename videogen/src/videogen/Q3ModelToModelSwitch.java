package videogen;

import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

import playlist.Playlist;
import playlist.PlaylistFactory;

public class Q3ModelToModelSwitch extends Q1ModelToTextSwitch{

	private Playlist videoList = null;

	public Q3ModelToModelSwitch() {
		super();
		videoList = PlaylistFactory.eINSTANCE.createPlaylist();
	}


	public static Playlist convertVideogenToPlaylist(VideoGeneratorModel inputVideogenModel){
		Q3ModelToModelSwitch m2m = new Q3ModelToModelSwitch();
		m2m.doSwitch(inputVideogenModel);
		Playlist videoList = m2m.getVideoList();
		return videoList;
	}



	public Playlist getVideoList() {
		return videoList;
	}



	public void setVideoList(Playlist videoList) {
		this.videoList = videoList;
	}
}
