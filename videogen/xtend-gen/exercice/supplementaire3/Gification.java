package exercice.supplementaire3;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogen.ProcessFFMPEG;

@SuppressWarnings("all")
public class Gification {
  public VideoGeneratorModel loadVideoGenerator(final URI uri) {
    VideoGeneratorModel _xblockexpression = null;
    {
      VideoGenStandaloneSetupGenerated _videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated();
      _videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource res = _resourceSetImpl.getResource(uri, true);
      EList<EObject> _contents = res.getContents();
      EObject _get = _contents.get(0);
      _xblockexpression = ((VideoGeneratorModel) _get);
    }
    return _xblockexpression;
  }
  
  public void saveVideoGenerator(final URI uri, final VideoGeneratorModel pollS) {
    try {
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource rs = _resourceSetImpl.createResource(uri);
      EList<EObject> _contents = rs.getContents();
      _contents.add(pollS);
      HashMap<Object, Object> _hashMap = new HashMap<Object, Object>();
      rs.save(_hashMap);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test1() {
    try {
      ArrayList<String> aa = new ArrayList<String>();
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      Assert.assertNotNull(videoGen);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      int _size = _videoseqs.size();
      Assert.assertEquals(7, _size);
      this.ProcessGIF(videoGen, aa);
      ProcessFFMPEG.generateGIF(aa);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void ProcessGIF(final VideoGeneratorModel videoGen, final ArrayList aa) {
    try {
      final PrintWriter writer = new PrintWriter("ffmpeglist.txt", "UTF-8");
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = desc.getVideoid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            String _location = desc.getLocation();
            aa.add(_location);
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_1 = desc_1.getVideoid();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              String _location_1 = desc_1.getLocation();
              aa.add(_location_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            VideoDescription _get = _videodescs.get(0);
            String _videoid_2 = _get.getVideoid();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
            boolean _not_2 = (!_isNullOrEmpty_2);
            if (_not_2) {
              EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
              VideoDescription _get_1 = _videodescs_1.get(0);
              String _location_2 = _get_1.getLocation();
              aa.add(_location_2);
            }
          }
        }
      };
      _videoseqs.forEach(_function);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = Gification.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
