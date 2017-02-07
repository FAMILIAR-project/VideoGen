package insertText;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;

@SuppressWarnings("all")
public class VideoGenerator {
  @Test
  public void generate() {
    String filePath = "/home/loic/Videos/jean.mp4";
    String text = "Loic";
    this.generateVideo("Test !!", filePath, "/home/loic/zd.mp4");
  }
  
  public void generateVideo(final String text, final String inputFile, final String outputFile) {
    try {
      ProcessBuilder _processBuilder = new ProcessBuilder("ffmpeg", "-y", "-i", inputFile, "-vf", (("drawtext=fontsize=40:fontcolor=white:text=\'" + text) + "\':x=(w-tw)/2:y=(h-th)/2"), outputFile);
      ProcessBuilder _redirectErrorStream = _processBuilder.redirectErrorStream(true);
      Process processDuration = _redirectErrorStream.start();
      InputStream _inputStream = processDuration.getInputStream();
      Charset _defaultCharset = Charset.defaultCharset();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream, _defaultCharset);
      BufferedReader processOutputReader = new BufferedReader(_inputStreamReader);
      String line = null;
      while ((!Objects.equal((line = processOutputReader.readLine()), null))) {
        InputOutput.<String>println(line);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
