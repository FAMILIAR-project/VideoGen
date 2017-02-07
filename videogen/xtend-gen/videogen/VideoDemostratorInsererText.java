package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
public class VideoDemostratorInsererText {
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
      Process process = _runtime.exec(("C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 " + videoLocation));
      process.waitFor(2000, TimeUnit.MILLISECONDS);
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
  
  /**
   * Inserer du text dans la video
   * videoLocation = hubication de la video
   * text = texte a inserer dans la video
   * position = position du texte inser�
   */
  public static String insertText(final String videoLocation, final String text, final String positionX, final String positionY) {
    try {
      String[] name = videoLocation.split("\\.(?=[^\\.]+$)");
      String pathFontFile = "/Users/Sandra/";
      String _get = name[0];
      String _plus = ((((((((((("C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -i " + videoLocation) + " -vf drawtext=\'fontfile=") + pathFontFile) + "arial.ttf:text=") + text) + ":fontcolor=white:fontsize=44:box=1:boxcolor=black@0.5:boxborderw=5:x=") + positionX) + ":y=") + positionY) + "\' -codec:a copy ") + _get);
      String cmd1 = (_plus + "-2.mp4");
      InputOutput.<String>println(("Commande : " + cmd1));
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmd1);
      process.waitFor(2000, TimeUnit.MILLISECONDS);
      String _get_1 = name[0];
      return (_get_1 + "-2.mp4");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    URI _createURI = URI.createURI("fooQ1.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        InputOutput.<String>println("Mandatory");
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String fileLocation = _description.getLocation();
        final String location = fileLocation;
        final double duration = VideoDemostratorInsererText.getDuration(fileLocation);
        final String text = "VideoObligatoire";
        final String positionX = "(w-text_w)/2";
        final String positionY = "(h-text_h)/2";
        String locatTemp = VideoDemostratorInsererText.insertText(location, text, positionX, positionY);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          final int rand = _random.nextInt(2);
          if ((rand == 0)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_1.getLocation();
            final String location_1 = fileLocation_1;
            final double duration_1 = VideoDemostratorInsererText.getDuration(fileLocation_1);
            final String text_1 = "VideoOptional";
            final String positionX_1 = "(w-text_w)/3";
            final String positionY_1 = "(h-text_h)/3";
            String locatTemp_1 = VideoDemostratorInsererText.insertText(location_1, text_1, positionX_1, positionY_1);
          }
        } else {
          InputOutput.<String>println("else");
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
          final int size = _videodescs.size();
          EList<VideoDescription> _videodescs_1 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          Random _random_1 = new Random();
          int _nextInt = _random_1.nextInt(size);
          VideoDescription _get = _videodescs_1.get(_nextInt);
          String fileLocation_2 = _get.getLocation();
          final String location_2 = fileLocation_2;
          final double duration_2 = VideoDemostratorInsererText.getDuration(fileLocation_2);
          final String text_2 = "VideoAlternative";
          final String positionX_2 = "(w-text_w)/4";
          final String positionY_2 = "(h-text_h)/4";
          String locatTemp_2 = VideoDemostratorInsererText.insertText(location_2, text_2, positionX_2, positionY_2);
        }
      }
    }
  }
  
  private static int i = 0;
  
  private File ffmpeg;
  
  public static String genID() {
    int _plusPlus = VideoDemostratorInsererText.i++;
    return ("" + Integer.valueOf(_plusPlus));
  }
}
