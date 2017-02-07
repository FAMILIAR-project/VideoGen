package videogen;

import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class Vignette {
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
  
  @Test
  public void genVignette() {
    URI _createURI = URI.createURI("q9.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      String path = "";
      String name = "";
      if ((videoseq instanceof MandatoryVideoSeq)) {
        VideoDescription _description = ((MandatoryVideoSeq)videoseq).getDescription();
        String _location = _description.getLocation();
        path = _location;
        VideoDescription _description_1 = ((MandatoryVideoSeq)videoseq).getDescription();
        String _videoid = _description_1.getVideoid();
        name = _videoid;
        this.createVignette(path, name);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          VideoDescription _description_2 = ((OptionalVideoSeq)videoseq).getDescription();
          String _location_1 = _description_2.getLocation();
          path = _location_1;
          VideoDescription _description_3 = ((OptionalVideoSeq)videoseq).getDescription();
          String _videoid_1 = _description_3.getVideoid();
          name = _videoid_1;
          this.createVignette(path, name);
        } else {
          if ((videoseq instanceof AlternativeVideoSeq)) {
            EList<VideoDescription> _videodescs = ((AlternativeVideoSeq)videoseq).getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String _location_2 = vdesc.getLocation();
                path = _location_2;
                String _videoid_2 = vdesc.getVideoid();
                name = _videoid_2;
                this.createVignette(path, name);
              }
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public void createVignette(final String path, final String name) {
    try {
      InputOutput.<String>println(("path=" + path));
      InputOutput.<String>println(("name=" + name));
      String cmd = (((("ffmpeg -i " + path) + " -ss 00:00:01.000 -vframes 1 ") + name) + ".jpg -y");
      InputOutput.<String>println(cmd);
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmd);
      process.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
