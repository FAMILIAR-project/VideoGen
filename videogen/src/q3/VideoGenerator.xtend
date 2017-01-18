package q3

import M3UPlaylist.Playlist
import org.junit.Test
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import q11.VideoGenLoader

/**
 * Video to M3U Model
 */
public class VideoGenerator {

	
	@Test
	def generate() {
		
		// Loading
		var videoGen = (new VideoGenLoader()).load("foo2.videogen")
		
		// Build playlist
		var finalPlaylist=(new SequenceGenerator(videoGen)).getPlaylist()


		//var Diagnostic validate = Diagnostician.INSTANCE.validate(finalPlaylist);
	  	//assertEquals(Diagnostic.OK, validate.getSeverity());
	
		var entries=finalPlaylist.getEntries()
		
		println("Generated playlist model :")
		for(e:entries){
			println(e.path)
		}
			
	}
	
	def Playlist generatePlaylist(VideoGeneratorModel videoGen){
		(new SequenceGenerator(videoGen)).getPlaylist()
	}
	
}