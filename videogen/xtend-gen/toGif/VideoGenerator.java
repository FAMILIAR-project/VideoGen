package toGif;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

@SuppressWarnings("all")
public class VideoGenerator {
  @Test
  public void generate() {
    String filePath = "/home/loic/Videos/jean.mp4";
    String text = "Loic";
    this.generateVideo("Test !!", filePath, "/home/loic/zd.mp4");
  }
  
  public int generateVideo(final String text, final String inputFile, final String outputFile) {
    try {
      int _xblockexpression = (int) 0;
      {
        ProcessBuilder _processBuilder = new ProcessBuilder("ffmpeg", "-y", "-i", inputFile, (outputFile + ".gif"));
        Process processDuration = _processBuilder.start();
        _xblockexpression = processDuration.waitFor();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
