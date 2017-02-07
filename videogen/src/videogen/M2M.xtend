package videogen

import java.util.HashMap
import java.io.PrintWriter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel


import static org.junit.Assert.*
import java.util.Collections
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl
import java.io.File
import org.xtext.example.playlist.m3u.m3U.Model
import org.xtext.example.playlist.m3u.m3U.impl.M3UFactoryImpl

class M2M {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def savePlaylistGenerator(URI uri, Model pollS) {
		val m = Resource.Factory.Registry.INSTANCE.extensionToFactoryMap
		m.put("model", new XMIResourceFactoryImpl())
		println(uri)
		println(pollS.listVideo)
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		
		println(rs)
		rs.contents.add(pollS); 
		println(uri)
		rs.save(Collections.EMPTY_MAP);
	}
	
	@Test
	def transformVideoGen2Playlist() {
		// loading
		
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		val playlistModel = M3UFactoryImpl.init.createModel
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					 val vid = M3UFactoryImpl.init.createVideo
					 vid.location = desc.location
					 playlistModel.listVideo.add(vid)
				} 
					
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					val vid = M3UFactoryImpl.init.createVideo
					 vid.location = desc.location
					 playlistModel.listVideo.add(vid)	
				}
					
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videodescs.get(0).location.isNullOrEmpty) {
					val vid = M3UFactoryImpl.init.createVideo
					 vid.location = altvid.videodescs.get(0).location
					 playlistModel.listVideo.add(vid)	
				}
					
			}
		]	
		savePlaylistGenerator(URI.createURI(new File("foo2m3u.xmi").absolutePath), playlistModel)
	}
	
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}