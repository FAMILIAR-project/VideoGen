package videogen

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.HashMap
import java.util.Random
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.playlist.Playlist
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.videoGen.impl.VideoSeqImpl

class FFmpegRep {

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

// qst4
	def static playlistToFFMPEG(Playlist playlist) {
		val content = new StringBuffer
		playlist.videos.forEach [ video |
			content.append('file \'' + video.path + "\'\n")
		]

		Operations.writeToFile("ffmpeg", content.toString)
		println(content)
		content.toString
	}

	def static void generateThumbnail(VideoGeneratorModel videoGen) {

		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				// println(desc.location)
				if (!desc.videoid.isNullOrEmpty) {
					Operations.execCommandFFmpeg(desc.location, desc.videoid)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				// println(desc.location)
				if (!desc.videoid.isNullOrEmpty) {
					Operations.execCommandFFmpeg(desc.location, desc.videoid)

				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							// println(vdesc.location)
							Operations.execCommandFFmpeg(vdesc.location, vdesc.videoid)
						}
					}
				}
			}
		}
	}

	def static void main(String[] args) {
		// var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		var videoGen = loadVideoGenerator(URI.createURI("videos.videogen"))
//		playlistToFFMPEG(videoToPlaylist(videoGen))
		generateThumbnail(videoGen)
	// printToHTML(videoGen)
	}
}
