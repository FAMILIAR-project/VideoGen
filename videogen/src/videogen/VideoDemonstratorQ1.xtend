package videogen

import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*
import java.util.Random
import java.lang.reflect.Field
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter

/**
 * FFMPEG
 */
class VideoDemonstratorQ1 {

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

/**
 * write file playlist.txt format ffmpeg
 */
	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("fooQ1.videogen"))
		assertNotNull(videoGen)
		// assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
			}
		]
		// serializing
		saveVideoGenerator(URI.createURI("fooQ1bis.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("fooQ1bis.videogen"), videoGen)

		printToFFmpeg(videoGen)

	}

	def void printToFFmpeg(VideoGeneratorModel videoGen) {
		// var numSeq = 1
		var contenuFile = "";
		val test = new File("playList.txt");
		if (!test.exists()) {
			test.createNewFile();
		}

		val fw = new FileWriter(test);

		//println("# this is a comment test 1")
		contenuFile += "# this is a comment test 1" + System.lineSeparator();

		// videoGen.videoseqs.forEach[videoseq | if (videoseq instanceof MandatoryVideoSeq)
		for (var x = 0; x < videoGen.videoseqs.toSet.size; x++) {

				var videoseq = videoGen.videoseqs.toSet.get(x)
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description;
				if (!desc.videoid.isNullOrEmpty)
					// println ("file '" + desc.location + "'") 
					contenuFile += "file '" + desc.location + "'" + System.lineSeparator();
			} else if (videoseq instanceof OptionalVideoSeq) {
				// faire un math random
				val desc = (videoseq as OptionalVideoSeq).description

				// le prof a fait ça ************
				val i = new Random().nextInt(2);

				if (i == 0) {
					if (!desc.videoid.isNullOrEmpty)
						// println ("file '" + desc.location + "'") 
						contenuFile += "file '" + desc.location + "'" + System.lineSeparator();

				}

			// **********************
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				// faire du random pour les alternatives aleatroire
				if (altvid.videodescs.size > 1) {

					// le prof a fait ça *********
					val nbAlts = altvid.videodescs.size
					val i = (new Random().nextInt(nbAlts)) - 1

					
					// println (altvid.videodescs.get(i).location)
					contenuFile += "file '" + altvid.videodescs.get(i).location + "'"
//					for (vdesc : altvid.videodescs) {
//							println ("File '" + vdesc.location + "'")
//					}
				}

			}

		}

	println(contenuFile)
	fw.write(contenuFile);
	fw.close();
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}

}
