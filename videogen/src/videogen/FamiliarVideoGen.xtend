package videogen

import java.io.PrintWriter
import java.util.ArrayList
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*
import fr.unice.polytech.modalis.familiar.fm.basic.FMLFeatureModelReader

class FamiliarVideoGen {

	var myvar = new FMLFeatureModelReader()
	var res = ""
	var alternativeList = new ArrayList<String>();

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	@Test
	def testing(){
		toFamiliar("foo3.videogen","foo3.fml")
	}

	
	def toFamiliar(String input, String output) {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI(input))
		assertNotNull(videoGen)

		res = "fmVideoGen = FM (VideoGen: "
		alternativeList = new ArrayList<String>();

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				if ((videoseq as MandatoryVideoSeq).description.videoid == null) {
					throw new NullPointerException("all videos must have a identifier to generate a fml file");
				}
				res += (videoseq as MandatoryVideoSeq).description.videoid + " "
			} else if (videoseq instanceof OptionalVideoSeq) {
				if ((videoseq as OptionalVideoSeq).description.videoid == null) {
					throw new NullPointerException("all videos must have a identifier to generate a fml file");
				}
				res += "[" + (videoseq as OptionalVideoSeq).description.videoid + "] "
			} else {
				if ((videoseq as AlternativeVideoSeq).videoid == null) {
					throw new NullPointerException("all videos must have a identifier to generate a fml file");
				}
				res += (videoseq as AlternativeVideoSeq).videoid + " "

				val altvid = (videoseq as AlternativeVideoSeq)

				var tmp = (videoseq as AlternativeVideoSeq).videoid + ": ("
				for (vdesc : altvid.videodescs) {
					if (vdesc.videoid == null) {
					throw new NullPointerException("all videos must have a identifier to generate a fml file");
					}
					tmp += vdesc.videoid + "|"
				}
				tmp = tmp.substring(0, tmp.length()-1);
				tmp += ");\n"
				alternativeList.add(tmp)
			}
		]
		res += ";\n"
		for (entry : alternativeList) {
			res += entry
		}
		res += ")"
		
		// serializing
		val file = new PrintWriter(output, "UTF-8")
		file.println(res);
		file.close();
	}
}
