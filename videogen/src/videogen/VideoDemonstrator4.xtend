package videogen

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStreamReader
import java.util.HashMap
import java.util.Random
import java.util.Scanner
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
import videoGenQ2.impl.VideoGenQ2FactoryImpl
import videoGenQ2.MediaFile

class VideoDemonstrator4 {
	
	Scanner s
	
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
	
		def static String createVignette(String path, String filename) {
		var String cmdVignette= "ffmpeg -y -i "+ path +" -r 1 -t 00:00:01 -ss 00:00:02 -f image2 /home/dania/Documents/IDM/Vignettes/" + filename + ".png"
		
		var Process process = Runtime.getRuntime().exec(cmdVignette);
		process.waitFor();
		
		return "/home/dania/Documents/IDM/Vignettes/" + filename + ".png"
}
	
	
	@Test
	def tp3_q9() {
		var videoGen = loadVideoGenerator(URI.createURI("main.videogen")) 
		var fact = new VideoGenQ2FactoryImpl()
		var playlist= fact.createPlaylist()		
		assertNotNull(videoGen)
				
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for(videoseq : videoGen.videoseqs.toSet) {
			if (videoseq instanceof MandatoryVideoSeq) {
				
				println("Mandatory")
				val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
				var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
				if(fileId.isNullOrEmpty)  fileId = genID()  
				
				var mediafile = fact.createMediaFile()
				mediafile.location = fileLocation 
				mediafile.duration =  getDuration(fileLocation)
				
				createVignette(fileLocation,fileId)
				
				playlist.mediafile.add(mediafile)
				
				
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				// Random between 0-1
				if (new Random().ints(1) == 1) {
					val fileLocation = (videoseq as OptionalVideoSeq).description.location;
					var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
					if(fileId.isNullOrEmpty)  fileId = genID()  
					
					var mediafile = fact.createMediaFile()
					mediafile.location = fileLocation
					mediafile.duration =  getDuration(fileLocation)
					createVignette(fileLocation,fileId)
					
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
		}
	}

	def void printToHTML(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  
					println ("<li>" + desc.videoid + "</li>")  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) 
					println ("<li>" + desc.videoid + "</li>") 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					println ("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")
				for (vdesc : altvid.videodescs) {
					if(!vdesc.videoid.isNullOrEmpty) 
						println ("<li>" + vdesc.videoid + "</li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("</ul>")
			}
		]
		println("</ul>")
	}
	
	static var i = 0;
	
	File ffmpeg
	
	def genID() {
		"v" + i++
	}
	
}