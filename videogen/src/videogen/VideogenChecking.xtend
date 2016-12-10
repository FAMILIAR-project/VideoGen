package videogen

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq

class VideogenChecking {
	//Partie 5
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def videogenChecking(URI uri){
		var videogen = loadVideoGenerator(uri)
		checkIDs(videogen)
		checkProbs(videogen)
		checkLocations(videogen)
	}
	
	def checkIDs(VideoGeneratorModel mod){
		var listID=new ArrayList()
		for (video:mod.videoseqs){
			if (video instanceof MandatoryVideoSeq){
				if (video.description.videoid.isNullOrEmpty){
					println("Warning :")
				}
			}
			if (video instanceof OptionalVideoSeq){
				
			}
			if (video instanceof AlternativeVideoSeq){
				
			}
		}
	}
	
	def checkProbs(VideoGeneratorModel mod){
		
	}
	
	def checkLocations(VideoGeneratorModel mod){
		
	}
	def static void main(String[] args) {
		val vc = new VideogenChecking
		val fin = URI.createURI("test.videogen")
		vc.videogenChecking(fin)
	}
}