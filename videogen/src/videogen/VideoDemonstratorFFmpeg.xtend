package videogen

import java.util.HashMap
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
import java.util.Random

/**
 * Transformation xtend pour generer un script FFmpeg (Question 1)
 **/
class VideoDemonstratorFFmpeg {
	
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
		var videoGen = loadVideoGenerator(URI.createURI("fooReal.videogen")) 
		assertNotNull(videoGen)	
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty)  desc.videoid = genID() 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID() 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
			}
		]
		// serializing
		saveVideoGenerator(URI.createURI("fooRealOut.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("fooRealOut.videogen"), videoGen)		
	    // Appel de la fonction pour generer en sortie un script FFmpeg	 
		printFFmpeg(videoGen)		
	}
	
	//Fonction qui genere en sortie le FFmpeg en tenant compte des cas optionnal et alternatives
	def void printFFmpeg(VideoGeneratorModel videoGen) {
		println("#Sequence FFmpeg generate")
		videoGen.videoseqs.forEach[videoseq | 
			//Cas video obligatoire
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty)  
					println ("file '" + desc.location + "'")  				
			}
			//Cas video optionnelle
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					val test = new Random().nextInt(100) //Generer un nombre entre 0 et 100
					println("#TestRes:" + test)
					if(test <= 50){ //Si le nombre est en dessous de 50: on rajoute la video optionnelle
						println ("file '" + desc.location + "'")
					} 	 	
				}
			}
			//Cas video alternative
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				//On récupere la taille de la liste et on genere un entier aléatoire pour chosir la video 
				val choix = new Random().nextInt(altvid.videodescs.size)
				println("#Choix:" + choix)
				val vdesc = altvid.videodescs.get(choix)	 
				if(!vdesc.videoid.isNullOrEmpty && !vdesc.location.isNullOrEmpty) 
					println ("file '" + vdesc.location + "'") 
		
			}
		]
		println("#End of generation")
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}