package videogen;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import videogen.IdmUtil;

@SuppressWarnings("all")
public class Gification {
  @Test
  public void gification() {
    URI _createURI = URI.createURI("videos.videogen");
    VideoGeneratorModel videoGen = IdmUtil.loadVideoGenerator(_createURI);
    IdmUtil.checkVideoGen(videoGen);
  }
  
  public String concatVideos(final String ffmegPlaylist) {
    try {
      String cmd = (("ffmpeg -auto_convert 1 -f concat -safe 0 -i " + ffmegPlaylist) + " -codec copy -y /home/paul/Vidéos/idm/gification/concat_playlist.mp4");
      Runtime _runtime = Runtime.getRuntime();
      Process result = _runtime.exec(cmd);
      result.waitFor();
      return "/home/paul/Vidéos/idm/gification/concat_playlist.mp4";
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createGifFromVideo(final String videoLocation, final int duration, final int start, final int size, final String filename) {
    try {
      String cmd = (((((((((("ffmpeg -v warning -ss " + Integer.valueOf(start)) + " -t ") + Integer.valueOf(duration)) + " -i ") + videoLocation) + " -vf scale=") + Integer.valueOf(size)) + ":-1 -gifflags +transdiff -y /home/paul/Vidéos/idm/gification/") + filename) + ".gif");
      Runtime _runtime = Runtime.getRuntime();
      Process result = _runtime.exec(cmd);
      result.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void createGifHDFromVideo(final String videoLocation, final int duration, final int start, final int size, final String filename) {
    try {
      String cmd1 = (((((((("ffmpeg -v warning -ss " + Integer.valueOf(start)) + " -t ") + Integer.valueOf(duration)) + " -i ") + videoLocation) + " -vf scale=") + Integer.valueOf(size)) + ":-1:flags=lanczos,palettegen -y /home/paul/Vidéos/idm/gification/palette.png");
      Runtime _runtime = Runtime.getRuntime();
      Process result1 = _runtime.exec(cmd1);
      result1.waitFor();
      String cmd2 = (((((("ffmpeg -ss 0 -t 3 -i " + videoLocation) + " -i /home/paul/Vidéos/idm/gification/palette.png -filter_complex \"fps=10,scale=") + Integer.valueOf(size)) + ":-1:flags=lanczos[x];[x][1:v]paletteuse\" -y /home/paul/Vidéos/idm/gification/") + filename) + "HD.gif");
      InputOutput.<String>println(cmd2);
      Runtime _runtime_1 = Runtime.getRuntime();
      Process result2 = _runtime_1.exec(cmd2);
      result2.waitFor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
