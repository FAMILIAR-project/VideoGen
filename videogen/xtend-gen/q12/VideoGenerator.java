package q12;

import M3UPlaylist.Playlist;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import q11.VideoGenLoader;

@SuppressWarnings("all")
public class VideoGenerator {
  /**
   * Load
   */
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
  
  public List<String> generatePlaylistForFile(final String file) {
    List<String> _xblockexpression = null;
    {
      VideoGenLoader _videoGenLoader = new VideoGenLoader();
      VideoGeneratorModel videoGen = _videoGenLoader.load(file);
      q3.VideoGenerator _videoGenerator = new q3.VideoGenerator();
      Playlist playlistModel = _videoGenerator.generatePlaylist(videoGen);
      q7.VideoGenerator _videoGenerator_1 = new q7.VideoGenerator();
      List<String> playlistM3U = _videoGenerator_1.generateStringList(playlistModel);
      int _size = playlistM3U.size();
      InputOutput.<Integer>println(Integer.valueOf(_size));
      _xblockexpression = playlistM3U;
    }
    return _xblockexpression;
  }
}
