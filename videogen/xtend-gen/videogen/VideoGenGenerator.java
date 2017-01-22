package videogen;

import com.google.common.base.Objects;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;

@SuppressWarnings("all")
public class VideoGenGenerator {
  @Test
  public void testGeneration() {
    this.generate("videos/montage.videogen");
  }
  
  public void generate(final String path) {
    URI _createURI = URI.createURI(path);
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    this.generateId(videoGen);
    this.generateDuration(videoGen);
    URI _createURI_1 = URI.createURI(path);
    this.saveVideoGenerator(_createURI_1, videoGen);
    this.metrics(videoGen);
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
   * Generators
   */
  public void generateId(final VideoGeneratorModel videoGen) {
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
  }
  
  public void generateDuration(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        int _genDuration = this.genDuration(_location);
        desc.setDuration(_genDuration);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          String _location_1 = desc_1.getLocation();
          int _genDuration_1 = this.genDuration(_location_1);
          desc_1.setDuration(_genDuration_1);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs) {
            {
              final VideoDescription desc_2 = ((VideoDescription) vdesc);
              String _location_2 = desc_2.getLocation();
              int _genDuration_2 = this.genDuration(_location_2);
              desc_2.setDuration(_genDuration_2);
            }
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public void generateThumbnails(final VideoGeneratorModel videoGen) {
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _location = desc.getLocation();
        this.genVignette(_location);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          double _random = Math.random();
          double _multiply = (_random * 1);
          boolean _greaterThan = (_multiply > 0.5);
          if (_greaterThan) {
            String _location_1 = desc_1.getLocation();
            this.genVignette(_location_1);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan_1 = (_size > 0);
          if (_greaterThan_1) {
            double _random_1 = Math.random();
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            int _size_1 = _videodescs_1.size();
            double i = (_random_1 * _size_1);
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            VideoDescription _get = _videodescs_2.get(((int) i));
            String _location_2 = _get.getLocation();
            this.genVignette(_location_2);
          }
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public void metrics(final VideoGeneratorModel videoGen) {
    int duree_max = 0;
    int duree_min = 0;
    int duree_avg = 0;
    int size_max = 0;
    int size_min = 0;
    int size_avg = 0;
    int nb_sol = 0;
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        nb_sol++;
        int _duree_min = duree_min;
        VideoDescription _description = ((MandatoryVideoSeq)videoseq).getDescription();
        int _duration = _description.getDuration();
        duree_min = (_duree_min + _duration);
        int _duree_max = duree_max;
        VideoDescription _description_1 = ((MandatoryVideoSeq)videoseq).getDescription();
        int _duration_1 = _description_1.getDuration();
        duree_max = (_duree_max + _duration_1);
        int _duree_avg = duree_avg;
        VideoDescription _description_2 = ((MandatoryVideoSeq)videoseq).getDescription();
        int _duration_2 = _description_2.getDuration();
        duree_avg = (_duree_avg + _duration_2);
        int _size_min = size_min;
        VideoDescription _description_3 = ((MandatoryVideoSeq)videoseq).getDescription();
        int _duration_3 = _description_3.getDuration();
        size_min = (_size_min + _duration_3);
        int _size_max = size_max;
        VideoDescription _description_4 = ((MandatoryVideoSeq)videoseq).getDescription();
        int _duration_4 = _description_4.getDuration();
        size_max = (_size_max + _duration_4);
        int _size_avg = size_avg;
        VideoDescription _description_5 = ((MandatoryVideoSeq)videoseq).getDescription();
        int _duration_5 = _description_5.getDuration();
        size_avg = (_size_avg + _duration_5);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          int _nb_sol = nb_sol;
          nb_sol = (_nb_sol * 2);
          int _duree_max_1 = duree_max;
          VideoDescription _description_6 = ((OptionalVideoSeq)videoseq).getDescription();
          int _duration_6 = _description_6.getDuration();
          duree_max = (_duree_max_1 + _duration_6);
          int _duree_avg_1 = duree_avg;
          VideoDescription _description_7 = ((OptionalVideoSeq)videoseq).getDescription();
          int _duration_7 = _description_7.getDuration();
          int _divide = (_duration_7 / 2);
          duree_avg = (_duree_avg_1 + _divide);
          int _size_max_1 = size_max;
          VideoDescription _description_8 = ((OptionalVideoSeq)videoseq).getDescription();
          int _duration_8 = _description_8.getDuration();
          size_max = (_size_max_1 + _duration_8);
          int _size_avg_1 = size_avg;
          VideoDescription _description_9 = ((OptionalVideoSeq)videoseq).getDescription();
          int _duration_9 = _description_9.getDuration();
          int _divide_1 = (_duration_9 / 2);
          size_avg = (_size_avg_1 + _divide_1);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          int duree_alt_tot = 0;
          int duree_alt_max = 0;
          int duree_alt_min = 0;
          int size_alt_tot = 0;
          int size_alt_max = 0;
          int size_alt_min = 0;
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            int _nb_sol_1 = nb_sol;
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            int _size_1 = _videodescs_1.size();
            nb_sol = (_nb_sol_1 * _size_1);
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            for (final VideoDescription videodesc : _videodescs_2) {
              {
                int _duration_10 = videodesc.getDuration();
                boolean _greaterThan_1 = (_duration_10 > duree_alt_max);
                if (_greaterThan_1) {
                  int _duration_11 = videodesc.getDuration();
                  duree_alt_max = _duration_11;
                }
                int _duration_12 = videodesc.getDuration();
                boolean _lessThan = (_duration_12 < duree_alt_min);
                if (_lessThan) {
                  int _duration_13 = videodesc.getDuration();
                  duree_alt_min = _duration_13;
                }
                int _duree_alt_tot = duree_alt_tot;
                int _duration_14 = videodesc.getDuration();
                duree_alt_tot = (_duree_alt_tot + _duration_14);
                int _size_2 = videodesc.getSize();
                boolean _greaterThan_2 = (_size_2 > size_alt_max);
                if (_greaterThan_2) {
                  int _size_3 = videodesc.getSize();
                  size_alt_max = _size_3;
                }
                int _size_4 = videodesc.getSize();
                boolean _lessThan_1 = (_size_4 < duree_alt_min);
                if (_lessThan_1) {
                  int _size_5 = videodesc.getSize();
                  size_alt_min = _size_5;
                }
                int _size_alt_tot = size_alt_tot;
                int _size_6 = videodesc.getSize();
                size_alt_tot = (_size_alt_tot + _size_6);
              }
            }
            int _duree_max_2 = duree_max;
            duree_max = (_duree_max_2 + duree_alt_max);
            int _duree_min_1 = duree_min;
            duree_min = (_duree_min_1 + duree_alt_min);
            int _duree_avg_2 = duree_avg;
            EList<VideoDescription> _videodescs_3 = altvid.getVideodescs();
            int _size_2 = _videodescs_3.size();
            int _divide_2 = (duree_alt_tot / _size_2);
            duree_avg = (_duree_avg_2 + _divide_2);
            int _size_max_2 = size_max;
            size_max = (_size_max_2 + size_alt_max);
            int _size_min_1 = size_min;
            size_min = (_size_min_1 + size_alt_min);
            int _size_avg_2 = size_avg;
            EList<VideoDescription> _videodescs_4 = altvid.getVideodescs();
            int _size_3 = _videodescs_4.size();
            int _divide_3 = (size_alt_tot / _size_3);
            size_avg = (_size_avg_2 + _divide_3);
          }
        }
      }
    }
    System.out.println(
      ((((((((((((("Nombre de variantes : " + Integer.valueOf(nb_sol)) + 
        "\n Duree Moyenne : ") + Integer.valueOf(duree_avg)) + "\n Duree Max : ") + Integer.valueOf(duree_max)) + 
        "\n Duree Min : ") + Integer.valueOf(duree_min)) + "\n Taille Moyenne : ") + Integer.valueOf(size_avg)) + 
        "\n Taille Max : ") + Integer.valueOf(size_max)) + "\n Taille Min : ") + Integer.valueOf(size_min)));
  }
  
