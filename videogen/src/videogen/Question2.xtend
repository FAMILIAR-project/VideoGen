package videogen

import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import playlist.Playlist
import playlist.PlaylistFactory
import java.util.Collections

class Question2 {
	def static loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def static saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	def static main(String[] args)
	{
		var videoGen = loadVideoGenerator(URI.createURI("mastaconcat.videogen"))
		val rand = new Random()
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist
		val cmd = "vlc play.m3u"
		videoGen.videoseqs.forEach[videoseq|
			if(videoseq instanceof MandatoryVideoSeq)
			{
				val mediafile = PlaylistFactory.eINSTANCE.createVideo
				mediafile.url = videoseq.description.location
				playlist.videos.add(mediafile)
			}
			if(videoseq instanceof OptionalVideoSeq)
			{
				if(rand.nextInt(2) == 1)
				{
					val mediafile = PlaylistFactory.eINSTANCE.createVideo
					mediafile.url = videoseq.description.location
					playlist.videos.add(mediafile)
				}
			}
			if(videoseq instanceof AlternativeVideoSeq)
			{
				val listAlt = (videoseq as AlternativeVideoSeq).videodescs
				val quicesera = rand.nextInt(listAlt.size)
				val mediafile = PlaylistFactory.eINSTANCE.createVideo
				mediafile.url = listAlt.get(quicesera).location
				playlist.videos.add(mediafile)
			}
		]
		Files.write(Paths.get("play.m3u"), 
			Collections.singletonList(PlaylistToText.playlistToText(playlist,"m3u"))
		)
		Runtime.runtime.exec(cmd)
		return
	}
}