package videogen;


import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Command {
	
	 

	public void vignette(String location, String name) throws InterruptedException, IOException{
		String commandVignette = "ffmpeg -y -i " + "./" + location + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 " + name + ".png";
		Process p = Runtime.getRuntime().exec(commandVignette);
		p.waitFor();
		
	}
	
	public void gif(String location, String name) throws IOException, InterruptedException{
		String commandGif = "ffmpeg -i " + location +" "+ name + ".gif";
		Process p = Runtime.getRuntime().exec(commandGif);
		p.waitFor();
		
	}
	
	public void text(String location, String name, String sometext) throws IOException, InterruptedException{
		File f = new File(location);
		String path = f.getAbsolutePath();
		String commandText = "ffmpeg -i "+path+" -vf drawtext=text='"+sometext+"':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=10:y=10 -codec:a copy "+path+name+"test.mp4";
		//String commandText = "ffmpeg -i "+path+" -vf drawtext=fontfile=/path/to/font.ttf:text=\'"+ sometext
		//	    +"\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:y=(h-text_h)/2 -codec:a copy "+path+name+"tds.mp4";
		System.out.println(commandText);
		Process p = Runtime.getRuntime().exec(commandText);
		p.waitFor();
		System.out.println(p.exitValue());
	}
	
	public void filter(String location, String name) throws IOException, InterruptedException{
		
		
		String commandFilter = "ffmpeg -i " + location +" -vf hue=s=0 -c:a copy "+ name + ".mp4";
		Process p = Runtime.getRuntime().exec(commandFilter);
		p.waitFor();
		
	}

}
