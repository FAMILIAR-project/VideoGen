package videogen

import PlaylistRoot.MediaFile
import PlaylistRoot.Playlist
import PlaylistRoot.PlaylistRootFactory
import java.io.File
import java.io.InputStream
import java.io.PrintWriter
import java.util.HashMap
import java.util.Random
import java.util.Scanner
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
	
	@Test
	def testQ1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("foo1.txt"))
		pw.println("#Ceci est un commentaire")
					
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				pw.println("file " + desc.location);
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var coin = new Random().nextInt(1)
				if(coin == 1) pw.println("file " + desc.location)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var coin = new Random().nextInt(altvid.videodescs.size)
				var desc = altvid.videodescs.get(coin)
				pw.println("file " + desc.location)
			}
		]
		pw.close();
	}
	
	@Test
	def testQ3() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
					
		//Creation d une instance de Playlist
		val playlist = videogen2playlist(videoGen)
		val strPlaylist = playlist2text(playlist)
		val pw = new PrintWriter(new File("foo1.m3u"))
		pw.println(strPlaylist)
		pw.close();
	}
	//Q3-2, transfo modele to text
	def playlist2text(Playlist playlist) {
		var text = ""
		for (MediaFile f : playlist.videos){
			text += f.path +"\n"
		}
		text
	}
	//Q3-1, transformation model to model
	def videogen2playlist(VideoGeneratorModel videoGen) {
		val playList = PlaylistRootFactory.eINSTANCE.createPlaylist
		val listVideos = playList.videos
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val video = (videoseq as MandatoryVideoSeq)
				val mediaFile = PlaylistRootFactory.eINSTANCE.createMediaFile
				mediaFile.name = video.description.videoid
				mediaFile.path = video.description.location
				listVideos.add(mediaFile)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val video = (videoseq as OptionalVideoSeq)
				var coin = new Random().nextInt(1)
				if(coin == 1) {
					val mediaFile = PlaylistRootFactory.eINSTANCE.createMediaFile
					mediaFile.name = video.description.videoid
					mediaFile.path = video.description.location
					listVideos.add(mediaFile)
					}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var coin = new Random().nextInt(altvid.videodescs.size)
				var video = altvid.videodescs.get(coin)
				val mediaFile = PlaylistRootFactory.eINSTANCE.createMediaFile
				mediaFile.name = video.videoid
				mediaFile.path = video.location
				listVideos.add(mediaFile)
			}
		]
		playList
	}
	
	@Test
	def testQ4() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("foo2.txt"))
		pw.println("#Ceci est un commentaire")
					
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				pw.println("file '" + desc.location + "'");
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var coin = new Random().nextInt(1)
				if(coin == 1) pw.println("file '" + desc.location + "'")
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var coin = new Random().nextInt(altvid.videodescs.size)
				var desc = altvid.videodescs.get(coin)
				pw.println("file '" + desc.location + "'")
			}
		]
		pw.close();

	}
	
	@Test
	def testQ7() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("foo2.txt"))
		pw.println("#Ceci est un commentaire")
					
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				pw.println("file '" + desc.location + "'");
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var coin = new Random().nextInt(1)
				if(coin == 1) pw.println("file '" + desc.location + "'")
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var coin = new Random().nextInt(altvid.videodescs.size)
				var desc = altvid.videodescs.get(coin)
				pw.println("file '" + desc.location + "'")
			}
		]
		pw.close();

	}
		
	//Question 8
	def getDuration(String path){
		var command = ""
		var process = Runtime.runtime.exec(command)
		process.waitFor()
		val str = convertStreamToString(process.inputStream);
		Double::parseDouble(str.trim);
	}
	
	def static String convertStreamToString(InputStream is){
		val scanner = new Scanner(is).useDelimiter("\\A");
		if(scanner.hasNext()) {scanner.next;}
		else "";	
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