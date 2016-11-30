package videogen;

import java.io.PrintWriter;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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

@SuppressWarnings("all")
public class ConcatenateVideoSeq {
  private VideoDemonstrator vd = new VideoDemonstrator();
  
  public Resource saveFile(final URI uri) {
    ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
    Resource rs = _resourceSetImpl.createResource(uri);
    return rs;
  }
  
  public Object random() {
    return null;
  }
  
  @Test
  public void generateAllAlternatives() {
    try {
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = this.vd.loadVideoGenerator(_createURI);
      final PrintWriter writer = new PrintWriter("test.txt", "UTF-8");
      Assert.assertNotNull(videoGen);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      int _size = _videoseqs.size();
      Assert.assertEquals(7, _size);
      EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          final String path = desc.getLocation();
          writer.write((("file \'" + path) + "\'\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final OptionalVideoSeq videoseqOptional = ((OptionalVideoSeq) videoseq);
            double _random = Math.random();
            final double random = (_random * 100);
            if (((videoseqOptional.getDescription().getProbability() == 0) && (random <= 50))) {
              final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
              final String path_1 = desc_1.getLocation();
              writer.write((("file \'" + path_1) + "\'\n"));
            } else {
              if (((random >= 0) && (random <= videoseqOptional.getDescription().getProbability()))) {
                final VideoDescription desc_2 = ((OptionalVideoSeq) videoseq).getDescription();
                final String path_2 = desc_2.getLocation();
                writer.write((("file \'" + path_2) + "\'\n"));
              }
            }
          } else {
            final AlternativeVideoSeq videoseqAlt = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = videoseqAlt.getVideodescs();
            final int size = _videodescs.size();
            double _random_1 = Math.random();
            final double random_1 = (_random_1 * size);
            final int randomInt = Double.valueOf(random_1).intValue();
            EList<VideoDescription> _videodescs_1 = videoseqAlt.getVideodescs();
            final VideoDescription alt = _videodescs_1.get(randomInt);
            final String desc_3 = alt.getDescription();
            final String path_3 = alt.getLocation();
            writer.write((("file \'" + path_3) + "\'\n"));
          }
        }
      };
      _videoseqs_1.forEach(_function);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
