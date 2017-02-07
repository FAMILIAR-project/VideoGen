package videogen;

import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.playlist.Playlist;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogen.Operations;

@SuppressWarnings("all")
public class FFmpegRep {
  public static VideoGeneratorModel loadVideoGenerator(final URI uri) {
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
  
  public static Playlist videoToPlaylist(final VideoGeneratorModel videoGen) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field createvideo is undefined for the type PlaylistFactory"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method or field createvideo is undefined for the type PlaylistFactory"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method or field createvideo is undefined for the type PlaylistFactory"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\npath cannot be resolved"
      + "\nduration cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nadd cannot be resolved"
      + "\npath cannot be resolved"
      + "\nduration cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nadd cannot be resolved"
      + "\npath cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nduration cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public static String playlistToFFMPEG(final Playlist playlist) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method or field path is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nforEach cannot be resolved");
  }
  
  public static void generateDuration(final VideoGeneratorModel videoGen) {
    final StringBuffer content = new StringBuffer();
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location = desc.getLocation();
          String i = Operations.commandFFmpegToGenerateDuration(_location);
          String _location_1 = desc.getLocation();
          String _plus = (_location_1 + "\t");
          content.append(_plus);
          content.append(i);
          content.append("\n");
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_2 = desc_1.getLocation();
            String i_1 = Operations.commandFFmpegToGenerateDuration(_location_2);
            String _location_3 = desc_1.getLocation();
            String _plus_1 = (_location_3 + "\t");
            content.append(_plus_1);
            content.append(i_1);
            content.append("\n");
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_3 = vdesc.getVideoid();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
              boolean _not_3 = (!_isNullOrEmpty_3);
              if (_not_3) {
                String _location_4 = vdesc.getLocation();
                String i_2 = Operations.commandFFmpegToGenerateDuration(_location_4);
                String _location_5 = vdesc.getLocation();
                String _plus_2 = (_location_5 + "\t");
                content.append(_plus_2);
                content.append(i_2);
                content.append("\n");
              }
            }
          }
        }
      }
    }
    String _string = content.toString();
    Operations.writeToFile("videosDuration.txt", _string);
  }
  
  public static void generateThumbnail(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location = desc.getLocation();
          String _location_1 = desc.getLocation();
          Operations.commandFFmpegToGenerateImage(_location, _location_1);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_2 = desc_1.getLocation();
            String _location_3 = desc_1.getLocation();
            Operations.commandFFmpegToGenerateImage(_location_2, _location_3);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_3 = vdesc.getVideoid();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
              boolean _not_3 = (!_isNullOrEmpty_3);
              if (_not_3) {
                String _location_4 = vdesc.getLocation();
                String _location_5 = vdesc.getLocation();
                Operations.commandFFmpegToGenerateImage(_location_4, _location_5);
              }
            }
          }
        }
      }
    }
  }
  
  public static void generateWebPage(final VideoGeneratorModel videoGen) {
    final StringBuffer contentMondatory = new StringBuffer();
    final StringBuffer contentOptionals = new StringBuffer();
    final StringBuffer contentAlt = new StringBuffer();
    contentMondatory.append(
      " <div style=\"display:inline-block; vertical-align:top;\" ><h3>Mondatory : </h3><ul></br>");
    contentOptionals.append(
      "<div style=\"display:inline-block; vertical-align:top; \"><h3>Optionals : </h3><ul></br>");
    contentAlt.append("<div style=\"display:inline-block; vertical-align:top;\"><h3>Alternatives : </h3><ul></br>");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location = desc.getLocation();
          String _plus = ("<li><img src=\"" + _location);
          String _plus_1 = (_plus + ".jpg\" width= \"200\" height=\"200\" alt=\"");
          String _location_1 = desc.getLocation();
          String _plus_2 = (_plus_1 + _location_1);
          String _plus_3 = (_plus_2 + "\"/></li>");
          contentMondatory.append(_plus_3);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_2 = desc_1.getLocation();
            String _plus_4 = ("<li><img src=\"" + _location_2);
            String _plus_5 = (_plus_4 + ".jpg\" width= \"200\" height=\"200\"  alt=\"");
            String _location_3 = desc_1.getLocation();
            String _plus_6 = (_plus_5 + _location_3);
            String _plus_7 = (_plus_6 + "\"/></li>");
            contentOptionals.append(_plus_7);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_3 = vdesc.getVideoid();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
              boolean _not_3 = (!_isNullOrEmpty_3);
              if (_not_3) {
                String _location_4 = vdesc.getLocation();
                String _plus_8 = ("<li><img src=\"" + _location_4);
                String _plus_9 = (_plus_8 + ".jpg\" width= \"200\" height=\"200\"  alt=\"");
                String _location_5 = vdesc.getLocation();
                String _plus_10 = (_plus_9 + _location_5);
                String _plus_11 = (_plus_10 + "\"/></li>");
                contentAlt.append(_plus_11);
              }
            }
          }
        }
      }
    }
    contentMondatory.append("</ul></div>");
    contentOptionals.append("</ul></div>");
    contentAlt.append("</ul></div>");
    String _string = contentMondatory.toString();
    String _string_1 = contentOptionals.toString();
    String _plus_12 = (_string + _string_1);
    String _string_2 = contentAlt.toString();
    String content = (_plus_12 + _string_2);
    Operations.writeToFile("webPage.html", content);
  }
  
  public static void textIncrust(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location = desc.getLocation();
          String _textIncrust = desc.getTextIncrust();
          Operations.commandIncrustText(_location, _textIncrust);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_1 = desc_1.getLocation();
            String _textIncrust_1 = desc_1.getTextIncrust();
            Operations.commandIncrustText(_location_1, _textIncrust_1);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_3 = vdesc.getVideoid();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
              boolean _not_3 = (!_isNullOrEmpty_3);
              if (_not_3) {
                String _location_2 = vdesc.getLocation();
                String _textIncrust_2 = vdesc.getTextIncrust();
                Operations.commandIncrustText(_location_2, _textIncrust_2);
              }
            }
          }
        }
      }
    }
    InputOutput.<String>println("sdsdsdsd");
  }
  
  public static void blackAndWhiteFilter(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location = desc.getLocation();
          Operations.commandFilterBlackAndWhite(_location);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_1 = desc_1.getLocation();
            Operations.commandFilterBlackAndWhite(_location_1);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_3 = vdesc.getVideoid();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
              boolean _not_3 = (!_isNullOrEmpty_3);
              if (_not_3) {
                String _location_2 = vdesc.getLocation();
                Operations.commandFilterBlackAndWhite(_location_2);
              }
            }
          }
        }
      }
    }
    InputOutput.<String>println("sdsdsdsd");
  }
  
  public static void main(final String[] args) {
    URI _createURI = URI.createURI("videos.videogen");
    VideoGeneratorModel videoGen = FFmpegRep.loadVideoGenerator(_createURI);
    FFmpegRep.generateDuration(videoGen);
  }
}
