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

class VideoDemonstrator {

	def loadVideoGenerator(URI uri) {
		val videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated()
		videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

	@Test
	def void testCommandExec(){
		val String[] command = #['ls']
		println("starting process")
		val commandExec = Utils.commandExec(command)
		println("process done")
		println("output : \n" + commandExec)

 	}

	@Test
	def void testQ1(){
		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		val text = Q1ModelToTextSwitch.modelToText(videoGen)
		println(text)

		Utils.fileWrite("testq1.ffmpeg", text)
 	}

	@Test
	def void testQ3(){
		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		val playlist = Q3ModelToModelSwitch.convertVideogenToPlaylist(videoGen)
		println(playlist)

 	}

 	@Test
	def void testQ3bis(){
		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val playlist = Q3ModelToModelSwitch.convertVideogenToPlaylist(videoGen)

		val playlistText = Q3ModelPlaylistToM3USwitch.modelToText(playlist)
		println(playlistText)

	}

	@Test
	def void test4(){
		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val playlist = Q3ModelToModelSwitch.convertVideogenToPlaylist(videoGen)

		val playlistText = Q4ModelPlaylistToFFMPEG.modelToText(playlist)
		println(playlistText)

	}

	@Test
	def void test1() {
		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty)  desc.videoid = genID()
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
			}
			else {
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

		printToHTML(videoGen)


	}

	def void printToHTML(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)
					println ("<li>" + desc.videoid + "</li>")
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)
					println ("<li>" + desc.videoid + "</li>")
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty)
					println ("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")
				for (vdesc : altvid.videodescs) {
					if(!vdesc.videoid.isNullOrEmpty)
						println ("<li>" + vdesc.videoid + "</li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("</ul>")
			}
		]
		println("</ul>")
	}

	static var i = 0;
	def genID() {
		"v" + i++
	}

}