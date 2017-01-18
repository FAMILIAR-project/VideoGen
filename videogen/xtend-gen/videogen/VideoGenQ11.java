package videogen;

import com.google.common.base.Objects;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoGenQ11 {
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
  public void checkConformity() {
    URI _createURI = URI.createURI("foo4.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    this.checkLocation(videoGen);
    this.checkIdentifiers(videoGen);
    this.checkProbability(videoGen);
  }
  
  public void checkLocation(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location_1 = desc.getLocation();
          this.checkLocation(_location_1, videoGen);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _location_2 = desc_1.getLocation();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_2);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_3 = desc_1.getLocation();
            this.checkLocation(_location_3, videoGen);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _location_4 = vdesc.getLocation();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_location_4);
            boolean _not_2 = (!_isNullOrEmpty_2);
            if (_not_2) {
              String _location_5 = vdesc.getLocation();
              this.checkLocation(_location_5, videoGen);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public String checkLocation(final String location, final VideoGeneratorModel videoGen) {
    String _xblockexpression = null;
    {
      VideoGenQ11.i = 0;
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = desc.getLocation();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            String _videoid = desc.getVideoid();
            boolean _equals = Objects.equal(_videoid, location);
            if (_equals) {
              VideoGenQ11.i++;
            }
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_1 = desc_1.getLocation();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_1);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              String _videoid_1 = desc_1.getVideoid();
              boolean _equals_1 = Objects.equal(_videoid_1, location);
              if (_equals_1) {
                VideoGenQ11.i++;
              }
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _location_2 = vdesc.getLocation();
              boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_location_2);
              if (_isNullOrEmpty_2) {
                String _videoid_2 = vdesc.getVideoid();
                boolean _equals_2 = Objects.equal(_videoid_2, location);
                if (_equals_2) {
                  VideoGenQ11.i++;
                }
              }
            }
          }
        }
      };
      _videoseqs.forEach(_function);
      String _xifexpression = null;
      if ((VideoGenQ11.i > 1)) {
        _xifexpression = InputOutput.<String>println(("error : location checks : the same video location was found more than once ! " + location));
      } else {
        _xifexpression = InputOutput.<String>println(("info : location checks : no problem found on the video location : " + location));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void checkIdentifiers(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _videoid_1 = desc.getVideoid();
          this.checkIdentifiers(_videoid_1, videoGen);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_2 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _videoid_3 = desc_1.getVideoid();
            this.checkIdentifiers(_videoid_3, videoGen);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _videoid_4 = vdesc.getVideoid();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_4);
            boolean _not_2 = (!_isNullOrEmpty_2);
            if (_not_2) {
              String _videoid_5 = vdesc.getVideoid();
              this.checkIdentifiers(_videoid_5, videoGen);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  private static int i = 0;
  
  public String checkIdentifiers(final String videoid, final VideoGeneratorModel videoGen) {
    String _xblockexpression = null;
    {
      VideoGenQ11.i = 0;
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = desc.getVideoid();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            String _videoid_1 = desc.getVideoid();
            boolean _equals = Objects.equal(_videoid_1, videoid);
            if (_equals) {
              VideoGenQ11.i++;
            }
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_2 = desc_1.getVideoid();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_2);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              String _videoid_3 = desc_1.getVideoid();
              boolean _equals_1 = Objects.equal(_videoid_3, videoid);
              if (_equals_1) {
                VideoGenQ11.i++;
              }
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_4 = vdesc.getVideoid();
              boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_4);
              if (_isNullOrEmpty_2) {
                String _videoid_5 = vdesc.getVideoid();
                boolean _equals_2 = Objects.equal(_videoid_5, videoid);
                if (_equals_2) {
                  VideoGenQ11.i++;
                }
              }
            }
          }
        }
      };
      _videoseqs.forEach(_function);
      String _xifexpression = null;
      if ((VideoGenQ11.i > 1)) {
        _xifexpression = InputOutput.<String>println(("error : identifier checks : the same video was found more than once ! " + videoid));
      } else {
        _xifexpression = InputOutput.<String>println(("info : identifier checks : no problem found on the identifier " + videoid));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void checkProbability(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc = ((OptionalVideoSeq) videoseq).getDescription();
          int _probability = desc.getProbability();
          boolean _lessThan = (_probability < 100);
          if (_lessThan) {
            String _videoid = desc.getVideoid();
            String _plus = ("error : probability checks : optional video with more than 100% probability ! " + _videoid);
            InputOutput.<String>println(_plus);
          } else {
            String _videoid_1 = desc.getVideoid();
            String _plus_1 = ("info : probability checks : optional video with less than 100% probability : " + _videoid_1);
            InputOutput.<String>println(_plus_1);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          int sizeAll = 0;
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            int _sizeAll = sizeAll;
            int _probability_1 = vdesc.getProbability();
            sizeAll = (_sizeAll + _probability_1);
          }
          if ((sizeAll < 100)) {
            InputOutput.<String>println(("error : probability checks : alternative video with more than 100% probability ! " + Integer.valueOf(sizeAll)));
          } else {
            InputOutput.<String>println(("info : probability checks : alternative video with less than 100% probability : " + Integer.valueOf(sizeAll)));
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
}
