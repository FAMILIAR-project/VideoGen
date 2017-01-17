package repair;

import java.util.ArrayList;
import java.util.HashMap;
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
import repair.SequenceGenerator;

/**
 * Generate ffmpeg
 */
@SuppressWarnings("all")
public class VideoReparator {
  private VideoGeneratorModel repaired;
  
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
  
  /**
   * Save
   */
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
  public VideoGeneratorModel generate() {
    VideoGeneratorModel _xblockexpression = null;
    {
      URI _createURI = URI.createURI("test.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      Assert.assertNotNull(videoGen);
      this.repairId(videoGen);
      URI _createURI_1 = URI.createURI("foo2bis.xmi");
      this.saveVideoGenerator(_createURI_1, videoGen);
      URI _createURI_2 = URI.createURI("foo2bis.videogen");
      this.saveVideoGenerator(_createURI_2, videoGen);
      SequenceGenerator _sequenceGenerator = new SequenceGenerator(videoGen);
      VideoGeneratorModel finalVideo = _sequenceGenerator.getRepairedModel();
      _xblockexpression = this.repaired = finalVideo;
    }
    return _xblockexpression;
  }
  
  public VideoGeneratorModel getRepair() {
    VideoGeneratorModel _xblockexpression = null;
    {
      this.generate();
      _xblockexpression = this.repaired;
    }
    return _xblockexpression;
  }
  
  public void printDesc(final VideoDescription desc) {
    String _location = desc.getLocation();
    String _plus = ("Location : " + _location);
    InputOutput.<String>println(_plus);
    int _duration = desc.getDuration();
    String _plus_1 = ("Duration : " + Integer.valueOf(_duration));
    InputOutput.<String>println(_plus_1);
    int _probability = desc.getProbability();
    String _plus_2 = ("Probability : " + Integer.valueOf(_probability));
    InputOutput.<String>println(_plus_2);
    int _size = desc.getSize();
    String _plus_3 = ("Size : " + Integer.valueOf(_size));
    InputOutput.<String>println(_plus_3);
    String _description = desc.getDescription();
    String _plus_4 = ("Description : " + _description);
    InputOutput.<String>println(_plus_4);
    InputOutput.println();
  }
  
  /**
   * Repair null id
   */
  public void repairId(final VideoGeneratorModel videoGen) {
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
          final ArrayList<VideoDescription> current = new ArrayList<VideoDescription>();
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            {
              String _videoid_3 = vdesc.getVideoid();
              boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
              if (_isNullOrEmpty_3) {
                String _genID_3 = this.genID();
                vdesc.setVideoid(_genID_3);
              }
              current.add(vdesc);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoReparator.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
