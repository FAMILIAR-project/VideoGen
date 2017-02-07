package videogen;

import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;
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
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field mediaFile is undefined for the type Playlist"
      + "\ntext cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\ntext cannot be resolved"
      + "\nduration cannot be resolved"
      + "\nvideoid cannot be resolved"
      + "\nlocation cannot be resolved"
      + "\n+ cannot be resolved");
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
