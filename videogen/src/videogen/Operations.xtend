package videogen

import java.io.BufferedReader
import java.io.FileWriter
import java.io.InputStreamReader
import java.util.Scanner

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
			".j+pg"
		// println(command)
		var p = Runtime.runtime.exec(command)
		p.waitFor
	}

	def static String commandFFmpegToGenerateDuration(String path) {
		var command = "ffprobe -i " + path + " -show_entries format=duration -v quiet -sexagesimal -of csv=p=0"
		var p = Runtime.runtime.exec(command)
		p.waitFor
		var str = new Scanner(p.inputStream)
		if (str.hasNext())
			return str.next().trim
	}

	def static void commandIncrustText(String path, String text) {
		val String [] str = path.split("/")
		val folder = str.get(0)
		var name = str.get(1).split("\\.").get(0)

		var command = "ffmpeg -i " + path + " -vf drawtext=fontfile=/path/to/font.ttf:text=\'" + text +
			"\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=(w-text_w)/2:y=(h-text_h)/2 -codec:a copy " +
			folder + "/" + name + "Incr.mp4"

		var p = Runtime.runtime.exec(command)
		p.waitFor
	}

	def void commandIncrustText(String path, String text, int x, int y) {
		val String [] str = path.split("/")
		val folder = str.get(0)
		var name = str.get(1).split("\\.").get(0)
		// check if x and y > 0
		if (x > 0 && y > 0) {
			var command = "ffmpeg -i " + path + " -vf drawtext=fontfile=/path/to/font.ttf:text=\'" + text +
				"\':fontcolor=white:fontsize=24:box=1:boxcolor=black@0.5:boxborderw=5:x=" + x + "/2:y=" + y +
				" -codec:a copy " + folder + "/" + name + "IncwithPos.mp4"

			var p = Runtime.runtime.exec(command)
			p.waitFor
		}
	}

	// just this filter
	def static void commandFilterBlackAndWhite(String path) {
		val String [] str = path.split("/")
		val folder = str.get(0)
		var name = str.get(1).split("\\.").get(0)
		var command = "ffmpeg -i " + path + " -vf hue=s=0 -c:a copy " + folder + "/" + name + "Filter.mp4"

		var p = Runtime.runtime.exec(command)
		p.waitFor
	}

	def static BufferedReader getOutput(Process p) {
		var inputStreamReader = new InputStreamReader(p.getInputStream())
		new BufferedReader(inputStreamReader)
	}

	def static void displayBuffer(BufferedReader buf) {
		var ligne = ""
		println(buf.lines.count)
		while ((ligne = buf.readLine()) != null) {
			println(ligne);
		}
	}
}
