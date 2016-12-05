package videogen;

import java.io.IOException;

public class FfmpegHelper {

	public int getDuration(String path) throws InterruptedException, IOException{
		int duration;
		
		String cmd = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i /home/simon/Documents/VIDEO/" + path; 
		Process process = Runtime.getRuntime().exec(cmd);
		
		return process.waitFor();
	}
}
