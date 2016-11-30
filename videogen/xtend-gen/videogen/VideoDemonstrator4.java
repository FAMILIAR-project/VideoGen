package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
import videoGenQ2.MediaFile;
import videoGenQ2.Playlist;
import videoGenQ2.impl.VideoGenQ2FactoryImpl;

@SuppressWarnings("all")
public class VideoDemonstrator4 {
  private Scanner s;
  
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
  
  public static double getDuration(final String videoLocation) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(("ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      double _parseDouble = Double.parseDouble(outputJson);
      long _round = Math.round(_parseDouble);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String createVignette(final String path, final String filename) {
    try {
      String cmdVignette = (((("ffmpeg -y -i " + path) + " -r 1 -t 00:00:01 -ss 00:00:02 -f image2 /home/dania/Documents/IDM/Vignettes/") + filename) + ".png");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdVignette);
      process.waitFor();
      return (("/home/dania/Documents/IDM/Vignettes/" + filename) + ".png");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void tp3_q9() {
    URI _createURI = URI.createURI("main.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    VideoGenQ2FactoryImpl fact = new VideoGenQ2FactoryImpl();
    Playlist playlist = fact.createPlaylist();
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        InputOutput.<String>println("Mandatory");
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String fileLocation = _description.getLocation();
        VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
        String fileId = _description_1.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(fileId);
        if (_isNullOrEmpty) {
          String _genID = this.genID();
          fileId = _genID;
        }
        MediaFile mediafile = fact.createMediaFile();
        mediafile.setLocation(fileLocation);
        double _duration = VideoDemonstrator4.getDuration(fileLocation);
        mediafile.setDuration(_duration);
        VideoDemonstrator4.createVignette(fileLocation, fileId);
        EList<MediaFile> _mediafile = playlist.getMediafile();
        _mediafile.add(mediafile);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          IntStream _ints = _random.ints(1);
          boolean _equals = Objects.equal(_ints, Integer.valueOf(1));
          if (_equals) {
            VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_2.getLocation();
            VideoDescription _description_3 = ((MandatoryVideoSeq) videoseq).getDescription();
            String fileId_1 = _description_3.getVideoid();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(fileId_1);
            if (_isNullOrEmpty_1) {
              String _genID_1 = this.genID();
              fileId_1 = _genID_1;
            }
            MediaFile mediafile_1 = fact.createMediaFile();
            mediafile_1.setLocation(fileLocation_1);
            double _duration_1 = VideoDemonstrator4.getDuration(fileLocation_1);
            mediafile_1.setDuration(_duration_1);
            VideoDemonstrator4.createVignette(fileLocation_1, fileId_1);
            EList<MediaFile> _mediafile_1 = playlist.getMediafile();
            _mediafile_1.add(mediafile_1);
          }
        } else {
          InputOutput.<String>println("else");
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
          final int size = _videodescs.size();
          EList<VideoDescription> _videodescs_1 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          Random _random_1 = new Random();
          int _nextInt = _random_1.nextInt(size);
          VideoDescription _get = _videodescs_1.get(_nextInt);
          String fileLocation_2 = _get.getLocation();
          MediaFile mediafile_2 = fact.createMediaFile();
          mediafile_2.setLocation(fileLocation_2);
          double _duration_2 = VideoDemonstrator4.getDuration(fileLocation_2);
          mediafile_2.setDuration(_duration_2);
          EList<MediaFile> _mediafile_2 = playlist.getMediafile();
          _mediafile_2.add(mediafile_2);
        }
      }
    }
  }
  
  public void printToHTML(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("<ul>");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _videoid_1 = desc.getVideoid();
          String _plus = ("<li>" + _videoid_1);
          String _plus_1 = (_plus + "</li>");
          InputOutput.<String>println(_plus_1);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_2 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _videoid_3 = desc_1.getVideoid();
            String _plus_2 = ("<li>" + _videoid_3);
            String _plus_3 = (_plus_2 + "</li>");
            InputOutput.<String>println(_plus_3);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_4 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_4);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            String _videoid_5 = altvid.getVideoid();
            String _plus_4 = ("<li>" + _videoid_5);
            String _plus_5 = (_plus_4 + "</li>");
            InputOutput.<String>println(_plus_5);
          }
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            InputOutput.<String>println("<ul>");
          }
          EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs_1) {
            String _videoid_6 = vdesc.getVideoid();
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_6);
            boolean _not_3 = (!_isNullOrEmpty_3);
            if (_not_3) {
              String _videoid_7 = vdesc.getVideoid();
              String _plus_6 = ("<li>" + _videoid_7);
              String _plus_7 = (_plus_6 + "</li>");
              InputOutput.<String>println(_plus_7);
            }
          }
          EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
          int _size_1 = _videodescs_2.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            InputOutput.<String>println("</ul>");
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("</ul>");
  }
  
  private static int i = 0;
  
  private File ffmpeg;
  
  public String genID() {
    int _plusPlus = VideoDemonstrator4.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
