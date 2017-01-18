package q10

import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import q8.VideoReparator
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.nio.file.Paths
import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.Charset
import java.io.FileWriter
import java.io.BufferedWriter
import java.nio.file.Path

/**
 * Generate ffmpeg
 */
public class VideoGenerator {
	
	/**
	 * Load
	 */
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	/**
	 * Save
	 */
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	@Test
	def generate() {
		
		// Loading
		var videoReparator = new VideoReparator()
		var videoGen =videoReparator.getRepair()	
		
		generateHTML(videoGen, "src/main/webapp/videogen/")
		
	}
	
	
	def generateIn(String from, String folderPath){
		// Loading
		var videoReparator = new VideoReparator()
		var videoGen =videoReparator.getRepaired(from)	
		
		generateHTML(videoGen, folderPath)
	}
	
	def generateForJHipster(String from, String folderPath){
		// Loading
		var videoReparator = new VideoReparator()
		var videoGen =videoReparator.getRepaired(from)	
		
		var fileWriter = new FileWriter(Paths.get(folderPath,"index.html").toString);
		var	buffer = new BufferedWriter(fileWriter);
		
		buffer.write("<ul>")
		for(videoseq:videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				var dest=generateVignette(desc, folderPath)				
				buffer.write("<li>"+getIMGForJHipster(dest)+"</li>")
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var dest=generateVignette(desc, folderPath)
				buffer.write("<li>"+getIMGForJHipster(dest)+"</li>")
				
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				buffer.write("<ul>")
				for (vdesc : altvid.videodescs) {
					var dest=generateVignette(vdesc, folderPath)
					buffer.write("<li>"+getIMGForJHipster(dest)+"</li>")
					
				}
				buffer.write("</ul>")
				
				
			}
		}
		buffer.write("</ul>")

		buffer.close()
		fileWriter.close()
	}
	
	
	
	
	
	def generateHTML(VideoGeneratorModel videoGen, String folder){
		var fileWriter = new FileWriter(Paths.get(folder,"index.html").toString);
		var	buffer = new BufferedWriter(fileWriter);
		buffer.write("<html><head><title>Generated From VideoGen Model</title></head><body>")
		
		buffer.write("<ul>")
		for(videoseq:videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				var dest=generateVignette(desc, folder)				
				buffer.write("<li>"+getIMG(dest)+"</li>")
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var dest=generateVignette(desc, folder)
				buffer.write("<li>"+getIMG(dest)+"</li>")
				
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				buffer.write("<ul>")
				for (vdesc : altvid.videodescs) {
					var dest=generateVignette(vdesc, folder)
					buffer.write("<li>"+getIMG(dest)+"</li>")
					
				}
				buffer.write("</ul>")
				
				
			}
		}
		buffer.write("</ul>")
		buffer.write("</body></html>")
		buffer.close()
		fileWriter.close()
	}
	
	def String generateVignette(VideoDescription desc, String folder){
		var Runtime r = Runtime.getRuntime();
		var dest=Paths.get(folder,desc.videoid)+".png"
		var param="-y -i "+desc.location +" -r 1 -t 00:00:01 -ss 00:00:2 "+ dest       
		var Process processDuration = new ProcessBuilder("ffmpeg","-y", "-i", desc.location, "-r", "1", "-t", "00:00:01", "-ss", "00:00:2",Paths.get(folder,desc.videoid)+".png"  ).redirectErrorStream(true).start();
	
	    processDuration.waitFor();
		dest
		
	} 	
	
	def getIMG(String dest){
		"<img src=\""+dest+"\" width=\"200\"/>"
	}
	def getIMGForJHipster(String dest){
		var p = Paths.get(dest);
		var file = p.getFileName().toString();
		"<img src=\"videogen/"+file+"\" width=\"200\"/>"
	}
		
}
	
	
