package videogen;

import playlist.Playlist;
import videogen.transformModelToText;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    final transformModelToText vv = new transformModelToText();
    Playlist playlist = vv.playlist();
    vv.createFeatureModel();
  }
}
