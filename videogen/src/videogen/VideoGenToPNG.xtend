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

class VideoGenToPNG {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	@Test
	def test1() {
		// loading
		
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					ProcessFFMPEG.generateImage(desc.location)
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					ProcessFFMPEG.generateImage(desc.location)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if(vdesc.location.isNullOrEmpty) {
						ProcessFFMPEG.generateImage(vdesc.location)
					}
				}
			}
		]
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}