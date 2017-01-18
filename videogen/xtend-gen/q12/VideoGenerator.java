package q12;

import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import q8.VideoReparator;

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
      VideoReparator _videoReparator = new VideoReparator();
      VideoGeneratorModel videoGen = _videoReparator.getRepaired(file);
      q7.VideoGenerator _videoGenerator = new q7.VideoGenerator();
      _xblockexpression = _videoGenerator.getPlaylist(videoGen);
    }
    return _xblockexpression;
  }
}
