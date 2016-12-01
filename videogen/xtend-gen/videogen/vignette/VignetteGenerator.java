package videogen.vignette;

import java.io.File;
import java.io.PrintWriter;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogen.VideoDemonstrator;
import videogen.vignette.FFMPEGHelper;

@SuppressWarnings("all")
public class VignetteGenerator {
  private VideoDemonstrator vd = new VideoDemonstrator();
  
  @Test
  public void generateVignettes() {
    final FFMPEGHelper ffmpeg = new FFMPEGHelper();
    URI _createURI = URI.createURI("test-vignette.videogen");
    VideoGeneratorModel videoGen = this.vd.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    int _size = _videoseqs.size();
    Assert.assertEquals(3, _size);
    EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        final String path = desc.getLocation();
        String _videoid = desc.getVideoid();
        ffmpeg.generateThumbnail(path, _videoid);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          final String path_1 = desc_1.getLocation();
          String _videoid_1 = desc_1.getVideoid();
          ffmpeg.generateThumbnail(path_1, _videoid_1);
        } else {
          final AlternativeVideoSeq videoseqAlt = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = videoseqAlt.getVideodescs();
          for (final VideoDescription video : _videodescs) {
            String _location = video.getLocation();
            String _videoid_2 = video.getVideoid();
            ffmpeg.generateThumbnail(_location, _videoid_2);
          }
        }
      }
    };
    _videoseqs_1.forEach(_function);
  }
  
  @Test
  public void generateHTML() {
    try {
      File html = new File("vignettes.html");
      PrintWriter writer = new PrintWriter("vignettes.html");
      writer.write(
        "<html><body>");
      writer.write("</body></html>");
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
