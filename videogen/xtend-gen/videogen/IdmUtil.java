package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class IdmUtil {
  private static Writer writer;
  
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
  
  /**
   * Create a file
   */
  public static void createFile(final String filename, final String content) {
    try {
      FileOutputStream _fileOutputStream = new FileOutputStream(filename);
      OutputStreamWriter _outputStreamWriter = new OutputStreamWriter(_fileOutputStream, "utf-8");
      BufferedWriter _bufferedWriter = new BufferedWriter(_outputStreamWriter);
      IdmUtil.writer = _bufferedWriter;
      IdmUtil.writer.write(content);
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException ex = (IOException)_t;
        String _message = ex.getMessage();
        System.out.println(_message);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    } finally {
      try {
        IdmUtil.writer.close();
      } catch (final Throwable _t_1) {
        if (_t_1 instanceof Exception) {
          final Exception ex_1 = (Exception)_t_1;
        } else {
          throw Exceptions.sneakyThrow(_t_1);
        }
      }
    }
  }
  
  /**
   * Generate playlist from a videogen model
   */
  public static void checkVideoGen(final VideoGeneratorModel videoGen) {
    Assert.assertNotNull(videoGen);
    ArrayList<String> locationList = new ArrayList<String>();
    int probabilitiesSum = 0;
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq)videoseq).getDescription();
          String location = _description.getLocation();
          boolean _contains = locationList.contains(location);
          Assert.assertFalse(_contains);
          locationList.add(location);
        }
        if ((videoseq instanceof OptionalVideoSeq)) {
          VideoDescription _description_1 = ((OptionalVideoSeq)videoseq).getDescription();
          int probability = _description_1.getProbability();
          Assert.assertFalse((probability < 0));
          Assert.assertFalse((probability > 100));
          Assert.assertFalse(((probability + probabilitiesSum) > 100));
          int _probabilitiesSum = probabilitiesSum;
          probabilitiesSum = (_probabilitiesSum + probability);
          VideoDescription _description_2 = ((OptionalVideoSeq)videoseq).getDescription();
          String location_1 = _description_2.getLocation();
          boolean _contains_1 = locationList.contains(location_1);
          Assert.assertFalse(_contains_1);
          locationList.add(location_1);
        }
        if ((videoseq instanceof AlternativeVideoSeq)) {
          final AlternativeVideoSeq atlVideoSeq = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = atlVideoSeq.getVideodescs();
          for (final VideoDescription videoseqAlt : _videodescs) {
            {
              String location_2 = videoseqAlt.getLocation();
              boolean _contains_2 = locationList.contains(location_2);
              Assert.assertFalse(_contains_2);
              locationList.add(location_2);
            }
          }
        }
      }
    }
  }
  
  /**
   * Get duration of a video
   */
  public static double getDuration(final String videoLocation) {
    try {
      String cmd = ("ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation);
      Runtime _runtime = Runtime.getRuntime();
      Process result = _runtime.exec(cmd);
      InputStream _inputStream = result.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader bufferReader = new BufferedReader(_inputStreamReader);
      StringBuilder stringBuilder = new StringBuilder();
      String line = "";
      while ((!Objects.equal((line = bufferReader.readLine()), null))) {
        stringBuilder.append(line);
      }
      String resultString = stringBuilder.toString();
      return Double.parseDouble(resultString);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Create a vignette for a video
   */
  public static String createVignette(final String videoLocation, final String filename) {
    try {
      String vignettesLocation = "/home/paul/Vidéos/idm/vignettes/";
      String cmd = ((((("ffmpeg -i " + videoLocation) + " -ss 00:00:01.000 -vframes 1 ") + vignettesLocation) + filename) + ".png -y");
      Runtime _runtime = Runtime.getRuntime();
      Process result = _runtime.exec(cmd);
      result.waitFor();
      return ((vignettesLocation + filename) + ".png");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public static String genID() {
    int _plusPlus = IdmUtil.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  public static String getFilenameWithoutExtension(final String fileLocation) {
    File _file = new File(fileLocation);
    String _name = _file.getName();
    return _name.replaceFirst("[.][^.]+$", "");
  }
  
  public static String getFilenameWithExtension(final String fileLocation) {
    File _file = new File(fileLocation);
    return _file.getName();
  }
  
  public static String getFilLocationWithoutExtension(final String fileLocation) {
    return fileLocation.replaceFirst("[.][^.]+$", "");
  }
}
