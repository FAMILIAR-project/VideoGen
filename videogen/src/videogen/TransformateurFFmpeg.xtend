package videogen

import java.util.HashMap
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
import org.xtext.example.mydsl.videoGen.VideoDescription

class TransformateurFFmpeg {
	
	def loadVideoGenerator(URI uri
	) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	static var res = ""
	
	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				res += ecrireLigne(desc)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				res += ecrireLigne(desc) 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					res += ecrireLigne(vdesc)
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)		
	System.out.println(res) 
			
	}
	
	@Test
	def m3uExt() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)

		res += "#EXTM3U\n"
		
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				res += ecrireBlocM3U(desc)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				res += ecrireBlocM3U(desc) 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					res += ecrireBlocM3U(vdesc)
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)		
	System.out.println(res) 
		
	}
	
	@Test
	def vignettes() {
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)		
				
		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				var name = desc.location.substring(0, desc.location.lastIndexOf('.'))
				var cmd = "ffmpeg -y -i " + desc.location + " -r 1 -t 00:00:01 -ss 00:00:$2 -f image2 vignettes/" + name + ".png"
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var name = desc.location.substring(0, desc.location.lastIndexOf('.'))
				var cmd = "ffmpeg -y -i " + desc.location + " -r 1 -t 00:00:01 -ss 00:00:$2 -f image2 vignettes/" + name + ".png" 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					var name = vdesc.location.substring(0, vdesc.location.lastIndexOf('.'))
					var cmd = "ffmpeg -y -i " + vdesc.location + " -r 1 -t 00:00:01 -ss 00:00:$2 -f image2 vignettes/" + name + ".png"
				}
			}	
		]
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
	def ecrireLigne(VideoDescription desc){
		var tmp = "file "
		tmp += desc.location
		tmp += "\n"	
		return tmp
	}
	
	def ecrireBlocM3U(VideoDescription desc){
		var tmp = "file"
		tmp += "#EXTINF:"
		tmp += desc.duration
		tmp += ","
		var name = desc.location.substring(0, desc.location.lastIndexOf('.'))
		tmp += name
		tmp += "\n"
		tmp += desc.location
		return tmp
	}
	
}
