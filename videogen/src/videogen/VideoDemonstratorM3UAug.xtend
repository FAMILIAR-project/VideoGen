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
 * Transformation xtend pour generer un script M3U à partir d'un model auquel on a rajouté la taille de la vidéo
 **/
class VideoDemonstratorM3UAug {
	
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
		var videoGen = loadVideoGenerator(URI.createURI("fooRealAug.videogen")) 
		assertNotNull(videoGen)
		//assertEquals(7, videoGen.videoseqs.size)			
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
	//Appelle d'une fonction qui va generer un script M3U
	printM3UAug(videoGen)
		 
			
	}
	
	//Fonction qui va generer un script M3U
	def void printM3UAug(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("#EXTM3U")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty)  
					println("#EXT-X-DISCONTINUITY")
					println("#EXTINF:"+ desc.duration) //on récupére la durée au lieu de la calculer
					println ("" + desc.location + "")		
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					val test = new Random().nextInt(100)
					if(test <= 50){
						println("#EXT-X-DISCONTINUITY")
						println("#EXTINF:"+ desc.duration) 
						println ("" + desc.location + "")	
					} 	 	
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val choix = new Random().nextInt(altvid.videodescs.size)
				val vdesc = altvid.videodescs.get(choix)	 
				if(!vdesc.videoid.isNullOrEmpty && !vdesc.location.isNullOrEmpty) 
					println("#EXT-X-DISCONTINUITY")
					println("#EXTINF:"+ vdesc.duration) 
					println ("" + vdesc.location + "")	
		
			}
		]
		println("#EXT-X-ENDLIST")
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
}