package videogen

import java.io.BufferedReader
import java.io.File
import java.io.IOException
import java.io.InputStreamReader
import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

class VideoDemonstratorGification {

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
			"ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation);

		process.waitFor();

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		var String line = "";
		var String outputJson = "";
		while ((line = reader.readLine()) != null) {
			outputJson = outputJson + line;

			println(outputJson)
		}
		println(outputJson)
		return Math.round(Double.parseDouble(outputJson)) - 1;
	}

	def static String createGif(String duration, String start, String size, String path, String filename) {
		var String cmdGif = "ffmpeg -v warning "

		// Durée du gif en seconde
		if (duration != null) {
			cmdGif += "-t " + duration + " "
		}

		// Début du gif en seconde
		if (start != null) {
			cmdGif += " -ss " + start + " "
		}

		// Chemin de la video
		cmdGif += "-i " + path + " "

		// Taille
		if (size != null) {
			cmdGif += "-vf scale=" + size + ":-1 "
		} else {
			cmdGif += "-vf scale=300:-1 "
		}

		cmdGif += "-gifflags +transdiff -y " + filename + ".gif"

		var Process process = Runtime.getRuntime().exec(cmdGif);
		process.waitFor();

		return filename + ".gif"
	}

	def static void deleteFile(String path) {
		var String cmdDelete = "rm " + path

		var Process process = Runtime.getRuntime().exec(cmdDelete);
		process.waitFor();
	}

	// Concatene une liste de vidéo
	def static void concat(String playlist) {
		var String cmdConcat = "ffmpeg -f concat -safe 0 -i " + playlist + " -c copy /home/clementg/Documents/Travail/IDM/concat.mp4"

		var Process process = Runtime.getRuntime().exec(cmdConcat);
		process.waitFor();
	}
	
	/*def static void concat(String playlist) {
		var String cmdConcatener = "ffmpeg -f concat -safe 0 -i " + playlist + " -c copy /videoconcat.m3u"

		var Process process = Runtime.getRuntime().exec(cmdConcatener);
		process.waitFor();
	}*/

	@Test
	def tp6_gif() {
		var videoGen = loadVideoGenerator(URI.createURI("main.videogen"))
		

		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		/*
		for(videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {

				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;

				


			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;

					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					mediafile.duration =  getDuration(fileLocation)
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
				playlist.mediafile.add(mediafile)
			}
		}*/

		// New file
		try {
			val path = "./"
			val pl = new File(path + "playlist.txt");
			if (!pl.exists()) {
				pl.createNewFile();
			}

/*
			// Ecrit le fichier
			val fw = new FileWriter(pl.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			var totalDuration = 0.0;
			for( MediaFile mediafile : playlist.mediafile){
				bw.write('file ' + mediafile.location + System.lineSeparator());
				totalDuration = totalDuration + mediafile.duration
				println(mediafile.location + "(" + mediafile.duration +")s")
			}
			bw.close();

			// Concatene
			concat(path + "playlist.txt");
			deleteFile(path + "playlist.txt")

			// Créer le gif
			val myGif = createGif(totalDuration.toString, null, "500", path + "concat.mp4", "myGif")
			deleteFile(path + "concat.mp4")*/

		} catch (IOException e) {
			e.printStackTrace
		}
	}

	def static String creerGif(String duration, String start, String size, String path, String filename) {
		var String cmdGif = "ffmpeg -v warning "

		if (duration != null) {
			cmdGif += "-t " + duration + " "
		}

		if (start != null) {
			cmdGif += " -ss " + start + " "
		}

		cmdGif += "-i " + path + " "

		if (size != null) {
			cmdGif += "-vf scale=" + size + ":-1 "
		} else {
			cmdGif += "-vf scale=300:-1 "
		}

		cmdGif += "-gifflags +transdiff -y " + filename + ".gif"

		var Process process = Runtime.getRuntime().exec(cmdGif);
		process.waitFor();

		return filename + ".gif"
	}

	



}
