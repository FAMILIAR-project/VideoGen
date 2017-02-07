package videogen

import java.io.PrintWriter
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*

class VideoGenExtended2M3UExtended {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	@Test
	def test1() {
		// loading
		
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		
		val writer = new PrintWriter("ffmpeglist_for_question_8.txt", "UTF-8");
		writer.println("#EXTM3U")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					writer.println("#EXT-X-DISCONTINUITY")
					writer.println("#EXTINF:" + ProcessFFMPEG.getDuration(desc.location))
					writer.println(desc.location)
					writer.println()
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					writer.println("#EXT-X-DISCONTINUITY")
					writer.println("#EXTINF:" + ProcessFFMPEG.getDuration(desc.location))
					writer.println(desc.location)
					writer.println()
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videodescs.get(0).location.isNullOrEmpty) {
					writer.println("#EXT-X-DISCONTINUITY")
					writer.println("#EXTINF:" + ProcessFFMPEG.getDuration(altvid.videodescs.get(0).location))
					writer.println(altvid.videodescs.get(0).location)
					writer.println()
				}
			}
		]
		writer.close();
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}