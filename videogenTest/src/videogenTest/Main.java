package videogenTest;

import videogen.*;

public class Main {

	private static playlistTools pst=new playlistTools();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//pst.test1();
		//pst.genVignette("Videos/V6.mp4");
		//pst.genDuration("output.mp4");
		//pst.playlistToVignettes(pst.videogenToPlaylistFull("foo2bis.videogen"));
		//pst.videoGenToHTML("foo2bis.videogen");
		//pst.videogenGenerator("foo2bis.videogen");
		pst.genDuration("Videos/V6.mp4");
		pst.concatFFMPEG();
		pst.playlistToM3U(pst.videogenToPlaylistFull("foo2bis.videogen"));
	}

}
