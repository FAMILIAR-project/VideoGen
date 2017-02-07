package q9

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.nio.file.Paths
import org.junit.Test
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import q11.VideoGenLoader

/**
 * Generate Vignettes of VideoGen model to a specified folder
 */
public class VideoGenerator {
	

	@Test
	def generate() {
		
		// Please edit test.videogen to get real file
		var videoGen = (new VideoGenLoader()).load("test.videogen")
		
		// Please edit path of destination
		generateVignettes(videoGen, "/home/loic/test")
		
	}
	
	
	
	def generateVignettes(VideoGeneratorModel videoGen, String folder){
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				generateVignette(desc, folder)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				generateVignette(desc, folder)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					generateVignette(vdesc, folder)
				}
				
			}
		]
	}
	
	def generateVignette(VideoDescription desc, String folder){
		var Process processDuration = new ProcessBuilder("ffmpeg","-y", "-i", desc.location, "-r", "1", "-t", "00:00:01", "-ss", "00:00:2",Paths.get(folder,desc.videoid)+".png"  ).redirectErrorStream(true).start();
			
		var BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(processDuration.getInputStream(), Charset.defaultCharset()))
		    var String line;
		    while ((line = processOutputReader.readLine()) != null) {
	
				println(line)		        
		    }
		    processDuration.waitFor();
			
		
		} 	
		
}
	
	
	
