package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import playlist.MediaFile;
import playlist.Playlist;
import playlist.PlaylistFactory;

@SuppressWarnings("all")
public class transformModelToText {
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
  
  public void transform() {
    try {
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final PrintWriter writer = new PrintWriter("/home/yousra/workspaceIDM/VideoGen/videogen/src/videogen/videogenresult.txt", "UTF-8");
      final Random random = new Random();
      random.nextInt(101);
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          writer.println(((((("file" + " ") + "\'") + desc) + "\'") + "\n"));
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(1);
            if ((proba == 1)) {
              writer.println(((((("file" + " ") + "\'") + desc_1) + "\'") + "\n"));
            }
            InputOutput.<String>println(((("proba " + desc_1) + " ") + Integer.valueOf(proba)));
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            ArrayList<Object> l = new ArrayList<Object>();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            int proba_1 = random.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_1.get(proba_1);
            String _location = vaa.getLocation();
            String _plus = ((("file" + " ") + "\'") + _location);
            String _plus_1 = (_plus + "\'");
            String _plus_2 = (_plus_1 + "\n");
            writer.println(_plus_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static int i = 0;
  
  public String genID() {
    int _plusPlus = transformModelToText.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
  
  public Playlist playlist() {
    Playlist _xblockexpression = null;
    {
      final Playlist playlist = PlaylistFactory.eINSTANCE.createPlaylist();
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final Random random = new Random();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          MediaFile MF = PlaylistFactory.eINSTANCE.createMediaFile();
          MF.setLocation(desc);
          EList<MediaFile> _videos = playlist.getVideos();
          _videos.add(MF);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_1.getLocation();
            int proba = random.nextInt(1);
            if ((proba == 1)) {
              MediaFile MF_1 = PlaylistFactory.eINSTANCE.createMediaFile();
              MF_1.setLocation(desc_1);
              EList<MediaFile> _videos_1 = playlist.getVideos();
              _videos_1.add(MF_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            ArrayList<Object> l = new ArrayList<Object>();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            int proba_1 = random.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_1.get(proba_1);
            MediaFile MF_2 = PlaylistFactory.eINSTANCE.createMediaFile();
            String _location = vaa.getLocation();
            MF_2.setLocation(_location);
            EList<MediaFile> _videos_2 = playlist.getVideos();
            _videos_2.add(MF_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      _xblockexpression = playlist;
    }
    return _xblockexpression;
  }
  
  public void transformationPlaylistToFileM3U(final Playlist playlist) {
    try {
      final PrintWriter writer = new PrintWriter("result.m3u");
      EList<MediaFile> _videos = playlist.getVideos();
      for (final MediaFile element : _videos) {
        String _location = element.getLocation();
        String _plus = (_location + "\n");
        writer.write(_plus);
      }
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void transformationPlaylistToFileffmpeg(final Playlist playlist) {
    try {
      final PrintWriter writer = new PrintWriter("result.ffmpeg");
      EList<MediaFile> _videos = playlist.getVideos();
      for (final MediaFile element : _videos) {
        String _location = element.getLocation();
        String _plus = ("file " + _location);
        String _plus_1 = (_plus + "\n");
        writer.write(_plus_1);
      }
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void transformationPlaylistToFileM3UEtendu(final Playlist playlist) {
    try {
      final PrintWriter writer = new PrintWriter("resultEtendu.m3u");
      writer.write("#EXTM3U \n");
      EList<MediaFile> _videos = playlist.getVideos();
      for (final MediaFile element : _videos) {
        int _duration = element.getDuration();
        String _plus = ((("#EXT-X-DISCONTINUITY" + " \n") + " #EXTINF :") + Integer.valueOf(_duration));
        String _plus_1 = (_plus + "\n");
        String _location = element.getLocation();
        String _plus_2 = (_plus_1 + _location);
        String _plus_3 = (_plus_2 + "\n");
        writer.write(_plus_3);
      }
      writer.write("#EXT-X-ENDLIST");
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void transformAjoutDuree() {
    URI _createURI = URI.createURI("foo1.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    final Random random = new Random();
    random.nextInt(101);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String desc = _description.getLocation();
        VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
        int duree = _description_1.getDuration();
        double _calculDuree = this.calculDuree(desc);
        int _intValue = Double.valueOf(_calculDuree).intValue();
        duree = _intValue;
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
          final String desc_1 = _description_2.getLocation();
          this.calculDuree(desc_1);
          int proba = random.nextInt(1);
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          ArrayList<Object> l = new ArrayList<Object>();
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          int proba_1 = random.nextInt(_size);
          EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
          final VideoDescription vaa = _videodescs_1.get(proba_1);
        }
      }
    };
    _videoseqs.forEach(_function);
  }
  
  public Playlist playlistWithDuration() {
    Playlist _xblockexpression = null;
    {
      final Playlist playlist = PlaylistFactory.eINSTANCE.createPlaylist();
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final Random random = new Random();
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          final String desc = _description.getLocation();
          VideoDescription _description_1 = ((MandatoryVideoSeq) videoseq).getDescription();
          int duree = _description_1.getDuration();
          double _calculDuree = this.calculDuree(desc);
          int _intValue = Double.valueOf(_calculDuree).intValue();
          duree = _intValue;
          MediaFile MF = PlaylistFactory.eINSTANCE.createMediaFile();
          MF.setLocation(desc);
          MF.setDuration(duree);
          EList<MediaFile> _videos = playlist.getVideos();
          _videos.add(MF);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
            final String desc_1 = _description_2.getLocation();
            VideoDescription _description_3 = ((MandatoryVideoSeq) videoseq).getDescription();
            int duree_1 = _description_3.getDuration();
            double _calculDuree_1 = this.calculDuree(desc_1);
            int _intValue_1 = Double.valueOf(_calculDuree_1).intValue();
            duree_1 = _intValue_1;
            int proba = random.nextInt(1);
            if ((proba == 1)) {
              MediaFile MF_1 = PlaylistFactory.eINSTANCE.createMediaFile();
              MF_1.setLocation(desc_1);
              MF_1.setDuration(duree_1);
              EList<MediaFile> _videos_1 = playlist.getVideos();
              _videos_1.add(MF_1);
            }
          } else {
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            ArrayList<Object> l = new ArrayList<Object>();
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            int _size = _videodescs.size();
            int proba_1 = random.nextInt(_size);
            EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
            final VideoDescription vaa = _videodescs_1.get(proba_1);
            VideoDescription _description_4 = ((MandatoryVideoSeq) videoseq).getDescription();
            int duree_2 = _description_4.getDuration();
            MediaFile MF_2 = PlaylistFactory.eINSTANCE.createMediaFile();
            String _location = vaa.getLocation();
            double _calculDuree_2 = this.calculDuree(_location);
            int _intValue_2 = Double.valueOf(_calculDuree_2).intValue();
            duree_2 = _intValue_2;
            String _location_1 = vaa.getLocation();
            MF_2.setLocation(_location_1);
            MF_2.setDuration(duree_2);
            EList<MediaFile> _videos_2 = playlist.getVideos();
            _videos_2.add(MF_2);
          }
        }
      };
      _videoseqs.forEach(_function);
      _xblockexpression = playlist;
    }
    return _xblockexpression;
  }
  
  public double calculDuree(final String videoLocation) {
    try {
      double _xblockexpression = (double) 0;
      {
        String cmd = ("/usr/local/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation);
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(cmd);
        InputStream _inputStream = p.getInputStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
        BufferedReader reader = new BufferedReader(_inputStreamReader);
        double line = 0.0;
        String _readLine = reader.readLine();
        double _parseDouble = Double.parseDouble(_readLine);
        line = _parseDouble;
        _xblockexpression = line;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public double creationVignette(final String videoLocation, final int tempsCapture, final String chemin) {
    try {
      double _xblockexpression = (double) 0;
      {
        String cmd = ((((("ffmpeg -y -i" + videoLocation) + "-r 1 -t 00:00:01 -ss 00:00:") + Integer.valueOf(tempsCapture)) + "-f image2") + chemin);
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(cmd);
        InputStream _inputStream = p.getInputStream();
        InputStreamReader _inputStreamReader = new InputStreamReader(_inputStream);
        BufferedReader reader = new BufferedReader(_inputStreamReader);
        double line = 0.0;
        String _readLine = reader.readLine();
        double _parseDouble = Double.parseDouble(_readLine);
        line = _parseDouble;
        _xblockexpression = line;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void playlistVignette(final Playlist playlist) {
    EList<MediaFile> _videos = playlist.getVideos();
    for (final MediaFile element : _videos) {
      String _location = element.getLocation();
      String _location_1 = element.getLocation();
      String _plus = (_location_1 + ".png");
      this.creationVignette(_location, 1, _plus);
    }
  }
  
  public void printToHTML(final VideoGeneratorModel videoGen) {
    InputOutput.<String>println("<ul>");
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    final Consumer<VideoSeq> _function = (VideoSeq videoseq) -> {
      if ((videoseq instanceof MandatoryVideoSeq)) {
        VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
        final String desc = _description.getLocation();
        this.creationVignette(desc, 1, (desc + ".png"));
        InputOutput.<String>println(((("<li>" + "<img src=") + desc) + ".png/></li>"));
      } else {
        if ((videoseq instanceof OptionalVideoSeq)) {
          VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
          final String desc_1 = _description_1.getLocation();
          this.creationVignette(desc_1, 1, (desc_1 + ".png"));
          InputOutput.<String>println(((("<li>" + "<img src=") + desc_1) + ".png/></li>"));
        } else {
          final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
          EList<VideoDescription> _videodescs = altvid.getVideodescs();
          int _size = _videodescs.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            InputOutput.<String>println("<ul>");
          }
          EList<VideoDescription> _videodescs_1 = altvid.getVideodescs();
          for (final VideoDescription vdesc : _videodescs_1) {
            {
              String _location = vdesc.getLocation();
              String _location_1 = vdesc.getLocation();
              String _plus = (_location_1 + ".png");
              this.creationVignette(_location, 1, _plus);
              String _location_2 = vdesc.getLocation();
              String _plus_1 = (("<li>" + "<img src=") + _location_2);
              String _plus_2 = (_plus_1 + ".png/></li>");
              InputOutput.<String>println(_plus_2);
            }
          }
          EList<VideoDescription> _videodescs_2 = altvid.getVideodescs();
          int _size_1 = _videodescs_2.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            InputOutput.<String>println("</ul>");
          }
        }
      }
    };
    _videoseqs.forEach(_function);
    InputOutput.<String>println("</ul>");
  }
  
  public void verify() {
    try {
      URI _createURI = URI.createURI("foo1.videogen");
      VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
      final Random random = new Random();
      random.nextInt(101);
      String idOp = "";
      String idAl = "";
      String idM = "";
      EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
      for (final VideoSeq videoseq : _videoseqs) {
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _videoid = _description.getVideoid();
          idM = _videoid;
          boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(idM);
          if (_isNullOrEmpty) {
            String _genID = this.genID();
            idM = _genID;
          }
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
            final int probabilite = _description_1.getProbability();
            VideoDescription _description_2 = ((OptionalVideoSeq) videoseq).getDescription();
            String _videoid_1 = _description_2.getVideoid();
            idOp = _videoid_1;
            boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(idOp);
            if (_isNullOrEmpty_1) {
              String _genID_1 = this.genID();
              idOp = _genID_1;
            }
            if ((probabilite > 1)) {
              throw new Exception();
            }
          } else {
            int totalProb = 0;
            final AlternativeVideoSeq altvid = ((AlternativeVideoSeq) videoseq);
            EList<VideoDescription> _videodescs = altvid.getVideodescs();
            for (final VideoDescription vdesc : _videodescs) {
              {
                String _videoid_2 = vdesc.getVideoid();
                idAl = _videoid_2;
                final int probabilite_1 = vdesc.getProbability();
                boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(idAl);
                if (_isNullOrEmpty_2) {
                  String _genID_2 = this.genID();
                  idAl = _genID_2;
                }
                if (((Objects.equal(idAl, idOp) || Objects.equal(idAl, idM)) || Objects.equal(idM, idOp))) {
                  throw new Exception();
                }
                int _talProb = totalProb;
                totalProb = (_talProb + probabilite_1);
              }
            }
            if ((totalProb > 1)) {
              throw new Exception();
            }
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
