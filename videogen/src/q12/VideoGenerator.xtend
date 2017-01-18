package q12

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
	
	def String generatePlaylistForFile(String file){
		var videoGen=(new VideoReparator()).getRepaired(file)
		
		(new q4.VideoGenerator()).getPlaylist(videoGen)
	}
		
}
	
	
