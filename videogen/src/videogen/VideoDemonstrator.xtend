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
import java.util.LinkedList
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.util.List
import java.util.Random
import org.tritcorp.playlist.model.Playlist.*
import org.tritcorp.playlist.model.Playlist.impl.*
import java.io.FileWriter
import java.io.InputStream
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Arrays
import java.io.IOException

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

	def concatFFMPEG() {
		var runtime = Runtime.getRuntime()
		val res = runtime.exec("ffmpeg.exe -f concat -i out.ffmpeg -c copy output.mp4")
		System.out.println(res)

	}

	def playlistToM3U(Playlist playlist) {
		val fw = new FileWriter("out.m3u");
		playlist.getFiles().forEach [ file |
			fw.write(file.getPath() + "\n")
		]
		fw.close()

	}

	def playlistToFFMPEG(Playlist playlist) {
		val fw = new FileWriter("out.ffmpeg");
		playlist.getFiles().forEach [ file |
			fw.write("file '" + file.getPath() + "'\n")
		]
		fw.close()
		concatFFMPEG()
	}

	def Playlist testM2M() {

		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2bis.videogen"))
		assertNotNull(videoGen)
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		// model2model
		val plf = PlaylistFactoryImpl.init()
		val pl = plf.createPlaylist()
		// Instancier modele PLaylist
		// iterate over videogen model
		videoGen.videoseqs.forEach [ videoseq |
			val rand = new Random()
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.location.isNullOrEmpty) {
					var mf = plf.createMediaFile()
					mf.setPath(desc.location)
					pl.getFiles.add(mf)
				}

			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val p = desc.probability
				val res = rand.nextInt(100)
				if (p > 0) {
					if (!desc.location.isNullOrEmpty && res <= p) {
						var mf = plf.createMediaFile()
						mf.setPath(desc.location)
						pl.getFiles.add(mf)
					}

				} else if (!desc.location.isNullOrEmpty && res <= 50) {
					var mf = plf.createMediaFile()
					mf.setPath(desc.location)
					pl.getFiles.add(mf)
				}

			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val l = altvid.getVideodescs()
				val r = l.length

				var boolean found = false
				var pr = 0
				for (vdesc : altvid.videodescs) {
					if (vdesc.probability > 0)
						pr = vdesc.probability
				}
				var i = 0
				if (pr == 0) {
					do {
						i = 0
						for (vdesc : altvid.videodescs) {
							if (!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(r) % r
								if (p == i && ! found) {
									var mf = plf.createMediaFile()
									mf.setPath(vdesc.location)
									pl.getFiles.add(mf)
									found = true
								}
								i++
							}
						}
					} while (! found)
				} else {
					do {
						i = 0
						for (vdesc : altvid.videodescs) {
							if (!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(100)
								if (p <= pr && ! found) {
									var mf = plf.createMediaFile()
									mf.setPath(vdesc.location)
									pl.getFiles.add(mf)
									found = true
								}
								i++
							}
						}
					} while (! found)
				}
			}
		]

		return pl
	}

	def Playlist videogenToPlaylistFull(String file) {

		// loading
		var videoGen = loadVideoGenerator(URI.createURI(file))
		assertNotNull(videoGen)
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		// model2model
		val plf = PlaylistFactoryImpl.init()
		val pl = plf.createPlaylist()
		// Instancier modele PLaylist
		// iterate over videogen model
		videoGen.videoseqs.forEach [ videoseq |
			val rand = new Random()
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.location.isNullOrEmpty) {
					var mf = plf.createMediaFile()
					mf.setPath(desc.location)
					pl.getFiles.add(mf)
				}

			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.location.isNullOrEmpty) {
					var mf = plf.createMediaFile()
					mf.setPath(desc.location)
					pl.getFiles.add(mf)
				}

			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val l = altvid.getVideodescs()

				for (vdesc : altvid.videodescs) {
					if (!vdesc.location.isNullOrEmpty) {
						var mf = plf.createMediaFile()
						mf.setPath(vdesc.location)
						pl.getFiles.add(mf)
					}

				}

			}

		]

		return pl
	}

	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2bis.videogen"))
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
			}
		]
		// serializing
		saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)

		// printToHTML(videoGen)
		val videoGen1 = loadVideoGenerator(URI.createURI("foo2bis.videogen"))
		// printVideoList(videoGen1)
		val playlist = testM2M()

		println("M3U")
		playlistToM3U(playlist)
		println("\nFFMPEG")
		playlistToFFMPEG(playlist)
	}

	def void printVideoList(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach [ videoseq |
			val rand = new Random()
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.location.isNullOrEmpty)
					println("file '" + desc.location + "'")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val p = desc.probability
				val res = rand.nextInt(100)
				if (p > 0) {
					if (!desc.location.isNullOrEmpty && res <= p)
						println("file '" + desc.location + "'")
				} else if (!desc.location.isNullOrEmpty && res <= 50)
					println("file '" + desc.location + "'")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val l = altvid.getVideodescs()
				val r = l.length

				var boolean found = false
				var pr = 0
				for (vdesc : altvid.videodescs) {
					if (vdesc.probability > 0)
						pr = vdesc.probability
				}
				var i = 0
				if (pr == 0) {
					do {
						i = 0
						for (vdesc : altvid.videodescs) {
							if (!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(r) % r
								if (p == i && ! found) {
									println("file '" + vdesc.location + "'")
									found = true
								}
								i++
							}
						}
					} while (! found)
				} else {
					do {
						i = 0
						for (vdesc : altvid.videodescs) {
							if (!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(100)
								if (p <= pr && ! found) {
									println("file '" + vdesc.location + "'")
									found = true
								}
								i++
							}
						}
					} while (! found)
				}
			}
		]
	}

	def String printToHTML(VideoGeneratorModel videoGen) {
		val s= new StringBuffer()
		// var numSeq = 1
		s.append("<html>")
		s.append("<h1>Liste des videos disponibles </h1>")
		s.append("<ul>")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty)
					s.append("<h2>Video obligatoire</h2>")
					s.append("<li><img height=\"200\" width=\"160\" src=\""+ desc.location +".jpg"+ "\"/></li>")
			} else if (videoseq instanceof OptionalVideoSeq) {
				s.append("<h2>Video optionnelle</h2>")
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty)
					s.append("<li><img height=\"200\" width=\"160\" src=\""+ desc.location +".jpg"+ "\"/></li>")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty)
					s.append("<li>" + "<h2>Videos alternatives</h2>" + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					s.append("<ul>")
				for (vdesc : altvid.videodescs) {
					if (!vdesc.videoid.isNullOrEmpty)
						s.append("<li><img height=\"200\" width=\"160\" src=\""+ vdesc.location +".jpg"+ "\"/></li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					s.append("</ul>")
			}
		]
		s.append("</ul>")
		s.append("</html>")
		return s.toString()
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}

}
