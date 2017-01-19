package videogen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
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
import videogen.VideogenToThumbnails;
import videogenPlaylist.MediaFile;
import videogenPlaylist.Playlist;
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl;

/**
 * Vignettes
 */
@SuppressWarnings("all")
public class VideogenWarnings {
  private String thumbnail = "";
  
  private List thumbsId = new ArrayList<Integer>();
  
  private List thumbsPath = new ArrayList<String>();
  
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
  
  public static String createThumbnail(final String path, final String filename) {
    try {
      String cmdThumbnail = (((("C:\\Users\\Robin\\Desktop\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -i " + path) + " -ss 00:00:01.000 -vframes 1 thumbnails/") + filename) + "1.png");
      Runtime _runtime = Runtime.getRuntime();
      Process process = _runtime.exec(cmdThumbnail);
      process.waitFor(2000, TimeUnit.MILLISECONDS);
      return (filename + "1.png");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test() {
    URI _createURI = URI.createURI("testVideos.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    VideogenPlaylistFactoryImpl factory = new VideogenPlaylistFactoryImpl();
    Playlist playlist = factory.createPlaylist();
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    for (final VideoSeq video : _videoseqs) {
      if ((video instanceof MandatoryVideoSeq)) {
        VideoDescription _description = ((MandatoryVideoSeq) video).getDescription();
        final String path = _description.getLocation();
        VideoDescription _description_1 = ((MandatoryVideoSeq) video).getDescription();
        String id = _description_1.getVideoid();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(id);
        if (_isNullOrEmpty) {
          String _genID = this.genID();
          id = _genID;
        }
        MediaFile mediafile = factory.createMediaFile();
        mediafile.setPath(path);
        String _thumbnail = this.thumbnail;
        String _createThumbnail = VideogenToThumbnails.createThumbnail(path, id);
        String _plus = ("<img src = " + _createThumbnail);
        String _plus_1 = (_plus + " width=\'400px\' height=auto/><br/>");
        this.thumbnail = (_thumbnail + _plus_1);
        String _path = mediafile.getPath();
        boolean _contains = this.thumbsPath.contains(_path);
        if (_contains) {
          String _thumbnail_1 = this.thumbnail;
          String _path_1 = mediafile.getPath();
          String _plus_2 = (("<p>Cette video obligatoire existe deja" + "<b>") + _path_1);
          String _plus_3 = (_plus_2 + "</b>");
          String _plus_4 = (_plus_3 + "</p>");
          this.thumbnail = (_thumbnail_1 + _plus_4);
        } else {
          boolean _contains_1 = this.thumbsId.contains(id);
          if (_contains_1) {
            String _thumbnail_2 = this.thumbnail;
            this.thumbnail = (_thumbnail_2 + (((("<p>L\'identifiant de cette video obligatoire n\'est pas unique" + "<b>") + id) + "</b>") + "</p>"));
          } else {
            String _path_2 = mediafile.getPath();
            this.thumbsPath.add(_path_2);
            this.thumbsId.add(id);
            EList<MediaFile> _mediaFile = playlist.getMediaFile();
            _mediaFile.add(mediafile);
          }
        }
      } else {
        if ((video instanceof OptionalVideoSeq)) {
          VideoDescription _description_2 = ((OptionalVideoSeq) video).getDescription();
          final String path_1 = _description_2.getLocation();
          VideoDescription _description_3 = ((OptionalVideoSeq) video).getDescription();
          String id_1 = _description_3.getVideoid();
          boolean _isNullOrEmpty_1 = StringExtensions.isNullOrEmpty(id_1);
          if (_isNullOrEmpty_1) {
            String _genID_1 = this.genID();
            id_1 = _genID_1;
          }
          MediaFile mediafile_1 = factory.createMediaFile();
          mediafile_1.setPath(path_1);
          String _thumbnail_3 = this.thumbnail;
          String _createThumbnail_1 = VideogenToThumbnails.createThumbnail(path_1, id_1);
          String _plus_5 = ("<img src= " + _createThumbnail_1);
          String _plus_6 = (_plus_5 + " width=\'400px\' height=auto/><br/>");
          this.thumbnail = (_thumbnail_3 + _plus_6);
          String _path_3 = mediafile_1.getPath();
          boolean _contains_2 = this.thumbsPath.contains(_path_3);
          if (_contains_2) {
            String _thumbnail_4 = this.thumbnail;
            String _path_4 = mediafile_1.getPath();
            String _plus_7 = (("<p>Cette video optionelle existe deja" + "<b>") + _path_4);
            String _plus_8 = (_plus_7 + "</b>");
            String _plus_9 = (_plus_8 + "</p>");
            this.thumbnail = (_thumbnail_4 + _plus_9);
          } else {
            boolean _contains_3 = this.thumbsId.contains(id_1);
            if (_contains_3) {
              String _thumbnail_5 = this.thumbnail;
              this.thumbnail = (_thumbnail_5 + (((("<p>L\'identifiant de cette video optionelle n\'est pas unique" + "<b>") + id_1) + "</b>") + "</p>"));
            } else {
              String _path_5 = mediafile_1.getPath();
              this.thumbsPath.add(_path_5);
              this.thumbsId.add(id_1);
              EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
              _mediaFile_1.add(mediafile_1);
            }
          }
        } else {
          EList<VideoDescription> _videodescs = ((AlternativeVideoSeq) video).getVideodescs();
          for (final VideoDescription alt : _videodescs) {
            {
              String path_2 = alt.getLocation();
              String id_2 = alt.getVideoid();
              boolean _isNullOrEmpty_2 = StringExtensions.isNullOrEmpty(id_2);
              if (_isNullOrEmpty_2) {
                String _genID_2 = this.genID();
                id_2 = _genID_2;
              }
              MediaFile mediafile_2 = factory.createMediaFile();
              mediafile_2.setPath(path_2);
              String _thumbnail_6 = this.thumbnail;
              String _createThumbnail_2 = VideogenToThumbnails.createThumbnail(path_2, id_2);
              String _plus_10 = ("<img src=" + _createThumbnail_2);
              String _plus_11 = (_plus_10 + " width=\'400px\' height=auto/><br/>");
              this.thumbnail = (_thumbnail_6 + _plus_11);
              String _path_6 = mediafile_2.getPath();
              boolean _contains_4 = this.thumbsPath.contains(_path_6);
              if (_contains_4) {
                String _thumbnail_7 = this.thumbnail;
                String _path_7 = mediafile_2.getPath();
                String _plus_12 = (("<p>Cette video alternative existe deja" + "<b>") + _path_7);
                String _plus_13 = (_plus_12 + "</b>");
                String _plus_14 = (_plus_13 + "</p>");
                this.thumbnail = (_thumbnail_7 + _plus_14);
              } else {
                boolean _contains_5 = this.thumbsId.contains(id_2);
                if (_contains_5) {
                  String _thumbnail_8 = this.thumbnail;
                  this.thumbnail = (_thumbnail_8 + (((("<p>L\'identifiant de cette video alternative n\'est pas unique" + "<b>") + id_2) + "</b>") + "</p>"));
                } else {
                  String _path_8 = mediafile_2.getPath();
                  this.thumbsPath.add(_path_8);
                  this.thumbsId.add(id_2);
                  EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
                  _mediaFile_2.add(mediafile_2);
                }
              }
            }
          }
        }
      }
    }
    try {
      final File file = new File("thumbnails/thumbnailsQ9.html");
      boolean _exists = file.exists();
      boolean _not = (!_exists);
      if (_not) {
        file.createNewFile();
      } else {
        file.delete();
      }
      File _absoluteFile = file.getAbsoluteFile();
      final FileWriter fw = new FileWriter(_absoluteFile);
      final BufferedWriter bw = new BufferedWriter(fw);
      bw.write("<!DOCTYPE html> \n");
      bw.write("<head> \n");
      bw.write("<link rel=\"stylesheet\" href=\"style.css\"/> \n");
      bw.write("</head> \n");
      bw.write("<body> \n");
      bw.write((this.thumbnail + "\n"));
      bw.write("</body> \n");
      bw.write("</html> \n");
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
  
  public String genID() {
    int _plusPlus = VideogenWarnings.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
