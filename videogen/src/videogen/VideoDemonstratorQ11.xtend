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
import java.io.IOException
import java.io.BufferedWriter
import videogenPlayList.impl.VideogenPlayListFactoryImpl
import java.util.ArrayList
import java.util.List

/**
 * Question 11 :
 * On utilise la localisation entiere du video d'origine comme ID d'une vignette.
 * On cree un arraylist qui contient les locations des videos qui sont deja ajoutés a notres vignettes et 
 * si on retrouve que l'application essaie de faire une nouvelle vignette a partir d'une video deja utilisé
 * on l'ajoute pas et a la place on montre le message suivant
 * "Cette video est déjà presente !!!" + (la location de la video)
 */
class VideoDemonstratorQ11 {
	
	//array qui contient les id des vignettes
	List vignettesID = new ArrayList<String>();

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


	def static String createVignette(String path, String filename) {
		var String cmdVignette = "C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -y -i " + path +
			" -r 1 -t 00:00:03 -ss 00:00:04 -f image2 C:\\Users\\Sandra\\git\\VideoGen\\videogen\\vignettes\\" + filename + ".png"
			
			

		var Process process = Runtime.getRuntime().exec(cmdVignette);
		process.waitFor();

		return filename + ".png"
	}

	@Test
	def test() {
		var videoGen = loadVideoGenerator(URI.createURI("fooQ1.videogen"))
		var fact = new VideogenPlayListFactoryImpl()
		var playlist= fact.createPlayList()
		assertNotNull(videoGen)

		for (videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {

				
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
				var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
				if(fileId.isNullOrEmpty) fileId = genID()

				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation

				vignette += "<img src = " + createVignette(fileLocation, fileId) + " width='400px' height=auto/><br/>"
				
				vignettesID.add(mediafile.location) // cette ligne est pour avoir l'erreur d'inserer 2 fois la meme vignette
				
				if (!vignettesID.contains(mediafile.location)) {
					vignettesID.add(mediafile.location)
					playlist.mediaFile.add(mediafile)
				}else{
					vignette += "<p>Cette video est déjà presente !!!   " + "<b>"+mediafile.location+"</b>" +"</p>"
				}

			println(vignettesID.toString)	

			} else if (videoseq instanceof OptionalVideoSeq) {
				
				val rand = new Random().nextInt(2);
				// Random between 0-1
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					var fileId = (videoseq as OptionalVideoSeq).description.videoid;
					if(fileId.isNullOrEmpty) fileId = genID()

					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					
					vignette += "<img src= " + createVignette(fileLocation, fileId) + " width='400px' height=auto/><br/>"
					
					if (!vignettesID.contains(mediafile.location)) {
						vignettesID.add(mediafile.location)
						playlist.mediaFile.add(mediafile)
					}else{
						vignette += "<p>test</p>"
					}
				
					println(vignettesID.toString)
				}
			} else {
				
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).
					location;

				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation
				vignette += "<img src=" + createVignette(fileLocation,"alternative") + " width='400px' height=auto/><br/>"
				
				
				if (!vignettesID.contains(mediafile.location)) {
					vignettesID.add(mediafile.location)
					playlist.mediaFile.add(mediafile)
				}else{
					vignette += "<p>test</p>"
				}
				
				println(vignettesID.toString)
			}
		}
		// New file 
		try {
			val ffmpeg = new File("C:\\Users\\Sandra\\git\\VideoGen\\videogen\\vignettes\\vignettesQ11.html");
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

	static var i = 0;
	
	String vignette = ""

	def genID() {
		"v" + i++
	}

}
