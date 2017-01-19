package videogen;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.playlist.Playlist;
import org.xtext.example.mydsl.playlist.PlaylistFactory;
import org.xtext.example.mydsl.playlist.video;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import videogen.Operations;

@SuppressWarnings("all")
public class M3uRep {
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
    Playlist _xblockexpression = null;
    {
      String data = "";
      String _data = data;
      data = (_data + "#this is a comment\n");
      Playlist playList = PlaylistFactory.eINSTANCE.createPlaylist();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          video vid = PlaylistFactory.eINSTANCE.createvideo();
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = _description.getLocation();
          vid.setPath(_location);
          VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
          int _duration = _description_1.getDuration();
          vid.setDuration(_duration);
          VideoDescription _description_2 = ((MandatoryVideoSeq) videoseq).getDescription();
          String _description_3 = _description_2.getDescription();
          vid.setDescription(_description_3);
          EList<video> _videos = playList.getVideos();
          _videos.add(vid);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_1 = desc.getLocation();
            boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location_1);
            boolean _not = (!_isNullOrEmpty);
            if (_not) {
              Random _random = new Random();
              int _nextInt = _random.nextInt(2);
              boolean _equals = (_nextInt == 1);
              if (_equals) {
                video vid_1 = PlaylistFactory.eINSTANCE.createvideo();
                String _location_2 = desc.getLocation();
                vid_1.setPath(_location_2);
                int _duration_1 = desc.getDuration();
                vid_1.setDuration(_duration_1);
                String _description_4 = desc.getDescription();
                vid_1.setDescription(_description_4);
                EList<video> _videos_1 = playList.getVideos();
                _videos_1.add(vid_1);
              }
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            String _videoid = altvid.getVideoid();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              EList<VideoDescription> _videodescs = altvid.getVideodescs();
              Random _random_1 = new Random();
              EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
              int _size = _videodescs_1.size();
              int _nextInt_1 = _random_1.nextInt(_size);
              VideoDescription seq = _videodescs.get(_nextInt_1);
              video vid_2 = PlaylistFactory.eINSTANCE.createvideo();
              String _location_3 = seq.getLocation();
              vid_2.setPath(_location_3);
              String _description_5 = seq.getDescription();
              vid_2.setDescription(_description_5);
              int _duration_2 = seq.getDuration();
              vid_2.setDuration(_duration_2);
              EList<video> _videos_2 = playList.getVideos();
              _videos_2.add(vid_2);
            }
          }
        }
      }
      _xblockexpression = playList;
    }
    return _xblockexpression;
  }
  
  public static String toM3U(final Playlist playlist) {
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    return M3uRep.toM3U(playlist, Boolean.valueOf(false), Boolean.valueOf(false), _hashMap);
  }
  
  public static String toM3U(final Playlist playlist, final Boolean extended) {
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    return M3uRep.toM3U(playlist, extended, Boolean.valueOf(false), _hashMap);
  }
  
  public static String toM3U(final Playlist playlist, final Boolean extended, final Boolean discontinued) {
    HashMap<String, String> _hashMap = new HashMap<String, String>();
    return M3uRep.toM3U(playlist, extended, Boolean.valueOf(false), _hashMap);
  }
  
  /**
   * Return a textual representation of a M3U model to text convertion with extended, discontinuited and stream facility
   * 
   * Example :
   * 		result => http://schworak.com/blog/e41/extended-pls-plsv2/
   * 		options => {
   * 						"CODECS": "avc1.66.30,mp4a.40.2",
   * 						"RESOLUTION": "640x360",
   * 						"BANDWITH": "684383",
   * 						...
   * 					}
   * @see https://en.wikipedia.org/wiki/M3U
   * @see http://schworak.com/blog/e39/m3u-play-list-specification/
   * @see http://tools.ietf.org/html/draft-pantos-http-live-streaming
   */
  public static String toM3U(final Playlist playlist, final Boolean extended, final Boolean discontinued, final Map<String, String> options) {
    String _xblockexpression = null;
    {
      final StringBuffer content = new StringBuffer();
      if ((extended).booleanValue()) {
        content.append(("#EXTM3U" + "\n"));
        content.append(("#EXT-X-VERSION:3" + "\n"));
        content.append(("#EXT-X-MEDIA-SEQUENCE:44850" + "\n"));
      }
      boolean _isEmpty = options.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final ArrayList<Object> list = Lists.<Object>newArrayList();
        final BiConsumer<String, String> _function = (String key, String value) -> {
          list.add(((key + "=") + value));
        };
        options.forEach(_function);
        String _join = IterableExtensions.join(list, ",");
        String _plus = ("#EXT-X-STREAM-INF:" + _join);
        String _plus_1 = (_plus + "\n");
        content.append(_plus_1);
      }
      EList<video> _videos = playlist.getVideos();
      final Consumer<video> _function_1 = (video video) -> {
        if ((extended).booleanValue()) {
          if ((discontinued).booleanValue()) {
            content.append(("#EXT-X-DISCONTINUITY" + "\n"));
          }
          int _duration = video.getDuration();
          String _plus_2 = ("#EXTINF:" + Integer.valueOf(_duration));
          String _plus_3 = (_plus_2 + ",");
          String _description = video.getDescription();
          String _plus_4 = (_plus_3 + _description);
          String _plus_5 = (_plus_4 + "\n");
          content.append(_plus_5);
        }
        String _path = video.getPath();
        String _plus_6 = (_path + "\n");
        content.append(_plus_6);
      };
      _videos.forEach(_function_1);
      if ((extended).booleanValue()) {
        content.append(("#EXT-X-ENDLIST" + "\n"));
      }
      String _string = content.toString();
      Operations.writeToFile("m3u.txt", _string);
      _xblockexpression = content.toString();
    }
    return _xblockexpression;
  }
  
  public static void main(final String[] args) {
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = M3uRep.loadVideoGenerator(_createURI);
    Playlist _videoToPlaylist = M3uRep.videoToPlaylist(videoGen);
    M3uRep.toM3U(_videoToPlaylist);
  }
}
