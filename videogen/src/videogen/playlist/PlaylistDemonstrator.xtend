package videogen.playlist

import java.io.PrintWriter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.playlist.PlaylistStandaloneSetupGenerated
import org.xtext.example.playlist.playlist.Playlist
import org.xtext.example.playlist.playlist.impl.PlaylistFactoryImpl

import static org.junit.Assert.*

class PlaylistDemonstrator {
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def loadPlaylist(URI uri) {
		new PlaylistStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Playlist
	}
	
	@Test
	def videogenToPlaylist() {
		var videoGen = loadVideoGenerator(URI.createURI("test.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		var playlistFactory = new PlaylistFactoryImpl
		var playlist = playlistFactory.createPlaylist
		var videoseqs = videoGen.videoseqs
		println(videoseqs.size)
		for(videoseq : videoseqs) {
			var location = ''
			if (videoseq instanceof MandatoryVideoSeq) {
				location = (videoseq as MandatoryVideoSeq).description.location			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				location = (videoseq as OptionalVideoSeq).description.location
			}
			else {
				val alts = (videoseq as AlternativeVideoSeq).videodescs
				for(alt : alts) {
					location = alt.location
				}
			}
			var video = playlistFactory.createVideo
			video.location = location
			playlist.videos.add(video)
		}
		
		assertNotNull(playlist)
		assertEquals(7, playlist.videos.size)
		
		
		playlist2text(playlist)
	}
	
	def playlist2text(Playlist playlist) {
		val writer = new PrintWriter("test.m3u", "UTF-8")
		for(var i = 0; i < playlist.videos.size; i++) {
			writer.write(playlist.videos.get(i).location + "\n")
		}
		writer.close();
	}
}