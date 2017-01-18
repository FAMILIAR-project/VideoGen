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
import java.util.function.Consumer;
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
import videogenPlayList.MediaFile;
import videogenPlayList.PlayList;
import videogenPlayList.impl.VideogenPlayListFactoryImpl;

@SuppressWarnings("all")
public class VideoDemonstratorQ3 {
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
      Process process = _runtime.exec(("C:\\Users\\kaoutar\\Downloads\\ffmpeg-20161204-1f5630a-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
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
  
  @Test
  public void TpQ3() {
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
        MediaFile mediaFile = fact.createMediaFile();
        mediaFile.setLocation(fileLocation);
        double _duration = VideoDemonstratorQ3.getDuration(fileLocation);
        mediaFile.setDuration(_duration);
        EList<MediaFile> _mediaFile = playlist.getMediaFile();
        _mediaFile.add(mediaFile);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          final int rand = _random.nextInt(2);
          if ((rand == 0)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_1.getLocation();
            MediaFile mediaFile_1 = fact.createMediaFile();
            mediaFile_1.setLocation(fileLocation_1);
            double _duration_1 = VideoDemonstratorQ3.getDuration(fileLocation_1);
            mediaFile_1.setDuration(_duration_1);
            EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
            _mediaFile_1.add(mediaFile_1);
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
          MediaFile mediaFile_2 = fact.createMediaFile();
          mediaFile_2.setLocation(fileLocation_2);
          double _duration_2 = VideoDemonstratorQ3.getDuration(fileLocation_2);
          mediaFile_2.setDuration(_duration_2);
          EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
          _mediaFile_2.add(mediaFile_2);
        }
      }
    }
    try {
      final File pl = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlistq3.m3u");
      boolean _exists = pl.exists();
      boolean _not = (!_exists);
      if (_not) {
        pl.createNewFile();
      }
      File _absoluteFile = pl.getAbsoluteFile();
      final FileWriter fw = new FileWriter(_absoluteFile);
      final BufferedWriter bw = new BufferedWriter(fw);
      String _lineSeparator = System.lineSeparator();
      String _plus = ("#EXTM3U" + _lineSeparator);
      bw.write(_plus);
      EList<MediaFile> _mediaFile_3 = playlist.getMediaFile();
      for (final MediaFile mediafile : _mediaFile_3) {
        double _duration_3 = mediafile.getDuration();
        String _plus_1 = ("#EXTINF:" + Double.valueOf(_duration_3));
        String _plus_2 = (_plus_1 + " ,Example Artist - Example title ");
        String _lineSeparator_1 = System.lineSeparator();
        String _plus_3 = (_plus_2 + _lineSeparator_1);
        String _location = mediafile.getLocation();
        String _plus_4 = (_plus_3 + _location);
        String _lineSeparator_2 = System.lineSeparator();
        String _plus_5 = (_plus_4 + _lineSeparator_2);
        bw.write(_plus_5);
      }
      bw.close();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Test
  public void test1() {
    URI _createURI = URI.createURI("fooVideos.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        if (_isNullOrEmpty) {
          String _genID = this.genID();
          desc.setVideoid(_genID);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _videoid_1 = desc_1.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          if (_isNullOrEmpty_1) {
            String _genID_1 = this.genID();
            desc_1.setVideoid(_genID_1);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          String _videoid_2 = altvid.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          if (_isNullOrEmpty_2) {
            String _genID_2 = this.genID();
            altvid.setVideoid(_genID_2);
          }
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _videoid_3 = vdesc.getVideoid();
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
            if (_isNullOrEmpty_3) {
              String _genID_3 = this.genID();
              vdesc.setVideoid(_genID_3);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    URI _createURI_1 = URI.createURI("foo2bis.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("foo2bis.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
  }
  
  public void printToM3u(final VideoGeneratorModel videoGen) {
    final VideogenPlayListFactoryImpl fact = new VideogenPlayListFactoryImpl();
    PlayList playlist = fact.createPlayList();
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        InputOutput.<String>println("Mandatory");
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String desc = _description.getLocation();
        MediaFile mediaFile = fact.createMediaFile();
        mediaFile.setLocation(desc);
        EList<MediaFile> _mediaFile = playlist.getMediaFile();
        _mediaFile.add(mediaFile);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          final int unsurDeux = _random.nextInt(2);
          if ((unsurDeux == 0)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            MediaFile mediaFile_1 = fact.createMediaFile();
            mediaFile_1.setLocation(desc_1);
            EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
            _mediaFile_1.add(mediaFile_1);
          }
        } else {
          InputOutput.<String>println("Alternative");
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
          final int altvidsize = _videodescs.size();
          EList<VideoDescription> _videodescs_1 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          Random _random_1 = new Random();
          int _nextInt = _random_1.nextInt(altvidsize);
          VideoDescription _get = _videodescs_1.get(_nextInt);
          final String desc_2 = _get.getLocation();
          MediaFile mediaFile_2 = fact.createMediaFile();
          mediaFile_2.setLocation(desc_2);
          EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
          _mediaFile_2.add(mediaFile_2);
        }
      }
    }
    try {
      final File CPlaylist = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlistq3.m3u");
      boolean _exists = CPlaylist.exists();
      boolean _not = (!_exists);
      if (_not) {
        CPlaylist.createNewFile();
      }
      String _path = CPlaylist.getPath();
      InputOutput.<String>println(_path);
      File _absoluteFile = CPlaylist.getAbsoluteFile();
      final FileWriter fw = new FileWriter(_absoluteFile);
      final BufferedWriter bw = new BufferedWriter(fw);
      String _lineSeparator = System.lineSeparator();
      String _plus = ("#EXTM3U" + _lineSeparator);
      bw.write(_plus);
      EList<MediaFile> _mediaFile_3 = playlist.getMediaFile();
      for (final MediaFile mediafile : _mediaFile_3) {
        String _lineSeparator_1 = System.lineSeparator();
        String _plus_1 = ("#EXTINF:-1, Example Artist - Example title" + _lineSeparator_1);
        String _location = mediafile.getLocation();
        String _plus_2 = (_plus_1 + _location);
        String _lineSeparator_2 = System.lineSeparator();
        String _plus_3 = (_plus_2 + _lineSeparator_2);
        bw.write(_plus_3);
      }
      bw.close();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorQ3.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
