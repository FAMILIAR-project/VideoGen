package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogenPlayList.MediaFile;
import videogenPlayList.PlayList;
import videogenPlayList.impl.VideogenPlayListFactoryImpl;

@SuppressWarnings("all")
public class VideoDemonstratorGification {
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
      Process process = _runtime.exec(
        ("C:\\Users\\kaoutar\\Downloads\\ffmpeg-20161204-1f5630a-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
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
  
  public static String creerGif(final String duration, final String start, final String size, final String path, final String filename) {
    try {
      String cmdGif = "ffmpeg -v warning ";
      boolean _notEquals = (!Objects.equal(duration, null));
      if (_notEquals) {
        String _cmdGif = cmdGif;
        cmdGif = (_cmdGif + (("-t " + duration) + " "));
      }
      boolean _notEquals_1 = (!Objects.equal(start, null));
      if (_notEquals_1) {
        String _cmdGif_1 = cmdGif;
        cmdGif = (_cmdGif_1 + ((" -ss " + start) + " "));
      }
      String _cmdGif_2 = cmdGif;
      cmdGif = (_cmdGif_2 + (("-i " + path) + " "));
      boolean _notEquals_2 = (!Objects.equal(size, null));
      if (_notEquals_2) {
        String _cmdGif_3 = cmdGif;
        cmdGif = (_cmdGif_3 + (("-vf scale=" + size) + ":-1 "));
      } else {
        String _cmdGif_4 = cmdGif;
        cmdGif = (_cmdGif_4 + "-vf scale=300:-1 ");
      }
      String _cmdGif_5 = cmdGif;
      cmdGif = (_cmdGif_5 + (("-gifflags +transdiff -y " + filename) + ".gif"));
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdGif);
      process.waitFor();
      return (filename + ".gif");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void deleteFile(final String path) {
    try {
      String cmdDelete = ("rm " + path);
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdDelete);
      process.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void concat(final String playlist) {
    try {
      String cmdConcatener = (("ffmpeg -f concat -safe 0 -i " + playlist) + " -c copy /videoconcat.m3u");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdConcatener);
      process.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testGification() {
    URI _createURI = URI.createURI("fooVideos.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    VideogenPlayListFactoryImpl fact = new VideogenPlayListFactoryImpl();
    PlayList playlist = fact.createPlayList();
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        InputOutput.<String>println("Mandatory");
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String fileLocation = _description.getLocation();
        MediaFile mediafile = fact.createMediaFile();
        mediafile.setLocation(fileLocation);
        double _duration = VideoDemonstratorGification.getDuration(fileLocation);
        mediafile.setDuration(_duration);
        EList<MediaFile> _mediaFile = playlist.getMediaFile();
        _mediaFile.add(mediafile);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          final int rand = _random.nextInt(2);
          if ((rand == 0)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_1.getLocation();
            MediaFile mediafile_1 = fact.createMediaFile();
            mediafile_1.setLocation(fileLocation_1);
            double _duration_1 = VideoDemonstratorGification.getDuration(fileLocation_1);
            mediafile_1.setDuration(_duration_1);
            EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
            _mediaFile_1.add(mediafile_1);
          }
        } else {
          InputOutput.<String>println("Alternatives");
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
          final int size = _videodescs.size();
          EList<VideoDescription> _videodescs_1 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          Random _random_1 = new Random();
          int _nextInt = _random_1.nextInt(size);
          VideoDescription _get = _videodescs_1.get(_nextInt);
          String fileLocation_2 = _get.getLocation();
          MediaFile mediafile_2 = fact.createMediaFile();
          mediafile_2.setLocation(fileLocation_2);
          double _duration_2 = VideoDemonstratorGification.getDuration(fileLocation_2);
          mediafile_2.setDuration(_duration_2);
          EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
          _mediaFile_2.add(mediafile_2);
        }
      }
    }
    try {
      final String path = "/";
      final File pl = new File((path + "playlist.txt"));
      boolean _exists = pl.exists();
      boolean _not = (!_exists);
      if (_not) {
        pl.createNewFile();
      }
      File _absoluteFile = pl.getAbsoluteFile();
      final FileWriter fw = new FileWriter(_absoluteFile);
      final BufferedWriter bw = new BufferedWriter(fw);
      double totalDuration = 0.0;
      EList<MediaFile> _mediaFile_3 = playlist.getMediaFile();
      for (final MediaFile mediafile_3 : _mediaFile_3) {
        {
          String _location = mediafile_3.getLocation();
          String _plus = ("file " + _location);
          String _lineSeparator = System.lineSeparator();
          String _plus_1 = (_plus + _lineSeparator);
          bw.write(_plus_1);
          double _duration_3 = mediafile_3.getDuration();
          double _plus_2 = (totalDuration + _duration_3);
          totalDuration = _plus_2;
          String _location_1 = mediafile_3.getLocation();
          String _plus_3 = (_location_1 + "(");
          double _duration_4 = mediafile_3.getDuration();
          String _plus_4 = (_plus_3 + Double.valueOf(_duration_4));
          String _plus_5 = (_plus_4 + ")s");
          InputOutput.<String>println(_plus_5);
        }
      }
      bw.close();
      VideoDemonstratorGification.concat((path + "playlist.txt"));
      InputOutput.<String>println(" concat done");
      VideoDemonstratorGification.deleteFile((path + "playlist.txt"));
      String _string = Double.valueOf(totalDuration).toString();
      final String myGif = VideoDemonstratorGification.creerGif(_string, null, "500", (path + "videoconcat.m3u"), "myGif");
      InputOutput.<String>println(" mygif done");
      VideoDemonstratorGification.deleteFile((path + "videoconcat.mp4"));
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}
