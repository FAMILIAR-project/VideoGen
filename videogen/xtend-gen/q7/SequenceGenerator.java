package q7;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistFactory;
import M3UPlaylist.Playlist;
import java.util.ArrayList;
import java.util.List;
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
  
  private String text = new String();
  
  private List<String> sequence = new ArrayList<String>();
  
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
    return this.text;
  }
  
  public List<String> getSequence() {
    return this.sequence;
  }
  
  public void buildPlaylist() {
    String _text = this.text;
    this.text = (_text + "#EXTM3U\n");
    this.sequence.add("#EXTM3U");
    EList<Entry> _entries = this.playlist.getEntries();
    for (final Entry e : _entries) {
      {
        boolean _isDiscontinuity = e.isDiscontinuity();
        if (_isDiscontinuity) {
          String _text_1 = this.text;
          this.text = (_text_1 + "#EXT-X-DISCONTINUITY\n");
          this.sequence.add("#EXT-X-DISCONTINUITY");
        }
        Integer _duration = e.getDuration();
        boolean _notEquals = ((_duration).intValue() != (-1));
        if (_notEquals) {
          String _text_2 = this.text;
          Integer _duration_1 = e.getDuration();
          String _plus = ("#EXTINF:" + _duration_1);
          String _plus_1 = (_plus + "\n");
          this.text = (_text_2 + _plus_1);
          Integer _duration_2 = e.getDuration();
          String _plus_2 = ("#EXTINF:" + _duration_2);
          this.sequence.add(_plus_2);
        }
        String _text_3 = this.text;
        String _path = e.getPath();
        String _plus_3 = (_path + "\n");
        this.text = (_text_3 + _plus_3);
      }
    }
  }
}
