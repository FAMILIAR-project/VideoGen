package videogenTest;

import videogen.*;

public class Main {

	private static playlistTools pst=new playlistTools();
	
	public static void main(String[] args) {
		//Generates all the pictures for the videos described in the given file
		pst.playlistToVignettes(pst.videogenToPlaylistFull("foo2bis.videogen"));
		//generates an HTML file given the videogen model
		pst.videoGenToHTML("foo2bis.videogen");
		//Concatenates files given in out.ffmpeg
		pst.concatFFMPEG();
		//Generates an extended M3U file
		pst.playlistToM3UExtended(pst.videogenToPlaylistFull("foo2bis.videogen"));
		//Using the .jar app (in GUI mode) of FAMILIAR, we see that this feature model has 48 possible configurations The generated script is runnable in the FAMILIAR tool V1.1
		pst.videogenToFml("foo2bis.videogen");
		//Generates a videogen model from a given folder
		pst.videoGenFromFolder("Videos");
		
	}

}
