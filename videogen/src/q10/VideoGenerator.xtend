package q10

import java.io.BufferedWriter
import java.io.FileWriter
import java.nio.file.Paths
import org.junit.Test
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import q11.VideoGenLoader

/**
 * Generate index.html + vignette
 */
public class VideoGenerator {
	

	
	@Test
	def generate() {
		
		// Please edit test.videogen to get real file
		var videoGen = (new VideoGenLoader()).load("test.videogen")	
		
		// Please edit path of destination
		generateHTML(videoGen, "/home/loic/test")
		
	}
	
	
	def generateIn(VideoGeneratorModel videoGen, String folderPath){
		generateHTML(videoGen, folderPath)
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
		var dest=Paths.get(folder,desc.videoid)+".png"
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
	
	
