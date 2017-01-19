package videogen;

import java.io.FileWriter;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class Operations {
  public static void writeToFile(final String filename, final String content) {
    try {
      final FileWriter writer = new FileWriter((filename + ".txt"));
      writer.write(content);
      writer.flush();
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void execCommandFFmpeg(final String path, final String name) {
    try {
      String command = ((((("ffmpeg -i " + path) + " -vcodec mjpeg -vframes 1 -an -f rawvideo -s 640x360 -ss 3 ") + 
        "resources/") + name) + ".jpg");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
