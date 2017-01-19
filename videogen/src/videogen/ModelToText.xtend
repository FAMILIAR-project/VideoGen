package videogen

import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.Random
import java.io.FileWriter
import java.io.File
 

class ModelToText {

	static def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

	def static writeToFile(String filename, String content) {
		val writer = new FileWriter(filename + ".txt")
		writer.write(content)
		writer.flush()
		writer.close()
	}

	static def void printToHTML(VideoGeneratorModel videoGen) {
		// var numSeq = 1
		var data = "#this is a comment\n"

		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.location.isNullOrEmpty)
					data += "File " + desc.location + "\n"

			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.location.isNullOrEmpty) {
					if (new Random().nextInt(1) == 1) {
						data += "File " + desc.location + "\n"
					}
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty)
					data +=
						"File " + altvid.videodescs.get(new Random().nextInt(altvid.videodescs.size)).location + "\n"
			}
		}
		println(data)
        
        val writer = new FileWriter("result.txt")
		writer.write(data)
		writer.flush()
		writer.close()
		 
	}

	def static void main(String[] args) {
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		printToHTML(videoGen)
	}
}
