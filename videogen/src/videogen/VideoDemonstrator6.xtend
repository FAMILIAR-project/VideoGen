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
import videoGenQ2.impl.VideoGenQ2FactoryImpl

import static org.junit.Assert.*
import java.io.File
import java.io.FileWriter
import java.io.BufferedWriter
import java.io.IOException
import java.util.ArrayList
import java.util.List

class VideoDemonstrator6 {

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
		}
		return Math.round(Double.parseDouble(outputJson)) - 1;
	}

	def static String createVignette(String path, String filename) {
		var String cmdVignette = "ffmpeg -y -i " + path +
			" -r 1 -t 00:00:01 -ss 00:00:02 -f image2 /home/dania/Documents/IDM/Vignettes/" + filename + ".png"

		var Process process = Runtime.getRuntime().exec(cmdVignette);
		process.waitFor();

		return "/home/dania/Documents/IDM/Vignettes/" + filename + ".png"
	}

	@Test
	def tp3_q11() {
		var videoGen = loadVideoGenerator(URI.createURI("main.videogen"))
		var fact = new VideoGenQ2FactoryImpl()
		var playlist = fact.createPlaylist()
		assertNotNull(videoGen)

		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for (videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {

				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
				var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
				if (fileId.isNullOrEmpty || vignettesID.contains(fileId)) {
					fileId = genID()
				} else {
					vignettesID.add(fileId)
				}
				if (!vignettes.contains(fileLocation)) {
					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					mediafile.duration = getDuration(fileLocation)

					vignette +=
						"<p>" + fileLocation + "</p><br/> 
						<img src = " + createVignette(fileLocation, fileId) + " width='130px' height=auto id=" +
							fileId + "/><br/>"

					playlist.mediafile.add(mediafile)
					vignettes.add(fileLocation);
				} else {
					System.out.println("hey la vignette est deja presente M " + fileLocation);
					vignette += "<p>Hey la vignette est deja presente !!</p> " + fileLocation + " <br/>"
				}

			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					var fileId = (videoseq as OptionalVideoSeq).description.videoid;
					if (fileId.isNullOrEmpty || vignettesID.contains(fileId)) {
						fileId = genID()
					} else {
						vignettesID.add(fileId)
					}
					if (!vignettes.contains(fileLocation)) {
						var mediafile = fact.createMediaFile()
						mediafile.location = fileLocation
						mediafile.duration = getDuration(fileLocation)

						vignette +=
							"<p>" + fileLocation + "</p><br/><img src=" + createVignette(fileLocation, fileId) +
								" width='130px' height=auto id=" + fileId + "/><br/>"
						playlist.mediafile.add(mediafile)
						vignettes.add(fileLocation)
					} else {
						vignette += "<p>Hey la vignette est deja presente " + fileLocation + " !!</p> <br/>"
						System.out.println("hey la vignette est deja presente O " + fileLocation);
					}

				}
			} else {
				println("else alternative")
				// Recuperation des informations utiles pour le traitement 
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;
				val index = new Random().nextInt(size)
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(index).location;
				// Gestion de l'identifiant	
				var fileId = (videoseq as AlternativeVideoSeq).videodescs.get(index).videoid;
				if (fileId.isNullOrEmpty || vignettesID.contains(fileId)) {
					fileId = genID()
				} else {
					vignettesID.add(fileId)
				}

				// Si la vignette n'existe pas 
				if (!vignettes.contains(fileLocation)) {
					// Ajout du media a la playlist
					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					mediafile.duration = getDuration(fileLocation)
					// Ajout dans le champs la vignette
					vignette +=
						"<p>" + fileLocation + "</p><br/><img src=" + createVignette(fileLocation, fileId) +
							" width='130px' height=auto id=" + fileId + "/><br/>"
					playlist.mediafile.add(mediafile)
					vignettes.add(fileLocation)

				} else {
					// Sinon ajout dans le fichier HTML que la vignette est deja presente
					vignette += "<p>Hey la vignette est deja presente !!</p> " + fileLocation + "<br/>"
				}

			}
		}
		generateHtmlFile(vignette);
	}

	static var i = 0;
	String vignette = ""
	List vignettes = new ArrayList<String>();
	List vignettesID = new ArrayList<String>();

	def genID() {
		"vid" + i++
	}

	def generateHtmlFile(String vignette) {
		// New file  
		try {
			val ffmpeg = new File("/home/dania/Documents/IDM/vignettes.html");
			if (!ffmpeg.exists()) {
				ffmpeg.createNewFile();
			}
			val fw = new FileWriter(ffmpeg.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("<!DOCTYPE html><html><body>");

			bw.write(vignette);
			
			bw.write("</html></body>");
			bw.close();

		} catch (IOException e) {
			e.printStackTrace
		}
	}

}
