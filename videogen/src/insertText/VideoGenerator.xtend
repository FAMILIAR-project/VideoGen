package insertText

import org.junit.Test
import java.io.BufferedReader
import java.nio.charset.Charset
import java.io.InputStreamReader

public class VideoGenerator {
	
	/**
	 * 
	 */
	 @Test
	def void generate(){
		var filePath="/home/loic/Videos/jean.mp4";
		var text="Loic";
		generateVideo("Test !!",filePath, "/home/loic/zd.mp4")
	}
	
	
	
	def generateVideo(String text, String inputFile, String outputFile){
		var Process processDuration = new ProcessBuilder("ffmpeg", "-y","-i", inputFile, "-vf", "drawtext=fontsize=40:fontcolor=white:text='"+text+"':x=(w-tw)/2:y=(h-th)/2",  outputFile).redirectErrorStream(true).start();

			var BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(processDuration.getInputStream(), Charset.defaultCharset()))
			    var String line;
			    while ((line = processOutputReader.readLine()) != null) {
						println(line)
						        
			    }
			    }
		
}
	
	
