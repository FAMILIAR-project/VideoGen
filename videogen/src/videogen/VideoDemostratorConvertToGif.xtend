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
import videogenGif.Gif

class VideoDemostratorConvertToGif {

	
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
	 *transforme une partie de la video en fichier gif de base qualité
	 * videoLocation = path de la video a utiliser
	 * tailleW = weight de l'image .gif
	 * tailleH = height de l'image .gif
	 */
	def static convertToGif(String videoLocation, Integer tailleW, Integer tailleH){
		
		var String[] name = videoLocation.split("/");

		// a changer selon l'hubication du executable ffmpeg
		var cmd = "C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -i " + videoLocation + " -ss 00:00:00.000 -pix_fmt rgb24 -r 10 -s "+tailleW+"x"+tailleH+" -t 00:00:10.000 gif/"+name.get(name.length-1)+".gif"
	    
	    println("Commande : " + cmd);
		
		var Process process = Runtime.getRuntime().exec(cmd);
		
		process.waitFor(2000, TimeUnit.MILLISECONDS);
	
	}
	
	/**
	 *transforme une partie de la video en fichier gif de haute qualité
	 * videoLocation = path de la video a utiliser
	 * taille = taille de l'image gif de sortie
	 */
	def static convertToGifHD(String videoLocation, Integer taille){
		
		var String[] name = videoLocation.split("/");
		
		//cree une image .pg qui servira pour la creation du .gif d'haute qualité
		var cmdPalette = "C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -y -ss 0 -t 3 -i "+videoLocation+" -vf fps=10,scale="+taille+":-1:flags=lanczos,palettegen gif/"+name.get(name.length-1)+".png"
	 	 
	 	println("Commande palette: " + cmdPalette);
	 	 
	 	var Process processPalette = Runtime.getRuntime().exec(cmdPalette);
		
		processPalette.waitFor(2000, TimeUnit.MILLISECONDS);
		
		// commande pour la creation du .gif en utilisant la palette crée avant
		var cmdGif = "C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -ss 0 -t 3 -i "+videoLocation+" -i gif/"+name.get(name.length-1)+".png -filter_complex \"fps=10,scale="+taille+":-1:flags=lanczos[x];[x][1:v]paletteuse\" gif/"+name.get(name.length-1)+".gif"
	    
	    println("Commande gif: " + cmdGif);
		
		var Process processGif = Runtime.getRuntime().exec(cmdGif);
		
		processGif.waitFor(2000, TimeUnit.MILLISECONDS);
	
	}
	
	
	@Test
	def test() {
		var videoGen = loadVideoGenerator(URI.createURI("fooQ1.videogen")) 
		var fact = new VideogenPlayListFactoryImpl()
		assertNotNull(videoGen)
				
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for(videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) { 
				
				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
		
				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
					
				convertToGifHD(fileLocation, 500)
				
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					
					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					
					convertToGif(fileLocation, 200, 100)
					
					
				} 
			}
			else {
				println("else")
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;		
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).location;

				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
				
				convertToGif(fileLocation, 250, 300)
				
			}
		}
		
		
	}
	
	static var i = 0;
	
	File ffmpeg
	
	def static genID() {
		"" + i++
	}

}