package videogen;

import com.google.common.base.Objects;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;
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
public class VideoGenDurationGenerator {
  @Test
  public void generateDuration() {
    URI _createURI = URI.createURI("videos/montage.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    int _size = _videoseqs.size();
    Assert.assertEquals(3, _size);
    EList<VideoSeq> _videoseqs_1 = videoGen.getVideoseqs();
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
    _videoseqs_1.forEach(_function);
    URI _createURI_1 = URI.createURI("videos/montage.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("videos/montage.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
    this.modelToTextM3U(videoGen);
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
  
  public void modelToTextM3U(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("#EXTM3U\n");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        int _genDuration = this.genDuration(_location);
        String _plus = ("#EXTINF:" + Integer.valueOf(_genDuration));
        String _plus_1 = (_plus + "\n");
        String _location_1 = desc.getLocation();
        String _plus_2 = (_plus_1 + _location_1);
        String _plus_3 = (_plus_2 + "\n");
        InputOutput.<String>println(_plus_3);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          double _random = Math.random();
          double _multiply = (_random * 1);
          boolean _greaterThan = (_multiply > 0.5);
          if (_greaterThan) {
            String _location_2 = desc_1.getLocation();
            int _genDuration_1 = this.genDuration(_location_2);
            String _plus_4 = ("#EXTINF:" + Integer.valueOf(_genDuration_1));
            String _plus_5 = (_plus_4 + "\n");
            String _location_3 = desc_1.getLocation();
            String _plus_6 = (_plus_5 + _location_3);
            String _plus_7 = (_plus_6 + "\n");
            InputOutput.<String>println(_plus_7);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan_1 = (_size > 0);
          if (_greaterThan_1) {
            double _random_1 = Math.random();
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            int _size_1 = _videodescs_1.size();
            double i = (_random_1 * _size_1);
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            VideoDescription _get = _videodescs_2.get(((int) i));
            String _location_4 = _get.getLocation();
            int _genDuration_2 = this.genDuration(_location_4);
            String _plus_8 = ("#EXTINF:" + Integer.valueOf(_genDuration_2));
            String _plus_9 = (_plus_8 + "\n");
            EList<VideoDescription> _videodescs_3 = altvid.getVideodescs();
            VideoDescription _get_1 = _videodescs_3.get(((int) i));
            String _location_5 = _get_1.getLocation();
            String _plus_10 = (_plus_9 + _location_5);
            String _plus_11 = (_plus_10 + "\n");
            InputOutput.<String>println(_plus_11);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoGenDurationGenerator.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  public int genDuration(final String path) {
    try {
      String cmd = ("ffprobe -i " + path);
      Runtime r = Runtime.getRuntime();
      Process p = r.exec(cmd);
      InputStream _errorStream = p.getErrorStream();
      Scanner sc = new Scanner(_errorStream);
      Pattern durPattern = Pattern.compile("(?<=Duration: )[^,]*");
      String dur = sc.findWithinHorizon(durPattern, 0);
      boolean _equals = Objects.equal(dur, null);
      if (_equals) {
        throw new RuntimeException("Could not parse duration.");
      }
      String[] hms = dur.split(":");
      String _get = hms[0];
      int _parseInt = Integer.parseInt(_get);
      int _multiply = (_parseInt * 3600);
      String _get_1 = hms[1];
      int _parseInt_1 = Integer.parseInt(_get_1);
      int _multiply_1 = (_parseInt_1 * 60);
      int _plus = (_multiply + _multiply_1);
      String _get_2 = hms[2];
      double _parseDouble = Double.parseDouble(_get_2);
      double totalSecs = (_plus + _parseDouble);
      return ((int) totalSecs);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
