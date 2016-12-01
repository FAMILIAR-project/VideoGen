package videogen;

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq

import static org.junit.Assert.*
import org.junit.Test
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import java.io.PrintWriter

public class ConcatenateVideoSeq {
	var vd = new VideoDemonstrator;
	
	def saveFile(URI uri) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		return rs;
	}
	
	def random(){
		
	}
	
	@Test
	def generateAllAlternatives() {
		// loading
		var videoGen = vd.loadVideoGenerator(URI.createURI("foo2.videogen"))
		val writer = new PrintWriter("test.txt", "UTF-8")
		
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				val path = desc.location
				writer.write("file '" + path + "'\n")
				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val videoseqOptional = (videoseq as OptionalVideoSeq)
				val random = (Math.random * 100);
				if(videoseqOptional.description.probability == 0 && random <= 50) {
					val desc = (videoseq as OptionalVideoSeq).description
					val path = desc.location
					writer.write("file '" + path + "'\n")
					
				}
				else if(random >= 0 && random <= videoseqOptional.description.probability) {
					val desc = (videoseq as OptionalVideoSeq).description
					val path = desc.location
					writer.write("file '" + path + "'\n")
					
				}
			}
			else {
				val videoseqAlt = (videoseq as AlternativeVideoSeq)
				val size = videoseqAlt.videodescs.size
				val random = Math.random * size
				val randomInt = random.intValue;
				val alt = videoseqAlt.videodescs.get(randomInt)
				val path = alt.location
				writer.write("file '" + path + "'\n")
				
			}
			
		]
		writer.close();
	}
}