package videogen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FfmpegHelper {

	public int getDuration(String path) throws InterruptedException, IOException{
		double duration = 0 ;
		
		String cmd = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i /home/simon/Documents/VIDEO/" + path; 
		Process process = Runtime.getRuntime().exec(cmd);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null)
		    duration =  Double.parseDouble(line);
		process.waitFor();
		
		return (int)duration;
	}
}
