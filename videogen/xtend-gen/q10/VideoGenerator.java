package q10;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import q11.VideoGenLoader;

/**
 * Generate index.html + vignette
 */
@SuppressWarnings("all")
public class VideoGenerator {
  @Test
  public void generate() {
    VideoGenLoader _videoGenLoader = new VideoGenLoader();
    VideoGeneratorModel videoGen = _videoGenLoader.load("test.videogen");
    this.generateHTML(videoGen, "/home/loic/test");
  }
  
  public void generateIn(final VideoGeneratorModel videoGen, final String folderPath) {
    this.generateHTML(videoGen, folderPath);
  }
  
  public void generateHTML(final VideoGeneratorModel videoGen, final String folder) {
    try {
      Path _get = Paths.get(folder, "index.html");
      String _string = _get.toString();
      FileWriter fileWriter = new FileWriter(_string);
      BufferedWriter buffer = new BufferedWriter(fileWriter);
      buffer.write("<html><head><title>Generated From VideoGen Model</title></head><body>");
      buffer.write("<ul>");
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String dest = this.generateVignette(desc, folder);
          String _iMG = this.getIMG(dest);
          String _plus = ("<li>" + _iMG);
          String _plus_1 = (_plus + "</li>");
          buffer.write(_plus_1);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String dest_1 = this.generateVignette(desc_1, folder);
            String _iMG_1 = this.getIMG(dest_1);
            String _plus_2 = ("<li>" + _iMG_1);
            String _plus_3 = (_plus_2 + "</li>");
            buffer.write(_plus_3);
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            buffer.write("<ul>");
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String dest_2 = this.generateVignette(vdesc, folder);
                String _iMG_2 = this.getIMG(dest_2);
                String _plus_4 = ("<li>" + _iMG_2);
                String _plus_5 = (_plus_4 + "</li>");
                buffer.write(_plus_5);
              }
            }
            buffer.write("</ul>");
          }
        }
      }
      buffer.write("</ul>");
      buffer.write("</body></html>");
      buffer.close();
      fileWriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String generateVignette(final VideoDescription desc, final String folder) {
    try {
      String _xblockexpression = null;
      {
        String _videoid = desc.getVideoid();
        Path _get = Paths.get(folder, _videoid);
        String dest = (_get + ".png");
        String _location = desc.getLocation();
        String _videoid_1 = desc.getVideoid();
        Path _get_1 = Paths.get(folder, _videoid_1);
        String _plus = (_get_1 + ".png");
        ProcessBuilder _processBuilder = new ProcessBuilder("ffmpeg", "-y", "-i", _location, "-r", "1", "-t", "00:00:01", "-ss", "00:00:2", _plus);
        ProcessBuilder _redirectErrorStream = _processBuilder.redirectErrorStream(true);
        Process processDuration = _redirectErrorStream.start();
        processDuration.waitFor();
        _xblockexpression = dest;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String getIMG(final String dest) {
    return (("<img src=\"" + dest) + "\" width=\"200\"/>");
  }
  
  public String getIMGForJHipster(final String dest) {
    String _xblockexpression = null;
    {
      Path p = Paths.get(dest);
      Path _fileName = p.getFileName();
      String file = _fileName.toString();
      _xblockexpression = (("<img src=\"videogen/" + file) + "\" width=\"200\"/>");
    }
    return _xblockexpression;
  }
}
