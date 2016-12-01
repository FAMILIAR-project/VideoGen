package videogen.vignette

import java.io.File
import org.eclipse.emf.common.util.URI
import org.junit.Test
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import videogen.VideoDemonstrator

import static org.junit.Assert.*
import java.io.OutputStreamWriter
import java.io.OutputStream
import java.io.PrintWriter

class VignetteGenerator {
	var vd = new VideoDemonstrator
	
	@Test
	def generateVignettes() {
		val ffmpeg = new FFMPEGHelper()
		var videoGen = vd.loadVideoGenerator(URI.createURI("test-vignette.videogen"))
		assertNotNull(videoGen)
		assertEquals(3, videoGen.videoseqs.size)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				val path = desc.location
				ffmpeg.generateThumbnail(path, desc.videoid)			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val path = desc.location
				ffmpeg.generateThumbnail(path, desc.videoid)
			}
			else {
				val videoseqAlt = (videoseq as AlternativeVideoSeq)
				for(VideoDescription video : videoseqAlt.videodescs) {
					ffmpeg.generateThumbnail(video.location, video.videoid)
				}
			}	
		]
	}
	
	@Test
	def generateHTML() {
		var html = new File("vignettes.html");
		var writer = new PrintWriter("vignettes.html");
		writer.write(
			"<html><body>"
		);
		
		// for(...)
		
		writer.write("</body></html>");
		writer.close();
	}
}