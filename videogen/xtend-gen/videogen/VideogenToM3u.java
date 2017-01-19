package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
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
import videogenPlaylist.MediaFile;
import videogenPlaylist.Playlist;
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl;

/**
 * Questions 2
 */
@SuppressWarnings("all")
public class VideogenToM3u {
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
      Process process = _runtime.exec(("C:\\Users\\Robin\\Desktop\\ffmpeg-3.2.2-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
      process.waitFor(2000, TimeUnit.MILLISECONDS);
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
  public void test1() {
    URI _createURI = URI.createURI("testVideos.videogen");
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
    URI _createURI_1 = URI.createURI("fooQ1bis.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("fooQ1bis.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.toM3u(videoGen);
  }
  
  public void toM3u(final VideoGeneratorModel videoGen) {
    try {
      VideogenPlaylistFactoryImpl factory = new VideogenPlaylistFactoryImpl();
      Playlist playlist = factory.createPlaylist();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq video : _videoseqs) {
        {
          MediaFile file = factory.createMediaFile();
          if ((video instanceof MandatoryVideoSeq)) {
            final VideoDescription desc = ((MandatoryVideoSeq) video).getDescription();
            String _videoid = desc.getVideoid();
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              String _location = desc.getLocation();
              file.setPath(_location);
            }
            String _location_1 = desc.getLocation();
            double _duration = VideogenToM3u.getDuration(_location_1);
            file.setDuration(_duration);
            EList<MediaFile> _mediaFile = playlist.getMediaFile();
            _mediaFile.add(file);
          } else {
            if ((video instanceof OptionalVideoSeq)) {
              final VideoDescription desc_1 = ((OptionalVideoSeq) video).getDescription();
              Random _random = new Random();
              int _nextInt = _random.nextInt(2);
              boolean _equals = (_nextInt == 0);
              if (_equals) {
                String _videoid_1 = desc_1.getVideoid();
                boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
                boolean _not_1 = (!_isNullOrEmpty_1);
                if (_not_1) {
                  String _location_2 = desc_1.getLocation();
                  file.setPath(_location_2);
                }
                String _location_3 = desc_1.getLocation();
                double _duration_1 = VideogenToM3u.getDuration(_location_3);
                file.setDuration(_duration_1);
                EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
                _mediaFile_1.add(file);
              }
            } else {
              final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) video);
              EList<VideoDescription> _videodescs = altvid.getVideodescs();
              final int nbAltVids = _videodescs.size();
              Random _random_1 = new Random();
              final int i = _random_1.nextInt(nbAltVids);
              EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
              VideoDescription _get = _videodescs_1.get(i);
              String _location_4 = _get.getLocation();
              file.setPath(_location_4);
              EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
              VideoDescription _get_1 = _videodescs_2.get(i);
              String _location_5 = _get_1.getLocation();
              double _duration_2 = VideogenToM3u.getDuration(_location_5);
              file.setDuration(_duration_2);
              EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
              _mediaFile_2.add(file);
            }
          }
        }
      }
      final File file = new File("createdPlaylists/playlist.m3u");
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      }
      final FileWriter writer = new FileWriter(file);
      writer.write("#EXTM3U \n");
      EList<MediaFile> _mediaFile = playlist.getMediaFile();
      for (final MediaFile md : _mediaFile) {
        {
          writer.write("#EXT-X-DISCONTINUITY \n");
          double _duration = md.getDuration();
          String _plus = ("#EXTINF: " + Double.valueOf(_duration));
          String _plus_1 = (_plus + ", Sample artist - Sample title \n");
          writer.write(_plus_1);
          String _path = md.getPath();
          String _plus_2 = (_path + "\n");
          writer.write(_plus_2);
        }
      }
      writer.write("#EXT-X-ENDLIST");
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideogenToM3u.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
