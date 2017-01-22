package videogen.vignette;

import java.io.File;
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
  
  public int applyFilter(final String filter, final String input, final String output) {
    try {
      int _xblockexpression = (int) 0;
      {
        File file = new File(output);
        boolean _exists = file.exists();
        if (_exists) {
          file.delete();
        }
        int _xifexpression = (int) 0;
        boolean _equals = filter.equals("BLACK_AND_WHITE");
        if (_equals) {
          int _xblockexpression_1 = (int) 0;
          {
            String command = ((("ffmpeg -i " + input) + " -vf hue=s=0 -c:a copy ") + output);
            Runtime _runtime = Runtime.getRuntime();
            Process p = _runtime.exec(command);
            _xblockexpression_1 = p.waitFor();
          }
          _xifexpression = _xblockexpression_1;
        } else {
          int _xifexpression_1 = (int) 0;
          boolean _equals_1 = filter.equals("SEPIA");
          if (_equals_1) {
            int _xblockexpression_2 = (int) 0;
            {
              String command = ((((("ffmpeg -i " + input) + " -filter_complex ") + "[0:v]colorchannelmixer=.393:.769:.189:0:.349:.686:.168:0:.272:.534:.131[colorchannelmixed];[colorchannelmixed]eq=1.0:0:1.3:2.4:1.0:1.0:1.0:1.0[color_effect]") + " -map [color_effect] -c:v libx264 -c:a copy ") + output);
              Runtime _runtime = Runtime.getRuntime();
              Process p = _runtime.exec(command);
              _xblockexpression_2 = p.waitFor();
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xifexpression = _xifexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int applyTextToVideo(final String text, final String color, final String position, final int size, final String input, final String output) {
    try {
      int _xblockexpression = (int) 0;
      {
        File file = new File(output);
        boolean _exists = file.exists();
        if (_exists) {
          file.delete();
        }
        String command = "";
        boolean _equals = position.equals("TOP");
        if (_equals) {
          command = (((((((((((("ffmpeg -i " + input) + " -vf drawtext=text=") + "\'") + text) + "\'") + ":fontcolor=") + color) + ":fontsize=") + Integer.valueOf(size)) + ":box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:") + "y=10 -codec:a copy ") + output);
        } else {
          boolean _equals_1 = position.equals("CENTER");
          if (_equals_1) {
            command = (((((((((((("ffmpeg -i " + input) + " -vf drawtext=text=") + "\'") + text) + "\'") + ":fontcolor=") + color) + ":fontsize=") + Integer.valueOf(size)) + ":box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:") + "y=(h-text_h)/2 -codec:a copy ") + output);
          } else {
            boolean _equals_2 = position.equals("BOTTOM");
            if (_equals_2) {
              command = (((((((((((("ffmpeg -i " + input) + " -vf drawtext=text=") + "\'") + text) + "\'") + ":fontcolor=") + color) + ":fontsize=") + Integer.valueOf(size)) + ":box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:") + "y=(h-text_h) -codec:a copy ") + output);
            }
          }
        }
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
