package videogen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class Question2 {
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
  
  public static void saveVideoGenerator(final URI uri, final VideoGeneratorModel pollS) {
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
  
  public static void main(final String[] args) {
    try {
      URI _createURI = URI.createURI("mastaconcat.videogen");
      VideoGeneratorModel videoGen = Question2.loadVideoGenerator(_createURI);
      final ArrayList<String> list = new ArrayList<String>();
      final Random rand = new Random();
      final String entry = "%s";
      final String cmd = "vlc play.m3u";
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = _description.getLocation();
          String _format = String.format(entry, _location);
          list.add(_format);
        }
        if ((videoseq instanceof OptionalVideoSeq)) {
          int _nextInt = rand.nextInt(2);
          boolean _equals = (_nextInt == 1);
          if (_equals) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            String _location_1 = _description_1.getLocation();
            String _format_1 = String.format(entry, _location_1);
            list.add(_format_1);
          }
        }
        if ((videoseq instanceof AlternativeVideoSeq)) {
          final EList<VideoDescription> listAlt = ((AlternativeVideoSeq) videoseq).getVideodescs();
          int _size = listAlt.size();
          final int quicesera = rand.nextInt(_size);
          VideoDescription _get = listAlt.get(quicesera);
          String _location_2 = _get.getLocation();
          String _format_2 = String.format(entry, _location_2);
          list.add(_format_2);
        }
      };
      _videoseqs.forEach(_function);
      Path _get = Paths.get("play.m3u");
      Files.write(_get, list);
      Runtime _runtime = Runtime.getRuntime();
      _runtime.exec(cmd);
      return;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
