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
	//Partie 1
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def void modelToText(URI uri,FileWriter fout){
		var videogen = loadVideoGenerator(uri)
		val rnd = new Random()
		fout.write("# this is a comment\n")
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				fout.write("file '"+vid.description.location+"'\n")
			}
			if (vid instanceof OptionalVideoSeq){
				if (rnd.nextBoolean()){
					fout.write("file '"+vid.description.location+"'\n")
				}
			}
			if (vid instanceof AlternativeVideoSeq){
				var n = rnd.nextInt(vid.videodescs.size)
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