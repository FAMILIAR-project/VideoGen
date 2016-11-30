package videogen

import java.util.HashMap
import java.io.PrintWriter
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
import java.util.Random
import playlist.Playlist
import playlist.impl.PlaylistImpl
import playlist.impl.PlaylistFactoryImpl
import playlist.Comment
import playlist.File

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
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
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
	}

	@Test
	def Playlist toPlaylist() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val fact = PlaylistFactoryImpl.eINSTANCE
		val playlist = PlaylistFactoryImpl.eINSTANCE.createPlaylist as Playlist
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		val file = new PrintWriter("out.ffmpeg", "UTF-8")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val video = fact.createFile
				video.path = (videoseq as MandatoryVideoSeq).description.location
				playlist.content.add(video)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if ((new Random()).nextDouble() < (desc.probability / 100 as double)) {
					val video = fact.createFile
					video.path = desc.location
					playlist.content.add(video)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var res = ""
				var tmp = 0 as double
				var min = 0 as double
				for (vdesc : altvid.videodescs) {
					tmp = (new Random()).nextDouble()
					if (tmp > min) {
						min = tmp
						res = vdesc.location
					}
				}
				val video = fact.createFile
				video.path = res
				playlist.content.add(video)
			}
		]
		// serializing
		file.close()
		return playlist
	}

	@Test
	def ffmpeg() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		val file = new PrintWriter("out.ffmpeg", "UTF-8")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				file.println("file '" + (videoseq as MandatoryVideoSeq).description.location + "'")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if ((new Random()).nextDouble() < (desc.probability / 100 as double))
					file.println("file '" + desc.location + "'")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var res = ""
				var tmp = 0 as double
				var min = 0 as double
				for (vdesc : altvid.videodescs) {
					tmp = (new Random()).nextDouble()
					if (tmp > min) {
						min = tmp
						res = ("file '" + vdesc.location + "'")
					}
				}
				file.println(res)
			}
		]
		// serializing
		file.close()
	}

	@Test
	def playlistToM3U(Playlist playlist) {
		assertNotNull(playlist)	
		val file = new 	PrintWriter("out.m3u", "UTF-8")
		playlist.content.forEach[entry | 
			if (entry instanceof Comment) {
				file.println("#"+(entry as Comment).content)				
			}
			else if (entry instanceof File) {
				file.println((entry as File).path)
			}
		]
	// serializing
	file.close()
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

	static var i = 0;

	def genID() {
		"v" + i++
	}

}
