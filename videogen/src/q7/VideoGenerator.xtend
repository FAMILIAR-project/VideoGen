package q7

import org.junit.Test
import M3UPlaylist.Playlist
import M3UPlaylist.M3UPlaylistFactory
import M3UPlaylist.Entry
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.List

/**
 * M3U Model to M3U Text
 */
public class VideoGenerator {
	

	
	@Test
	def void generate() {
		var Playlist playlist=getSample()
		
		var String text=new SequenceGenerator(playlist).getText()
		
		print(text)

	}
	
	def List<String> generateStringList(Playlist playlist){
		new SequenceGenerator(playlist).getSequence()
	}
	
	def Playlist getSample(){
		var Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
		var Entry e1=M3UPlaylistFactory.eINSTANCE.createEntry()
		e1.path = "p1"
		e1.discontinuity = true;
		e1.duration=1;
		var Entry e2=M3UPlaylistFactory.eINSTANCE.createEntry()
		e2.discontinuity = true;
		e2.path = "p2"
		
		playlist.entries.add(e1)
		playlist.entries.add(e2)
		
		playlist
	}
	
	
}