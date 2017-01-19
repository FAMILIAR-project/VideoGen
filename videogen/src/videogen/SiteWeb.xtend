package videogen

import java.io.PrintWriter
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.common.util.URI
import org.junit.Test

class SiteWeb {
	var str = "";

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def void writeToFile(String content, String path) {
		val file = new PrintWriter(path + ".html", "UTF-8")
		file.print(content)
	}

	@Test
	def void testFile() {
		var str = genHtml("q10.videogen")
		writeToFile(str, "index.html")
	}

	def String genHtml(String pathfile) {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI(pathfile))
		str = "\""
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach [ videoseq |
			var path = ""
			var name = ""
			if (videoseq instanceof MandatoryVideoSeq) {
				println("<h1>mandatory</h1>")
				str += "<h1>mandatory</h1>"
				str += "<br>"

				path = videoseq.description.location
				name = videoseq.description.videoid
				createVignette(path, name)
				printInFile(name)
			} else if (videoseq instanceof OptionalVideoSeq) {
				str += "<h1>optional</h1>"
				str += "<br>"
				path = videoseq.description.location
				name = videoseq.description.videoid
				createVignette(path, name)
				printInFile(name)
			} else if (videoseq instanceof AlternativeVideoSeq) {
				str += "<h1>alternatives</h1>"
				str += "<br>"
				for (vdesc : videoseq.videodescs) {
					path = vdesc.location
					name = vdesc.videoid
					createVignette(path, name)
					printInFile(name)
				}
			}

		]
		str += "\""
		// serializing
		return str;
	}

	def void createVignette(String path, String name) {
		println("path=" + path)
		println("name=" + name)
		var cmd = "ffmpeg -i " + path + " -ss 00:00:01.000 -vframes 1 " + "src/main/webapp/content/images/" + name +
			".jpg -y";
		println(cmd)
		var Process process = Runtime.runtime.exec(cmd)
		process.waitFor()
	}

	def void printInFile(String name) {
		str += "<img src=\'content/images/" + name + ".jpg'>"
		str += "<br>"
	}
}
