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
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		val fact = PlaylistFactoryImpl.eINSTANCE
		val playlist = PlaylistFactoryImpl.eINSTANCE.createPlaylist as Playlist
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		val file = new PrintWriter("out.ffmpeg", "UTF-8")
		videoGen.videoseqs.forEach [ videoseq |
			var path = ""
			var name = ""
			if (videoseq instanceof MandatoryVideoSeq) {
				path = videoseq.description.location
				name = videoseq.description.videoid
			} else if (videoseq instanceof OptionalVideoSeq) {
				path = videoseq.description.location
				name = videoseq.description.videoid
			} else if (videoseq instanceof AlternativeVideoSeq) {
				for (vdesc : videoseq.videodescs) {
					path = vdesc.location
					name = vdesc.videoid
				}
			}
			println("path="+path)
			println("name="+name)
			var cmd = "ffmpeg -i "+path+" -ss 00:00:01.000 -vframes 1 "+name+".jpg -y";
			println(cmd)
		//	"ffmpeg -y -i" + path + "-r 1 -t 00:00:01 -ss 00:00:$2 -f image2 ./test/" + name + ".png"
			var Process process = Runtime.runtime.exec(cmd)
			process.waitFor()
		]
		// serializing
		file.close()
	}
}
