package videogen

import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.io.FileWriter

class ThumbnailGenerator {
	//Partie 4
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def thumbnailGenerator(URI in, String out){
		var videogen = loadVideoGenerator(in)
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				generateThumbnail(vid.description.location) 
			}
			if (vid instanceof OptionalVideoSeq){
				generateThumbnail(vid.description.location)
			}
			if (vid instanceof AlternativeVideoSeq){
				for (videodesc:vid.videodescs){
					generateThumbnail(videodesc.location)
				}
			}
		]
		printToHTML(videogen,new FileWriter(out))
	}
	
	def void generateThumbnail(String videoLocation){
		var wd = System.getProperty("user.dir")
		var name = extractName(videoLocation)
		//println(name)
		//createFile(wd+"/thumb/" + name + ".jpg","")
		//println(wd+"/"+videoLocation)
		var cmd = "/usr/bin/ffmpeg -i " + wd+"/"+videoLocation + " -ss 00:00:01.000 -vframes 1 "+wd+"/thumb/" + name + ".jpg -y"
		var Process process = Runtime.getRuntime().exec(cmd)
		process.waitFor()
		//println(process.exitValue())
	}
	
	def static String extractName(String txt){
		var sp1 = txt.split("/")
		var sp2 = sp1.get(sp1.size-1).split("\\.")
		return sp2.get(0)
	}
	
	def void printToHTML(VideoGeneratorModel mod,FileWriter fout){
		fout.write("<html>\n")
		mod.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				var thumbnailName = "thumb/"+extractName(vid.description.location)+".jpg"
				fout.write("<div>\n")
				fout.write("<img src=\""+thumbnailName+"\">\n")
				fout.write("</div>\n") 
			}
			if (vid instanceof OptionalVideoSeq){
				var thumbnailName = "thumb/"+extractName(vid.description.location)+".jpg"
				fout.write("<div>\n")
				fout.write("<img src=\""+thumbnailName+"\">\n")
				fout.write("</div>\n") 
			}
			if (vid instanceof AlternativeVideoSeq){
				fout.write("<div>\n")				 
				for (videodesc:vid.videodescs){
					var thumbnailName = "thumb/"+extractName(videodesc.location)+".jpg"
					fout.write("<img src=\""+thumbnailName+"\">\n")
				}
				fout.write("</div>\n")
			}
		]
		fout.write("</html>")
		fout.close()
	}
	
	def static void main(String[] args) {
		val tg = new ThumbnailGenerator
		val fin = URI.createURI("test.videogen")
		val fout = "test.html"
		//println("wd = "+System.getProperty("user.dir"))
		tg.thumbnailGenerator(fin,fout)
	}
}