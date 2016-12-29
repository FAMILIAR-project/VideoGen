package videogen;

import M3u.M3uFactory;
import M3u.MediaFile;
import M3u.Playlist;
import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoDemonstratorFFmpegPlayList {
  private static String pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
  
  private static String pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/";
  
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
  
  @Test
  public void test1() {
    URI _createURI = URI.createURI("fooReal.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    Playlist play = M3uFactory.eINSTANCE.createPlaylist();
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
    this.registerPlayList(videoGen, play);
  }
  
  public void registerPlayList(final VideoGeneratorModel videoGen, final Playlist play) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc.getLocation())))) {
          MediaFile mediaFile = M3uFactory.eINSTANCE.createMediaFile();
          String _location = desc.getLocation();
          mediaFile.setLocation(_location);
          EList<MediaFile> _mediafile = play.getMediafile();
          _mediafile.add(mediaFile);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc_1.getLocation())))) {
            Random _random = new Random();
            final int test = _random.nextInt(100);
            if ((test <= 50)) {
              MediaFile mediaFile_1 = M3uFactory.eINSTANCE.createMediaFile();
              String _location_1 = desc_1.getLocation();
              mediaFile_1.setLocation(_location_1);
              EList<MediaFile> _mediafile_1 = play.getMediafile();
              _mediafile_1.add(mediaFile_1);
            }
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          Random _random_1 = new Random();
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          final int choix = _random_1.nextInt(_size);
          EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
          final VideoDescription vdesc = _videodescs_1.get(choix);
          if (((!StringExtensions.isNullOrEmpty(vdesc.getVideoid())) && (!StringExtensions.isNullOrEmpty(vdesc.getLocation())))) {
            MediaFile mediaFile_2 = M3uFactory.eINSTANCE.createMediaFile();
            String _location_2 = vdesc.getLocation();
            mediaFile_2.setLocation(_location_2);
            EList<MediaFile> _mediafile_2 = play.getMediafile();
            _mediafile_2.add(mediaFile_2);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    this.createScripts(play);
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorFFmpegPlayList.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  public void createScripts(final Playlist play) {
    EList<MediaFile> _mediafile = play.getMediafile();
    int _size = _mediafile.size();
    String _plus = ("Size:" + Integer.valueOf(_size));
    System.out.println(_plus);
    InputOutput.<String>println("=======FFMpeg======");
    InputOutput.<String>println("#DebutGeneration");
    EList<MediaFile> _mediafile_1 = play.getMediafile();
    for (final MediaFile f : _mediafile_1) {
      String _location = f.getLocation();
      String _plus_1 = ("file \'" + _location);
      String _plus_2 = (_plus_1 + "\'");
      InputOutput.<String>println(_plus_2);
    }
    InputOutput.<String>println("#FinGeneration");
    InputOutput.<String>println("======M3U======");
    InputOutput.<String>println("#EXTM3U");
    EList<MediaFile> _mediafile_2 = play.getMediafile();
    for (final MediaFile f_1 : _mediafile_2) {
      {
        InputOutput.<String>println("#EXT-X-DISCONTINUITY");
        String _location_1 = f_1.getLocation();
        String _plus_3 = (VideoDemonstratorFFmpegPlayList.pathVideo + _location_1);
        int _duration = VideoDemonstratorFFmpegPlayList.getDuration(_plus_3);
        String _plus_4 = ("#EXTINF:" + Integer.valueOf(_duration));
        InputOutput.<String>println(_plus_4);
        String _location_2 = f_1.getLocation();
        String _plus_5 = ("" + _location_2);
        String _plus_6 = (_plus_5 + "");
        InputOutput.<String>println(_plus_6);
      }
    }
    InputOutput.<String>println("#EXT-X-ENDLIST");
  }
  
  public static int getDuration(final String path) {
    try {
      String pathnorm = path.replace("/", "\\");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec((((VideoDemonstratorFFmpegPlayList.pathFFmpeg + "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"") + pathnorm) + "\""));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      float _parseFloat = Float.parseFloat(outputJson);
      int _round = Math.round(_parseFloat);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
