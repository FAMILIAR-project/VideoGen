package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
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
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

@SuppressWarnings("all")
public class VideoDemonstratorQ4 {
  private static int i = 0;
  
  private String vignette = "";
  
  public String genID() {
    int _plusPlus = VideoDemonstratorQ4.i++;
    return ("v" + Integer.valueOf(_plusPlus));
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
  
  /**
   * @Test
   * def TP3() {
   * var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen"))
   * var fact = new VideogenPlayListFactoryImpl()
   * var playlist= fact.createPlayList()
   * assertNotNull(videoGen)
   * for (videoseq : videoGen.videoseqs.toSet) {
   * if (videoseq instanceof MandatoryVideoSeq) {
   * 
   * println("Mandatory")
   * val fileLocation = (videoseq as MandatoryVideoSeq).description.location;
   * println (fileLocation)
   * var fileId = (videoseq as MandatoryVideoSeq).description.videoid;
   * println (fileId)
   * if(fileId.isNullOrEmpty) fileId = genID()
   * 
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = fileLocation
   * mediaFile.duration =  getDuration(fileLocation)
   * 
   * vignette += "<img src = " + createVignette(fileLocation, fileId) + " width='130px' height=auto/><br/>"
   * 
   * playlist.mediaFile.add(mediaFile)
   * 
   * } else if (videoseq instanceof OptionalVideoSeq) {
   * println("Optional")
   * val rand = new Random().nextInt(2);
   * // Random between 0-1
   * if (rand == 0) {
   * val fileLocation = (videoseq as OptionalVideoSeq).description.location;
   * var fileId = (videoseq as OptionalVideoSeq).description.videoid;
   * if(fileId.isNullOrEmpty) fileId = genID()
   * 
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = fileLocation
   * mediaFile.duration =  getDuration(fileLocation)
   * 
   * vignette += "<img src=" + createVignette(fileLocation, fileId) + " width='130px' height=auto/><br/>"
   * playlist.mediaFile.add(mediaFile)
   * }
   * } else {
   * println("else alternative")
   * val size = (videoseq as AlternativeVideoSeq).videodescs.size;
   * var fileLocation = (videoseq as AlternativeVideoSeq).videodescs.get(new Random().nextInt(size)).
   * location;
   * 
   * var mediaFile = fact.createMediaFile()
   * mediaFile.location = fileLocation
   * mediaFile.duration =  getDuration(fileLocation)
   * vignette += "<img src=" + createVignette(fileLocation,"alternative") + " width='130px' height=auto/><br/>"
   * playlist.mediaFile.add(mediaFile)
   * }
   * }
   * try {
   * val ffmpeg = new File("/Users/kaoutar/git/VideoGen/videogen/Vignettes/vignette.html");
   * if (!ffmpeg.exists()) {
   * ffmpeg.createNewFile();
   * }
   * val fw = new FileWriter(ffmpeg.getAbsoluteFile());
   * val bw = new BufferedWriter(fw);
   * bw.write("<!DOCTYPE html><html><body>");
   * bw.write("les vignettes");
   * bw.write("<br/>");
   * bw.write(vignette);
   * bw.write("</html></body>");
   * bw.close();
   * 
   * } catch (IOException e) {
   * e.printStackTrace
   * }
   * }
   */
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
  
  public static String createVignette(final String path, final String filename) {
    try {
      String _property = System.getProperty("user.dir");
      String _plus = ((("ffmpeg -y -i " + path) + 
        " -ss 00:00:02 -vframes 1 ") + _property);
      String _plus_1 = (_plus + "/Vignettes/");
      String _plus_2 = (_plus_1 + filename);
      String cmdVignette = (_plus_2 + ".jpg");
      InputOutput.<String>println(cmdVignette);
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdVignette);
      process.waitFor();
      return (filename + ".jpg");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
