package videogen.vignette;

import java.io.File;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;

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
  
  public Integer applyFilter(final String filter, final String input, final String output) {
    try {
      Integer _xblockexpression = null;
      {
        File file = new File(output);
        boolean _exists = file.exists();
        if (_exists) {
          file.delete();
        }
        Integer _xifexpression = null;
        boolean _equals = filter.equals("BLACK_AND_WHITE");
        if (_equals) {
          Integer _xblockexpression_1 = null;
          {
            String command = ((("ffmpeg -i " + input) + " -vf hue=s=0 -c:a copy ") + output);
            InputOutput.<String>println(command);
            Runtime _runtime = Runtime.getRuntime();
            Process p = _runtime.exec(command);
            p.waitFor();
            int _exitValue = p.exitValue();
            _xblockexpression_1 = InputOutput.<Integer>println(Integer.valueOf(_exitValue));
          }
          _xifexpression = _xblockexpression_1;
        } else {
          Integer _xifexpression_1 = null;
          boolean _equals_1 = filter.equals("SEPIA");
          if (_equals_1) {
            Integer _xblockexpression_2 = null;
            {
              String command = ((((("ffmpeg -i " + input) + " -filter_complex ") + "[0:v]colorchannelmixer=.393:.769:.189:0:.349:.686:.168:0:.272:.534:.131[colorchannelmixed];[colorchannelmixed]eq=1.0:0:1.3:2.4:1.0:1.0:1.0:1.0[color_effect]") + " -map [color_effect] -c:v libx264 -c:a copy ") + output);
              InputOutput.<String>println(command);
              Runtime _runtime = Runtime.getRuntime();
              Process p = _runtime.exec(command);
              p.waitFor();
              int _exitValue = p.exitValue();
              _xblockexpression_2 = InputOutput.<Integer>println(Integer.valueOf(_exitValue));
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
}
