package q7;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistFactory;
import M3UPlaylist.Playlist;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import q7.SequenceGenerator;

/**
 * Generate Simple playlist text
 */
@SuppressWarnings("all")
public class VideoGenerator {
  @Test
  public void generate() {
    Playlist playlist = this.getSample();
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(playlist);
    String text = _sequenceGenerator.getText();
    InputOutput.<String>print(text);
  }
  
  public Playlist getSample() {
    Playlist _xblockexpression = null;
    {
      Playlist playlist = M3UPlaylistFactory.eINSTANCE.createPlaylist();
      Entry e1 = M3UPlaylistFactory.eINSTANCE.createEntry();
      e1.setPath("p1");
      Entry e2 = M3UPlaylistFactory.eINSTANCE.createEntry();
      e2.setPath("p2");
      EList<Entry> _entries = playlist.getEntries();
      _entries.add(e1);
      EList<Entry> _entries_1 = playlist.getEntries();
      _entries_1.add(e2);
      _xblockexpression = playlist;
    }
    return _xblockexpression;
  }
}
