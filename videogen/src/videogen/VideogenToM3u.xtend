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
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl
import videogenPlaylist.MediaFile
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.concurrent.TimeUnit
import org.xtext.example.mydsl.videoGen.VideoSeq

/*
 * Questions 2
 */
class VideogenToM3u {

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
		var Process process = Runtime.getRuntime().exec("C:\\Users\\Robin\\Desktop\\ffmpeg-3.2.2-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation );
		
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
		var videoGen = loadVideoGenerator(URI.createURI("testVideos.videogen"))
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

		toM3u(videoGen)

	}

	def void toM3u(VideoGeneratorModel videoGen) {
			
		var factory = new VideogenPlaylistFactoryImpl()
		var playlist= factory.createPlaylist()
		
		for (VideoSeq video : videoGen.videoseqs) {
			var file = factory.createMediaFile()
			
			// mandatory
			if (video instanceof MandatoryVideoSeq) {
				val desc = (video as MandatoryVideoSeq).description;
				if (!desc.videoid.isNullOrEmpty)
					file.path= desc.location
					file.duration = getDuration(desc.location)
					playlist.mediaFile.add(file);
					
			// optional		
			} else if (video instanceof OptionalVideoSeq) {
				val desc = (video as OptionalVideoSeq).description

				if (new Random().nextInt(2) == 0) {
					if (!desc.videoid.isNullOrEmpty)
						file.path= desc.location
						file.duration = getDuration(desc.location)
						playlist.mediaFile.add(file);
						
				}
			// alternative
			} else {
				val altvid = (video as AlternativeVideoSeq)
				val nbAltVids = altvid.videodescs.size
				val i = (new Random().nextInt(nbAltVids))
				
				file.path= altvid.videodescs.get(i).location
				file.duration = getDuration(altvid.videodescs.get(i).location)
				playlist.mediaFile.add(file);
			}
				
		}
		
		val file = new File("createdPlaylists/playlist.m3u");
		if (!file.exists()) {
			file.createNewFile();
		}

		val writer = new FileWriter(file);
	
		writer.write("#EXTM3U \n");
		for(MediaFile md : playlist.mediaFile){
			writer.write("#EXT-X-DISCONTINUITY \n");
			writer.write("#EXTINF: " + md.duration + ", Sample artist - Sample title \n");
			writer.write(md.path + "\n")
		}
		writer.write("#EXT-X-ENDLIST");
		writer.close();
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}
	
}