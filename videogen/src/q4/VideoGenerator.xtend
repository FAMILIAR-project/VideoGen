package q4

import org.junit.Test
import M3UPlaylist.Playlist
import M3UPlaylist.M3UPlaylistFactory
import M3UPlaylist.Entry
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
/**
 * Generate Simple playlist text
 */
public class VideoGenerator {
	

	
	@Test
	def void generate() {
		var Playlist playlist=getSample()
		
		var String text=new SequenceGenerator(playlist).getText()
		
		print(text)

	}
	
	def String getPlaylist(VideoGeneratorModel playlist){
		new SequenceGenerator((new q3.VideoGenerator()).getPlaylist(playlist)).getText()
	}
	
	def Playlist getSample(){
		var Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
		var Entry e1=M3UPlaylistFactory.eINSTANCE.createEntry()
		e1.path = "p1"
		e1.discontinuity = true;
		e1.duration=1;
		var Entry e2=M3UPlaylistFactory.eINSTANCE.createEntry()
		e2.path = "p2"
		
		playlist.entries.add(e1)
		playlist.entries.add(e2)
		
		playlist
	}
	
	
}