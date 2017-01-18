package videogen

import java.io.PrintWriter
import java.util.Random
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import playlist.Playlist
import playlist.impl.PlaylistFactoryImpl
import org.eclipse.emf.common.util.URI
import org.junit.Test

class Vignette {

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	@Test
	def void genVignette() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("q9.videogen"))
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach [ videoseq |
			var path = ""
			var name = ""
			if (videoseq instanceof MandatoryVideoSeq) {
				path = videoseq.description.location
				name = videoseq.description.videoid
				createVignette(path, name)
			} else if (videoseq instanceof OptionalVideoSeq) {
				path = videoseq.description.location
				name = videoseq.description.videoid
				createVignette(path, name)
			} else if (videoseq instanceof AlternativeVideoSeq) {
				for (vdesc : videoseq.videodescs) {
					path = vdesc.location
					name = vdesc.videoid
					createVignette(path, name)
				}
			}
		]
	}
	def void createVignette(String path, String name) {
		println("path=" + path)
		println("name=" + name)
		var cmd = "ffmpeg -i " + path + " -ss 00:00:01.000 -vframes 1 " + name + ".jpg -y";
		println(cmd)
		var Process process = Runtime.runtime.exec(cmd)
		process.waitFor()
	}
}
