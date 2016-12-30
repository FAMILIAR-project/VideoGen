package videogen.vignette;

import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class FFMPEGHelper {
  public int generateThumbnail(final String location, final String name) {
    return this.execCmd(location, name);
  }
  
  public int execCmd(final String location, final String name) {
    try {
      int _xblockexpression = (int) 0;
      {
        String command = ((((("ffmpeg -y -i " + "./") + location) + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 ") + name) + ".png");
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(command);
        _xblockexpression = p.waitFor();
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
