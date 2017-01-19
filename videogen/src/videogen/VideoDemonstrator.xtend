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
import java.util.Random
import java.io.PrintWriter

import playlist.model.playlist.playlist.PlaylistFactory
import playlist.model.playlist.playlist.Playlist

import java.util.Scanner
import java.io.InputStream
import java.io.FileWriter
import java.io.File

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

	// @Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val writer = new PrintWriter("/home/salma/workspaceVideoGen/VideoGen/videogen/src/videogen/resultat.txt")
		writer.write("#MyPlaylist \n")
		
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				
				val loc = desc.location
				writer.write("file '" + loc + "'\n")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description

				val random = new Random().nextInt(1)
				println("random1 " + random)
				val loc = desc.location
				if (random == 1)
					writer.write("file '" + loc + "'\n")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				val j = new Random().nextInt(altvid.videodescs.size)
				println("random2 " + j)
				val vid = altvid.videodescs.get(j)

				writer.write("file '" + vid.location + "'\n")

			}

		]

		writer.close()
	
	}
	
	

	// Q3-1
	//@Test
	def createPlaylist() {

		val playlist = PlaylistFactory.eINSTANCE.createPlaylist;

		var videoGen = loadVideoGenerator(URI.createURI("foo4.videogen"))

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				var vid = PlaylistFactory.eINSTANCE.createVideoFile()
				vid.location = desc.location
				playlist.contains.add(vid)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val proba = new Random().nextInt(1)

				if (proba == 1) {
					var vid = PlaylistFactory.eINSTANCE.createVideoFile()
					vid.location = desc.location
					playlist.contains.add(vid)
				}
			} else {

				val altvid = (videoseq as AlternativeVideoSeq)

				var proba = new Random().nextInt(altvid.videodescs.size)
				val vidChoisi = altvid.videodescs.get(proba)
				var vid = PlaylistFactory.eINSTANCE.createVideoFile()
				vid.location = vidChoisi.location
				playlist.contains.add(vid)
			}

		]
    	
    	createFileFfmpeg(playlist)
    	createFileM3U(playlist)
    
	}

	// Q4-Q8
	def convertPlaylistIntoFormat(Playlist playlist, String format) {
		var str = ""
		if (format.equals("M3U")) {
			val videos = playlist.contains
			for (v : videos) {
				str = v.location + "\n"
			}
		} else if (format.equals("M3U extended")) {
			val videos = playlist.contains
			str = "#EXTM3U \n"
			for (v : videos) {

				str += "#EXT-X-DISCONTINUITY" + " \n" + " #EXTINF :" + v.duration + "\n" + v.location + "\n"
			}

			str += "#EXT-X-ENDLIST"

		}

		str
	}

	// Q3-2
	def createFileM3U(Playlist playlist) {

		val writer = new PrintWriter("resultM3U.m3u")
		for (video : playlist.contains)
			writer.write(video.location + "\n")

		writer.close()
	}

	// Q4
	def createFileFfmpeg(Playlist playlist) {

		val writer = new PrintWriter("resultFfmpeg.txt")
		for (video : playlist.contains)
			writer.write("file '" + video.location + "'\n")

		writer.close()
	}

	// Q7
	// @Test
	def addDurationToPlaylist() {

		val playlist = PlaylistFactory.eINSTANCE.createPlaylist;

		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				val duration = calculDuration(desc.location)
				var vid = PlaylistFactory.eINSTANCE.createVideoFile()
				vid.location = desc.location
				vid.duration = duration as int
				playlist.contains.add(vid)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description

				val duration = calculDuration(desc.location)

				val proba = new Random().nextInt(1)

				if (proba == 1) {
					var vid = PlaylistFactory.eINSTANCE.createVideoFile()
					vid.location = desc.location
					vid.duration = duration as int
					playlist.contains.add(vid)
				}
			} else {

				val altvid = (videoseq as AlternativeVideoSeq)

				for (vdesc : altvid.videodescs) {
					val duration = calculDuration(vdesc.location)
					vdesc.duration = duration as int
				}

				var proba = new Random().nextInt(altvid.videodescs.size)
				val vidChoisi = altvid.videodescs.get(proba)
				var vid = PlaylistFactory.eINSTANCE.createVideoFile()
				vid.location = vidChoisi.location
				playlist.contains.add(vid)
			}

		]

	}

	def calculDuration(
		String videoLocation) {

		var cmd = "/usr/local/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " +
			videoLocation

		var process = Runtime.getRuntime().exec(cmd)
		process.waitFor()
		val str = convertStreamToString(process.inputStream)
		Double::parseDouble(str.trim())
	}

	def static String convertStreamToString(InputStream is) {
		val scanner = new Scanner(is).useDelimiter("\\A")
		if (scanner.hasNext())
			scanner.next()
		else
			""
	}

	// Q9
	def playlistVignette(Playlist playlist) {

		for (video : playlist.contains) {

			createVignette(video.location)

		}

	}

	def createVignette(String location) {
		var cmd = "ffmpeg -i " + location + " -f image2 -ss 5 -vframes 1 -s 160x120 " + location + ".jpg"
		var process = Runtime.runtime.exec(cmd)

	// process.waitFor()
	// val str = convertStreamToString(process.inputStream)
	// Double::parseDouble(str.trim())
	}

	// Q10
	@Test
	def void printToHTML() {
		var videoGen = loadVideoGenerator(URI.createURI("foo4.videogen"))

		println("<html>")

		val writer = new PrintWriter("result.html")
		writer.write("<html> <body bgcolor=black> <ul>")
		writer.write("<font color=\"blue\" size=\"6\"><center>VideoGen</font>")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				
				createVignette(desc.location)

				println("<p>" + "<img src=\"" + desc.location + ".jpg\">" + "</p>")
				
				writer.write("<p>" + "<img src=\"" + desc.location + ".jpg\">" + "</p>")
				
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				createVignette(desc.location)
				println("<p>" + "<img src=\"" + desc.location + ".jpg\">" + "</p>")
				writer.write("<p>" + "<img src=\"" + desc.location + ".jpg\">" + "</p>")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				if (altvid.videodescs.size > 0) 
					println("<div>")
					writer.write("<div>")
				for (vdesc : altvid.videodescs) {
					
					createVignette(vdesc.location)
					println("<img src=\"" + vdesc.location + ".jpg\">" + "</li>")
					writer.write("<img src=\"" + vdesc.location + ".jpg\">" + "</li>")
				}
				if (altvid.videodescs.size > 0) 
					println("</div>")
				writer.write("</div>")
			}
		]
		println("</body></html>")
		writer.write("</body> </html>")
		writer.close()

	}

	// sup1
	def void automaticSpec(String script, String folder, String outputFile) {
		var cmd = "bash " + script + " " + folder + " " + outputFile
		println(cmd)
		Runtime.getRuntime().exec(cmd)
	}
	
	@Test
	def void testSup1(){
		//automaticSpec("script.sh", "myPlaylist",
		//	"outputScript.txt")
		gification("script2.sh", URI.createURI("v1.mp4"), "video.gif" )
		textOnVideo("v1")
	}
	
	//Gification
	def gification(String script, URI video, String output ){
		var cmd = "bash " + script + " " + video+ " " + output
	
		println(cmd)
		Runtime.getRuntime().exec(cmd)
		
	}
	
	def textOnVideo(String text){
		
		var cmd= "ffmpeg -i v1.mp4 -vf drawtext=\"fontfile=/path/to/font.ttf: \\
text="+text+": fontcolor=white: fontsize=24: box=1: boxcolor=black@0.5: \\
boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/2\" -codec:a copy output.mp4"
println(cmd)
Runtime.getRuntime().exec(cmd)
	}

//	static var i = 0;
//	def genID() {
//		"v" + i++
//	]
}
