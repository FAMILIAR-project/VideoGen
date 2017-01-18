package q7


import static org.junit.Assert.*;
import M3UPlaylist.Playlist
import M3UPlaylist.M3UPlaylistFactory
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.util.Diagnostician
import java.util.List
import java.util.ArrayList

/**
 * Sequence generator
 */
class SequenceGenerator {
	

	// M3UPlaylist model
	private Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
	
	private String text=new String()
	private List<String> sequence=new ArrayList<String>();
	
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
		text
	}
	def List<String> getSequence(){
		sequence
	}
	
	def buildPlaylist(){
		sequence.clear()
		text+="#EXTM3U\n"
		sequence.add("#EXTM3U")
		for( e:playlist.entries){
			if(e.discontinuity){
				text+="#EXT-X-DISCONTINUITY\n"
				sequence.add("#EXT-X-DISCONTINUITY")
				
			}
			if(e.duration!=-1){
				text+="#EXTINF:"+e.duration+"\n"
				sequence.add("#EXTINF:"+e.duration)
				
			}
			text+=e.path+"\n"
			sequence.add(e.path)
			
		}
	}
	
}