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
import videogen.vignette.FFMPEGHelper

import static org.junit.Assert.*

class VideoDemonstrator {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
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
				if(desc.videoid.isNullOrEmpty)  desc.videoid = genID()  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID() 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		
	printToHTML(videoGen)
		 
			
	}
	
	@Test
	def testFilters() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("test.videogen"))			
		for(video : videoGen.videoseqs) {
			if(video instanceof MandatoryVideoSeq) {
				var videoMandatory = (video as MandatoryVideoSeq)
				var filter = videoMandatory.description.filter
				var location = videoMandatory.description.location
				var ffmpegHelper = new FFMPEGHelper
				var f = filter.filter
				ffmpegHelper.applyFilter(f, location, "filteredVideos/" + location)
			}
			else if (video instanceof OptionalVideoSeq) {
				val random = (Math.random() * 2) as int
				if(random == 1) {
					var videoOptional = (video as OptionalVideoSeq)
					var filter = videoOptional.description.filter
					var location = videoOptional.description.location
					var f = filter.filter
					var ffmpegHelper = new FFMPEGHelper
					ffmpegHelper.applyFilter(f, location, "filteredVideos/" + location)
				}
			}
			else {
				val alts = (video as AlternativeVideoSeq).videodescs
				val random = (Math.random() * alts.size) as int
				var videoAlt = alts.get(random)
				var location = videoAlt.location;
				var filter = videoAlt.filter
				var f = filter.filter
				var ffmpegHelper = new FFMPEGHelper
				ffmpegHelper.applyFilter(f, location, "filteredVideos/" + location)
			}
		}
	}
	
	@Test
	def testIncrustTextToVideo() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("test.videogen"))			
		for(video : videoGen.videoseqs) {
			if(video instanceof MandatoryVideoSeq) {
				var videoMandatory = (video as MandatoryVideoSeq)
				var text = videoMandatory.description.text
				if(text != null) {
					var location = videoMandatory.description.location
					var content = text.content
					var position = text.position
					var color = text.color
					var size = text.size
					var ffmpegHelper = new FFMPEGHelper
					ffmpegHelper.applyTextToVideo(content, color, position, size, location, "textIncrustedVideos/" + location)
				}
			}
			else if (video instanceof OptionalVideoSeq) {
				val random = (Math.random() * 2) as int
				if(random == 1) {
					var videoOptional = (video as OptionalVideoSeq)
					var text = videoOptional.description.text
					if(text != null) {
						var location = videoOptional.description.location
						var content = text.content
						var position = text.position
						var color = text.color
						var size = text.size
						var ffmpegHelper = new FFMPEGHelper
						ffmpegHelper.applyTextToVideo(content, color, position, size, location, "textIncrustedVideos/" + location)
					}
				}
			}
			else {
				val alts = (video as AlternativeVideoSeq).videodescs
				val random = (Math.random() * alts.size) as int
				var videoAlt = alts.get(random)
				var text = videoAlt.text
				if(text != null) {
					var location = videoAlt.location
					var content = text.content
					var position = text.position
					var color = text.color
					var size = text.size
					var ffmpegHelper = new FFMPEGHelper
					ffmpegHelper.applyTextToVideo(content, color, position, size, location, "textIncrustedVideos/" + location)
				}
			}
		}
	}
	
	def void printToHTML(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  
					println ("<li>" + desc.videoid + "</li>")  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) 
					println ("<li>" + desc.videoid + "</li>") 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					println ("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")
				for (vdesc : altvid.videodescs) {
					if(!vdesc.videoid.isNullOrEmpty) 
						println ("<li>" + vdesc.videoid + "</li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("</ul>")
			}
		]
		println("</ul>")
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}