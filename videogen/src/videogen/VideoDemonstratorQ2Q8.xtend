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
import videogenPlayList.impl.VideogenPlayListFactoryImpl
import videogenPlayList.MediaFile
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit

/*
 * Questions 2 - 8
 */
class VideoDemonstratorQ2Q8 {

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
	
	def static double getDuration(String videoLocation){
		var Process process = Runtime.getRuntime().exec("C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation );
		
		
		process.waitFor(2000, TimeUnit.MILLISECONDS);

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
		return Math.round(Double.parseDouble(outputJson))-1;
	}

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

		printToM3u(videoGen)

	}

	def void printToM3u(VideoGeneratorModel videoGen) {
			
		var fact = new VideogenPlayListFactoryImpl()
		var playlist= fact.createPlayList()
		
		for (var x = 0; x < videoGen.videoseqs.toSet.size; x++) {
			var file = fact.createMediaFile()
			
			var videoseq = videoGen.videoseqs.toSet.get(x)
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description;
				if (!desc.videoid.isNullOrEmpty)
					file.location= desc.location
					file.duration = getDuration(desc.location)
					playlist.mediaFile.add(file);
			} else if (videoseq instanceof OptionalVideoSeq) {
				
				val desc = (videoseq as OptionalVideoSeq).description

				val i = new Random().nextInt(2);

				if (i == 0) {
					if (!desc.videoid.isNullOrEmpty)
						file.location= desc.location
						file.duration = getDuration(desc.location)
						playlist.mediaFile.add(file);

				}

			// **********************
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				// faire du random pour les alternatives aleatroire
				if (altvid.videodescs.size > 1) {

					
					val nbAlts = altvid.videodescs.size
					val i = (new Random().nextInt(nbAlts)) - 1
					
					file.location= altvid.videodescs.get(i).location
					file.duration = getDuration(altvid.videodescs.get(i).location)
					playlist.mediaFile.add(file);

				}

			}

		}

		
		val test = new File("generatedPlayList/playList.m3u");
		if (!test.exists()) {
			test.createNewFile();
		}

		val fw = new FileWriter(test);
	
		fw.write("#EXTM3U" + System.lineSeparator());
		for(MediaFile md : playlist.mediaFile){
			fw.write("#EXTINF:" +md.duration+ ", Sample artist - Sample title" + System.lineSeparator());
			fw.write(md.location + System.lineSeparator())
		}
		fw.close();
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}
	
}
