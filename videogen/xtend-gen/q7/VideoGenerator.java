package q7;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistFactory;
import M3UPlaylist.Playlist;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import q7.SequenceGenerator;

/**
 * M3U Model to M3U Text
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
  
  public List<String> getPlaylist(final VideoGeneratorModel playlist) {
    q3.VideoGenerator _videoGenerator = new q3.VideoGenerator();
    Playlist _generatePlaylist = _videoGenerator.generatePlaylist(playlist);
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(_generatePlaylist);
    return _sequenceGenerator.getSequence();
  }
  
  public Playlist getSample() {
    Playlist _xblockexpression = null;
    {
      Playlist playlist = M3UPlaylistFactory.eINSTANCE.createPlaylist();
      Entry e1 = M3UPlaylistFactory.eINSTANCE.createEntry();
      e1.setPath("p1");
      e1.setDiscontinuity(true);
      e1.setDuration(Integer.valueOf(1));
      Entry e2 = M3UPlaylistFactory.eINSTANCE.createEntry();
      e2.setDiscontinuity(true);
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
