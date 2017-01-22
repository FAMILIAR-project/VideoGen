package videogen

import java.io.File
import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Assert
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
		val commandExec = Utils.commandExec(command)
		println("output : \n" + commandExec)
 	}

	@Test
	def void testRandomGenerationVideo(){
		val fileName = FFMPEGHelper.randomGenerationVideo(5);
		Assert.assertTrue(new File(fileName).exists)
		val commandExec = Utils.commandExec(#['ls'])
		Assert.assertTrue(commandExec.contains(fileName))

		new File(fileName).delete
 	}

 	@Test
	def void testComputeGif(){
		val d = 2
		val fileName = FFMPEGHelper.randomGenerationVideo(d);
		Assert.assertTrue(new File(fileName).exists)
		val gifPath = FFMPEGHelper.generateGif(fileName)
		Assert.assertTrue(new File(gifPath).exists)

		new File(fileName).delete
		new File(gifPath).delete
 	}

 	@Test
	def void testComputeDuration(){
		val d = 5
		val fileName = FFMPEGHelper.randomGenerationVideo(d);
		Assert.assertTrue(new File(fileName).exists)
		val duration = FFMPEGHelper.computeDuration(fileName);
		Assert.assertEquals(d,duration);

		new File(fileName).delete
 	}

	@Test
	def void testThumbnailGen() {
		var path = FFMPEGHelper.randomGenerationVideo(5);
		println(path);
		val imgPath = FFMPEGHelper.generateThumbnail(path)
		Assert.assertTrue(new File(imgPath).exists);

		new File(path).delete
		new File(imgPath).delete
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
	def void testQ7() {
		RandomVideoGeneratorSwitch.main(#[]);

		val createURI = URI.createURI("foo2_avi_only.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		Q7VideoDurationSetterSwitch.assignDuration(videoGen)
		saveVideoGenerator(URI.createURI("foo2_avi_only_with_duration.videogen"), videoGen)

	}

	@Test
	def void testQ8() {
		RandomVideoGeneratorSwitch.main(#[]);

		val createURI = URI.createURI("foo2_avi_only.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		Q7VideoDurationSetterSwitch.assignDuration(videoGen)
		val xm3uText = Q8ModelToXM3USwitch.modelToXM3U(videoGen)
		println(xm3uText)

	}

	@Test
	def void testQ9 () {

		RandomVideoGeneratorSwitch.main(#[]);

		val createURI = URI.createURI("foo2_avi_only.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		Q9GenerateTBSwitch.generateThumbnails(videoGen)
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