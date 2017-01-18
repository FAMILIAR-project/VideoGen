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

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	@Test
	def void genHtml() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("q10.videogen"))
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		val file = new PrintWriter("index.html", "UTF-8")
		file.println("<html>")
		videoGen.videoseqs.forEach [ videoseq |
			var path = ""
			var name = ""
			if (videoseq instanceof MandatoryVideoSeq) {
				file.println("<h1>mandatory</h1>");
				file.println("<br>");
				path = videoseq.description.location
				name = videoseq.description.videoid
				createVignette(path, name)
				printInFile(file, name)
			} else if (videoseq instanceof OptionalVideoSeq) {
				file.println("<h1>optional</h1>");
				file.println("<br>");
				path = videoseq.description.location
				name = videoseq.description.videoid
				createVignette(path, name)
				printInFile(file, name)
			} else if (videoseq instanceof AlternativeVideoSeq) {
				file.println("<h1>alternative</h1>");
				file.println("<br>");
				for (vdesc : videoseq.videodescs) {
					path = vdesc.location
					name = vdesc.videoid
					createVignette(path, name)
					printInFile(file, name)
				}
			}

		]
		// serializing
		file.println("</html>")
		file.close()
	}

	def void createVignette(String path, String name) {
		println("path=" + path)
		println("name=" + name)
		var cmd = "ffmpeg -i " + path + " -ss 00:00:01.000 -vframes 1 " + name + ".jpg -y";
		println(cmd)
		var Process process = Runtime.runtime.exec(cmd)
		process.waitFor()
	}

	def void printInFile(PrintWriter file, String name) {
		file.println("<img src=\'" + name + ".jpg'>");
		file.println("<br>");
	}
}
