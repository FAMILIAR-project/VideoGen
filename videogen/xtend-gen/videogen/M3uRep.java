package videogen;

import java.util.HashMap;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.playlist.Playlist;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method or field duration is undefined for the type Object"
      + "\nThe method or field description is undefined for the type Object"
      + "\nThe method or field path is undefined for the type Object"
      + "\nThere is no context to infer the closure\'s argument types from. Consider typing the arguments or put the closures into a typed context."
      + "\nforEach cannot be resolved"
      + "\n+ cannot be resolved");
  }
  
  public static void main(final String[] args) {
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = M3uRep.loadVideoGenerator(_createURI);
    Playlist _videoToPlaylist = M3uRep.videoToPlaylist(videoGen);
    M3uRep.toM3U(_videoToPlaylist);
  }
}
