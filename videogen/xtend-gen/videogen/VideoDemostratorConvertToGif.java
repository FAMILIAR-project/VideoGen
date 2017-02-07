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
import videogenPlayList.MediaFile;
import videogenPlayList.impl.VideogenPlayListFactoryImpl;

@SuppressWarnings("all")
public class VideoDemostratorConvertToGif {
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
   * transforme une partie de la video en fichier gif de base qualité
   * videoLocation = path de la video a utiliser
   * tailleW = weight de l'image .gif
   * tailleH = height de l'image .gif
   */
  public static boolean convertToGif(final String videoLocation, final Integer tailleW, final Integer tailleH) {
    try {
      boolean _xblockexpression = false;
      {
        String[] name = videoLocation.split("/");
        int _length = name.length;
        int _minus = (_length - 1);
        String _get = name[_minus];
        String _plus = ((((((("C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -i " + videoLocation) + " -ss 00:00:00.000 -pix_fmt rgb24 -r 10 -s ") + tailleW) + "x") + tailleH) + " -t 00:00:10.000 gif/") + _get);
        String cmd = (_plus + ".gif");
        InputOutput.<String>println(("Commande : " + cmd));
        Runtime _runtime = Runtime.getRuntime();
        Process process = _runtime.exec(cmd);
        _xblockexpression = process.waitFor(2000, TimeUnit.MILLISECONDS);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * transforme une partie de la video en fichier gif de haute qualité
   * videoLocation = path de la video a utiliser
   * taille = taille de l'image gif de sortie
   */
  public static boolean convertToGifHD(final String videoLocation, final Integer taille) {
    try {
      boolean _xblockexpression = false;
      {
        String[] name = videoLocation.split("/");
        int _length = name.length;
        int _minus = (_length - 1);
        String _get = name[_minus];
        String _plus = ((((("C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -y -ss 0 -t 3 -i " + videoLocation) + " -vf fps=10,scale=") + taille) + ":-1:flags=lanczos,palettegen gif/") + _get);
        String cmdPalette = (_plus + ".png");
        InputOutput.<String>println(("Commande palette: " + cmdPalette));
        Runtime _runtime = Runtime.getRuntime();
        Process processPalette = _runtime.exec(cmdPalette);
        processPalette.waitFor(2000, TimeUnit.MILLISECONDS);
        int _length_1 = name.length;
        int _minus_1 = (_length_1 - 1);
        String _get_1 = name[_minus_1];
        String _plus_1 = ((("C:\\Users\\Sandra\\Desktop\\ffmpeg-20161127-801b5c1-win64-static\\bin\\ffmpeg -ss 0 -t 3 -i " + videoLocation) + " -i gif/") + _get_1);
        String _plus_2 = (_plus_1 + ".png -filter_complex \"fps=10,scale=");
        String _plus_3 = (_plus_2 + taille);
        String _plus_4 = (_plus_3 + ":-1:flags=lanczos[x];[x][1:v]paletteuse\" gif/");
        int _length_2 = name.length;
        int _minus_2 = (_length_2 - 1);
        String _get_2 = name[_minus_2];
        String _plus_5 = (_plus_4 + _get_2);
        String cmdGif = (_plus_5 + ".gif");
        InputOutput.<String>println(("Commande gif: " + cmdGif));
        Runtime _runtime_1 = Runtime.getRuntime();
        Process processGif = _runtime_1.exec(cmdGif);
        _xblockexpression = processGif.waitFor(2000, TimeUnit.MILLISECONDS);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    URI _createURI = URI.createURI("fooQ1.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    VideogenPlayListFactoryImpl fact = new VideogenPlayListFactoryImpl();
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    Set<VideoSeq> _set = IterableExtensions.<VideoSeq>toSet(_videoseqs);
    for (final VideoSeq videoseq : _set) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        InputOutput.<String>println("Mandatory");
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String fileLocation = _description.getLocation();
        MediaFile mediafile = fact.createMediaFile();
        mediafile.setLocation(fileLocation);
        VideoDemostratorConvertToGif.convertToGifHD(fileLocation, Integer.valueOf(500));
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          InputOutput.<String>println("Optional");
          Random _random = new Random();
          final int rand = _random.nextInt(2);
          if ((rand == 0)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String fileLocation_1 = _description_1.getLocation();
            MediaFile mediafile_1 = fact.createMediaFile();
            mediafile_1.setLocation(fileLocation_1);
            VideoDemostratorConvertToGif.convertToGif(fileLocation_1, Integer.valueOf(200), Integer.valueOf(100));
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
          MediaFile mediafile_2 = fact.createMediaFile();
          mediafile_2.setLocation(fileLocation_2);
          VideoDemostratorConvertToGif.convertToGif(fileLocation_2, Integer.valueOf(250), Integer.valueOf(300));
        }
      }
    }
  }
  
  private static int i = 0;
  
  private File ffmpeg;
  
  public static String genID() {
    int _plusPlus = VideoDemostratorConvertToGif.i++;
    return ("" + Integer.valueOf(_plusPlus));
  }
}
