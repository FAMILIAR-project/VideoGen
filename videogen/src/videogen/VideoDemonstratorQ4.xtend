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

class VideoDemonstratorQ4 {
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
	
	def static double getDuration(String videoLocation) {
		var Process process = Runtime.getRuntime().exec(
			"C:\\Users\\kaoutar\\Downloads\\ffmpeg-20161204-1f5630a-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation);

		process.waitFor();

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
		while ((line = reader.readLine()) != null) {
			outputJson = outputJson + line;
		}
		return Math.round(Double.parseDouble(outputJson)) - 1;
	}
	
	
	def static String createVignette(String path, String filename) {
		var String cmdVignette = "ffmpeg -y -i " + path +
			" -r 1 -t 00:00:01 -ss 00:00:02 -f image2 /VideoGen/videogen/Vignettes/" + filename + ".jpg -y"


		var Process process = Runtime.getRuntime().exec(cmdVignette);
		process.waitFor();

		return "/videogen/Vignettes/" + filename + ".jpg -y"
	}
	
	@Test
	def TP3() {
		var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen"))
		var fact = new VideogenPlayListFactoryImpl()
		var playlist = fact.createPlayList()
		assertNotNull(videoGen)

		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for (videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {

				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
				println (fileLocation)
				var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
				println (fileId)
				if(fileId.isNullOrEmpty) fileId = genID()
				
				var mediaFile = fact.createMediaFile()
				mediaFile.location = fileLocation 
				mediaFile.duration =  getDuration(fileLocation)

				vignette += "<img src = " + createVignette(fileLocation, fileId) + " width='130px' height=auto/><br/>"

				playlist.mediaFile.add(mediaFile)

			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					var fileId = (videoseq as OptionalVideoSeq).description.videoid;
					if(fileId.isNullOrEmpty) fileId = genID()

					var mediaFile = fact.createMediaFile()
				mediaFile.location = fileLocation 
				mediaFile.duration =  getDuration(fileLocation)
					
					vignette += "<img src=" + createVignette(fileLocation, fileId) + " width='130px' height=auto/><br/>"
					playlist.mediaFile.add(mediaFile)
				}
			} else {
				println("else alternative")
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).
					location;

				var mediaFile = fact.createMediaFile()
				mediaFile.location = fileLocation 
				mediaFile.duration =  getDuration(fileLocation)
				vignette += "<img src=" + createVignette(fileLocation,"alternative") + " width='130px' height=auto/><br/>"
				playlist.mediaFile.add(mediaFile)
			}
		}
		// New file 
		try {
			val ffmpeg = new File("/Users/kaoutar/git/VideoGen/videogen/Vignettes/vignette.html");
			if (!ffmpeg.exists()) {
				ffmpeg.createNewFile();
			}
			val fw = new FileWriter(ffmpeg.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("<!DOCTYPE html><html><body>");
			bw.write("les vignettes");
			bw.write(vignette);
			bw.write("</html></body>");
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace
		}
	}

	static var i = 0;
	
	String vignette = ""

	def genID() {
		"v" + i++
	}
	
}