package q1;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import q1.SequenceGenerator;
import q11.VideoGenLoader;

/**
 * VideoGen model to ffmpeg string
 */
@SuppressWarnings("all")
public class VideoGenToFFmpeg {
  @Test
  public void generate() {
    VideoGenLoader _videoGenLoader = new VideoGenLoader();
    VideoGeneratorModel videoGen = _videoGenLoader.load("foo2.videogen");
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(videoGen);
    ArrayList<String> finalVideo = _sequenceGenerator.getSequence();
    for (final String f : finalVideo) {
      InputOutput.<String>print((f + "\n"));
    }
  }
  
  public List<String> generateStringList(final VideoGeneratorModel videoGen) {
    SequenceGenerator _sequenceGenerator = new SequenceGenerator(videoGen);
    return _sequenceGenerator.getSequence();
  }
}
