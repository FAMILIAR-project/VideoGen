package videogen;

import java.io.IOException;

public class Toto {
	
	 

	public void toto(String location, String name) throws InterruptedException, IOException{
		String command = "ffmpeg -y -i " + "./" + location + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 " + name + ".png";
		Process p = Runtime.getRuntime().exec(command);
		p.waitFor();
		
	}

}
