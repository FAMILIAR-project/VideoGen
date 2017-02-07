package videogen;

import java.io.PrintWriter;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
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
public class VideoGenExtended2M3UExtended {
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
  
  @Test
  public void test1() {
    try {
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final PrintWriter writer = new PrintWriter("ffmpeglist_for_question_8.txt", "UTF-8");
      writer.println("#EXTM3U");
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        try {
          if ((videoseq instanceof MandatoryVideoSeq)) {
            final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
            String _location = desc.getLocation();
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              writer.println("#EXT-X-DISCONTINUITY");
              String _location_1 = desc.getLocation();
              String _duration = ProcessFFMPEG.getDuration(_location_1);
              String _plus = ("#EXTINF:" + _duration);
              writer.println(_plus);
              String _location_2 = desc.getLocation();
              writer.println(_location_2);
              writer.println();
            }
          } else {
            if ((videoseq instanceof OptionalVideoSeq)) {
              final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
              String _location_3 = desc_1.getLocation();
              boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_3);
              boolean _not_1 = (!_isNullOrEmpty_1);
              if (_not_1) {
                writer.println("#EXT-X-DISCONTINUITY");
                String _location_4 = desc_1.getLocation();
                String _duration_1 = ProcessFFMPEG.getDuration(_location_4);
                String _plus_1 = ("#EXTINF:" + _duration_1);
                writer.println(_plus_1);
                String _location_5 = desc_1.getLocation();
                writer.println(_location_5);
                writer.println();
              }
            } else {
              final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
              EList<VideoDescription> _videodescs = altvid.getVideodescs();
              VideoDescription _get = _videodescs.get(0);
              String _location_6 = _get.getLocation();
              boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_location_6);
              boolean _not_2 = (!_isNullOrEmpty_2);
              if (_not_2) {
                writer.println("#EXT-X-DISCONTINUITY");
                EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
                VideoDescription _get_1 = _videodescs_1.get(0);
                String _location_7 = _get_1.getLocation();
                String _duration_2 = ProcessFFMPEG.getDuration(_location_7);
                String _plus_2 = ("#EXTINF:" + _duration_2);
                writer.println(_plus_2);
                EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
                VideoDescription _get_2 = _videodescs_2.get(0);
                String _location_8 = _get_2.getLocation();
                writer.println(_location_8);
                writer.println();
              }
            }
          }
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
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
    int _plusPlus = VideoGenExtended2M3UExtended.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
