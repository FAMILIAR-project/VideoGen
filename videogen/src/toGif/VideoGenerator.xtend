package toGif

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
		var Process processDuration = new ProcessBuilder("ffmpeg", "-y","-i", inputFile,outputFile+".gif").start()
		processDuration.waitFor()
	}
		
}
	
	
