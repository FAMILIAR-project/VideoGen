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
		//Generates an extended M3U file (There is a method for standard M3U as well)
		pst.playlistToM3UExtended(pst.videogenToPlaylistFull("foo2bis.videogen"));
		//Using the .jar app (in GUI mode) of FAMILIAR, we see that this feature model has 48 possible configurations The generated script is runnable in the FAMILIAR tool V1.1
		pst.videogenToFml("foo2bis.videogen");
		//Generates a videogen model from a given folder
		pst.videoGenFromFolder("Videos");
			
		
		/**
		 * What else.
		 * 
		 * I have been reading for such a long time the FAMILIAR's Documentation, I have understood what feature models are.
		 * Still, I don't get what is asked in question 15. I thought I had to develop subparts for Random, Probability and Configurator. so I started this :
		 * fmGen0 = FM (VideoGenerator: Mode ; Mode: (Random|Probability|Configurator);)
		   fmGen1 = FM (VideoGen : Type; Type: (Mandatory|Optional|Alternatives); Mandatory : VideoM; Optional: [VideoO]; Alternatives : (VideoA1|VideoA2|VideoA3);)
		   
		   But there is no points doing this as long as I have no idea how to make it possible to link fmGen1 to Random, Probability or Configurator. Moreover, I didn't find
		   how to make Alternatives have a list of Xor... Even with Unions or aggregation.
		   Next to this, I've tried FML basic and FML environment. I Liked it, but I think that I didn't get all the points of it.
		   Because I was curious, I decided to try to generate some FML files from videogen (as asked in the project's subject).
		   But if you have any correction of what was supposed to be done for the question number 15, I would be glad. 
		   
		   I wanted to do more bonus exercices, but I lack time and FFMPEG has bored me for now, and I haven't managed to understand what to do next with FAMILIAR...
		   Well, may be what I have done is good enough !
		   
		 */
		
	
		
	}

}
