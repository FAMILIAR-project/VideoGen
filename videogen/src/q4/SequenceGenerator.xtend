package q4

import M3UPlaylist.M3UPlaylistFactory
import M3UPlaylist.Playlist
import java.util.ArrayList
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.util.Diagnostician

import static org.junit.Assert.*

/**
 * Sequence generator
 */
class SequenceGenerator {
	

	// M3UPlaylist model
	private Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
	// Final Sequence
	private ArrayList<String> sequence=new ArrayList<String>()
	
	/**
	 * Constructor
	 */
	new(Playlist data){
		
		var Diagnostic validate = Diagnostician.INSTANCE.validate(data);
	
	  	assertEquals("Invalid playlist model", Diagnostic.OK, validate.getSeverity());
		
		this.playlist=data
		
		buildPlaylist()
	}
	
	def String getText(){
		var String o=new String()
		for(e:sequence){
			o+=e+"\n"
		}
		o
	}
	
	/**
	 * Sequence getter
	 */
	def ArrayList<String> getSequence(){
		sequence
	}
	
	/**
	 * Add location to the sequence
	 */
	def void appendVideo(String file){
		sequence.add("file \""+file+"\"")
	}
	
	def buildPlaylist(){
		for( e:playlist.entries){
			appendVideo(e.path)
		}
	}
	
}