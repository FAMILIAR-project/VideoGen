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
import java.io.File
import java.io.FileWriter
import org.xtext.example.mydsl.videoGen.VideoSeq

class VideogenToFfmpeg {

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

	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		assertNotNull(videoGen)

		// generate ids if necessary
		videoGen.videoseqs.forEach[videoseq |
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

		toFFmpeg(videoGen)

	}

	def void toFFmpeg(VideoGeneratorModel videoGen) {
		var content = "";
		val file = new File("playList.txt");
		if (!file.exists()) {
			file.createNewFile();
		}

		val writer = new FileWriter(file);

		content += "# this is a comment \n";

		// videoGen.videoseqs.forEach[videoseq | if (videoseq instanceof MandatoryVideoSeq)
		for (VideoSeq video : videoGen.videoseqs) {
			// mandatory
			if (video instanceof MandatoryVideoSeq) {
				val desc = (video as MandatoryVideoSeq).description;
				if (!desc.videoid.isNullOrEmpty)
					content += "file '" + desc.location + "'\n";
					
			// optional		
			} else if (video instanceof OptionalVideoSeq) {
				// 50% chance
				if (new Random().nextInt(2) == 0) {
					val desc = (video as OptionalVideoSeq).description
					if (!desc.videoid.isNullOrEmpty)
						content += "file '" + desc.location + "'\n";
				}

			// alternative
			} else {
				val altvid = (video as AlternativeVideoSeq)

					// choose video with same probability
					val nbAltVids = altvid.videodescs.size
					val i = (new Random().nextInt(nbAltVids))
					content += "file '" + altvid.videodescs.get(i).location + "'\n"

			}
		}
		
		// println(content)
		writer.write(content);
		writer.close();
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}

}