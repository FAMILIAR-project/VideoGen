package videogen.playlist;

import java.io.PrintWriter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated;
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq;
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq;
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq;
import org.xtext.example.mydsl.videoGen.VideoDescription;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import org.xtext.example.mydsl.videoGen.VideoSeq;
import org.xtext.example.playlist.PlaylistStandaloneSetupGenerated;
import org.xtext.example.playlist.playlist.Playlist;
import org.xtext.example.playlist.playlist.Video;
import org.xtext.example.playlist.playlist.impl.PlaylistFactoryImpl;

@SuppressWarnings("all")
public class PlaylistDemonstrator {
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
  
  public Playlist loadPlaylist(final URI uri) {
    Playlist _xblockexpression = null;
    {
      PlaylistStandaloneSetupGenerated _playlistStandaloneSetupGenerated = new PlaylistStandaloneSetupGenerated();
      _playlistStandaloneSetupGenerated.createInjectorAndDoEMFRegistration();
      ResourceSetImpl _resourceSetImpl = new ResourceSetImpl();
      Resource res = _resourceSetImpl.getResource(uri, true);
      EList<EObject> _contents = res.getContents();
      EObject _get = _contents.get(0);
      _xblockexpression = ((Playlist) _get);
    }
    return _xblockexpression;
  }
  
  @Test
  public void videogenToPlaylist() {
    InputOutput.<String>println("OKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
    URI _createURI = URI.createURI("test.videogen");
    VideoGeneratorModel videoGen = this.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    EList<VideoSeq> _videoseqs = videoGen.getVideoseqs();
    int _size = _videoseqs.size();
    Assert.assertEquals(7, _size);
    PlaylistFactoryImpl playlistFactory = new PlaylistFactoryImpl();
    Playlist playlist = playlistFactory.createPlaylist();
    EList<VideoSeq> videoseqs = videoGen.getVideoseqs();
    int _size_1 = videoseqs.size();
    InputOutput.<Integer>println(Integer.valueOf(_size_1));
    for (final VideoSeq videoseq : videoseqs) {
      {
        String location = "";
        if ((videoseq instanceof MandatoryVideoSeq)) {
          VideoDescription _description = ((MandatoryVideoSeq) videoseq).getDescription();
          String _location = _description.getLocation();
          location = _location;
          Video video = playlistFactory.createVideo();
          video.setLocation(location);
          EList<Video> _videos = playlist.getVideos();
          _videos.add(video);
        } else {
          if ((videoseq instanceof OptionalVideoSeq)) {
            double _random = Math.random();
            double _multiply = (_random * 2);
            final int random = ((int) _multiply);
            if ((random == 1)) {
              VideoDescription _description_1 = ((OptionalVideoSeq) videoseq).getDescription();
              String _location_1 = _description_1.getLocation();
              location = _location_1;
              Video video_1 = playlistFactory.createVideo();
              video_1.setLocation(location);
              EList<Video> _videos_1 = playlist.getVideos();
              _videos_1.add(video_1);
            }
          } else {
            final EList<VideoDescription> alts = ((AlternativeVideoSeq) videoseq).getVideodescs();
            double _random_1 = Math.random();
            int _size_2 = alts.size();
            double _multiply_1 = (_random_1 * _size_2);
            final int random_1 = ((int) _multiply_1);
            VideoDescription _get = alts.get(random_1);
            String _location_2 = _get.getLocation();
            location = _location_2;
            Video video_2 = playlistFactory.createVideo();
            video_2.setLocation(location);
            EList<Video> _videos_2 = playlist.getVideos();
            _videos_2.add(video_2);
          }
        }
      }
    }
    Assert.assertNotNull(playlist);
    this.playlist2text(playlist);
  }
  
  public void playlist2text(final Playlist playlist) {
    try {
      final PrintWriter writer = new PrintWriter("test.m3u", "UTF-8");
      for (int i = 0; (i < playlist.getVideos().size()); i++) {
        EList<Video> _videos = playlist.getVideos();
        Video _get = _videos.get(i);
        String _location = _get.getLocation();
        String _plus = (_location + "\n");
        writer.write(_plus);
      }
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
