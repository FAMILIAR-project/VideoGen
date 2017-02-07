package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.File;
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
public class VideoDemonstratorInsertText {
  private static int i = 0;
  
  private File ffmpeg;
  
  public static String genID() {
    int _plusPlus = VideoDemonstratorInsertText.i++;
    return ("" + Integer.valueOf(_plusPlus));
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
  
  public static double getDuration(final String videoLocation) {
    try {
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(
        ("C:\\Users\\kaoutar\\Downloads\\ffmpeg-20161204-1f5630a-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      double _parseDouble = Double.parseDouble(outputJson);
      long _round = Math.round(_parseDouble);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInsertText() {
    throw new Error("Unresolved compilation problems:"
      + "\nMediaFile cannot be resolved to a type."
      + "\nVideogenPlayListFactoryImpl cannot be resolved."
      + "\ncreatePlayList cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nduration cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nduration cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nadd cannot be resolved"
      + "\ncreateMediaFile cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nduration cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nmediaFile cannot be resolved"
      + "\nduration cannot be resolved"
      + "\nlocation cannot be resolved");
  }
  
  public static String insererTextToVideo(final String videoLocation, final String text) {
    try {
      System.out.println("debut");
      String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
      String _get = name[0];
      String _plus = ((((("ffmpeg -i " + videoLocation) + " -vf drawtext=\'fontsize=15:fontfile=FreeSerif.ttf:text=") + text) + ":y=100:x=100\' -codec:a copy ") + _get);
      String cmd = (_plus + "-2.mp4");
      InputOutput.<String>println(cmd);
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmd);
      process.waitFor();
      InputStream _inputStream = process.getInputStream();
      InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
      BufferedReader reader = new BufferedReader(_inputStreamReader);
      String line = "";
      String outputJson = "";
      while ((!Objects.equal((line = reader.readLine()), null))) {
        outputJson = (outputJson + line);
      }
      String _string = outputJson.toString();
      System.out.println(_string);
      String _get_1 = name[0];
      return (_get_1 + "-2.mp4");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
