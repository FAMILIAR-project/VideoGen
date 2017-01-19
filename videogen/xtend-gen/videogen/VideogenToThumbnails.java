package videogen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
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
import videogenPlaylist.MediaFile;
import videogenPlaylist.Playlist;
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl;

/**
 * Vignettes
 */
@SuppressWarnings("all")
public class VideogenToThumbnails {
  private String thumbnail = "";
  
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
      String cmdThumbnail = (((("lib\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -i createdPlaylists/" + path) + " -ss 00:00:01.000 -vframes 1 thumbnails/") + filename) + "1.png");
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
        EList<MediaFile> _mediaFile = playlist.getMediaFile();
        _mediaFile.add(mediafile);
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
          String _thumbnail_1 = this.thumbnail;
          String _createThumbnail_1 = VideogenToThumbnails.createThumbnail(path_1, id_1);
          String _plus_2 = ("<img src= " + _createThumbnail_1);
          String _plus_3 = (_plus_2 + " width=\'400px\' height=auto/><br/>");
          this.thumbnail = (_thumbnail_1 + _plus_3);
          EList<MediaFile> _mediaFile_1 = playlist.getMediaFile();
          _mediaFile_1.add(mediafile_1);
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
              String _thumbnail_2 = this.thumbnail;
              String _createThumbnail_2 = VideogenToThumbnails.createThumbnail(path_2, id_2);
              String _plus_4 = ("<img src=" + _createThumbnail_2);
              String _plus_5 = (_plus_4 + " width=\'400px\' height=auto/><br/>");
              this.thumbnail = (_thumbnail_2 + _plus_5);
              EList<MediaFile> _mediaFile_2 = playlist.getMediaFile();
              _mediaFile_2.add(mediafile_2);
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
    int _plusPlus = VideogenToThumbnails.i++;
    return ("v" + Integer.valueOf(_plusPlus));
  }
}
