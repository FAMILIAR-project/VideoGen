package videogen

import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.util.Random
import java.io.FileWriter

class ModelToText{
<<<<<<< b2b6328e8a2fa021ca30e5db43a8460da211daa8
	//Partie 1
=======
	
>>>>>>> réponse question 1 et création modèle playlist
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def void modelToText(URI uri,FileWriter fout){
		var videogen = loadVideoGenerator(uri)
		val rnd = new Random()
<<<<<<< dd208ae18ad03eccf30f4fdb6d0b722a7f793ca6
<<<<<<< b2b6328e8a2fa021ca30e5db43a8460da211daa8
		fout.write("# this is a comment\n")
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
=======
=======
		
>>>>>>> jusqu'à Q7
		//println("# this is a comment")
		fout.write("# this is a comment\n")
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				//println("file '"+vid.description.location+"'")
>>>>>>> réponse question 1 et création modèle playlist
				fout.write("file '"+vid.description.location+"'\n")
			}
			if (vid instanceof OptionalVideoSeq){
				if (rnd.nextBoolean()){
<<<<<<< b2b6328e8a2fa021ca30e5db43a8460da211daa8
=======
					//println("file '"+vid.description.location+"'")
>>>>>>> réponse question 1 et création modèle playlist
					fout.write("file '"+vid.description.location+"'\n")
				}
			}
			if (vid instanceof AlternativeVideoSeq){
<<<<<<< b2b6328e8a2fa021ca30e5db43a8460da211daa8
				var n = rnd.nextInt(vid.videodescs.size)
=======
				
				var n = rnd.nextInt(vid.videodescs.size)
				//println("file '"+vid.videodescs.get(n).location+"'")
>>>>>>> réponse question 1 et création modèle playlist
				fout.write("file '"+vid.videodescs.get(n).location+"'\n")
			}
		]
		fout.close()
	}
	
	def static void main(String[] args) {
		//var in = args.get(1)
		val mtt = new ModelToText
		val fout = new FileWriter("foo2.ffm")
		mtt.modelToText(URI.createURI("foo2.videogen"),fout)
	}
}