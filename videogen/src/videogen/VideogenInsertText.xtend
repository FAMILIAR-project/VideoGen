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
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl
import videogenPlaylist.MediaFile
import java.util.concurrent.TimeUnit

class VideogenInsertText {
	
	static String rootPath = "createdPlaylists/"
	
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
		var Process process = Runtime.getRuntime().exec("lib\\ffmpeg-3.2.2-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + rootPath + videoLocation );
		
		process.waitFor(2000, TimeUnit.MILLISECONDS);

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
		return Math.round(Double.parseDouble(outputJson))-1;
	}
	
	def static String insertText(String videoLocation, String text, String positionX, String positionY){
		var String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
		
	    var String pathFontFile = "OpenSans-Regular.ttf";
			    
		var cmd = "lib\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -i " + rootPath + videoLocation+" -vf drawtext='fontfile=" + rootPath + pathFontFile + ":text="+text+":fontcolor=white:fontsize=44:box=1:boxcolor=black@0.5:boxborderw=5:x="+positionX+":y="+positionY+"' -codec:a copy " + rootPath + name.get(0) + "-2.webm"
	    	 		
		var Process process = Runtime.getRuntime().exec(cmd);
		process.waitFor(2000, TimeUnit.MILLISECONDS);
		
	   return name.get(0) + '-2.webm'
	}
	
	@Test
	def test() {
		var videoGen = loadVideoGenerator(URI.createURI("testVideos.videogen")) 
		var factory = new VideogenPlaylistFactoryImpl()
		var playlist= factory.createPlaylist()	
		assertNotNull(videoGen)
				
		for(videoseq : videoGen.videoseqs.toSet) {
			// Mandatory
			if (videoseq instanceof MandatoryVideoSeq) { 
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
				var mediafile = factory.createMediaFile()
				mediafile.path = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				mediafile.text = "Mandatory"
				mediafile.XAxis = "(w-text_w)/2"
				mediafile.YAxis = "(h-text_h)/2"
				
				var locatTemp = insertText(mediafile.path, mediafile.text, mediafile.XAxis, mediafile.YAxis)
				mediafile.path = locatTemp
				playlist.mediaFile.add(mediafile)
				
			// Optional
			} else if (videoseq instanceof OptionalVideoSeq) {
				if (new Random().nextInt(2) == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					
					var mediafile = factory.createMediaFile()
					mediafile.path = fileLocation
					mediafile.duration =  getDuration(fileLocation)
					mediafile.text = "Optional"
					mediafile.XAxis = "(w-text_w)/3"
					mediafile.YAxis = "(h-text_h)/3"
					
					var locatTemp = insertText(mediafile.path, mediafile.text, mediafile.XAxis, mediafile.YAxis)
					mediafile.path = locatTemp
					playlist.mediaFile.add(mediafile)
				}
				
			// Alternatives  
			} else {
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;		
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;

				var mediafile = factory.createMediaFile()
				mediafile.path = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				mediafile.text = "Alternative"
				mediafile.XAxis = "(w-text_w)/4"
				mediafile.YAxis = "(h-text_h)/4"
				
				var locatTemp = insertText(mediafile.path, mediafile.text, mediafile.XAxis, mediafile.YAxis)
				mediafile.path = locatTemp
				playlist.mediaFile.add(mediafile)
			}
		}
				
		try {
			val newPlaylist = new File("createdPlaylists/playlistText.m3u");
			if (!newPlaylist.exists()) {
				newPlaylist.createNewFile();
			}
			val fw = new FileWriter(newPlaylist.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("#EXTM3U \n") 	
			for (MediaFile mediafile : playlist.mediaFile){
				bw.write("#EXTINF:" + mediafile.duration + ", Example Artist - Example title \n" + mediafile.path + "\n");
			}
			
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace
		}
		
	}
	
	static var i = 0;
		
	def static genID() {
		"" + i++
	}

}