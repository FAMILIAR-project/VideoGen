package q11;

import com.google.common.base.Objects;
import java.util.HashMap;
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
import q8.VideoReparator;

/**
 * Check VideoGenModel
 */
@SuppressWarnings("all")
public class VideoGenLoader {
  public VideoGeneratorModel videoGen;
  
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
  public void generate() {
    VideoReparator videoReparator = new VideoReparator();
    VideoGeneratorModel videoGen = videoReparator.getRepair();
    this.checkID(videoGen);
    this.checkProbability(videoGen);
  }
  
  public VideoGeneratorModel load(final String path) {
    VideoGeneratorModel _xblockexpression = null;
    {
      VideoReparator videoReparator = new VideoReparator();
      VideoGeneratorModel videoGen = videoReparator.getRepaired(path);
      this.checkID(videoGen);
      this.checkProbability(videoGen);
      _xblockexpression = videoGen;
    }
    return _xblockexpression;
  }
  
  public String printWarning(final String text) {
    return InputOutput.<String>println(("Warning : " + text));
  }
  
  public boolean checkID(final VideoGeneratorModel videoGen) {
    boolean _xblockexpression = false;
    {
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          boolean _containID = this.containID(videoGen, desc);
          if (_containID) {
            String _videoid = desc.getVideoid();
            String _plus = ("Two same id -> \'" + _videoid);
            String _plus_1 = (_plus + "\'");
            this.printWarning(_plus_1);
            return true;
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            boolean _containID_1 = this.containID(videoGen, desc_1);
            if (_containID_1) {
              String _videoid_1 = desc_1.getVideoid();
              String _plus_2 = ("Two same id -> \'" + _videoid_1);
              String _plus_3 = (_plus_2 + "\'");
              this.printWarning(_plus_3);
              return true;
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            boolean _containIDAlt = this.containIDAlt(videoGen, altvid);
            if (_containIDAlt) {
              String _videoid_2 = altvid.getVideoid();
              String _plus_4 = ("Two same id -> \'" + _videoid_2);
              String _plus_5 = (_plus_4 + "\'");
              this.printWarning(_plus_5);
              return true;
            }
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              boolean _containID_2 = this.containID(videoGen, vdesc);
              if (_containID_2) {
                String _videoid_3 = vdesc.getVideoid();
                String _plus_6 = ("Two same id -> \'" + _videoid_3);
                String _plus_7 = (_plus_6 + "\'");
                this.printWarning(_plus_7);
                return true;
              }
            }
          }
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean containID(final VideoGeneratorModel videoGen, final VideoDescription descVid) {
    boolean _xblockexpression = false;
    {
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          boolean _notEquals = (!Objects.equal(desc, descVid));
          if (_notEquals) {
            String _videoid = desc.getVideoid();
            String _videoid_1 = descVid.getVideoid();
            boolean _equals = _videoid.equals(_videoid_1);
            if (_equals) {
              return true;
            }
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            boolean _notEquals_1 = (!Objects.equal(desc_1, descVid));
            if (_notEquals_1) {
              String _videoid_2 = desc_1.getVideoid();
              String _videoid_3 = descVid.getVideoid();
              boolean _equals_1 = _videoid_2.equals(_videoid_3);
              if (_equals_1) {
                return true;
              }
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              boolean _notEquals_2 = (!Objects.equal(vdesc, descVid));
              if (_notEquals_2) {
                String _videoid_4 = vdesc.getVideoid();
                String _videoid_5 = descVid.getVideoid();
                boolean _equals_2 = _videoid_4.equals(_videoid_5);
                if (_equals_2) {
                  return true;
                }
              }
            }
          }
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean containIDAlt(final VideoGeneratorModel videoGen, final AlternativeVideoSeq alt) {
    boolean _xblockexpression = false;
    {
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = desc.getVideoid();
          String _videoid_1 = alt.getVideoid();
          boolean _equals = _videoid.equals(_videoid_1);
          if (_equals) {
            return true;
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_2 = desc_1.getVideoid();
            String _videoid_3 = alt.getVideoid();
            boolean _equals_1 = _videoid_2.equals(_videoid_3);
            if (_equals_1) {
              return true;
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            boolean _notEquals = (!Objects.equal(altvid, alt));
            if (_notEquals) {
              String _videoid_4 = altvid.getVideoid();
              String _videoid_5 = alt.getVideoid();
              boolean _equals_2 = _videoid_4.equals(_videoid_5);
              if (_equals_2) {
                return true;
              }
            }
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              String _videoid_6 = vdesc.getVideoid();
              String _videoid_7 = alt.getVideoid();
              boolean _equals_3 = _videoid_6.equals(_videoid_7);
              if (_equals_3) {
                return true;
              }
            }
          }
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
  
  public boolean checkProbability(final VideoGeneratorModel videoGen) {
    boolean _xblockexpression = false;
    {
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          int _probability = desc.getProbability();
          boolean _greaterThan = (_probability > 100);
          if (_greaterThan) {
            int _probability_1 = desc.getProbability();
            String _plus = ("Probality -> " + Integer.valueOf(_probability_1));
            String _plus_1 = (_plus + " for video \'");
            String _videoid = desc.getVideoid();
            String _plus_2 = (_plus_1 + _videoid);
            String _plus_3 = (_plus_2 + "\'");
            this.printWarning(_plus_3);
            return true;
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            int _probability_2 = desc_1.getProbability();
            boolean _greaterThan_1 = (_probability_2 > 100);
            if (_greaterThan_1) {
              int _probability_3 = desc_1.getProbability();
              String _plus_4 = ("Probality -> " + Integer.valueOf(_probability_3));
              String _plus_5 = (_plus_4 + " for video \'");
              String _videoid_1 = desc_1.getVideoid();
              String _plus_6 = (_plus_5 + _videoid_1);
              String _plus_7 = (_plus_6 + "\'");
              this.printWarning(_plus_7);
              return true;
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            int prob = 0;
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                int _probability_4 = vdesc.getProbability();
                boolean _greaterThan_2 = (_probability_4 > 100);
                if (_greaterThan_2) {
                  int _probability_5 = vdesc.getProbability();
                  String _plus_8 = ("Probality -> " + Integer.valueOf(_probability_5));
                  String _plus_9 = (_plus_8 + " for video \'");
                  String _videoid_2 = vdesc.getVideoid();
                  String _plus_10 = (_plus_9 + _videoid_2);
                  String _plus_11 = (_plus_10 + "\'");
                  this.printWarning(_plus_11);
                  return true;
                }
                int _prob = prob;
                int _probability_6 = vdesc.getProbability();
                prob = (_prob + _probability_6);
                if ((prob > 100)) {
                  String _videoid_3 = altvid.getVideoid();
                  String _plus_12 = ("Video probability for alternative \"" + _videoid_3);
                  String _plus_13 = (_plus_12 + "\" > 100");
                  this.printWarning(_plus_13);
                  return true;
                }
              }
            }
          }
        }
      }
      _xblockexpression = false;
    }
    return _xblockexpression;
  }
}
