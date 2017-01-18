package videogen.vignette

import java.io.File

class FFMPEGHelper {
	def generateThumbnail(String location, String name) {
		execCmd(location, name)
	}
	
	def execCmd(String location, String name) {
		var command = "ffmpeg -y -i " + "./" + location + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 " + name + ".png"
		var p = Runtime.runtime.exec(command)
        p.waitFor
	}
	
	def applyFilter(String filter, String input, String output) {
		var file = new File(output);
		if(file.exists) {
			file.delete
		}
		if(filter.equals("BLACK_AND_WHITE")) {
			var command = "ffmpeg -i " + input + " -vf hue=s=0 -c:a copy " + output
			var p = Runtime.runtime.exec(command)
			p.waitFor
		}
		else if(filter.equals("SEPIA")) {
			var command = "ffmpeg -i " + input + " -filter_complex " + "[0:v]colorchannelmixer=.393:.769:.189:0:.349:.686:.168:0:.272:.534:.131[colorchannelmixed];[colorchannelmixed]eq=1.0:0:1.3:2.4:1.0:1.0:1.0:1.0[color_effect]" + " -map [color_effect] -c:v libx264 -c:a copy " + output
			var p = Runtime.runtime.exec(command)
			p.waitFor
		}
	}
	
	def applyTextToVideo(String text, String color, String position, int size, String input, String output) {
		var file = new File(output);
		if(file.exists) {
			file.delete
		}
		var command = ""
		if(position.equals("TOP")) {
			command = "ffmpeg -i " + input + " -vf drawtext=text=" + "'" + text + "'" + ":fontcolor=" + color + ":fontsize=" + size + ":box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:" + "y=10 -codec:a copy " + output		
		}
		else if(position.equals("CENTER")) {
			command = "ffmpeg -i " + input + " -vf drawtext=text=" + "'" + text + "'" + ":fontcolor=" + color + ":fontsize=" + size + ":box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:" + "y=(h-text_h)/2 -codec:a copy " + output
		}
		else if(position.equals("BOTTOM")) {
			command = "ffmpeg -i " + input + " -vf drawtext=text=" + "'" + text + "'" + ":fontcolor=" + color + ":fontsize=" + size + ":box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:" + "y=(h-text_h) -codec:a copy " + output
		}
		var p = Runtime.runtime.exec(command)
		p.waitFor
	}
}