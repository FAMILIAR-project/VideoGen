package videogen;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.logging.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
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
public class Specifications {
  private final static Logger LOGGER = Logger.getLogger(Specifications.class.getClass().getName());
  
  private ArrayList<String> locationList = new ArrayList<String>();
  
  private ArrayList<String> nameList = new ArrayList<String>();
  
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
  public void CheckSpecs() {
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    int _size = _videoseqs.size();
    Assert.assertEquals(7, _size);
    EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        String path = _description.getLocation();
        VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
        String name = _description_1.getVideoid();
        boolean _contains = this.locationList.contains(path);
        if (_contains) {
          Specifications.LOGGER.warning(("duplicate use of path: " + path));
        }
        this.locationList.add(path);
        if (((!Objects.equal(name, null)) && this.nameList.contains(name))) {
          Specifications.LOGGER.warning(("duplicate id for video: " + name));
        }
        boolean _notEquals = (!Objects.equal(name, null));
        if (_notEquals) {
          this.nameList.add(name);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
          String path_1 = _description_2.getLocation();
          VideoDescription _description_3 = ((OptionalVideoSeq) videoseq).getDescription();
          String name_1 = _description_3.getVideoid();
          boolean _contains_1 = this.locationList.contains(path_1);
          if (_contains_1) {
            Specifications.LOGGER.warning(("duplicate use of path: " + path_1));
          }
          this.locationList.add(path_1);
          if (((!Objects.equal(name_1, null)) && this.nameList.contains(name_1))) {
            Specifications.LOGGER.warning(("duplicate id for video: " + name_1));
          }
          boolean _notEquals_1 = (!Objects.equal(name_1, null));
          if (_notEquals_1) {
            this.nameList.add(name_1);
          }
          VideoDescription _description_4 = ((OptionalVideoSeq) videoseq).getDescription();
          int _probability = _description_4.getProbability();
          boolean _greaterThan = (_probability > 100);
          if (_greaterThan) {
            Specifications.LOGGER.severe(("probability >100 for video: " + name_1));
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            {
              String path_2 = vdesc.getLocation();
              String name_2 = vdesc.getVideoid();
              boolean _contains_2 = this.locationList.contains(path_2);
              if (_contains_2) {
                Specifications.LOGGER.warning(("duplicate use of path: " + path_2));
              }
              this.locationList.add(path_2);
              if (((!Objects.equal(name_2, null)) && this.nameList.contains(name_2))) {
                Specifications.LOGGER.warning(("duplicate id for video: " + name_2));
              }
              boolean _notEquals_2 = (!Objects.equal(name_2, null));
              if (_notEquals_2) {
                this.nameList.add(name_2);
              }
            }
          }
        }
      }
    };
    _videoseqs_1.forEach(_function);
  }
}
