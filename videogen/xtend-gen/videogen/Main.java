package videogen;

import org.eclipse.emf.common.util.URI;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import playlist.Playlist;
import videogen.transformationsVideo;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    final transformationsVideo vv = new transformationsVideo();
    vv.transform();
    Playlist playlist = vv.playlist();
    vv.transformationPlaylistToFileM3U(playlist);
    vv.transformationPlaylistToFileffmpeg(playlist);
    vv.transformationPlaylistToFileM3UEtendu(playlist);
    vv.playlistWithDuration();
    vv.playlistVignette(playlist);
    URI _createURI = URI.createURI("foo1.videogen");
    VideoGeneratorModel videoGen = vv.loadVideoGenerator(_createURI);
    vv.verify();
    vv.printToHTMLWithRandom(videoGen);
    vv.createVideoGen();
    vv.filters(videoGen);
    vv.createFeatureModel();
  }
}
