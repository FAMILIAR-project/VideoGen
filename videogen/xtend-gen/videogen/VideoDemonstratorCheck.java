package videogen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
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

@SuppressWarnings("all")
public class VideoDemonstratorCheck {
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
  public void test1() {
    URI _createURI = URI.createURI("fooReal.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
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
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _videoid_3 = vdesc.getVideoid();
            boolean _isNullOrEmpty_3 = StringExtensions.isNullOrEmpty(_videoid_3);
            if (_isNullOrEmpty_3) {
              String _genID_3 = this.genID();
              vdesc.setVideoid(_genID_3);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    URI _createURI_1 = URI.createURI("fooRealOut.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("fooRealOut.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.printFFmpeg(videoGen);
  }
  
  public void printFFmpeg(final VideoGeneratorModel videoGen) {
    final ArrayList<String> listIdUse = new ArrayList<String>();
    InputOutput.<String>println("#Sequence FFmpeg generate");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc.getLocation())))) {
          String _location = desc.getLocation();
          String _plus = ("file \'" + _location);
          String _plus_1 = (_plus + "\'");
          InputOutput.<String>println(_plus_1);
        }
        String _videoid = desc.getVideoid();
        listIdUse.add(_videoid);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc_1.getLocation())))) {
            Random _random = new Random();
            final int test = _random.nextInt(100);
            if (((test > 100) || (test < 0))) {
              InputOutput.<String>println("WARNING: le resultat de test est incohérent: vidéo ignorée");
            } else {
              InputOutput.<String>println(("#TestRes:" + Integer.valueOf(test)));
              if ((test <= 50)) {
                String _location_1 = desc_1.getLocation();
                String _plus_2 = ("file \'" + _location_1);
                String _plus_3 = (_plus_2 + "\'");
                InputOutput.<String>println(_plus_3);
                String _videoid_1 = desc_1.getVideoid();
                listIdUse.add(_videoid_1);
              }
            }
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          Random _random_1 = new Random();
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          final int choix = _random_1.nextInt(_size);
          InputOutput.<String>println(("#Choix:" + Integer.valueOf(choix)));
          if (((choix > altvid.getVideodescs().size()) || (choix < 0))) {
            System.out.println("WARNING: le resultat de test est incohérent: vidéo ignorée");
          } else {
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vdesc = _videodescs_1.get(choix);
            if (((!StringExtensions.isNullOrEmpty(vdesc.getVideoid())) && (!StringExtensions.isNullOrEmpty(vdesc.getLocation())))) {
              String _location_2 = vdesc.getLocation();
              String _plus_4 = ("file \'" + _location_2);
              String _plus_5 = (_plus_4 + "\'");
              InputOutput.<String>println(_plus_5);
              String _videoid_2 = vdesc.getVideoid();
              listIdUse.add(_videoid_2);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("#End of generation");
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorCheck.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
