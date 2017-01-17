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


import static org.junit.Assert.*
import videogenPlayList.impl.VideogenPlayListFactoryImpl
import videogenPlayList.MediaFile
import java.util.concurrent.TimeUnit

class VideoDemostratorInsererText {

	
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
		//a changer selon l'hubication du fichier ffmpeg
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
	
	/**
	 * Inserer du text dans la video
	 * videoLocation = hubication de la video
	 * text = texte a inserer dans la video
	 * position = position du texte inseré
	 */
	def static String insertText(String videoLocation, String text, String positionX, String positionY){
		
		var String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
	    
	    
	    // A changer selon l'ubication du fichier "ttf"
	     
	    var String pathFontFile = "/Users/Sandra/";
	    
	    // a changer selon l'hubication du executable ffmpeg
		var cmd1 = "C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -i "+videoLocation+" -vf drawtext='fontfile=" + pathFontFile + "arial.ttf:text="+text+":fontcolor=white:fontsize=44:box=1:boxcolor=black@0.5:boxborderw=5:x="+positionX+":y="+positionY+"' -codec:a copy " + name.get(0) + "-2.mp4"
	    	 
		println("Commande : " + cmd1);
		
		var Process process = Runtime.getRuntime().exec(cmd1);
		
		process.waitFor(2000, TimeUnit.MILLISECONDS);
		
	    
	   return name.get(0) + '-2.mp4'
	}
	
	
	
	
	@Test
	def test() {
		var videoGen = loadVideoGenerator(URI.createURI("fooQ1.videogen")) 
		var fact = new VideogenPlayListFactoryImpl()
		var playlist= fact.createPlayList()	
		assertNotNull(videoGen)
				
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for(videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) { 
				
				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
		
				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				mediafile.text = "VideoObligatoire"
				mediafile.positionX = "(w-text_w)/2" //le texte sera dans le centre de la video
				mediafile.positionY = "(h-text_h)/2"
				
				var locatTemp = insertText(mediafile.location, mediafile.text, mediafile.positionX, mediafile.positionY)
				mediafile.location = locatTemp
				System.out.println(mediafile.location)
				playlist.mediaFile.add(mediafile)
				
				
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					
					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					mediafile.duration =  getDuration(fileLocation)
					mediafile.text = "VideoOptional"
					mediafile.positionX = "(w-text_w)/3"
					mediafile.positionY = "(h-text_h)/3"
					
					var locatTemp = insertText(mediafile.location, mediafile.text, mediafile.positionX, mediafile.positionY)
					mediafile.location =locatTemp
					
					playlist.mediaFile.add(mediafile)
				} 
			}
			else {
				println("else")
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;		
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;

				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				mediafile.text = "VideoAlternative"
				mediafile.positionX = "(w-text_w)/4"
				mediafile.positionY = "(h-text_h)/4"
				
				var locatTemp = insertText(mediafile.location, mediafile.text, mediafile.positionX, mediafile.positionY)
				
				mediafile.location =locatTemp
				
				playlist.mediaFile.add(mediafile)
			}
		}
				
		// New file 
		try {
			val pl = new File("generatedPlayList/playlist-m3u-projet.m3u");
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
	
	static var i = 0;
	
	File ffmpeg
	
	def static genID() {
		"" + i++
	}

}