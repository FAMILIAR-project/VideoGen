package exercice.supplementaire3

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
import java.util.ArrayList
import videogen.ProcessFFMPEG

class Gification {
	
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
		var aa = new ArrayList()
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)

		
	ProcessGIF(videoGen,aa)
	ProcessFFMPEG.generateGIF(aa) 
			
	}
	
	def void ProcessGIF(VideoGeneratorModel videoGen ,ArrayList aa) {
		 val writer = new PrintWriter("ffmpeglist.txt", "UTF-8");
		//var numSeq = 1
		//xx = xx + "# this is a comment";
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  
                 aa.add(desc.location)			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) 
                aa.add(desc.location)			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videodescs.get(0).videoid.isNullOrEmpty) 
                aa.add(altvid.videodescs.get(0).location)			}
		]	
	
		writer.close();
		//Runtime.getRuntime().exec("ffmpeg -f concat -i ffmpeglist.txt -c copy output");
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}