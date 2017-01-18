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
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException
import java.io.BufferedReader
import java.io.InputStreamReader
import videogenPlayList.impl.VideogenPlayListFactoryImpl
import videogenPlayList.MediaFile

class VideoDemonstratorQ3 {
	
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
		var Process process = Runtime.getRuntime().exec("C:\\Users\\kaoutar\\Downloads\\ffmpeg-20161204-1f5630a-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation );
		
		process.waitFor();

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
		return Math.round(Double.parseDouble(outputJson))-1;
	}
	@Test
	def TpQ3() {
		var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen")) 
		var fact = new VideogenPlayListFactoryImpl()
		var playlist= fact.createPlayList()		
		assertNotNull(videoGen)
				
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for(videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {
				
				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
		
				var mediaFile = fact.createMediaFile()
				mediaFile.location = fileLocation 
				mediaFile.duration =  getDuration(fileLocation)
				
				playlist.mediaFile.add(mediaFile)
				
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					
					var mediaFile = fact.createMediaFile()
					mediaFile.location = fileLocation
					mediaFile.duration =  getDuration(fileLocation)
					playlist.mediaFile.add(mediaFile)
				} 
			}
			else {
				println("else")
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;		
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;

				var mediaFile = fact.createMediaFile()
				mediaFile.location = fileLocation 
				mediaFile.duration =  getDuration(fileLocation)
				playlist.mediaFile.add(mediaFile)
			}
		}
				
		// New file 
		try {
			val pl = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlistq3.m3u");
			if (!pl.exists()) {
				pl.createNewFile();
			}
			val fw = new FileWriter(pl.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("#EXTM3U" +System.lineSeparator) 	
			for( MediaFile mediafile : playlist.mediaFile){
				bw.write("#EXTINF:" + mediafile.duration+ " ,Example Artist - Example title " + System.lineSeparator + mediafile.location + System.lineSeparator);
			}
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace
		}
		
	}
	
	
	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen"))
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
		saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)

		//printToM3u(videoGen)

	}
	def void printToM3u(VideoGeneratorModel videoGen) {
			
		val fact = new VideogenPlayListFactoryImpl()
		var playlist= fact.createPlayList()
		
		for (videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {
				println("Mandatory")
				
				val desc = (videoseq as MandatoryVideoSeq).description.location;
				var mediaFile = fact.createMediaFile()
				mediaFile.location = desc
				playlist.mediaFile.add(mediaFile)
								
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val unsurDeux = new Random().nextInt(2);
				
				if(unsurDeux ==0){
					val desc = (videoseq as OptionalVideoSeq).description.location;
					var mediaFile = fact.createMediaFile()
					mediaFile.location = desc
					playlist.mediaFile.add(mediaFile)
				}

			// **********************
			} else {
				println("Alternative")
				val altvidsize = (videoseq as AlternativeVideoSeq).videodescs.size;
				val desc = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(altvidsize)).location;
				var mediaFile = fact.createMediaFile()
					mediaFile.location = desc
					playlist.mediaFile.add(mediaFile)
				
			}

			

		}
		try {
			
			val CPlaylist = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlistq3.m3u");
			if (!CPlaylist.exists()) {
				CPlaylist.createNewFile();
			}
			println(CPlaylist.path);
			
			val fw = new FileWriter(CPlaylist.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("#EXTM3U" + System.lineSeparator);
			for (MediaFile mediafile : playlist.mediaFile){
				bw.write("#EXTINF:-1, Example Artist - Example title" + System.lineSeparator + mediafile.location + System.lineSeparator );
			}
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace
		}
		
		
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}
}