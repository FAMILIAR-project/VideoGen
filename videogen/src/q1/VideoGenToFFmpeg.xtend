package q1;

import java.util.List
import org.junit.Test
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import q11.VideoGenLoader

/**
 * VideoGen model to ffmpeg string
 */
public class VideoGenToFFmpeg {
	

	@Test
	def generate() {
		
		// Loading
		var videoGen = (new VideoGenLoader()).load("foo2.videogen")
		
		// Build sequence
		var finalVideo=(new SequenceGenerator(videoGen)).getSequence()
		
		// Print sequence
		for(f: finalVideo){
			print(f+"\n")
		}	
	}
	
	
	def List<String> generateStringList(VideoGeneratorModel videoGen){
		(new SequenceGenerator(videoGen)).getSequence()
	}
}