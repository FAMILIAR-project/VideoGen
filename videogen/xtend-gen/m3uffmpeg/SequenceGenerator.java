package m3uffmpeg;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistFactory;
import M3UPlaylist.Playlist;
import java.util.ArrayList;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.junit.Assert;

/**
 * Sequence generator
 */
@SuppressWarnings("all")
public class SequenceGenerator {
  private Playlist playlist = M3UPlaylistFactory.eINSTANCE.createPlaylist();
  
  private ArrayList<String> sequence = new ArrayList<String>();
  
  private String text = new String();
  
  /**
   * Constructor
   */
  public SequenceGenerator(final Playlist data) {
    Diagnostic validate = Diagnostician.INSTANCE.validate(data);
    int _severity = validate.getSeverity();
    Assert.assertEquals("Invalid playlist model", Diagnostic.OK, _severity);
    this.playlist = data;
    this.buildPlaylist();
  }
  
  public String getText() {
    String _xblockexpression = null;
    {
      String o = new String();
      for (final String e : this.sequence) {
        String _o = o;
        o = (_o + (e + "\n"));
      }
      _xblockexpression = o;
    }
    return _xblockexpression;
  }
  
  /**
   * Sequence getter
   */
  public ArrayList<String> getSequence() {
    return this.sequence;
  }
  
  /**
   * Add location to the sequence
   */
  public void appendVideo(final String file) {
    this.sequence.add((("file \"" + file) + "\""));
  }
  
  public void buildPlaylist() {
    EList<Entry> _entries = this.playlist.getEntries();
    for (final Entry e : _entries) {
      String _path = e.getPath();
      this.appendVideo(_path);
    }
  }
}
