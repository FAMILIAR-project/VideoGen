package m3uffmpeg

import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import static org.junit.Assert.*;
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.VideoDescription
import M3UPlaylist.Playlist
import M3UPlaylist.M3UPlaylistFactory
import M3UPlaylist.Entry

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
	
	def Playlist getSample(){
		var Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
		var Entry e1=M3UPlaylistFactory.eINSTANCE.createEntry()
		e1.path = "p1"
		var Entry e2=M3UPlaylistFactory.eINSTANCE.createEntry()
		e2.path = "p2"
		
		playlist.entries.add(e1)
		playlist.entries.add(e2)
		
		playlist
	}
	
	
}