package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

@SuppressWarnings("all")
public class VideoDemonstratorGification {
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
  
  public static double getDuration(final String videoLocation) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(
        ("ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        {
          outputJson = (outputJson + line);
          InputOutput.<String>println(outputJson);
        }
      }
      InputOutput.<String>println(outputJson);
      double _parseDouble = Double.parseDouble(outputJson);
      long _round = Math.round(_parseDouble);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String createGif(final String duration, final String start, final String size, final String path, final String filename) {
    try {
      String cmdGif = "ffmpeg -v warning ";
      boolean _notEquals = (!Objects.equal(duration, null));
      if (_notEquals) {
        String _cmdGif = cmdGif;
        cmdGif = (_cmdGif + (("-t " + duration) + " "));
      }
      boolean _notEquals_1 = (!Objects.equal(start, null));
      if (_notEquals_1) {
        String _cmdGif_1 = cmdGif;
        cmdGif = (_cmdGif_1 + ((" -ss " + start) + " "));
      }
      String _cmdGif_2 = cmdGif;
      cmdGif = (_cmdGif_2 + (("-i " + path) + " "));
      boolean _notEquals_2 = (!Objects.equal(size, null));
      if (_notEquals_2) {
        String _cmdGif_3 = cmdGif;
        cmdGif = (_cmdGif_3 + (("-vf scale=" + size) + ":-1 "));
      } else {
        String _cmdGif_4 = cmdGif;
        cmdGif = (_cmdGif_4 + "-vf scale=300:-1 ");
      }
      String _cmdGif_5 = cmdGif;
      cmdGif = (_cmdGif_5 + (("-gifflags +transdiff -y " + filename) + ".gif"));
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdGif);
      process.waitFor();
      return (filename + ".gif");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void deleteFile(final String path) {
    try {
      String cmdDelete = ("rm " + path);
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdDelete);
      process.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void concat(final String playlist) {
    try {
      String cmdConcat = (("ffmpeg -f concat -safe 0 -i " + playlist) + " -c copy /home/clementg/Documents/Travail/IDM/concat.mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdConcat);
      process.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * def static void concat(String playlist) {
   * var String cmdConcatener = "ffmpeg -f concat -safe 0 -i " + playlist + " -c copy /videoconcat.m3u"
   * 
   * var Process process = Runtime.getRuntime().exec(cmdConcatener);
   * process.waitFor();
   * }
   */
  @Test
  public Boolean tp6_gif() {
    boolean _xblockexpression = false;
    {
      URI _createURI = URI.createURI("main.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      boolean _xtrycatchfinallyexpression = false;
      try {
        boolean _xblockexpression_1 = false;
        {
          final String path = "./";
          final File pl = new File((path + "playlist.txt"));
          boolean _xifexpression = false;
          boolean _exists = pl.exists();
          boolean _not = (!_exists);
          if (_not) {
            _xifexpression = pl.createNewFile();
          }
          _xblockexpression_1 = _xifexpression;
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          e.printStackTrace();
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return Boolean.valueOf(_xblockexpression);
  }
  
  public static String creerGif(final String duration, final String start, final String size, final String path, final String filename) {
    try {
      String cmdGif = "ffmpeg -v warning ";
      boolean _notEquals = (!Objects.equal(duration, null));
      if (_notEquals) {
        String _cmdGif = cmdGif;
        cmdGif = (_cmdGif + (("-t " + duration) + " "));
      }
      boolean _notEquals_1 = (!Objects.equal(start, null));
      if (_notEquals_1) {
        String _cmdGif_1 = cmdGif;
        cmdGif = (_cmdGif_1 + ((" -ss " + start) + " "));
      }
      String _cmdGif_2 = cmdGif;
      cmdGif = (_cmdGif_2 + (("-i " + path) + " "));
      boolean _notEquals_2 = (!Objects.equal(size, null));
      if (_notEquals_2) {
        String _cmdGif_3 = cmdGif;
        cmdGif = (_cmdGif_3 + (("-vf scale=" + size) + ":-1 "));
      } else {
        String _cmdGif_4 = cmdGif;
        cmdGif = (_cmdGif_4 + "-vf scale=300:-1 ");
      }
      String _cmdGif_5 = cmdGif;
      cmdGif = (_cmdGif_5 + (("-gifflags +transdiff -y " + filename) + ".gif"));
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdGif);
      process.waitFor();
      return (filename + ".gif");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