  public void genVignette(final String path) {
    try {
      Path _get = Paths.get(path);
      Path _parent = _get.getParent();
      Path _fileName = _parent.getFileName();
      String _string = _fileName.toString();
      String _plus = ((("ffmpeg -y -i " + path) + " -r 1 -t 00:00:01 -f image2 ") + _string);
      String _plus_1 = (_plus + "/vignette-");
      Path _get_1 = Paths.get(path);
      Path _fileName_1 = _get_1.getFileName();
      String _string_1 = _fileName_1.toString();
      String _replaceFirst = _string_1.replaceFirst("[.][^.]+$", "");
      String _plus_2 = (_plus_1 + _replaceFirst);
      String cmd = (_plus_2 + ".png");
      Runtime r = Runtime.getRuntime();
      Process p = r.exec(cmd);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String generateM3U(final VideoGeneratorModel videoGen) {
    String m3u = "";
    String _m3u = m3u;
    m3u = (_m3u + "#EXTM3U\n");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq videoseq : _videoseqs) {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        final VideoDescription desc = ((MandatoryVideoSeq) videoseq).getDescription();
        String _m3u_1 = m3u;
        String _location = desc.getLocation();
        String _plus = ("#EXTINF:\n" + _location);
        String _plus_1 = (_plus + "\n");
        m3u = (_m3u_1 + _plus_1);
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          final VideoDescription desc_1 = ((OptionalVideoSeq) videoseq).getDescription();
          double _random = Math.random();
          double _multiply = (_random * 1);
          boolean _greaterThan = (_multiply > 0.5);
          if (_greaterThan) {
            String _m3u_2 = m3u;
            String _location_1 = desc_1.getLocation();
            String _plus_2 = ("#EXTINF:\n" + _location_1);
            String _plus_3 = (_plus_2 + "\n");
            m3u = (_m3u_2 + _plus_3);
          }
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan_1 = (_size > 0);
          if (_greaterThan_1) {
            String _m3u_3 = m3u;
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            double _random_1 = Math.random();
            EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
            int _size_1 = _videodescs_2.size();
            double _multiply_1 = (_random_1 * _size_1);
            VideoDescription _get = _videodescs_1.get(((int) _multiply_1));
            String _location_2 = _get.getLocation();
            String _plus_4 = ("#EXTINF:\n" + _location_2);
            String _plus_5 = (_plus_4 + "\n");
            m3u = (_m3u_3 + _plus_5);
          }
        }
      }
    }
    return m3u;
  }
  
  /**
   * Utils
   */
  public int genDuration(final String path) {
    try {
      String cmd = ("ffprobe -i " + path);
      Runtime r = Runtime.getRuntime();
      Process p = r.exec(cmd);
      InputStream _errorStream = p.getErrorStream();
      Scanner sc = new Scanner(_errorStream);
      Pattern durPattern = Pattern.compile("(?<=Duration: )[^,]*");
      String dur = sc.findWithinHorizon(durPattern, 0);
      boolean _equals = Objects.equal(dur, null);
      if (_equals) {
        throw new RuntimeException("Could not parse duration.");
      }
      String[] hms = dur.split(":");
      String _get = hms[0];
      int _parseInt = Integer.parseInt(_get);
      int _multiply = (_parseInt * 3600);
      String _get_1 = hms[1];
      int _parseInt_1 = Integer.parseInt(_get_1);
      int _multiply_1 = (_parseInt_1 * 60);
      int _plus = (_multiply + _multiply_1);
      String _get_2 = hms[2];
      double _parseDouble = Double.parseDouble(_get_2);
      double totalSecs = (_plus + _parseDouble);
      return ((int) totalSecs);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = VideoGenGenerator.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
