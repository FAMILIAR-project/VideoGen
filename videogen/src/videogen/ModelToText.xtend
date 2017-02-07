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


import java.util.HashMap
import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.io.FileWriter
import java.io.File
import java.io.BufferedWriter

class ModelToText {


	def static loadVideoGenerator(URI uri) {
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
		//println("# this is a comment")
		fout.write("# this is a comment\n")
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				//println("file '"+vid.description.location+"'")
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

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

	def transform(VideoGeneratorModel videoGen){

	}

/*
def public static void main(String[] args){


	  var title = "foo3.videogen"

	   var  data="# this is a comment\n"

		var videoGen = loadVideoGenerator(URI.createURI(title))



			for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)

					data+="file "+desc.location+"\n"
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty)

				if (new Random().nextInt(1) == 0)
							data+="file "+desc.location+"\n"
			}
			else {

				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty)
					data+="file "+altvid.videodescs.get(new Random().nextInt(altvid.videodescs.size)).location+"\n"
			}
		}

	  var file = new File ("result.txt")
	  var filewriter = new FileWriter(file)
      filewriter.write( data );
      filewriter.flush
      filewriter.close



}

*/

def public static void main(String[] args){


	  var title = "foo3.videogen"

	   var  data="# this is a comment\n"

		var videoGen = loadVideoGenerator(URI.createURI(title))



			for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)

					data+="file "+desc.location+"\n"
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty)

				if (new Random().nextInt(1) == 0)
							data+="file "+desc.location+"\n"
			}
			else {

				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty)
					data+="file "+altvid.videodescs.get(new Random().nextInt(altvid.videodescs.size)).location+"\n"
			}
		}

	var file = new File ("result.txt")
	 var filewriter = new FileWriter(file)
      filewriter.write( data );
      filewriter.flush
      filewriter.close



}


}
