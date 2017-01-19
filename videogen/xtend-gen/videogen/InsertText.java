package videogen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;
import playlist.MediaFile;
import playlist.Playlist;
import videogen.IdmUtil;

@SuppressWarnings("all")
public class InsertText {
  private final static int BOTTOM_LEFT = 0;
  
  private final static int BOTTOM_RIGHT = 1;
  
  private final static int BOTTOM_CENTER = 2;
  
  private final static int TOP_LEFT = 3;
  
  private final static int TOP_RIGHT = 4;
  
  private final static int CENTER = 5;
  
  @Test
  public void testInsertText() {
    URI _createURI = URI.createURI("videos.videogen");
    VideoGeneratorModel videoGen = IdmUtil.loadVideoGenerator(_createURI);
    Assert.assertNotNull(videoGen);
    Playlist playlist = IdmUtil.generatePlaylist(videoGen);
    String m3uString = "";
    EList<MediaFile> _mediaFile = playlist.getMediaFile();
    for (final MediaFile mediaFile : _mediaFile) {
      {
        String _location = mediaFile.getLocation();
        String _filenameWithExtension = IdmUtil.getFilenameWithExtension(_location);
        mediaFile.setText(_filenameWithExtension);
        String _location_1 = mediaFile.getLocation();
        String _text = mediaFile.getText();
        String _createVideoWithText = this.createVideoWithText(_location_1, _text, InsertText.BOTTOM_LEFT);
        mediaFile.setLocation(_createVideoWithText);
        String _m3uString = m3uString;
        m3uString = (_m3uString + "#EXT-X-DISCONTINUITY\n");
        String _m3uString_1 = m3uString;
        double _duration = mediaFile.getDuration();
        String _plus = ("#EXTINF:" + Double.valueOf(_duration));
        String _plus_1 = (_plus + ", ");
        String _videoid = mediaFile.getVideoid();
        String _plus_2 = (_plus_1 + _videoid);
        String _plus_3 = (_plus_2 + "\n");
        m3uString = (_m3uString_1 + _plus_3);
        String _m3uString_2 = m3uString;
        String _location_2 = mediaFile.getLocation();
        String _plus_4 = (_location_2 + "\n\n");
        m3uString = (_m3uString_2 + _plus_4);
      }
    }
    IdmUtil.createFile("playlist-files-gen/inserted_text.m3u", m3uString);
  }
  
  /**
   * Create a video with a text
   */
  public String createVideoWithText(final String videoLocation, final String text, final int position) {
    try {
      String _filenameWithoutExtension = IdmUtil.getFilenameWithoutExtension(videoLocation);
      String fileLocationWithoutExtension = ("/home/paul/Vidéos/idm/inserted_text/" + _filenameWithoutExtension);
      String cmd = ((("ffmpeg -i " + videoLocation) + " -vf drawtext=\'fontsize=15:fontfile=FreeSerif.ttf:text=") + text);
      switch (position) {
        case InsertText.BOTTOM_RIGHT:
          String _cmd = cmd;
          cmd = (_cmd + ":x=(w-text_w):y=(h-text_h)\' ");
          break;
        case InsertText.BOTTOM_CENTER:
          String _cmd_1 = cmd;
          cmd = (_cmd_1 + ":x=(w-text_w)/2:y=(h-text_h)\' ");
          break;
        case InsertText.BOTTOM_LEFT:
          String _cmd_2 = cmd;
          cmd = (_cmd_2 + ":x=0:y=(h-text_h)\' ");
          break;
        case InsertText.TOP_RIGHT:
          String _cmd_3 = cmd;
          cmd = (_cmd_3 + ":x=(w-text_w):y=0\' ");
          break;
        case InsertText.TOP_LEFT:
          String _cmd_4 = cmd;
          cmd = (_cmd_4 + ":x=0:y=0\' ");
          break;
        case InsertText.CENTER:
          String _cmd_5 = cmd;
          cmd = (_cmd_5 + ":x=(w-text_w)/2:y=(h-text_h)/2\' ");
          break;
        default:
          String _cmd_6 = cmd;
          cmd = (_cmd_6 + ":x=(w-text_w)/2:y=(h-text_h)\' ");
          break;
      }
      String _cmd_6 = cmd;
      cmd = (_cmd_6 + (("-codec:a copy -y " + fileLocationWithoutExtension) + "_subtitle.mp4"));
      Runtime _runtime = Runtime.getRuntime();
      Process result = _runtime.exec(cmd);
      result.waitFor();
      return (fileLocationWithoutExtension + "_subtitle.mp4");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
