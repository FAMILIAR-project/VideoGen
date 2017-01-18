package videogen;

import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoGenForGenerateButton {
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
  
  public String generateHTMLResp() {
    String _xblockexpression = null;
    {
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final StringBuilder resp = new StringBuilder();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = desc.getLocation();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            String _location_1 = desc.getLocation();
            String _plus = ("<p> video : " + _location_1);
            String _plus_1 = (_plus + "</p>");
            resp.append(_plus_1);
            String _location_2 = desc.getLocation();
            String[] _split = _location_2.split("\\.");
            String _get = _split[0];
            String _plus_2 = ("<img src=\'" + _get);
            String _plus_3 = (_plus_2 + ".png\' />");
            resp.append(_plus_3);
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_3 = desc_1.getLocation();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_3);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              String _location_4 = desc_1.getLocation();
              String _plus_4 = ("<p> video : " + _location_4);
              String _plus_5 = (_plus_4 + "</p>");
              resp.append(_plus_5);
              String _location_5 = desc_1.getLocation();
              String[] _split_1 = _location_5.split("\\.");
              String _get_1 = _split_1[0];
              String _plus_6 = ("<img src=\'" + _get_1);
              String _plus_7 = (_plus_6 + ".png\' />");
              resp.append(_plus_7);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            VideoDescription _get_2 = _videodescs.get(0);
            String _location_6 = _get_2.getLocation();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_location_6);
            if (_isNullOrEmpty_2) {
              EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
              VideoDescription _get_3 = _videodescs_1.get(0);
              String _location_7 = _get_3.getLocation();
              String _plus_8 = ("<p> video : " + _location_7);
              String _plus_9 = (_plus_8 + "</p>");
              resp.append(_plus_9);
              EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
              VideoDescription _get_4 = _videodescs_2.get(0);
              String _location_8 = _get_4.getLocation();
              String[] _split_2 = _location_8.split("\\.");
              String _get_5 = _split_2[0];
              String _plus_10 = ("<img src=\'" + _get_5);
              String _plus_11 = (_plus_10 + ".png\' />");
              resp.append(_plus_11);
            }
          }
        }
      };
      _videoseqs.forEach(_function);
      _xblockexpression = resp.toString();
    }
    return _xblockexpression;
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoGenForGenerateButton.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
