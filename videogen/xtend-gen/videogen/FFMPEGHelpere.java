package videogen;

import java.io.File;
import java.io.InputStream;
import java.util.Scanner;
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
  
  public void executeCmdGIF(final String input, final String outputname) {
    try {
      String command = (((("ffmpeg -i " + input) + " ") + outputname) + ".gif");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void executeCmdIncrustText(final String input, final String outputname, final String t) {
    try {
      File f = new File(input);
      String path = f.getAbsolutePath();
      String command = ((((((("ffmpeg -i " + path) + " -vf drawtext=fontfile=/path/to/font.ttf:text=\'") + t) + "\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:y=(h-text_h)/2 -codec:a copy ") + path) + outputname) + ".mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void executeCmdFilterBlackAndWhite(final String input, final String output) {
    try {
      File f = new File(input);
      String path = f.getAbsolutePath();
      String command = ((((("ffmpeg -i " + path) + " -vf hue=s=0 -c:a copy ") + path) + output) + ".mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void executeCmdFilterLighter(final String input, final String output) {
    try {
      File f = new File(input);
      String path = f.getAbsolutePath();
      String command = ((((("ffmpeg -i " + path) + " -vf curves=preset=lighter -c:a copy ") + path) + output) + ".mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process p = _runtime.exec(command);
      p.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String executeCmdGetDuration(final String input) {
    try {
      String _xblockexpression = null;
      {
        File f = new File(input);
        String path = f.getAbsolutePath();
        String command = (("ffprobe -i " + path) + " -show_entries format=duration -v quiet -of csv=p=0");
        Runtime _runtime = Runtime.getRuntime();
        Process p = _runtime.exec(command);
        p.waitFor();
        InputStream _inputStream = p.getInputStream();
        Scanner _scanner = new Scanner(_inputStream);
        Scanner str = _scanner.useDelimiter("\\A");
        String _xifexpression = null;
        boolean _hasNext = str.hasNext();
        if (_hasNext) {
          String _next = str.next();
          _xifexpression = _next.trim();
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
