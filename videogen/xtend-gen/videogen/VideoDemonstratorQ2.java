package videogen;

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
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoDemonstratorQ2 {
  private static int i = 0;
  
  private String playList = "";
  
  public String genID() {
    int _plusPlus = VideoDemonstratorQ2.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  @Test
  public void TestTp3Q2() {
    throw new Error("Unresolved compilation problems:"
      + "\nMediaFile cannot be resolved to a type."
      + "\nVideogenPlayListFactoryImpl cannot be resolved."
      + "\ncreatePlayList cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nlocation cannot be resolved");
  }
  
  public void printToM3u(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("#this is a comment");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _videoid = desc.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_videoid);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          String _playList = this.playList;
          String _location = desc.getLocation();
          String _plus = ("file \'" + _location);
          String _plus_1 = (_plus + "\'");
          String _lineSeparator = System.lineSeparator();
          String _plus_2 = (_plus_1 + _lineSeparator);
          this.playList = (_playList + _plus_2);
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          Random _random = new Random();
          final int unsurDeux = _random.nextInt(2);
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if ((unsurDeux == 0)) {
            String _playList_1 = this.playList;
            String _location_1 = desc_1.getLocation();
            String _plus_3 = ("file \'" + _location_1);
            String _plus_4 = (_plus_3 + "\'");
            String _lineSeparator_1 = System.lineSeparator();
            String _plus_5 = (_plus_4 + _lineSeparator_1);
            this.playList = (_playList_1 + _plus_5);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          final int nbrFichier = _videodescs.size();
          Random _random_1 = new Random();
          final int numFichier = _random_1.nextInt(nbrFichier);
          String _videoid_1 = altvid.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_videoid_1);
          boolean _not_1 = (!_isNullOrEmpty_1);
          if (_not_1) {
            String _playList_2 = this.playList;
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            VideoDescription _get = _videodescs_1.get(numFichier);
            String _location_2 = _get.getLocation();
            String _plus_6 = ("file \'" + _location_2);
            String _plus_7 = (_plus_6 + "\'");
            String _lineSeparator_2 = System.lineSeparator();
            String _plus_8 = (_plus_7 + _lineSeparator_2);
            this.playList = (_playList_2 + _plus_8);
          }
          EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
          int _size = _videodescs_2.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            InputOutput.<String>println("file");
          }
          EList<VideoDescription> _videodescs_3 = altvid.getVideodescs();
          VideoDescription _get_1 = _videodescs_3.get(numFichier);
          String _videoid_2 = _get_1.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid_2);
          boolean _not_2 = (!_isNullOrEmpty_2);
          if (_not_2) {
            String _playList_3 = this.playList;
            EList<VideoDescription> _videodescs_4 = altvid.getVideodescs();
            VideoDescription _get_2 = _videodescs_4.get(numFichier);
            String _location_3 = _get_2.getLocation();
            String _plus_9 = ("file \'" + _location_3);
            String _plus_10 = (_plus_9 + "\'");
            String _lineSeparator_3 = System.lineSeparator();
            String _plus_11 = (_plus_10 + _lineSeparator_3);
            this.playList = (_playList_3 + _plus_11);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("</ul>");
  }
  
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
}
