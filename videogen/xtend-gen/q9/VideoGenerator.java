package q9;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import q11.VideoGenLoader;

/**
 * Generate Vignettes of VideoGen model to a specified folder
 */
@SuppressWarnings("all")
public class VideoGenerator {
  @Test
  public void generate() {
    VideoGenLoader _videoGenLoader = new VideoGenLoader();
    VideoGeneratorModel videoGen = _videoGenLoader.load("test.videogen");
    this.generateVignettes(videoGen, "/home/loic/test");
  }
  
  public void generateVignettes(final VideoGeneratorModel videoGen, final String folder) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        this.generateVignette(desc, folder);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          this.generateVignette(desc_1, folder);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            this.generateVignette(vdesc, folder);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public int generateVignette(final VideoDescription desc, final String folder) {
    try {
      int _xblockexpression = (int) 0;
      {
        String _location = desc.getLocation();
        String _videoid = desc.getVideoid();
        Path _get = Paths.get(folder, _videoid);
        String _plus = (_get + ".png");
        ProcessBuilder _processBuilder = new ProcessBuilder("ffmpeg", "-y", "-i", _location, "-r", "1", "-t", "00:00:01", "-ss", "00:00:2", _plus);
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
        _xblockexpression = processDuration.waitFor();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
