package videogen;

import playlist.playlist;
import videogen.transformModelToText;

@SuppressWarnings("all")
public class Main {
  public static void main(final String[] args) {
    final transformModelToText vv = new transformModelToText();
    playlist playlist = vv.playlist();
  }
}
