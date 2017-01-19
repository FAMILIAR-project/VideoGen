package videogen

import java.io.FileWriter
import java.io.InputStream
import java.io.BufferedReader
import java.io.InputStreamReader

class Operations {
	def static writeToFile(String filename, String content) {
		val writer = new FileWriter(filename)
		writer.write(content)
		writer.flush()
		writer.close()
	}

	def static void commandFFmpegToGenerateImage(String path, String name) {
		// var command = "ffmpeg -y -i " + path + " -r 1 -t 00:00:01 -ss 00:00:01.000 -f " + "resource" + name + ".png"
		var command = "ffmpeg -i " + path + " -vcodec mjpeg -vframes 1 -an -f rawvideo -s 640x360 -ss 3 " + name +
			".jpg"
		// println(command)
		var p = Runtime.runtime.exec(command)
		p.waitFor
	}

	def static Process commandFFmpegToGenerateDuration(String path) {
		var command = "ffmpeg -i " + path + "-vcodec copy -an -f null -"
		var p = Runtime.runtime.exec(command)
		p.waitFor
		p
	}

	def static BufferedReader getOutput(Process p) {
		var inputStreamReader = new InputStreamReader(p.getInputStream())
		new BufferedReader(inputStreamReader)
	}

	def static void displayBuffer(BufferedReader buf) {
 		var ligne = ""
		while ((ligne = buf.readLine()) != null) {
			println(ligne);
		}
	}
}
