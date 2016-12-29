package videogen

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStreamReader
import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import videoGenQ2.MediaFile
import videoGenQ2.impl.VideoGenQ2FactoryImpl

import static org.junit.Assert.*
import java.lang.reflect.Array

class projetInsertext {

	
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
		var Process process = Runtime.getRuntime().exec("ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation );
		
		process.waitFor();

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
		return Math.round(Double.parseDouble(outputJson))-1;
	}
	
	def static String insertText(String videoLocation, String text){
		System.out.println("debut")
		
		var String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
	    
		var cmd = "ffmpeg -i "+ videoLocation +" -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text=LONG_LINE:y=100:x=100' -codec:a copy " + name.get(0) + "-2.mp4"
	    
	    System.out.println(cmd)

		var Process process = Runtime.getRuntime().exec(cmd);
		process.waitFor();
		
		
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
	    System.out.println(outputJson.toString())
	    
	   return name.get(0) + '-2.mp4'
	}
	
	
	
	
	@Test
	def tp3_q7() {
		var videoGen = loadVideoGenerator(URI.createURI("main.videogen")) 
		var fact = new VideoGenQ2FactoryImpl()
		var playlist= fact.createPlaylist()		
		assertNotNull(videoGen)
				
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for(videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {
				
				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
		
				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				mediafile.insertedText = fileLocation
				
				var locatTemp = insertText(mediafile.location, mediafile.insertedText)
				mediafile.location = locatTemp
				System.out.println(mediafile.location)
				playlist.mediafile.add(mediafile)
				
				
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					
					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					mediafile.duration =  getDuration(fileLocation)
					mediafile.insertedText = 'nom : ' + fileLocation
					
					var locatTemp = insertText(mediafile.location, mediafile.insertedText)
					mediafile.location =locatTemp
					
					playlist.mediafile.add(mediafile)
				} 
			}
			else {
				println("else")
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;		
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;

				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				mediafile.insertedText = 'nom : ' + fileLocation
				
				var locatTemp = insertText(mediafile.location, mediafile.insertedText)
				
				mediafile.location =locatTemp
				
				playlist.mediafile.add(mediafile)
			}
		}
				
		// New file 
		try {
			val pl = new File("/home/dania/Documents/IDM/playlist-m3u-projet.m3u");
			if (!pl.exists()) {
				pl.createNewFile();
			}
			val fw = new FileWriter(pl.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("#EXTM3U" +System.lineSeparator) 	
			for( MediaFile mediafile : playlist.mediafile){
				bw.write("#EXTINF:" + mediafile.duration+ " ,Example Artist - Example title " + System.lineSeparator + mediafile.location + System.lineSeparator);
			}
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace
		}
		
	}
	
	static var i = 0;
	
	File ffmpeg
	
	def static genID() {
		"" + i++
	}

}
