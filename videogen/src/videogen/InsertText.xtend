package videogen

import org.eclipse.emf.common.util.URI
import org.junit.Test

import static org.junit.Assert.*

class InsertText {
	
	static final int BOTTOM_LEFT = 0
	static final int BOTTOM_RIGHT = 1
	static final int BOTTOM_CENTER = 2
	static final int TOP_LEFT = 3
	static final int TOP_RIGHT = 4
	static final int CENTER = 5
	
	@Test
	def testInsertText() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("videos.videogen"))
		assertNotNull(videoGen)

		// generate playlist
		var playlist = IdmUtil.generatePlaylist(videoGen)
		var m3uString = ""
		
		// loop over playlist
		for(mediaFile: playlist.mediaFile) {
			// create text
			mediaFile.text = IdmUtil.getFilenameWithExtension(mediaFile.location)
			// remplace video with video with text
			mediaFile.location = createVideoWithText(mediaFile.location, mediaFile.text, BOTTOM_LEFT)
			
			// write to file
			// write to file
			m3uString += "#EXT-X-DISCONTINUITY\n"
			m3uString += "#EXTINF:" + mediaFile.duration + ", " + mediaFile.videoid + "\n"
			m3uString += mediaFile.location + "\n\n"
		}
		
		// create file
		IdmUtil.createFile("playlist-files-gen/inserted_text.m3u", m3uString)
	}
	
	/**
	 * Create a video with a text
	 */
	def String createVideoWithText(String videoLocation, String text, int position) {
		var fileLocationWithoutExtension = "/home/paul/Vidéos/idm/inserted_text/" + IdmUtil.getFilenameWithoutExtension(videoLocation)
		
		// exec ffmpeg command		
		var cmd = "ffmpeg -i " + videoLocation + " -vf drawtext='fontsize=15:fontfile=FreeSerif.ttf:text=" + text
		
		// position
		switch(position) {
			case BOTTOM_RIGHT:
				cmd += ":x=(w-text_w):y=(h-text_h)' "
			
			case BOTTOM_CENTER:
				cmd += ":x=(w-text_w)/2:y=(h-text_h)' "
				
			case BOTTOM_LEFT:
				cmd += ":x=0:y=(h-text_h)' "
				
			case TOP_RIGHT:
				cmd += ":x=(w-text_w):y=0' "
			
			case TOP_LEFT:
				cmd += ":x=0:y=0' "
			
			case CENTER:
				cmd += ":x=(w-text_w)/2:y=(h-text_h)/2' "
				
			default:
				cmd += ":x=(w-text_w)/2:y=(h-text_h)' "
		}
		
		cmd += "-codec:a copy -y " + fileLocationWithoutExtension + "_subtitle.mp4"
		
		var result = Runtime.runtime.exec(cmd)
		result.waitFor()
		
		return fileLocationWithoutExtension + "_subtitle.mp4"
	}
}