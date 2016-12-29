package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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

/**
 * Transformation xtend pour generer un script FFmpeg (Question 1)
 */
@SuppressWarnings("all")
public class VideoDemonstratorCalculMetrique {
  private static String pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
  
  private static String pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/";
  
  private final HashMap<Integer, Integer> tailleVar = new HashMap<Integer, Integer>();
  
  private final HashMap<Integer, Integer> dureeVar = new HashMap<Integer, Integer>();
  
  private final HashMap<Integer, String> idVar = new HashMap<Integer, String>();
  
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
    this.printCalcMetrique(videoGen);
  }
  
  public void printCalcMetrique(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc.getLocation())))) {
          String _location = desc.getLocation();
          String _plus = (VideoDemonstratorCalculMetrique.pathVideo + _location);
          int duree = VideoDemonstratorCalculMetrique.getDuration(_plus);
          boolean _isEmpty = this.tailleVar.isEmpty();
          if (_isEmpty) {
            this.tailleVar.put(Integer.valueOf(1), Integer.valueOf(1));
            this.dureeVar.put(Integer.valueOf(1), Integer.valueOf(duree));
            String _videoid = desc.getVideoid();
            this.idVar.put(Integer.valueOf(1), _videoid);
          } else {
            Set<Map.Entry<Integer, Integer>> _entrySet = this.tailleVar.entrySet();
            for (final Map.Entry<Integer, Integer> variante : _entrySet) {
              Integer _key = variante.getKey();
              Integer _value = variante.getValue();
              int _plus_1 = ((_value).intValue() + 1);
              this.tailleVar.put(_key, Integer.valueOf(_plus_1));
            }
            Set<Map.Entry<Integer, Integer>> _entrySet_1 = this.dureeVar.entrySet();
            for (final Map.Entry<Integer, Integer> variante_1 : _entrySet_1) {
              Integer _key_1 = variante_1.getKey();
              Integer _value_1 = variante_1.getValue();
              int _plus_2 = ((_value_1).intValue() + duree);
              this.dureeVar.put(_key_1, Integer.valueOf(_plus_2));
            }
            Set<Map.Entry<Integer, String>> _entrySet_2 = this.idVar.entrySet();
            for (final Map.Entry<Integer, String> variante_2 : _entrySet_2) {
              Integer _key_2 = variante_2.getKey();
              String _value_2 = variante_2.getValue();
              String _plus_3 = (_value_2 + " ");
              String _videoid_1 = desc.getVideoid();
              String _plus_4 = (_plus_3 + _videoid_1);
              this.idVar.put(_key_2, _plus_4);
            }
          }
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc_1.getLocation())))) {
            String _location_1 = desc_1.getLocation();
            String _plus_5 = (VideoDemonstratorCalculMetrique.pathVideo + _location_1);
            int durée = VideoDemonstratorCalculMetrique.getDuration(_plus_5);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            String _location_2 = vdesc.getLocation();
            String _plus_6 = (VideoDemonstratorCalculMetrique.pathVideo + _location_2);
            int durée_1 = VideoDemonstratorCalculMetrique.getDuration(_plus_6);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<HashMap<Integer, Integer>>println(this.tailleVar);
    InputOutput.<HashMap<Integer, Integer>>println(this.dureeVar);
    InputOutput.<HashMap<Integer, String>>println(this.idVar);
    int _size = this.tailleVar.size();
    String _plus = ("Nb séquence: " + Integer.valueOf(_size));
    InputOutput.<String>println(_plus);
  }
  
  public static int getDuration(final String path) {
    try {
      String pathnorm = path.replace("/", "\\");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec((((VideoDemonstratorCalculMetrique.pathFFmpeg + "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"") + pathnorm) + "\""));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      float _parseFloat = Float.parseFloat(outputJson);
      int _round = Math.round(_parseFloat);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorCalculMetrique.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
