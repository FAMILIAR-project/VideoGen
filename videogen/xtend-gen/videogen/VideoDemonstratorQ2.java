package videogen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
public class VideoDemonstratorQ2 {
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
  public void TestTp3Q2() {
    URI _createURI = URI.createURI("fooVideos.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
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
      final File CPlaylist = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\playlist.m3u");
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
  
  /**
   * @Test
   * def test1() {
   * // loading
   * var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen"))
   * assertNotNull(videoGen)
   * assertEquals(7, videoGen.videoseqs.size)
   * videoGen.videoseqs.forEach[videoseq |
   * if (videoseq instanceof MandatoryVideoSeq) {
   * 
   * val desc = (videoseq as MandatoryVideoSeq).description
   * 
   * if(desc.videoid.isNullOrEmpty)  desc.videoid = genID()
   * 
   * }
   * else if (videoseq instanceof OptionalVideoSeq) {
   * 
   * val desc = (videoseq as OptionalVideoSeq).description
   * if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
   * }
   * 
   * else {
   * val altvid = (videoseq as AlternativeVideoSeq)
   * if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
   * for (vdesc : altvid.videodescs) {
   * if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
   * }
   * }
   * ]
   * // serializing
   * saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
   * saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
   * 
   * printToM3u(videoGen)
   * 
   * }
   */
  public void printToM3u(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("#this is a comment");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _playList = this.playList;
          String _location = desc.getLocation();
          String _plus = ("file \'" + _location);
          String _plus_1 = (_plus + "\'");
          String _lineSeparator = System.lineSeparator();
          String _plus_2 = (_plus_1 + _lineSeparator);
          this.playList = (_playList + _plus_2);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          Random _random = new Random();
          final int unsurDeux = _random.nextInt(2);
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if ((unsurDeux == 0)) {
            String _playList_1 = this.playList;
            String _location_1 = desc_1.getLocation();
            String _plus_3 = ("file \'" + _location_1);
            String _plus_4 = (_plus_3 + "\'");
            String _lineSeparator_1 = System.lineSeparator();
            String _plus_5 = (_plus_4 + _lineSeparator_1);
            this.playList = (_playList_1 + _plus_5);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          final int nbrFichier = _videodescs.size();
          Random _random_1 = new Random();
          final int numFichier = _random_1.nextInt(nbrFichier);
          String _videoid_1 = altvid.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _playList_2 = this.playList;
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            VideoDescription _get = _videodescs_1.get(numFichier);
            String _location_2 = _get.getLocation();
            String _plus_6 = ("file \'" + _location_2);
            String _plus_7 = (_plus_6 + "\'");
            String _lineSeparator_2 = System.lineSeparator();
            String _plus_8 = (_plus_7 + _lineSeparator_2);
            this.playList = (_playList_2 + _plus_8);
          }
          EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
          int _size = _videodescs_2.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            InputOutput.<String>println("file");
          }
          EList<VideoDescription> _videodescs_3 = altvid.getVideodescs();
          VideoDescription _get_1 = _videodescs_3.get(numFichier);
          String _videoid_2 = _get_1.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            String _playList_3 = this.playList;
            EList<VideoDescription> _videodescs_4 = altvid.getVideodescs();
            VideoDescription _get_2 = _videodescs_4.get(numFichier);
            String _location_3 = _get_2.getLocation();
            String _plus_9 = ("file \'" + _location_3);
            String _plus_10 = (_plus_9 + "\'");
            String _lineSeparator_3 = System.lineSeparator();
            String _plus_11 = (_plus_10 + _lineSeparator_3);
            this.playList = (_playList_3 + _plus_11);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("</ul>");
  }
  
  private static int i = 0;
  
  private String playList = "";
  
  public String genID() {
    int _plusPlus = VideoDemonstratorQ2.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
