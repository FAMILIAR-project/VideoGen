package q3;

import M3UPlaylist.Entry;
import M3UPlaylist.Playlist;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import q11.VideoGenLoader;
import q3.SequenceGenerator;

/**
 * Video to M3U Model
 */
@SuppressWarnings("all")
public class VideoGenerator {
  @Test
  public void generate() {
    VideoGenLoader _videoGenLoader = new VideoGenLoader();
    VideoGeneratorModel videoGen = _videoGenLoader.load("foo2.videogen");
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(videoGen);
    Playlist finalPlaylist = _sequenceGenerator.getPlaylist();
    EList<Entry> entries = finalPlaylist.getEntries();
    InputOutput.<String>println("Generated playlist model :");
    for (final Entry e : entries) {
      String _path = e.getPath();
      InputOutput.<String>println(_path);
    }
  }
  
  public Playlist generatePlaylist(final VideoGeneratorModel videoGen) {
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(videoGen);
    return _sequenceGenerator.getPlaylist();
  }
}
