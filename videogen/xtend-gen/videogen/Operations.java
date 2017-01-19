package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

@SuppressWarnings("all")
public class Operations {
  public static void writeToFile(final String filename, final String content) {
    try {
      final FileWriter writer = new FileWriter(filename);
      writer.write(content);
      writer.flush();
      writer.close();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void commandFFmpegToGenerateImage(final String path, final String name) {
    try {
      String command = (((("ffmpeg -i " + path) + " -vcodec mjpeg -vframes 1 -an -f rawvideo -s 640x360 -ss 3 ") + name) + 
        ".jpg");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static Process commandFFmpegToGenerateDuration(final String path) {
    try {
      Process _xblockexpression = null;
      {
        String command = (("ffmpeg -i " + path) + "-vcodec copy -an -f null -");
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(command);
        p.waitFor();
        _xblockexpression = p;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static BufferedReader getOutput(final Process p) {
    BufferedReader _xblockexpression = null;
    {
      InputStream _inputStream = p.getInputStream();
      InputStreamReader inputStreamReader = new InputStreamReader(_inputStream);
      _xblockexpression = new BufferedReader(inputStreamReader);
    }
    return _xblockexpression;
  }
  
  public static void displayBuffer(final BufferedReader buf) {
    try {
      String ligne = "";
      while ((!Objects.equal((ligne = buf.readLine()), null))) {
        InputOutput.<String>println(ligne);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
