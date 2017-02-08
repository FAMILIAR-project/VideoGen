package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
public class VideoDemonstrator5 {
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
        outputJson = (outputJson + line);
      }
      double _parseDouble = Double.parseDouble(outputJson);
      long _round = Math.round(_parseDouble);
      return (_round - 1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String createVignette(final String path, final String filename) {
    try {
      String cmdVignette = (((("ffmpeg -y -i " + path) + 
        " -r 1 -t 00:00:01 -ss 00:00:02 -f image2 /home/dania/Documents/IDM/Vignettes/") + filename) + ".png");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdVignette);
      process.waitFor();
      return (("/home/dania/Documents/IDM/Vignettes/" + filename) + ".png");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void tp3_q9() {
    URI _createURI = URI.createURI("main.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        InputOutput.<String>println("Mandatory");
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String fileLocation = _description.getLocation();
        VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
        String fileId = _description_1.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(fileId);
        if (_isNullOrEmpty) {
          String _genID = this.genID();
          fileId = _genID;
        }
        boolean _contains = this.vignettes.contains(fileLocation);
        boolean _not = (!_contains);
        if (_not) {
          String _vignette = this.vignette;
          String _createVignette = VideoDemonstrator5.createVignette(fileLocation, fileId);
          String _plus = ((("<p>" + fileLocation) + "</p><br/> \n\t\t\t\t\t\t<img src = ") + _createVignette);
          String _plus_1 = (_plus + " width=\'130px\' height=auto/><br/>");
          this.vignette = (_vignette + _plus_1);
          this.vignettes.add(fileLocation);
        } else {
          System.out.println(("hey la vignette est deja presente M " + fileLocation));
          String _vignette_1 = this.vignette;
          this.vignette = (_vignette_1 + (("<p>Hey la vignette est deja presente !!</p> " + fileLocation) + " <br/>"));
        }
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          final int rand = _random.nextInt(2);
          if ((rand == 0)) {
            VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_2.getLocation();
            VideoDescription _description_3 = ((OptionalVideoSeq) videoseq).getDescription();
            String fileId_1 = _description_3.getVideoid();
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(fileId_1);
            if (_isNullOrEmpty_1) {
              String _genID_1 = this.genID();
              fileId_1 = _genID_1;
            }
            boolean _contains_1 = this.vignettes.contains(fileLocation_1);
            boolean _not_1 = (!_contains_1);
            if (_not_1) {
              String _vignette_2 = this.vignette;
              String _createVignette_1 = VideoDemonstrator5.createVignette(fileLocation_1, fileId_1);
              String _plus_2 = ((("<p>" + fileLocation_1) + "</p><br/><img src=") + _createVignette_1);
              String _plus_3 = (_plus_2 + " width=\'130px\' height=auto/><br/>");
              this.vignette = (_vignette_2 + _plus_3);
              this.vignettes.add(fileLocation_1);
            } else {
              String _vignette_3 = this.vignette;
              this.vignette = (_vignette_3 + (("<p>Hey la vignette est deja presente " + fileLocation_1) + " !!</p> <br/>"));
              System.out.println(("hey la vignette est deja presente O " + fileLocation_1));
            }
          }
        } else {
          InputOutput.<String>println("else alternative");
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) videoseq).getVideodescs();
          final int size = _videodescs.size();
          Random _random_1 = new Random();
          final int index = _random_1.nextInt(size);
          EList<VideoDescription> _videodescs_1 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          VideoDescription _get = _videodescs_1.get(index);
          String fileLocation_2 = _get.getLocation();
          EList<VideoDescription> _videodescs_2 = ((AlternativeVideoSeq) videoseq).getVideodescs();
          VideoDescription _get_1 = _videodescs_2.get(index);
          String fileId_2 = _get_1.getVideoid();
          boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(fileId_2);
          if (_isNullOrEmpty_2) {
            String _genID_2 = this.genID();
            fileId_2 = _genID_2;
          }
          boolean _contains_2 = this.vignettes.contains(fileLocation_2);
          boolean _not_2 = (!_contains_2);
          if (_not_2) {
            String _vignette_4 = this.vignette;
            String _createVignette_2 = VideoDemonstrator5.createVignette(fileLocation_2, "alternative");
            String _plus_4 = ((("<p>" + fileLocation_2) + "</p><br/><img src=") + _createVignette_2);
            String _plus_5 = (_plus_4 + " width=\'130px\' height=auto/><br/>");
            this.vignette = (_vignette_4 + _plus_5);
            this.vignettes.add(fileLocation_2);
          } else {
            System.out.println(("hey la vignette est deja presente A " + fileLocation_2));
            String _vignette_5 = this.vignette;
            this.vignette = (_vignette_5 + (("<p>Hey la vignette est deja presente !!</p> " + fileLocation_2) + "<br/>"));
          }
        }
      }
    }
    try {
      final File ffmpeg = new File("/home/dania/Documents/IDM/vignettes.html");
      boolean _exists = ffmpeg.exists();
      boolean _not_3 = (!_exists);
      if (_not_3) {
        ffmpeg.createNewFile();
      }
      File _absoluteFile = ffmpeg.getAbsoluteFile();
      final FileWriter fw = new FileWriter(_absoluteFile);
      final BufferedWriter bw = new BufferedWriter(fw);
      bw.write("<!DOCTYPE html><html><body>");
      bw.write(this.vignette);
      bw.write("</html></body>");
      bw.close();
    } catch (final Throwable _t) {
      if (_t instanceof IOException) {
        final IOException e = (IOException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  private static int i = 0;
  
  private String vignette = "";
  
  private List vignettes = new ArrayList<String>();
  
  public String genID() {
    int _plusPlus = VideoDemonstrator5.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
