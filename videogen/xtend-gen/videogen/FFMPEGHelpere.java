package videogen;

import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class FFMPEGHelpere {
  public void executeCmd(final String location, final String name) {
    try {
      String command = ((((("ffmpeg -y -i " + "./") + location) + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 screenshot/") + name) + ".png");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
