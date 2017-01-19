package videogen

import java.io.BufferedReader
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
import java.util.concurrent.TimeUnit

class VideogenConvertGif {

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

	def static convertGif(String videoLocation, Integer tailleW, Integer tailleH){
		var String[] name = videoLocation.split("/");

		var cmd = "lib\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -i " + rootPath + videoLocation + " -ss 00:00:00.000 -pix_fmt rgb24 -r 10 -s "+tailleW+"x"+tailleH+" -t 00:00:10.000 gif/"+name.get(name.length-1)+".gif"
		
		var Process process = Runtime.getRuntime().exec(cmd);
		
		process.waitFor(2000, TimeUnit.MILLISECONDS);
	
	}
	
	def static convertToGifHD(String videoLocation, Integer taille){
		var String[] name = videoLocation.split("/");
		
		var cmdPalette = "lib\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -y -ss 0 -t 3 -i " + rootPath + videoLocation+" -vf fps=10,scale="+taille+":-1:flags=lanczos,palettegen gif/"+name.get(name.length-1)+".png"
	 	 
	 	var Process processPalette = Runtime.getRuntime().exec(cmdPalette);
		
		processPalette.waitFor(2000, TimeUnit.MILLISECONDS);
		
		var cmdGif = "lib\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -ss 0 -t 3 -i " + rootPath + videoLocation+" -i gif/"+name.get(name.length-1)+".png -filter_complex \"fps=10,scale="+taille+":-1:flags=lanczos[x];[x][1:v]paletteuse\" gif/"+name.get(name.length-1)+".gif"
		
		var Process processGif = Runtime.getRuntime().exec(cmdGif);
		
		processGif.waitFor(2000, TimeUnit.MILLISECONDS);
	}
	
	
	@Test
	def test() {
		var videoGen = loadVideoGenerator(URI.createURI("testVideos.videogen")) 
		var fact = new VideogenPlaylistFactoryImpl()
		assertNotNull(videoGen)
				
		for(videoseq : videoGen.videoseqs.toSet) {
			// Mandatory
			if (videoseq instanceof MandatoryVideoSeq) { 
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
		
				var mediafile = fact.createMediaFile()
				mediafile.path = fileLocation 
					
				convertToGifHD(fileLocation, 500)
				
			// Optional
			} else if (videoseq instanceof OptionalVideoSeq) {
				if (new Random().nextInt(2) == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					
					var mediafile = fact.createMediaFile()
					mediafile.path = fileLocation
					
					convertGif(fileLocation, 200, 100)
				} 
				
			// Alternative
			} else {
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;		
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;

				var mediafile = fact.createMediaFile()
				mediafile.path = fileLocation 
				
				convertGif(fileLocation, 250, 300)
				
			}
		}
		
		
	}
	
	static var i = 0;
		
	def static genID() {
		"" + i++
	}

}