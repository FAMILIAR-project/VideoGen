package q12

import java.util.List
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import q8.VideoReparator


public class VideoGenerator {
	
	/**
	 * Load
	 */
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def List<String> generatePlaylistForFile(String file){
		// Loading
		var videoGen = (new q11.VideoGenLoader()).load(file)
		var playlistModel=(new q3.VideoGenerator()).generatePlaylist(videoGen)		
		var playlistM3U=(new q7.VideoGenerator()).generateStringList(playlistModel)
		println(playlistM3U.size)
		playlistM3U
	}
		
}
	
	
