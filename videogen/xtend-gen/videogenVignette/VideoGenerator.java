package videogenVignette;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import repair.VideoReparator;

/**
 * Generate ffmpeg
 */
@SuppressWarnings("all")
public class VideoGenerator {
  /**
   * Load
   */
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
  
  /**
   * Save
   */
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
  public void generate() {
    VideoReparator videoReparator = new VideoReparator();
    VideoGeneratorModel videoGen = videoReparator.getRepair();
    this.generateVignettes(videoGen, "/home/loic/test");
  }
  
  public void generateVignettes(final VideoGeneratorModel videoGen, final String folder) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        this.generateVignette(desc, folder);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          this.generateVignette(desc_1, folder);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            this.generateVignette(vdesc, folder);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public int generateVignette(final VideoDescription desc, final String folder) {
    try {
      int _xblockexpression = (int) 0;
      {
        Runtime r = Runtime.getRuntime();
        String _location = desc.getLocation();
        String _plus = ("-y -i " + _location);
        String _plus_1 = (_plus + " -r 1 -t 00:00:01 -ss 00:00:2 ");
        String _videoid = desc.getVideoid();
        Path _get = Paths.get(folder, _videoid);
        String _plus_2 = (_plus_1 + _get);
        String param = (_plus_2 + ".png");
        String _location_1 = desc.getLocation();
        String _videoid_1 = desc.getVideoid();
        Path _get_1 = Paths.get(folder, _videoid_1);
        String _plus_3 = (_get_1 + ".png");
        ProcessBuilder _processBuilder = new ProcessBuilder("ffmpeg", "-y", "-i", _location_1, "-r", "1", "-t", "00:00:01", "-ss", "00:00:2", _plus_3);
        ProcessBuilder _redirectErrorStream = _processBuilder.redirectErrorStream(true);
        Process processDuration = _redirectErrorStream.start();
        StringBuilder strBuild = new StringBuilder();
        InputStream _inputStream = processDuration.getInputStream();
        Charset _defaultCharset = Charset.defaultCharset();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream, _defaultCharset);
        BufferedReader processOutputReader = new BufferedReader(_inputStreamReader);
        String line = null;
        while ((!Objects.equal((line = processOutputReader.readLine()), null))) {
          InputOutput.<String>println(line);
        }
        _xblockexpression = processDuration.waitFor();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
