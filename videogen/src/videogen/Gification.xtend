package videogen

import org.junit.Test
import static org.junit.Assert.*
import org.eclipse.emf.common.util.URI

class Gification {
	
	@Test
	def gification() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("videos.videogen"))
		// check videogen
		IdmUtil.checkVideoGen(videoGen)

		// generate playlist
		var playlist = IdmUtil.generatePlaylist(videoGen)
		var ffmpegStr = ""
		
		// loop over playlist
		for(mediaFile: playlist.mediaFile) {		
			// write to file
			ffmpegStr += "file '" + mediaFile.location + "'\n"
			createGifHDFromVideo(mediaFile.location, 3, 1, 320, IdmUtil.getFilenameWithoutExtension(mediaFile.location))
		}
		
		// create file
		IdmUtil.createFile("/home/paul/Vidéos/idm/gification/ffmpeg_playlist.txt", ffmpegStr)
		
		// concat videos
		var concatVideosLocation = concatVideos("/home/paul/Vidéos/idm/gification/ffmpeg_playlist.txt")
		// create gif from concat videos
		createGifFromVideo(concatVideosLocation, 3, 1, 300, "concat")
	}
	
	def String concatVideos(String ffmegPlaylist) {
		var cmd = "ffmpeg -auto_convert 1 -f concat -safe 0 -i " + ffmegPlaylist + " -codec copy -y /home/paul/Vidéos/idm/gification/concat_playlist.mp4"
		var result = Runtime.runtime.exec(cmd)
		result.waitFor()
		
		return "/home/paul/Vidéos/idm/gification/concat_playlist.mp4"
	}
	
	def void createGifFromVideo(String videoLocation, int duration, int start, int size, String filename) {
		// exec ffmpeg command	
		var cmd = "ffmpeg -v warning -ss " + start + " -t " + duration + " -i " + videoLocation + " -vf scale=" + size + ":-1 -gifflags +transdiff -y /home/paul/Vidéos/idm/gification/" + filename + ".gif"
		var result = Runtime.runtime.exec(cmd)
		result.waitFor()
	}
	
	def void createGifHDFromVideo(String videoLocation, int duration, int start, int size, String filename) {
		// exec ffmpeg command
		var cmd1 = "ffmpeg -v warning -ss " + start + " -t " + duration + " -i " + videoLocation + " -vf scale=" + size + ":-1:flags=lanczos,palettegen -y /home/paul/Vidéos/idm/gification/palette.png"
		var result1 = Runtime.runtime.exec(cmd1)
		result1.waitFor()
		
		var cmd2 = "ffmpeg -ss 0 -t 3 -i " + videoLocation + " -i /home/paul/Vidéos/idm/gification/palette.png -filter_complex \"fps=10,scale=" + size + ":-1:flags=lanczos[x];[x][1:v]paletteuse\" -y /home/paul/Vidéos/idm/gification/" + filename + "HD.gif"
		println(cmd2)
		var result2 = Runtime.runtime.exec(cmd2)
		result2.waitFor()
	}
}














