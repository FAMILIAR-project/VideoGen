package videogen;

import com.google.common.base.Objects;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.Stream;
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
        ".j+pg");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static String commandFFmpegToGenerateDuration(final String path) {
    try {
      String command = (("ffprobe -i " + path) + " -show_entries format=duration -v quiet -sexagesimal -of csv=p=0");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
      InputStream _inputStream = p.getInputStream();
      Scanner str = new Scanner(_inputStream);
      boolean _hasNext = str.hasNext();
      if (_hasNext) {
        String _next = str.next();
        return _next.trim();
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void commandIncrustText(final String path, final String text) {
    try {
      final String[] str = path.split("/");
      final String folder = str[0];
      String _get = str[1];
      String[] _split = _get.split("\\.");
      String name = _split[0];
      String command = (((((((("ffmpeg -i " + path) + " -vf drawtext=fontfile=/path/to/font.ttf:text=\'") + text) + 
        "\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:y=(h-text_h)/2 -codec:a copy ") + folder) + "/") + name) + "Incr.mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void commandIncrustText(final String path, final String text, final int x, final int y) {
    try {
      final String[] str = path.split("/");
      final String folder = str[0];
      String _get = str[1];
      String[] _split = _get.split("\\.");
      String name = _split[0];
      if (((x > 0) && (y > 0))) {
        String command = (((((((((((("ffmpeg -i " + path) + " -vf drawtext=fontfile=/path/to/font.ttf:text=\'") + text) + 
          "\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=") + Integer.valueOf(x)) + "/2:y=") + Integer.valueOf(y)) + 
          " -codec:a copy ") + folder) + "/") + name) + "IncwithPos.mp4");
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(command);
        p.waitFor();
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public static void commandFilterBlackAndWhite(final String path) {
    try {
      final String[] str = path.split("/");
      final String folder = str[0];
      String _get = str[1];
      String[] _split = _get.split("\\.");
      String name = _split[0];
      String command = (((((("ffmpeg -i " + path) + " -vf hue=s=0 -c:a copy ") + folder) + "/") + name) + "Filter.mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
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
      Stream<String> _lines = buf.lines();
      long _count = _lines.count();
      InputOutput.<Long>println(Long.valueOf(_count));
      while ((!Objects.equal((ligne = buf.readLine()), null))) {
        InputOutput.<String>println(ligne);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
