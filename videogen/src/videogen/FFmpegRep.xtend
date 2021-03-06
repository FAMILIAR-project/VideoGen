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


	// qst 7
	def static void generateDuration(VideoGeneratorModel videoGen) {
		val content = new StringBuffer

		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				// println(desc.location)
				if (!desc.videoid.isNullOrEmpty) {
					var i = Operations.commandFFmpegToGenerateDuration(desc.location)
					content.append(desc.location + "\t")
					content.append(i)
					content.append("\n")
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				// println(desc.location)
				if (!desc.videoid.isNullOrEmpty) {
					var i = Operations.commandFFmpegToGenerateDuration(desc.location)
					content.append(desc.location + "\t")
					content.append(i)
					content.append("\n")
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							// println(vdesc.location)
							var i = Operations.commandFFmpegToGenerateDuration(vdesc.location)
							content.append(vdesc.location + "\t")
							content.append(i)
							content.append("\n")

						}
					}
				}
			}
		}
		Operations.writeToFile("videosDuration.txt", content.toString)
	}

	// qst 9
	def static void generateThumbnail(VideoGeneratorModel videoGen) {

		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				// println(desc.location)
				if (!desc.videoid.isNullOrEmpty) {
					Operations.commandFFmpegToGenerateImage(desc.location, desc.location)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				// println(desc.location)
				if (!desc.videoid.isNullOrEmpty) {
					Operations.commandFFmpegToGenerateImage(desc.location, desc.location)

				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							// println(vdesc.location)
							Operations.commandFFmpegToGenerateImage(vdesc.location, vdesc.location)
						}
					}
				}
			}
		}
	}

	// qst 10
	def static void generateWebPage(VideoGeneratorModel videoGen) {
		val contentMondatory = new StringBuffer
		val contentOptionals = new StringBuffer
		val contentAlt = new StringBuffer
		contentMondatory.append(
			" <div style=\"display:inline-block; vertical-align:top;\" ><h3>Mondatory : </h3><ul></br>")
		contentOptionals.append(
			"<div style=\"display:inline-block; vertical-align:top; \"><h3>Optionals : </h3><ul></br>")
		contentAlt.append("<div style=\"display:inline-block; vertical-align:top;\"><h3>Alternatives : </h3><ul></br>")
		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					contentMondatory.append(
						"<li><img src=\"" + desc.location + ".jpg\" width= \"200\" height=\"200\" alt=\"" +
							desc.location + "\"/></li>")
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					contentOptionals.append(
						"<li><img src=\"" + desc.location + ".jpg\" width= \"200\" height=\"200\"  alt=\"" +
							desc.location + "\"/></li>")
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							contentAlt.append(
								"<li><img src=\"" + vdesc.location + ".jpg\" width= \"200\" height=\"200\"  alt=\"" +
									vdesc.location + "\"/></li>")
						}
					}
				}
			}
		}
		contentMondatory.append("</ul></div>")
		contentOptionals.append("</ul></div>")
		contentAlt.append("</ul></div>")
		var content = contentMondatory.toString + contentOptionals.toString + contentAlt.toString
		Operations.writeToFile("webPage.html", content)
	}

	// text incrust
	def static void textIncrust(VideoGeneratorModel videoGen) {
		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					Operations.commandIncrustText(desc.location, desc.textIncrust)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					Operations.commandIncrustText(desc.location, desc.textIncrust)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							Operations.commandIncrustText(vdesc.location, vdesc.textIncrust)
						}
					}
				}
			}
		}
		println("sdsdsdsd")
	}

	// filter
	def static void blackAndWhiteFilter(VideoGeneratorModel videoGen) {
		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					Operations.commandFilterBlackAndWhite(desc.location)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					Operations.commandFilterBlackAndWhite(desc.location)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty) {
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							Operations.commandFilterBlackAndWhite(vdesc.location)
						}
					}
				}
			}
		}
		println("sdsdsdsd")
	}

	def static void main(String[] args) {
		// var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		var videoGen = loadVideoGenerator(URI.createURI("videos.videogen"))
//		playlistToFFMPEG(videoToPlaylist(videoGen))
//		generateThumbnail(videoGen)
//		generateWebPage(videoGen)
		generateDuration(videoGen)
//		blackAndWhiteFilter(videoGen)
	// textIncrust(videoGen)
	// printToHTML(videoGen)
	}
}
