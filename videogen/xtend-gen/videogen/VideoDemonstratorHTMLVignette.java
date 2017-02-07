package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
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
 * Transformation xtend pour generer les vignettes des vid�os + un script html
 */
@SuppressWarnings("all")
public class VideoDemonstratorHTMLVignette {
  private static String pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
  
  private static String pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/";
  
  private static String pathVignette = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/Vignettes/";
  
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
    this.printHTMLVign(videoGen);
    URI _createURI_1 = URI.createURI("fooRealOut.xmi");
    this.saveVideoGenerator(_createURI_1, videoGen);
    URI _createURI_2 = URI.createURI("fooRealOut.videogen");
    this.saveVideoGenerator(_createURI_2, videoGen);
  }
  
  public void printHTMLVign(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("<!doctype html>\n<html lang=\'fr\'>\n<head>\n\t<meta charset=\'utf-8\'>\n\t<title>VideoGen</title>\n</head>\n<body bgcolor=black>\n\t<h1 style=\'color:white\'>VideoGen</h1>");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        if (((!StringExtensions.isNullOrEmpty(desc.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc.getLocation())))) {
          String _location = desc.getLocation();
          String _plus = (VideoDemonstratorHTMLVignette.pathVideo + _location);
          String _videoid = desc.getVideoid();
          String _location_1 = desc.getLocation();
          String _plus_1 = (VideoDemonstratorHTMLVignette.pathVideo + _location_1);
          int _duration = VideoDemonstratorHTMLVignette.getDuration(_plus_1);
          VideoDemonstratorHTMLVignette.getVignette(_plus, _videoid, _duration);
        }
        String _videoid_1 = desc.getVideoid();
        String _plus_2 = (("\t<div style=\'background-color: #FFFFFF;\'><h3>Video:</h3><img style=\'width:304px;height:228px;\' src=\"" + VideoDemonstratorHTMLVignette.pathVignette) + _videoid_1);
        String _plus_3 = (_plus_2 + ".png\"></div>");
        InputOutput.<String>println(_plus_3);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          if (((!StringExtensions.isNullOrEmpty(desc_1.getVideoid())) && (!StringExtensions.isNullOrEmpty(desc_1.getLocation())))) {
            String _location_2 = desc_1.getLocation();
            String _plus_4 = (VideoDemonstratorHTMLVignette.pathVideo + _location_2);
            String _videoid_2 = desc_1.getVideoid();
            String _location_3 = desc_1.getLocation();
            String _plus_5 = (VideoDemonstratorHTMLVignette.pathVideo + _location_3);
            int _duration_1 = VideoDemonstratorHTMLVignette.getDuration(_plus_5);
            VideoDemonstratorHTMLVignette.getVignette(_plus_4, _videoid_2, _duration_1);
            String _videoid_3 = desc_1.getVideoid();
            String _plus_6 = (("\t<div style=\'background-color: #FFFFFF;\'><h3>Videos optionel:</h3><img style=\'width:304px;height:228px;\' src=\"" + VideoDemonstratorHTMLVignette.pathVignette) + _videoid_3);
            String _plus_7 = (_plus_6 + ".png\"></div>");
            InputOutput.<String>println(_plus_7);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          InputOutput.<String>println("\t<div style=\'background-color: #FFFFFF;\'><h3>Videos alternatives:</h3>");
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            {
              String _location_4 = vdesc.getLocation();
              String _plus_8 = (VideoDemonstratorHTMLVignette.pathVideo + _location_4);
              String _videoid_4 = vdesc.getVideoid();
              String _location_5 = vdesc.getLocation();
              String _plus_9 = (VideoDemonstratorHTMLVignette.pathVideo + _location_5);
              int _duration_2 = VideoDemonstratorHTMLVignette.getDuration(_plus_9);
              VideoDemonstratorHTMLVignette.getVignette(_plus_8, _videoid_4, _duration_2);
              String _videoid_5 = vdesc.getVideoid();
              String _plus_10 = (("\t<img style=\'width:304px;height:228px;\' src=\"" + VideoDemonstratorHTMLVignette.pathVignette) + _videoid_5);
              String _plus_11 = (_plus_10 + ".png\">");
              InputOutput.<String>println(_plus_11);
            }
          }
          InputOutput.<String>println("</div>");
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("</body></html>");
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoDemonstratorHTMLVignette.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  public static void getVignette(final String path, final String name, final int duration) {
    try {
      String pathnorm = path.replace("/", "\\");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(((((((VideoDemonstratorHTMLVignette.pathFFmpeg + "ffmpeg -y -i ") + pathnorm) + " -r 1 -t 00:00:01 -ss 00:00:02 -f image2 ") + VideoDemonstratorHTMLVignette.pathVignette) + name) + ".png"));
      process.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static int getDuration(final String path) {
    try {
      String pathnorm = path.replace("/", "\\");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec((((VideoDemonstratorHTMLVignette.pathFFmpeg + "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"") + pathnorm) + "\""));
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
}
