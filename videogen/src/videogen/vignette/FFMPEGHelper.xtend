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
			println(command)
			var p = Runtime.runtime.exec(command)
			p.waitFor
			println(p.exitValue)
		}
		else if(filter.equals("SEPIA")) {
			var command = "ffmpeg -i " + input + " -filter_complex " + "[0:v]colorchannelmixer=.393:.769:.189:0:.349:.686:.168:0:.272:.534:.131[colorchannelmixed];[colorchannelmixed]eq=1.0:0:1.3:2.4:1.0:1.0:1.0:1.0[color_effect]" + " -map [color_effect] -c:v libx264 -c:a copy " + output
			println(command)
			var p = Runtime.runtime.exec(command)
			p.waitFor
			println(p.exitValue)
		}
	}
}