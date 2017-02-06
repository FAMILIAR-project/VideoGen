package videogen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import playlist.MediaFile;
import playlist.Playlist;
import videogen.IdmUtil;

@SuppressWarnings("all")
public class Gification {
  @Test
  public void gification() {
    URI _createURI = URI.createURI("videos.videogen");
    VideoGeneratorModel videoGen = IdmUtil.loadVideoGenerator(_createURI);
    IdmUtil.checkVideoGen(videoGen);
    Playlist playlist = IdmUtil.generatePlaylist(videoGen);
    String ffmpegStr = "";
    EList<MediaFile> _mediaFile = playlist.getMediaFile();
    for (final MediaFile mediaFile : _mediaFile) {
      String _ffmpegStr = ffmpegStr;
      String _location = mediaFile.getLocation();
      String _plus = ("file \'" + _location);
      String _plus_1 = (_plus + "\'\n");
      ffmpegStr = (_ffmpegStr + _plus_1);
    }
    IdmUtil.createFile("/home/paul/Vidéos/idm/gification/ffmpeg_playlist.txt", ffmpegStr);
    String concatVideosLocation = this.concatVideos("/home/paul/Vidéos/idm/gification/ffmpeg_playlist.txt");
    InputOutput.<String>println("hola");
    this.createGifFromVideo("concatVideosLocation", 20, 1, 300, "gifTest");
  }
  
  public String concatVideos(final String ffmegPlaylist) {
    try {
      String cmd = (("ffmpeg -auto_convert 1 -f concat -safe 0 -i " + ffmegPlaylist) + " -codec copy -y /home/paul/Vidéos/idm/gification/concat_playlist.mp4");
      InputOutput.<String>println(cmd);
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
}
