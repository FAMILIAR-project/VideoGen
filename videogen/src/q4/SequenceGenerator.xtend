package q4


import static org.junit.Assert.*;
import M3UPlaylist.Playlist
import M3UPlaylist.M3UPlaylistFactory
import org.eclipse.emf.common.util.Diagnostic
import org.eclipse.emf.ecore.util.Diagnostician

/**
 * Sequence generator
 */
class SequenceGenerator {
	

	// M3UPlaylist model
	private Playlist playlist=M3UPlaylistFactory.eINSTANCE.createPlaylist()
	
	private String text=new String()
	
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
	
	def buildPlaylist(){
		text+="#EXTM3U\n"
		for( e:playlist.entries){
			if(e.discontinuity){
				text+="#EXT-X-DISCONTINUITY\n"
			}
			if(e.duration!=-1){
				text+="#EXTINF:"+e.duration+"\n"
			}
			text+=e.path+"\n"
		}
	}
	
}