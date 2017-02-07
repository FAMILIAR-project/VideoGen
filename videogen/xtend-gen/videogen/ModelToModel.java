package videogen;

import java.io.File;
import java.io.FileWriter;
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
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogen.FFMPEGHelpere;

@SuppressWarnings("all")
public class ModelToModel {
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
  
  public static void modelToPlayList() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method convertPlaylistIntoFormat(PlayList, String) from the type ModelToModel refers to the missing type PlayList"
      + "\neINSTANCE cannot be resolved"
      + "\ncreatePlayList cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nadd cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nadd cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public static String convertPlaylistIntoFormat(final /* PlayList */Object playlist, final String ext) {
    throw new Error("Unresolved compilation problems:"
      + "\nMediaFile cannot be resolved to a type."
      + "\nMediaFile cannot be resolved to a type."
      + "\nvids cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\n+ cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nlocation cannot be resolved");
  }
  
  public static void modelToPlayListWithScreenShot() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method or field PlayListFactory is undefined"
      + "\nThe method convertPlaylistIntoFormat(PlayList, String) from the type ModelToModel refers to the missing type PlayList"
      + "\neINSTANCE cannot be resolved"
      + "\ncreatePlayList cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nadd cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nadd cannot be resolved"
      + "\neINSTANCE cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nvids cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public static void printDurationOfVideos() {
    FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        String temps = ffmpeg.executeCmdGetDuration(_location);
        InputOutput.<String>println(temps);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _location_1 = desc_1.getLocation();
          String temps_1 = ffmpeg.executeCmdGetDuration(_location_1);
          InputOutput.<String>println(temps_1);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            {
              String _location_2 = vdesc.getLocation();
              String temps_2 = ffmpeg.executeCmdGetDuration(_location_2);
              InputOutput.<String>println(temps_2);
            }
          }
        }
      }
    }
  }
  
  public static void printWebPage() {
    try {
      FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
      File file = new File("screenShot.html");
      FileWriter filewriter = new FileWriter(file);
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
      filewriter.write("<html> <body>");
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = desc.getLocation();
          String _string = _location.toString();
          String _location_1 = desc.getLocation();
          ffmpeg.executeCmd(_string, _location_1);
          String _location_2 = desc.getLocation();
          String _plus = (("<div> <img" + " src = \"screenshot/") + _location_2);
          String _plus_1 = (_plus + ".png\"");
          String _plus_2 = (_plus_1 + " height = \"300px\"");
          String _plus_3 = (_plus_2 + " width = \"300px\"");
          String _plus_4 = (_plus_3 + "\"/></div>");
          filewriter.write(_plus_4);
          filewriter.write("</br>");
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_3 = desc_1.getLocation();
            String _string_1 = _location_3.toString();
            String _location_4 = desc_1.getLocation();
            ffmpeg.executeCmd(_string_1, _location_4);
            String _location_5 = desc_1.getLocation();
            String _plus_5 = (("<div> <img" + " src = \"screenshot/") + _location_5);
            String _plus_6 = (_plus_5 + ".png\"");
            String _plus_7 = (_plus_6 + " height = \"300px\"");
            String _plus_8 = (_plus_7 + " width = \"300px\"");
            String _plus_9 = (_plus_8 + "\"/></div>");
            filewriter.write(_plus_9);
            filewriter.write("</br>");
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            filewriter.write("<div> ");
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String _location_6 = vdesc.getLocation();
                String _string_2 = _location_6.toString();
                String _location_7 = vdesc.getLocation();
                ffmpeg.executeCmd(_string_2, _location_7);
                String _location_8 = vdesc.getLocation();
                String _plus_10 = (("<img" + " src = \"screenshot/") + _location_8);
                String _plus_11 = (_plus_10 + ".png\"");
                String _plus_12 = (_plus_11 + " height = \"300px\"");
                String _plus_13 = (_plus_12 + " width = \"300px\"");
                String _plus_14 = (_plus_13 + "\"/>");
                filewriter.write(_plus_14);
              }
            }
            filewriter.write("</div> ");
          }
        }
      }
      filewriter.write("</body></html> ");
      filewriter.flush();
      filewriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void generateGIF() {
    FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        String _string = _location.toString();
        String _location_1 = desc.getLocation();
        ffmpeg.executeCmdGIF(_string, _location_1);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _location_2 = desc_1.getLocation();
          String _string_1 = _location_2.toString();
          String _location_3 = desc_1.getLocation();
          ffmpeg.executeCmdGIF(_string_1, _location_3);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _location_4 = vdesc.getLocation();
            String _string_2 = _location_4.toString();
            String _location_5 = vdesc.getLocation();
            ffmpeg.executeCmdGIF(_string_2, _location_5);
          }
        }
      }
    }
  }
  
  public static void incrustText() {
    FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _textIncrust = desc.getTextIncrust();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_textIncrust);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _location = desc.getLocation();
          String _string = _location.toString();
          String _textIncrust_1 = desc.getTextIncrust();
          ffmpeg.executeCmdIncrustText(_string, "incr1", _textIncrust_1);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _textIncrust_2 = desc_1.getTextIncrust();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_textIncrust_2);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _location_1 = desc_1.getLocation();
            String _string_1 = _location_1.toString();
            String _textIncrust_3 = desc_1.getTextIncrust();
            ffmpeg.executeCmdIncrustText(_string_1, "incr4", _textIncrust_3);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _textIncrust_4 = vdesc.getTextIncrust();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_textIncrust_4);
            boolean _not_2 = (!_isNullOrEmpty_2);
            if (_not_2) {
              String _location_2 = vdesc.getLocation();
              String _string_2 = _location_2.toString();
              String _textIncrust_5 = vdesc.getTextIncrust();
              ffmpeg.executeCmdIncrustText(_string_2, "incr3", _textIncrust_5);
            }
          }
        }
      }
    }
  }
  
  public static void filters() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field isNullOrEmpty is undefined for the type Filter"
      + "\nThe method or field isNullOrEmpty is undefined for the type Filter"
      + "\nThe method or field isNullOrEmpty is undefined for the type Filter"
      + "\nThe method or field isNullOrEmpty is undefined for the type Filter"
      + "\nThe method or field isNullOrEmpty is undefined for the type Filter"
      + "\nThe method or field isNullOrEmpty is undefined for the type Filter"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n! cannot be resolved"
      + "\n&& cannot be resolved");
  }
  
  public static void main(final String[] args) {
    ModelToModel.printDurationOfVideos();
  }
}
