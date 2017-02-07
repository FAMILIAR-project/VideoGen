package videogen;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Consumer;
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
import playList.MediaFile;
import playList.PlayList;
import playList.PlayListFactory;
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
    try {
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
      final PlayList playlist = PlayListFactory.eINSTANCE.createPlayList();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          final MediaFile mediaFile = PlayListFactory.eINSTANCE.createMediaFile();
          String _location = desc.getLocation();
          mediaFile.setLocation(_location);
          EList<MediaFile> _vids = playlist.getVids();
          _vids.add(mediaFile);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            Random _random = new Random();
            final int i = _random.nextInt(2);
            if ((i == 0)) {
              final MediaFile mediaFile_1 = PlayListFactory.eINSTANCE.createMediaFile();
              String _location_1 = desc_1.getLocation();
              mediaFile_1.setLocation(_location_1);
              EList<MediaFile> _vids_1 = playlist.getVids();
              _vids_1.add(mediaFile_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            Random _random_1 = new Random();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            final int j = _random_1.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vid = _videodescs_1.get(j);
            final MediaFile mediaFile_2 = PlayListFactory.eINSTANCE.createMediaFile();
            String _location_2 = vid.getLocation();
            mediaFile_2.setLocation(_location_2);
            EList<MediaFile> _vids_2 = playlist.getVids();
            _vids_2.add(mediaFile_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      final String playlistOnString = ModelToModel.convertPlaylistIntoFormat(playlist, "txt");
      File file = new File("ffmpeg.txt");
      FileWriter filewriter = new FileWriter(file);
      filewriter.write(playlistOnString);
      filewriter.flush();
      filewriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String convertPlaylistIntoFormat(final PlayList playlist, final String ext) {
    String _xblockexpression = null;
    {
      FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
      String data = "";
      boolean _equals = "M3U".equals(ext);
      if (_equals) {
        final EList<MediaFile> vids = playlist.getVids();
        for (final MediaFile f : vids) {
          String _data = data;
          String _location = f.getLocation();
          String _plus = (_location + "\n");
          data = (_data + _plus);
        }
      }
      boolean _equals_1 = "txt".equals(ext);
      if (_equals_1) {
        final EList<MediaFile> vids_1 = playlist.getVids();
        for (final MediaFile f_1 : vids_1) {
          String _data_1 = data;
          String _location_1 = f_1.getLocation();
          String _plus_1 = ("file \'" + _location_1);
          String _plus_2 = (_plus_1 + "\'");
          String _plus_3 = (_plus_2 + "\n");
          data = (_data_1 + _plus_3);
        }
      }
      _xblockexpression = data;
    }
    return _xblockexpression;
  }
  
  public static void modelToPlayListWithScreenShot() {
    try {
      FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
      URI _createURI = URI.createURI("foo2.videogen");
      VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
      final PlayList playlist = PlayListFactory.eINSTANCE.createPlayList();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          final MediaFile mediaFile = PlayListFactory.eINSTANCE.createMediaFile();
          String _location = desc.getLocation();
          mediaFile.setLocation(_location);
          String _location_1 = desc.getLocation();
          String _string = _location_1.toString();
          ffmpeg.executeCmd(_string, "v1");
          EList<MediaFile> _vids = playlist.getVids();
          _vids.add(mediaFile);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            Random _random = new Random();
            final int i = _random.nextInt(2);
            if ((i == 0)) {
              final MediaFile mediaFile_1 = PlayListFactory.eINSTANCE.createMediaFile();
              String _location_2 = desc_1.getLocation();
              mediaFile_1.setLocation(_location_2);
              String _location_3 = desc_1.getLocation();
              String _string_1 = _location_3.toString();
              ffmpeg.executeCmd(_string_1, "v2");
              EList<MediaFile> _vids_1 = playlist.getVids();
              _vids_1.add(mediaFile_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            Random _random_1 = new Random();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            final int j = _random_1.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vid = _videodescs_1.get(j);
            final MediaFile mediaFile_2 = PlayListFactory.eINSTANCE.createMediaFile();
            String _location_4 = vid.getLocation();
            mediaFile_2.setLocation(_location_4);
            String _location_5 = vid.getLocation();
            String _string_2 = _location_5.toString();
            ffmpeg.executeCmd(_string_2, "v3");
            EList<MediaFile> _vids_2 = playlist.getVids();
            _vids_2.add(mediaFile_2);
          }
        }
      }
      final String playlistOnString = ModelToModel.convertPlaylistIntoFormat(playlist, "txt");
      File file = new File("ffmpeg.txt");
      FileWriter filewriter = new FileWriter(file);
      filewriter.write(playlistOnString);
      filewriter.flush();
      filewriter.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
    FFMPEGHelpere ffmpeg = new FFMPEGHelpere();
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = ModelToModel.loadVideoGenerator(_createURI);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getFilter())) && "blackandwhite".equals(desc.getFilter()))) {
          String _location = desc.getLocation();
          String _string = _location.toString();
          ffmpeg.executeCmdFilterBlackAndWhite(_string, "blkw1");
        }
        if (((!StringExtensions.isNullOrEmpty(desc.getFilter())) && "lighter".equals(desc.getFilter()))) {
          String _location_1 = desc.getLocation();
          String _string_1 = _location_1.toString();
          ffmpeg.executeCmdFilterLighter(_string_1, "lgtr1");
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getFilter())) && "blackandwhite".equals(desc_1.getFilter()))) {
            String _location_2 = desc_1.getLocation();
            String _string_2 = _location_2.toString();
            ffmpeg.executeCmdFilterBlackAndWhite(_string_2, "blkw1");
          }
          if (((!StringExtensions.isNullOrEmpty(desc_1.getFilter())) && "lighter".equals(desc_1.getFilter()))) {
            String _location_3 = desc_1.getLocation();
            String _string_3 = _location_3.toString();
            ffmpeg.executeCmdFilterLighter(_string_3, "lgtr1");
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            {
              if (((!StringExtensions.isNullOrEmpty(vdesc.getFilter())) && "blackandwhite".equals(vdesc.getFilter()))) {
                String _location_4 = vdesc.getLocation();
                String _string_4 = _location_4.toString();
                ffmpeg.executeCmdFilterBlackAndWhite(_string_4, "blkw1");
              }
              if (((!StringExtensions.isNullOrEmpty(vdesc.getFilter())) && "lighter".equals(vdesc.getFilter()))) {
                String _location_5 = vdesc.getLocation();
                String _string_5 = _location_5.toString();
                ffmpeg.executeCmdFilterLighter(_string_5, "lgtr1");
              }
            }
          }
        }
      }
    }
  }
  
  public static void main(final String[] args) {
    ModelToModel.printDurationOfVideos();
  }
}
