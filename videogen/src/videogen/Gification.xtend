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
		}
		
		// create file
		IdmUtil.createFile("/home/paul/Vidéos/idm/gification/ffmpeg_playlist.txt", ffmpegStr)
		
		// concat videos
		var concatVideosLocation = concatVideos("/home/paul/Vidéos/idm/gification/ffmpeg_playlist.txt")
		println("hola")
		// create gif from concat videos
		createGifFromVideo("concatVideosLocation", 20, 1, 300, "gifTest")
	}
	
	def String concatVideos(String ffmegPlaylist) {
		var cmd = "ffmpeg -auto_convert 1 -f concat -safe 0 -i " + ffmegPlaylist + " -codec copy -y /home/paul/Vidéos/idm/gification/concat_playlist.mp4"
		println(cmd)
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
}