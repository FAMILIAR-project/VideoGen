package repair;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

/**
 * Sequence generator
 */
@SuppressWarnings("all")
public class SequenceGenerator {
  private VideoGeneratorModel data;
  
  /**
   * Constructor
   */
  public SequenceGenerator(final VideoGeneratorModel data) {
    this.data = data;
    this.repair();
  }
  
  /**
   * Sequence getter
   */
  public VideoGeneratorModel getRepairedModel() {
    return this.data;
  }
  
  public double getDuration(final String location) {
    try {
      String result = "";
      try {
        Runtime r = Runtime.getRuntime();
        ProcessBuilder _processBuilder = new ProcessBuilder("ffmpeg", "-i", location);
        ProcessBuilder _redirectErrorStream = _processBuilder.redirectErrorStream(true);
        Process processDuration = _redirectErrorStream.start();
        StringBuilder strBuild = new StringBuilder();
        InputStream _inputStream = processDuration.getInputStream();
        Charset _defaultCharset = Charset.defaultCharset();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream, _defaultCharset);
        BufferedReader processOutputReader = new BufferedReader(_inputStreamReader);
        String line = null;
        while ((!Objects.equal((line = processOutputReader.readLine()), null))) {
          boolean _contains = line.contains("Duration");
          if (_contains) {
            String _trim = line.trim();
            line = _trim;
            String[] _split = line.split(" ");
            String _get = _split[1];
            String[] _split_1 = _get.split(",");
            String _get_1 = _split_1[0];
            line = _get_1;
            String[] _split_2 = line.split(":");
            String _get_2 = _split_2[0];
            int hours = Integer.parseInt(_get_2);
            String[] _split_3 = line.split(":");
            String _get_3 = _split_3[1];
            int mins = Integer.parseInt(_get_3);
            String[] _split_4 = line.split(":");
            String _get_4 = _split_4[2];
            double secs = Double.parseDouble(_get_4);
            return (((3600 * hours) + (60 * mins)) + secs);
          }
        }
        processDuration.waitFor();
      } catch (final Throwable _t) {
        if (_t instanceof IOException) {
          final IOException e = (IOException)_t;
          System.out.println(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return 0;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Repair
   */
  public void repair() {
    EList<VideoSeq> _videoseqs = this.data.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        this.fix(desc);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          this.fix(desc_1);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription desc_2 : _videodescs) {
            this.fix(desc_2);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public double getSize(final VideoDescription desc) {
    File file = new File("/home/loic/Videos/op/a.mkv");
    boolean _exists = file.exists();
    if (_exists) {
      double bytes = file.length();
      double kilobytes = (bytes / 1024);
      double megabytes = (kilobytes / 1024);
      return megabytes;
    }
    return 0;
  }
  
  public void fix(final VideoDescription desc) {
    desc.setLocation("/home/loic/Videos/op/a.mkv");
    int _duration = desc.getDuration();
    boolean _equals = (_duration == 0);
    if (_equals) {
      String _location = desc.getLocation();
      double _duration_1 = this.getDuration(_location);
      desc.setDuration(((int) _duration_1));
    }
    int _size = desc.getSize();
    boolean _equals_1 = (_size == 0);
    if (_equals_1) {
      double _size_1 = this.getSize(desc);
      desc.setSize(((int) _size_1));
    }
  }
}
