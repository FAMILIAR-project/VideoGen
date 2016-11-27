package videogen

import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*
import java.util.ArrayList
import java.util.List
import playlist.impl.PlaylistModelImpl
import playlist.impl.PlaylistFactoryImpl
import playlist.PlaylistPackage
import playlist.PlaylistModel
import org.xtext.example.mydsl.videoGen.VideoSeq
import playlist.PlaylistFactory
import org.xtext.example.mydsl.videoGen.VideoDescription
import playlist.VideoMedia
import java.io.IOException
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.File
import java.lang.reflect.Array
import java.io.FileWriter
import java.util.logging.Logger

class VideoDemonstrator {

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("test1.videogen"))
		assertNotNull(videoGen)
		// assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGenTestModel(videoGen)
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability != 100) desc.probability = 100
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability == 0) desc.probability = 50
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				var i = 0
				var empty = 0
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					if(vdesc.probability == 0) empty++
					i += vdesc.probability
				}
				var p = 0
				if(i < 100) p = (100 - i) / empty
				for (vdesc : altvid.videodescs) {
					if(vdesc.probability == 0) vdesc.probability = p
				}
			}
		]
		transformVideoDuration(videoGen)
		generateThumbnail(videoGen)
		generateWebPage(videoGen)
		// serializing
		saveVideoGenerator(URI.createURI("test1.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("test1bis.videogen"), videoGen)

		// printToHTML(videoGen)
		// printToFfmpeg(videoGen)
		val playlist = videoGenToPlaylist(videoGen)
		printToFfmpeg(playlist)
		printToM3U(playlist)
	}

	def void videoGenTestModel(VideoGeneratorModel videoGen) {
		val logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
		checkIds(videoGen, logger)
		videoGenCheckProba(videoGen, logger)
		checkPaths(videoGen, logger)
	}

	def void checkPaths(VideoGeneratorModel videoGen, Logger logger) {
		val alts = <String>newArrayList()
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (alts.contains(desc.location)) {
					logger.warning("Video path error: path '" + desc.location + "' already exists")
				} else {
					alts.add(desc.location)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (alts.contains(desc.location)) {
					logger.warning("Video path error: path '" + desc.location + "' already exists")
				} else {
					alts.add(desc.location)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if (alts.contains(vdesc.location)) {
						logger.warning("Video path error: path '" + vdesc.location + "' already exists")
					} else {
						alts.add(vdesc.location)
					}
				}
			}
		]
	}

	def void checkIds(VideoGeneratorModel videoGen, Logger logger) {
		val alts = <String>newArrayList()
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (desc.videoid != null) {
					if (alts.contains(desc.videoid)) {
						logger.severe("ID error: id " + desc.videoid + " already exists")
					} else {
						alts.add(desc.videoid)
					}
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (desc.videoid != null) {
					if (alts.contains(desc.videoid)) {
						logger.severe("ID error: id " + desc.videoid + " already exists")
					} else {
						alts.add(desc.videoid)
					}
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videoid != null) {
					if (alts.contains(altvid.videoid)) {
						logger.severe("ID error: id " + altvid.videoid + " already exists")
					} else {
						alts.add(altvid.videoid)
					}
				}
				for (vdesc : altvid.videodescs) {
					if (vdesc.videoid != null) {
						if (alts.contains(vdesc.videoid)) {
							logger.severe("ID error: id " + vdesc.videoid + " already exists")
						} else {
							alts.add(vdesc.videoid)
						}
					}
				}
			}
		]
	}

	def void videoGenCheckProba(VideoGeneratorModel videoGen, Logger logger) {
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (desc.probability != 100 && desc.probability != 0)
					logger.warning(
						"Mandatory video: " + getVideoName(desc.location) + " - Probability != 100 (" +
							desc.probability + ") will be overwritten")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (desc.probability > 100) {
					logger.warning(
						"Optional video: " + getVideoName(desc.location) + " - Probability greater than 100 (" +
							desc.probability + ") - video will be pick anyway")
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var sum = 0
				var emptyProba = false
				for (vdesc : altvid.videodescs) {
					if (vdesc.probability > 100) {
						logger.severe(
							"Alternative video: " + getVideoName(vdesc.location) + " - Probability greater than 100 (" +
								vdesc.probability + ")")
						assertTrue(" Alternative video: Proba > 100", sum < vdesc.probability)
					}
					if(vdesc.probability == 0) emptyProba = true
					sum += vdesc.probability
				}

				if (sum > 100) {
					logger.severe(
						"Alternative videos: " + altvid.videoid + " - Probability greater than 100 (" + sum + ")")
					assertTrue(" Alternatives: Proba > 100", sum <= 100)
				}
				if (sum < 100 && !emptyProba) {
					logger.severe("Alternative videos: " + altvid.videoid + " - Proba Sum != 100 (" + sum + ")")
					assertTrue(" Alternatives: Proba lesser than 100", sum != 100)
				}
			}
		]
	}

	static var content = ""

	def void generateWebPage(VideoGeneratorModel videoGen) {
		var page = "<!DOCTYPE html>"
		page += '<html lang="en">'
		page += '<head>'
		page += '<meta charset="UTF-8">'
		page += '<title>VideoGen</title>'
		page += '</head>'
		page += '<body>'
		page += '<div>'
		page += '<ul>'
		videoGen.videoseqs.forEach [ videoseq |
			content += '<li>'
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				createWepPageVideo(desc)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				createWepPageVideo(desc)
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					createWepPageVideo(vdesc)
				}
			}
			content += "</li>"
		]
		page += content
		page += '</ul>'
		page += '</div>'
		page += '</body>'
		val pwd = System.getProperty("user.dir")
		println(pwd)
		val htmlFile = new File(pwd + "\\web\\videogen.html")
		val writer = new FileWriter(htmlFile)
		writer.write(page)
		writer.close()

	}

	def void createWepPageVideo(VideoDescription desc) {
		val name = getVideoName(desc.location)
		content += "<img height='150' width='200' src='../data/thumbnails/" + name + ".png' />"
		content += "<span>" + name + "</span>"
		content += "<span>time: " + desc.duration + "s</span><br>"
	}

	def void generateThumbnail(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				ffmpegThumbail(desc.location)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				ffmpegThumbail(desc.location)
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					ffmpegThumbail(vdesc.location)
				}
			}
		]
	}

	def void ffmpegThumbail(String path) {
		val pwd = System.getProperty("user.dir")
		println(pwd)
		val current = new File(pwd)
		var name = getVideoName(path)
		var cmd2 = "ffmpeg -y -i " + path + " -r 1 -t 00:00:01 -ss 00:00:02 -f image2 data/thumbnails/" + name + ".png"
		try {
			val pb = new ProcessBuilder("CMD", "/C", cmd2)
			pb.directory(current)
			pb.redirectErrorStream(true)
			val p = pb.start();
			p.waitFor()

		} catch (IOException ex) {
			println("error: " + ex)
		}

	}

	def void transformVideoDuration(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				desc.duration = ffmpegDuration(desc.location)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				desc.duration = ffmpegDuration(desc.location)
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					vdesc.duration = ffmpegDuration(vdesc.location)
				}
			}
		]
	}

	def int ffmpegDuration(String path) {
		println(path)
		val pwd = System.getProperty("user.dir")
		println(pwd)
		val current = new File(pwd)
		var cmd = "ffmpeg -i " + path + " 2>&1 | grep "
		cmd += '"Duration"| cut -d '
		cmd += "' ' -f 4 | sed s/,// | sed 's@\\..*@@g' | awk '{ split($1, A, "
		cmd += '":"); split(A[3], B, "."); print 3600*A[1] + 60*A[2] + B[1] }'
		cmd += "'"
		// println(cmd)
		var cmd2 = 'ffmpeg -i ' + path + ' 2>&1 | findstr "Duration"'
		println(cmd2)
		try {
			// val pb = new ProcessBuilder("ffmpeg", "-i", "test.mp4", '"2>&1"', "|", "grep", '"Duration"')
			val pb = new ProcessBuilder("CMD", "/C", cmd2)
			pb.directory(current)
			pb.redirectErrorStream(true);
			println(pb.directory)
			val p = pb.start();
			p.waitFor()
			val is = p.getInputStream();
			val br = new BufferedReader(new InputStreamReader(is));
			var line = br.readLine()
			println(line)
			br.close();
			var i = line.indexOf(",")
			var s = line.substring(0, i)
			var time = s.replace("Duration: ", "")
			time = time.replaceAll("\\s+", "");
			println(time)
			i = time.indexOf(".")
			time = time.substring(0, i)
			println(time)
			val tab = time.split(":").iterator
			var j = 0
			var duration = 0
			while (tab.hasNext) {
				var tmp = tab.next()
				switch (j) {
					case 0: duration += Integer::parseInt(tmp) * 3600
					case 1: duration += Integer::parseInt(tmp) * 60
					case 2: duration += Integer::parseInt(tmp)
				}
				j++
			}
			return duration
		} catch (IOException ex) {
			println("error: " + ex)
			return 0
		}
	}

	def void printToHTML(VideoGeneratorModel videoGen) {
		// var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty)
					println("<li>" + desc.videoid + "</li>")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty)
					println("<li>" + desc.videoid + "</li>")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty)
					println("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("<ul>")
				for (vdesc : altvid.videodescs) {
					if (!vdesc.videoid.isNullOrEmpty)
						println("<li>" + vdesc.videoid + "</li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("</ul>")
			}
		]
		println("</ul>")
	}

	def PlaylistModel videoGenToPlaylist(VideoGeneratorModel videoGen) {
		val factory = PlaylistFactoryImpl.eINSTANCE
		val playlist = factory.createPlaylistModel

		videoGen.videoseqs.forEach [ videoseq |
			var video = factory.createVideoMedia
			if (videoseq instanceof MandatoryVideoSeq) {
				println("Mandatory")
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) addVideoToPlaylist(factory, playlist, desc);
			} else if (videoseq instanceof OptionalVideoSeq) {
				println("Optional")
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					if(randomNumber() <= desc.probability / 100 as double) addVideoToPlaylist(factory, playlist, desc);
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty)
					println("Alternative")
				if (altvid.videodescs.size > 0) {
					// there are vid seq alternatives
					var empty = 0
					val double[] arr = newDoubleArrayOfSize(altvid.videodescs.size)
					val alts = <VideoDescription, Double>newLinkedHashMap()
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							if(vdesc.probability != 0) alts.put(vdesc, vdesc.probability / 100 as double)
						}
					}

					var iterate = 0
					var previous = 0.00
					for (Double d : alts.values) {
						if (d != 0.00) {
							previous += d
							arr.set(iterate, previous)
						}
						println("a: " + previous)
						iterate++
					}

					var x = randomNumber();
					var index = -1
					for (v : 0 ..< arr.size) {
						println("b: " + v + " -- " + arr.get(v))
						if (index == -1 && x < arr.get(v)) {
							addVideoToPlaylist(factory, playlist, alts.keySet().get(v));
							index = 0
						}
					}
				}
			}
		]
		return playlist
	}

	def void printToFfmpeg(PlaylistModel playlist) {
		playlist.media.forEach [ media |
			if (media instanceof VideoMedia) {
				println("file '" + media.location + "'")
			}
		]
	}

	def void printToM3U(PlaylistModel playlist) {
		println("#EXTM3U")
		println("")
		playlist.media.forEach [ media |
			if (media instanceof VideoMedia) {
				println("#EXT-X-DISCONTINUITY")
				println("#EXTINF:" + media.duration + ", " + media.name)
				println(media.location)
			}
			println("")
		]
		println("#EXT-X-ENDLIST")
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}

	def randomNumber() {
		var d = Math.random()
		println("Random: " + d)
		return d
	}

	def addVideoToPlaylist(PlaylistFactory factory, PlaylistModel playlist, VideoDescription desc) {
		val video = factory.createVideoMedia
		video.location = desc.location
		video.duration = desc.duration
		video.name = getVideoName(desc.location)
		playlist.eSetOne(PlaylistPackage.PLAYLIST_MODEL__MEDIA, video)
	}

	def getVideoName(String s) {
		return s.substring(s.lastIndexOf("/") + 1, s.indexOf("."))
	}
}
