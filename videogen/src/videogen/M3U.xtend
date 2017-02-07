package videogen

import java.util.HashMap
import java.io.PrintWriter
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
import org.xtext.example.playlist.m3u.m3U.Model
import org.xtext.example.playlist.m3u.M3UStandaloneSetupGenerated

class M3U {
	
	def loadPlayList(URI uri) {
		new M3UStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Model
	}
	
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	@Test
	def test1() {
		// loading
		
		var videoGen = loadPlayList(URI.createURI("foo2m3u.xmi")) 
		
	printToHTML(videoGen)
		 
			
	}
	
	def void printToHTML(Model playlist) {
		 val writer = new PrintWriter("ffmpeglist_from_playlist.txt", "UTF-8");
		//var numSeq = 1
		//xx = xx + "# this is a comment";
		playlist.listVideo.forEach[video| 
			
					writer.println ("file '" + video.location+ "'")  				
			
			
		
		]	
	
		writer.close();
		//Runtime.getRuntime().exec("ffmpeg -f concat -i ffmpeglist.txt -c copy output");
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}