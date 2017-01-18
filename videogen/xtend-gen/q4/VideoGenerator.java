package q4;

import M3UPlaylist.Entry;
import M3UPlaylist.M3UPlaylistFactory;
import M3UPlaylist.Playlist;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import q4.SequenceGenerator;

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
  
  public String getPlaylist(final VideoGeneratorModel playlist) {
    q3.VideoGenerator _videoGenerator = new q3.VideoGenerator();
    Playlist _playlist = _videoGenerator.getPlaylist(playlist);
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(_playlist);
    return _sequenceGenerator.getText();
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