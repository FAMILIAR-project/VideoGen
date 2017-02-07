package videogen.playlist;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;
import org.xtext.example.mydsl.PlaylistStandaloneSetupGenerated;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.playlist.Playlist;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

@SuppressWarnings("all")
public class PlaylistDemonstrator {
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
  
  public Playlist loadPlaylist(final URI uri) {
    Playlist _xblockexpression = null;
    {
      PlaylistStandaloneSetupGenerated _playlistStandaloneSetupGenerated = new PlaylistStandaloneSetupGenerated();
      _playlistStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource res = _resourceSetImpl.getResource(uri, true);
      EList<EObject> _contents = res.getContents();
      EObject _get = _contents.get(0);
      _xblockexpression = ((Playlist) _get);
    }
    return _xblockexpression;
  }
  
  @Test
  public void videogenToPlaylist() {
    throw new Error("Unresolved compilation problems:"
      + "\nOptionalVideoSeq cannot be resolved to a type."
      + "\nOptionalVideoSeq cannot be resolved to a type."
      + "\nAlternativeVideoSeq cannot be resolved to a type."
      + "\nThe method location(String) is undefined for the type Video"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method location(String) is undefined for the type Video"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method location(String) is undefined for the type Video"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nType mismatch: cannot convert from Playlist to Playlist"
      + "\nUnreachable code: The if condition can never match. It is already handled by a previous condition."
      + "\nadd cannot be resolved"
      + "\ndescription cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nvideodescs cannot be resolved"
      + "\nsize cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nadd cannot be resolved");
  }
  
  public void playlist2text(final Playlist playlist) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nThe method or field videos is undefined for the type Playlist"
      + "\nsize cannot be resolved"
      + "\nget cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\n+ cannot be resolved");
  }
}
