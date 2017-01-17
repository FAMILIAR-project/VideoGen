package videogen

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.io.File

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
					println("Warning : ID @"+video.description.location+" is null")
				}else{
					var idv=video.description.videoid
					if (listID.contains(idv)){
						println("Warning : ID "+idv+" is not unique !")
					}else{
						listID.add(idv)
					}
				}
			}
			if (video instanceof OptionalVideoSeq){
				if (video.description.videoid.isNullOrEmpty){
					println("Warning : ID @"+video.description.location+" is null")
				}else{
					var idv=video.description.videoid
					if (listID.contains(idv)){
						println("Warning : ID "+idv+" is not unique !")
					}else{
						listID.add(idv)
					}
				}
			}
			if (video instanceof AlternativeVideoSeq){
				for (videscs:video.videodescs){
					if (videscs.videoid.isNullOrEmpty){
						println("Warning : ID @"+videscs.location+" is null")
					}else{
						var idv=videscs.videoid
						if (listID.contains(idv)){
							println("Warning : ID "+idv+" is not unique !")
						}else{
							listID.add(idv)
						}
					}
				}
			}
		}
	}
	
	def checkProbs(VideoGeneratorModel mod){
		var sumProbs = 0
		for (video:mod.videoseqs){
			if (video instanceof MandatoryVideoSeq){
				if (video.description.probability!=100||video.description.probability!=0){
					println("Warning : mandatory video @"+video.description.location+" got a non 100% probability")
				}
			}
			if (video instanceof AlternativeVideoSeq){
				for (videscs:video.videodescs){
					sumProbs+=videscs.probability
				}
				if (sumProbs!=100){
					println("Warning : sum of probability @"+video.videoid+" is not 100%")
				}
			}
		}
	}
	
	def checkLocations(VideoGeneratorModel mod){
		for (video:mod.videoseqs){
			if (video instanceof MandatoryVideoSeq){
				var location=video.description.location
				var file = new File(location)
				if (!file.exists()){
					println("Warning : video@"+location+" is missing")
				}
			}
			if (video instanceof OptionalVideoSeq){
				var location=video.description.location
				var file = new File(location)
				if (!file.exists()){
					println("Warning : video@"+location+" is missing")
				}
			}
			if (video instanceof AlternativeVideoSeq){
				for (videscs:video.videodescs){
					var location=videscs.location
					var file = new File(location)
					if (!file.exists()){
						println("Warning : video@"+location+" is missing")
					}
				}
			}
		}
	}
	def static void main(String[] args) {
		val vc = new VideogenChecking
		val fin = URI.createURI("perso.videogen")
		vc.videogenChecking(fin)
	}
}