package videogen

import com.google.common.collect.Lists
import java.util.HashMap
import java.util.Map
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.Playlist
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

class M3uRep {
	static def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

	// qst 3
	static def Playlist videoToPlaylist(VideoGeneratorModel videoGen) {

		var data = ""
		data += "#this is a comment\n"
		var playList = PlaylistFactory.eINSTANCE.createPlaylist

		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				var vid = PlaylistFactory.eINSTANCE.createvideo
				vid.path = (videoseq as MandatoryVideoSeq).description.location
				vid.duration = (videoseq as MandatoryVideoSeq).description.duration
				vid.description = (videoseq as MandatoryVideoSeq).description.description
				playList.videos.add(vid)

			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.location.isNullOrEmpty) {
					if (new Random().nextInt(2) == 1) {
						var vid = PlaylistFactory.eINSTANCE.createvideo
						vid.path = desc.location
						vid.duration = desc.duration
						vid.description = desc.description
						playList.videos.add(vid)
					}
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					var seq = altvid.videodescs.get(new Random().nextInt(altvid.videodescs.size))
					var vid = PlaylistFactory.eINSTANCE.createvideo
					vid.path = seq.location
					vid.description = seq.description
					vid.duration = seq.duration
					playList.videos.add(vid)
				}
			}
		}
		playList
	}

	// qst3
	def static toM3U(Playlist playlist) {
		toM3U(playlist, false, false, new HashMap)
	}

	def static toM3U(Playlist playlist, Boolean extended) {
		toM3U(playlist, extended, false, new HashMap)
	}

	def static toM3U(Playlist playlist, Boolean extended, Boolean discontinued) {
		toM3U(playlist, extended, false, new HashMap)
	}

	/**
	 * Return a textual representation of a M3U model to text convertion with extended, discontinuited and stream facility
	 * 
	 * Example : 
	 * 		result => http://schworak.com/blog/e41/extended-pls-plsv2/
	 * 		options => {
	 * 						"CODECS": "avc1.66.30,mp4a.40.2",
	 * 						"RESOLUTION": "640x360",
	 * 						"BANDWITH": "684383",
	 * 						...
	 * 					} 
	 * @see https://en.wikipedia.org/wiki/M3U
	 * @see http://schworak.com/blog/e39/m3u-play-list-specification/
	 * @see http://tools.ietf.org/html/draft-pantos-http-live-streaming
	 * 
	 */
	def static toM3U(Playlist playlist, Boolean extended, Boolean discontinued, Map<String, String> options) {
		val content = new StringBuffer
		if (extended) {
			content.append("#EXTM3U" + "\n")
			content.append("#EXT-X-VERSION:3" + "\n")
			content.append("#EXT-X-MEDIA-SEQUENCE:44850" + "\n")
		}
		if (!options.empty) {
			val list = Lists.newArrayList
			options.forEach[key, value|list.add(key + "=" + value)]
			content.append("#EXT-X-STREAM-INF:" + list.join(",") + "\n")
		}
		playlist.videos.forEach [ video |
			if (extended) {
				if (discontinued) {
					content.append("#EXT-X-DISCONTINUITY" + "\n")
				}
				content.append("#EXTINF:" + video.duration + "," + video.description + "\n")
			}
			content.append(video.path + "\n")
		]
		if (extended) {
			content.append("#EXT-X-ENDLIST" + "\n")
		}
		// println(content.toString)
		Operations.writeToFile("m3u.txt", content.toString)
		content.toString
	}

	def static void main(String[] args) {
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		toM3U(videoToPlaylist(videoGen))
	// printToHTML(videoGen)
	}
}
