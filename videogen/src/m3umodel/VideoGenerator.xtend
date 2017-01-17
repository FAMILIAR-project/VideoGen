package m3umodel

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
import static org.junit.Assert.*;
import java.util.ArrayList
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.util.Diagnostician
import M3UPlaylist.M3UPlaylistFactory
import M3UPlaylist.Entry

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
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)		
			
		// Repair id
		repairId(videoGen)
		
		// Serializing
		saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		
		// Build playlist
		var finalPlaylist=(new SequenceGenerator(videoGen)).getPlaylist()

		var Diagnostic validate = Diagnostician.INSTANCE.validate(finalPlaylist);
	
	  	assertEquals(Diagnostic.OK, validate.getSeverity());
	
		var entries=finalPlaylist.getEntries()
		
		for(e:entries){
			println(e.path)
		}
			
	}
	
	
	/**
	 * Repair null id
	 */
	def void repairId(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty)  desc.videoid = genID() 
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID() 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				val current=new ArrayList<VideoDescription>();
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					current.add(vdesc)
				}				
			}
		]
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}