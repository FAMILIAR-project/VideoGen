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

//QUESTION 12 : VERIFICATION DE VIDEOGEN
class VideoGenVerificator {
	
	def static void main(String[] args) {
		val vc = new VideoGenVerificator
		val filename = URI.createURI("foo3.videogen")
		vc.verifieVideoGen(filename)
	}
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def verifieVideoGen(URI uri){
		var videoGen = loadVideoGenerator(uri)
		verifieId(videoGen)
		verifieLocation(videoGen)
	}
	
	def verifieId(VideoGeneratorModel videoGen){
		val listId = <String> newArrayList()
		println("ID VERIFICATION")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (desc.videoid != null) {
					if (listId.contains(desc.videoid)) {
						println("[ID ERREUR]: " + desc.videoid + " existe déja !")
					} else {
						listId.add(desc.videoid)
					}
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (desc.videoid != null) {
					if (listId.contains(desc.videoid)) {
						println("[ID ERREUR] : " + desc.videoid + " existe déja !")
					} else {
						listId.add(desc.videoid)
					}
				}
			} else {
				val desc = (videoseq as AlternativeVideoSeq)
				if (desc.videoid != null) {
					if (listId.contains(desc.videoid)) {
						println("[ID ERREUR] : " + desc.videoid + " existe déja !")
					} else {
						listId.add(desc.videoid)
					}
				}
				for (vdesc : desc.videodescs) {
					if (vdesc.videoid != null) {
						if (listId.contains(vdesc.videoid)) {
						println("[ID ERREUR] l'id : " + vdesc.videoid + " existe déja !")
						} else {
							listId.add(vdesc.videoid)
						}
					}
				}
			}
		]
	}

	def verifieLocation(VideoGeneratorModel videoGen){
		println("LOCATION VERIFICATION")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!new File(desc.location).exists()) {
					println("[LOCATION ERREUR] le chemin : " + desc.location + "est introuvable !");
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!new File(desc.location).exists()) {
					println("[LOCATION ERREUR] le chemin : " + desc.location + "est introuvable !");
				}
			} else {
				val desc = (videoseq as AlternativeVideoSeq)
				for (vdesc : desc.videodescs) {
				if (!new File(vdesc.location).exists()) {
					println("[LOCATION ERREUR] le chemin : " + vdesc.location + "est introuvable !");
				}
				}
			}
		]
	}
}