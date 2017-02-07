package videogen.playlist

import java.io.PrintWriter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test


import static org.junit.Assert.*
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.PlaylistStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.Playlist
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import playlist.impl.PlaylistFactoryImpl

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
				var video = playlistFactory.createVideo
				video.location = location
				playlist.videos.add(video)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val random = (Math.random() * 2) as int
				if(random == 1) {
					location = (videoseq as OptionalVideoSeq).description.location
					var video = playlistFactory.createVideo
					video.location = location
					playlist.videos.add(video)
				}
			}
			else {
				val alts = (videoseq as AlternativeVideoSeq).videodescs
				val random = (Math.random() * alts.size) as int
				location = alts.get(random).location;
				
				var video = playlistFactory.createVideo
				video.location = location
				playlist.videos.add(video)
			}
		}
		
		assertNotNull(playlist)
		
		
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