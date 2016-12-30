package videogen.vignette

import java.io.File
import java.io.PrintWriter
import java.util.ArrayList
import java.util.HashSet
import org.eclipse.emf.common.util.URI
import org.junit.Test
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import videogen.VideoDemonstrator

import static org.junit.Assert.*

class VignetteGenerator {
	var vd = new VideoDemonstrator
	
	@Test
	def generateVignettes() {
		val ffmpeg = new FFMPEGHelper()
		var videoGen = vd.loadVideoGenerator(URI.createURI("test-vignette.videogen"))
		
		assertNotNull(videoGen)
		assertEquals(3, videoGen.videoseqs.size)
		
		val ids = new ArrayList<String>
		val locations = new ArrayList<String>
		
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				val path = desc.location
				ffmpeg.generateThumbnail(path, desc.videoid)
				ids.add(desc.videoid)
				locations.add(path)		
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val path = desc.location
				ffmpeg.generateThumbnail(path, desc.videoid)
				ids.add(desc.videoid)
				locations.add(path)
				if(desc.probability > 100 || desc.probability < 0) {
					println("Video with id " + desc.videoid + " has a bad probability")
				}
			}
			else {
				val videoseqAlt = (videoseq as AlternativeVideoSeq)
				var probability = 0
				for(VideoDescription video : videoseqAlt.videodescs) {
					ffmpeg.generateThumbnail(video.location, video.videoid)
					ids.add(video.videoid)
					locations.add(video.location)
					probability += video.probability
				}
				if(probability < 0 || probability > 100) {
					println("An alternative has a bad probability")
				}
			}	
		]
		
		var idsWithoutDuplicates = new HashSet<String>(ids)
		var locationsWithoutDuplicates = new HashSet<String>(locations)
		
		if(idsWithoutDuplicates.size != ids.size) {
			println("Some videos have the same identifier")
		}
		
		if(locationsWithoutDuplicates.size != locations.size) {
			println("Some videos have the same path (same name)")
		}
		
		var html = new File("vignettes.html");
		var writer = new PrintWriter("vignettes.html");
		writer.write(
			"<html><body>"
		);
		
		for(var i = 0; i < videoGen.videoseqs.size; i++) {
			var videoseq = videoGen.videoseqs.get(i)
			if(videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				val name = desc.videoid
				writer.write(
					"<div>
						<img src=./" + name +
						".png width=140 height=80 style=" +
						"\"" + "margin:10px" + "\"" + ">" +
					"</div>"
				)
			}
			
			else if(videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val name = desc.videoid
				writer.write(
					"<div>
						<img src=./" + name +
						".png width=140 height=80 style=" +
						"\"" + "margin:10px" + "\"" + ">" +
					"</div>"
				)
			}
			
			else {
				val videoseqAlt = (videoseq as AlternativeVideoSeq)
				writer.write("<div><span>")
				for(VideoDescription video : videoseqAlt.videodescs) {
					val name = video.videoid
					writer.write(
						"<img src=./" + name +
						".png width=140 height=80 style=" +
						"\"" + "margin:10px" + "\"" + ">"
					)
				}				
				writer.write(
					"</span></div>"
				)
			}
		}
		
		writer.write("</body></html>");
		writer.close();
	}	
}