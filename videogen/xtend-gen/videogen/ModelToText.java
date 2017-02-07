package videogen;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Random;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class ModelToText {
  public static VideoGeneratorModel loadVideoGenerator(final URI uri) {
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
  
  public static void writeToFile(final String filename, final String content) {
    try {
      final FileWriter writer = new FileWriter((filename + ".txt"));
      writer.write(content);
      writer.flush();
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void printToHTML(final VideoGeneratorModel videoGen) {
    try {
      String data = "#this is a comment\n";
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = desc.getLocation();
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_location);
          boolean _not = (!_isNullOrEmpty);
          if (_not) {
            String _data = data;
            String _location_1 = desc.getLocation();
            String _plus = ("File " + _location_1);
            String _plus_1 = (_plus + "\n");
            data = (_data + _plus_1);
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_2 = desc_1.getLocation();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(_location_2);
            boolean _not_1 = (!_isNullOrEmpty_1);
            if (_not_1) {
              Random _random = new Random();
              int _nextInt = _random.nextInt(1);
              boolean _equals = (_nextInt == 1);
              if (_equals) {
                String _data_1 = data;
                String _location_3 = desc_1.getLocation();
                String _plus_2 = ("File " + _location_3);
                String _plus_3 = (_plus_2 + "\n");
                data = (_data_1 + _plus_3);
              }
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            String _videoid = altvid.getVideoid();
            boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(_videoid);
            boolean _not_2 = (!_isNullOrEmpty_2);
            if (_not_2) {
              String _data_2 = data;
              EList<VideoDescription> _videodescs = altvid.getVideodescs();
              Random _random_1 = new Random();
              EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
              int _size = _videodescs_1.size();
              int _nextInt_1 = _random_1.nextInt(_size);
              VideoDescription _get = _videodescs.get(_nextInt_1);
              String _location_4 = _get.getLocation();
              String _plus_4 = ("File " + _location_4);
              String _plus_5 = (_plus_4 + "\n");
              data = (_data_2 + _plus_5);
            }
          }
        }
      }
      InputOutput.<String>println(data);
      final FileWriter writer = new FileWriter("result.txt");
      writer.write(data);
      writer.flush();
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void main(final String[] args) {
    URI _createURI = URI.createURI("foo2.videogen");
    VideoGeneratorModel videoGen = ModelToText.loadVideoGenerator(_createURI);
    ModelToText.printToHTML(videoGen);
  }
}
