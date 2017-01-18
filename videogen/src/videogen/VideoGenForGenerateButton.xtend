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

class VideoGenForGenerateButton {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def generateHTMLResp() {
		// loading
		
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		val resp = new StringBuilder()
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					resp.append("<p> video : " + desc.location + "</p>")
					resp.append("<img src='" + desc.location.split("\\.").get(0) + ".png' />")
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					resp.append("<p> video : " + desc.location + "</p>")
					resp.append("<img src='" + desc.location.split("\\.").get(0) + ".png' />")
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videodescs.get(0).location.isNullOrEmpty) {
					resp.append("<p> video : " + altvid.videodescs.get(0).location + "</p>")
					resp.append("<img src='" + altvid.videodescs.get(0).location.split("\\.").get(0) + ".png' />")
				}
			}
		]
		resp.toString
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}