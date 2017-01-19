package videogen

import java.io.FileWriter

class Operations {
	def static writeToFile(String filename, String content) {
		val writer = new FileWriter(filename)
		writer.write(content)
		writer.flush()
		writer.close()
	}

	def static void execCommandFFmpeg(String path, String name) {
		// var command = "ffmpeg -y -i " + path + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f " + "resource" + name + ".png"
		var command = "ffmpeg -i " + path + " -vcodec mjpeg -vframes 1 -an -f rawvideo -s 640x360 -ss 3 " + name +
			".jpg"
		// println(command)
		var p = Runtime.runtime.exec(command)
		p.waitFor
	}
}
