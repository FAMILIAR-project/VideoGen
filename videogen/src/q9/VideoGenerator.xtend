package q9

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
		
		generateVignettes(videoGen, "/home/loic/test")
		
	}
	
	
	
	def generateVignettes(VideoGeneratorModel videoGen, String folder){
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				generateVignette(desc, folder)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				generateVignette(desc, folder)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					generateVignette(vdesc, folder)
				}
				
			}
		]
	}
	
	def generateVignette(VideoDescription desc, String folder){
		var Runtime r = Runtime.getRuntime();
		var param="-y -i "+desc.location +" -r 1 -t 00:00:01 -ss 00:00:2 "+Paths.get(folder,desc.videoid)+".png"          
		var Process processDuration = new ProcessBuilder("ffmpeg","-y", "-i", desc.location, "-r", "1", "-t", "00:00:01", "-ss", "00:00:2",Paths.get(folder,desc.videoid)+".png"  ).redirectErrorStream(true).start();
		var StringBuilder strBuild = new StringBuilder();
			
		var BufferedReader processOutputReader = new BufferedReader(new InputStreamReader(processDuration.getInputStream(), Charset.defaultCharset()))
		    var String line;
		    while ((line = processOutputReader.readLine()) != null) {
	
				println(line)		        
		    }
		    processDuration.waitFor();
			
		
		} 	
		
}
	
	
	
