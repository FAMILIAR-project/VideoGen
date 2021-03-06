package videogen

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStreamReader
import java.util.ArrayList
import java.util.HashMap
import java.util.List
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

class VideoDemonstratorP6 {
	
	static var i = 0;
	
	String vignette = ""
	List vignettes = new ArrayList<String>();
	List vignettes2 = new ArrayList<String>();
	
	
	def genID() {
		"v" + i++
	}
	
	def printHtmlFile(String vignette){
		
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
			" -ss 00:00:02 -vframes 1 "+System.getProperty('user.dir')+"/Vignettes/" + filename + ".jpg"
		println(cmdVignette)

		var Process process = Runtime.getRuntime().exec(cmdVignette);
		process.waitFor();

		return filename + ".jpg"
	}
	
	@Test
	def partie6() {
		var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen"))
		
		assertNotNull(videoGen)
		for (videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {

				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
				var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
				if(fileId.isNullOrEmpty || vignettes2.contains(fileId)){
					fileId = genID()
				} else {
					vignettes2.add(fileId)
				}
				
				if (!vignettes.contains(fileLocation)) {
					
					

					vignette +=
						"<p>"+ fileLocation +"</p><br/> 
						<img src = " + createVignette(fileLocation, fileId) + " width='130px' height=auto/><br/>"

					
					vignettes.add(fileLocation);
				} else {
					System.out.println("Mandatory: la vignette est deja presente  !! " + fileLocation );
					vignette +="<p>Mandatory: la vignette est deja presente !!</p> "+ fileLocation +" <br/>"
				}

			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optionals")
				val rand = new Random().nextInt(2);
	
				if (rand == 0) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					var fileId = (videoseq as OptionalVideoSeq).description.videoid;
					if(fileId.isNullOrEmpty || vignettes2.contains(fileId)){
					fileId = genID()
						} else {
					vignettes2.add(fileId)
						}
					if (!vignettes.contains(fileLocation)) {
						
						vignette +=
							"<p>"+ fileLocation +"</p><br/><img src=" + createVignette(fileLocation, fileId) + " width='130px' height=auto/><br/>"
							
							vignettes.add(fileLocation)
					} else {
						vignette += "<p>Optionals: la vignette est deja presente " + fileLocation + " !!</p> <br/>"
						System.out.println("Optionals: la vignette est deja presente" + fileLocation );
					}

				}
				
			} else {
				println("Alternative")
				val size = (videoseq as AlternativeVideoSeq).videodescs.size;
				val index = new Random().nextInt(size)
				var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(index).location;
				var fileId = (videoseq as AlternativeVideoSeq).videodescs.get(index).videoid;
				if(fileId.isNullOrEmpty || vignettes2.contains(fileId)){
					fileId = genID()
				} else {
					vignettes2.add(fileId)
				}				
				if (!vignettes.contains(fileLocation)) {
					
					vignette +=
						"<p>"+ fileLocation +"</p><br/><img src=" + createVignette(fileLocation, "alternative") + " width='130px' height=auto/><br/>"
					
					vignettes.add(fileLocation)

				} else {
					System.out.println("Alternatives : la vignette est deja presente  "+ fileLocation);
					vignette += "<p>Alternatives : la vignette est deja presente !!</p> " + fileLocation + "<br/>"
				}
			}
		}
		printHtmlFile(vignette);
}


		
}

		
	
	
