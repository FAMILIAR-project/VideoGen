package videogen.vignette

class FFMPEGHelper {
	def generateThumbnail(String location, String name) {
		execCmd(location, name)
	}
	
	def execCmd(String location, String name) {
		var command = "ffmpeg -y -i " + "./" + location + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f image2 " + name + ".png"
		var p = Runtime.runtime.exec(command)
        p.waitFor
	}
}