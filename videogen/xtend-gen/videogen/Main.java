package videogen;

import org.eclipse.emf.common.util.URI;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import playlist.Playlist;
import videogen.transformModelToText;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    final transformModelToText vv = new transformModelToText();
    Playlist playlist = vv.playlist();
    vv.transformationPlaylistToFileM3U(playlist);
    vv.transformationPlaylistToFileffmpeg(playlist);
    vv.playlistVignette(playlist);
    URI _createURI = URI.createURI("foo1.videogen");
    VideoGeneratorModel videoGen = vv.loadVideoGenerator(_createURI);
    vv.printToHTML(videoGen);
  }
}