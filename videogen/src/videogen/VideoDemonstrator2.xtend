package videogen

import java.io.BufferedReader
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.PrintWriter
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedHashMap
import java.util.Map
import java.util.Random
import java.util.Scanner
import java.util.logging.Logger
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Assert
import org.junit.Test

import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.VideoSeq
import playlist.Playlist
import playlist.PlaylistFactory

import videogen.vignette.FFMPEGHelper

import org.xtext.example.mydsl.PlaylistStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.PlaylistGeneratorModel
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.playlist.impl.PlaylistFactoryImpl
import org.xtext.example.mydsl.playlist.Mediafile

import static org.junit.Assert.*
<<<<<<< HEAD
import playlist.PlaylistModel
import playlist.impl.PlaylistFactoryImpl
=======
import java.util.ArrayList
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStreamReader
import java.io.BufferedReader
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.util.HashSet
import java.util.Set
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef

class VideoDemonstrator {

	def loadVideoGenerator(URI uri) {
		val videoGenStandaloneSetupGenerated = new VideoGenStandaloneSetupGenerated()
		videoGenStandaloneSetupGenerated.createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
<<<<<<< HEAD
		rs.getContents.add(pollS);
=======
		println(rs);
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	def loadPlaylistGenerator(URI uri) {
		new PlaylistStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as PlaylistGeneratorModel
	}
	
	def savePlaylistGenerator(URI uri, PlaylistGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		println(rs);
		rs.getContents.add(pollS); 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
		rs.save(new HashMap());
	}


	/***
	 * Return all the video to the user
	 */
	def LinkedHashMap<String, String> videoGenToJhipster() {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))
		// generateThumbnail(videoGen)
		val alts = <String, String>newLinkedHashMap()
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				alts.put(getVideoName(desc.location), "mandatory" + desc.videoid)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				alts.put(getVideoName(desc.location), "optional" + desc.videoid)
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					alts.put(getVideoName(vdesc.location), "alternative" + altvid.videoid)
				}
			}
		]
		return alts
	}

	
		/***
	 * Return the video name
	 * @param String s : video path
	 */

	def getVideoName(String s) {
		return s.substring(s.lastIndexOf("/") + 1, s.indexOf("."))
	}
	
	static var i = 0;

	def genID() {
		"v" + i++
	}
	
	

	/***
	 * Set probabilities depending of user's choices (config mode)
	 * if a video is picked by the user => probability = 100%
	 * else probability = 0%
	 *
	 */


	

	

	

	

	/***
	 * Create a GIF composed of the user's playlist video
	 * @param ArrayList<String> choices : user's current playlist
	 */
	def String generateGif(ArrayList<String> choices) {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))
		val alts = <String, Integer>newLinkedHashMap()
		val tmpArray = <String>newArrayList();
		for (String s : choices) {
			val tab0 = s.split("/").iterator
			var lastVal = ""
			while (tab0.hasNext) {
				lastVal = tab0.next()
			}
			if (lastVal.startsWith("tmp-")) {
				val tab = s.split("-").iterator
				var j = 0
				while (tab.hasNext) {
					val p = tab.next()
					if(j == 1) tmpArray.add(p)
					j++
				}
			} else {
				tmpArray.add(getVideoName(s))
			}
		}

		// transformVideoDuration(videoGen)
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (tmpArray.contains(getVideoName(desc.location))) {
					alts.put(desc.location, desc.duration)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (tmpArray.contains(getVideoName(desc.location))) {
					alts.put(desc.location, desc.duration)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if (tmpArray.contains(getVideoName(vdesc.location))) {
						alts.put(vdesc.location, vdesc.duration)
					}
				}
			}
		]
		var nb = tmpArray.size
		var gifDuration = 5.00
		var videoTimePerGif = gifDuration / ((nb as double) + 0.00)
		var tab = <String>newArrayList()
		var pwd = System.getProperty("user.dir")
		val current = new File(pwd)
		for (Map.Entry<String, Integer> entry : alts.entrySet()) {
			var location = entry.getKey();
			var duration = entry.getValue();
			var tmp = duration / 60.00;
			var decimal = (tmp as int);
			var fractional = tmp - ((decimal as double) + 0.00)
			fractional = Math.round(fractional * 60) * 0.01
			var a = (decimal as double) + fractional;

			var d = randomNumberIntervalle(a - (videoTimePerGif * 0.01))
			var deciRandom = (d as int);

			var frac = d - ((deciRandom as double) + 0.00)
			frac = Math.round(frac * 60)
			var sec = frac as int

			var startTime = deciRandom + ":"
			if (sec < 10) {
				startTime += "0" + sec
			} else {
				startTime += sec
			}
			val time = System.currentTimeMillis();
			var name = "src/main/webapp/data/gifs/" + getVideoName(location) + "-" + time + ".ts"
			tab.add(name);
			var cmd = "ffmpeg -ss " + startTime + " -t " + (videoTimePerGif as int) + " -i " + location +
				" -c copy -bsf:v h264_mp4toannexb -f mpegts " + name
			try {
				val pb = new ProcessBuilder("CMD", "/C", cmd)
				pb.directory(current)
				pb.redirectErrorStream(true);
				val p = pb.start();
				p.waitFor()
			} catch (IOException ex) {
				println("error: " + ex)
			}
		}
		val time = System.currentTimeMillis();
		var gifName = "gif-" + time + ".gif"
		var cmd2 = 'ffmpeg -i "concat:';
		for (String s : tab) {
			cmd2 += s + "|";
		}
		cmd2 = cmd2.substring(0, cmd2.length() - 1);
		cmd2 += '" -r 30 src/main/webapp/data/gifs/' + gifName

		try {
			val pb = new ProcessBuilder("CMD", "/C", cmd2)
			pb.directory(current)
			pb.redirectErrorStream(true);
			val p = pb.start();
			p.waitFor()
		} catch (IOException ex) {
			println("error: " + ex)
		}

		for (String s : tab) {
			var tmpFile = new File(s)
			tmpFile.delete()
		}
		return gifName
	}



	

	/***
	 * Add text to a video with FFMPEG
	 * @param String location : video location
	 * @param String text : text to add
	 * @param String position : text position in the video
	 */
	def String generateVideoWithText(String location, String text, String position) {
		val pwd = System.getProperty("user.dir")
		val current = new File(pwd)
		val time = System.currentTimeMillis();
		var name = "src/main/webapp/data/videos/tmp-" + getVideoName(location) + "-" + time + ".mp4"
		var pos = 1;
		if(position == "top") pos = 6;
		if(position == "middle") pos = 2;
		if(position == "bottom") pos = 1;

		var cmd = 'ffmpeg -i ' + location + ' -vf drawtext="fontfile=data/test.ttf: ';
		cmd += "text='" + text + "': fontcolor=white: fontsize=64: box=1: boxcolor=black@0.5: ";
		cmd += 'boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/' + pos + '" -codec:a copy ' + name
		val pb = new ProcessBuilder("CMD", "/C", cmd)
		pb.directory(current)
		pb.redirectErrorStream(true)
		val p = pb.start();
		//p.waitFor()
		return name

	}



	
	
	@Test
	def void testRandomGenerationVideo() {
		val fileName = FFMPEGHelper2.randomGenerationVideo(5);
		Assert.assertTrue(new File(fileName).exists)
		val commandExec = Utils.commandExec(#['ls'])
		Assert.assertTrue(commandExec.contains(fileName))

		new File(fileName).delete
	}

	@Test
	def void testComputeGif() {
		val d = 2
		val fileName = FFMPEGHelper2.randomGenerationVideo(d);
		Assert.assertTrue(new File(fileName).exists)
		val gifPath = FFMPEGHelper2.generateGif(fileName)
		Assert.assertTrue(new File(gifPath).exists)

		new File(fileName).delete
		new File(gifPath).delete
	}

	@Test
	def void testComputeDuration() {
		val d = 5
		val fileName = FFMPEGHelper2.randomGenerationVideo(d);
		Assert.assertTrue(new File(fileName).exists)
		val duration = FFMPEGHelper2.computeDuration(fileName);
		Assert.assertEquals(d, duration);

		new File(fileName).delete
	}

	@Test
	def void testThumbnailGen() {
		var path = FFMPEGHelper2.randomGenerationVideo(5);
		println(path);
		val imgPath = FFMPEGHelper2.generateThumbnail(path)
		Assert.assertTrue(new File(imgPath).exists);

		new File(path).delete
		new File(imgPath).delete
	}

	@Test
	def void testQ1() {
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
	def void testQ9() {

		RandomVideoGeneratorSwitch.main(#[]);

		val createURI = URI.createURI("foo2_avi_only.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		Q9GenerateTBSwitch.generateThumbnails(videoGen)
	}

	@Test
	def void testQ10() {

		RandomVideoGeneratorSwitch.main(#[]);

		val createURI = URI.createURI("foo2_avi_only.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		val htmlText = Q10GenerateHTMLPage.generateHTML(videoGen)
		println(htmlText)
		Utils.fileWrite("foo2.html",htmlText)
	}

	@Test
	def void testQ11() {

		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)

		Q11VideoGenCheckerSwitch.check(videoGen)
	}

	@Test
	def void testQ11Fail() {

		// loading
		val createURI = URI.createURI("foo2_fail.videogen")
		var videoGen = loadVideoGenerator(createURI)
		try {
			Q11VideoGenCheckerSwitch.check(videoGen)
			fail("Expected VideoCheckException");
		} catch (VideoCheckException e) {
			//SUCCESS
		}
	}

	


	def concatFFMPEG() {
		var runtime = Runtime.getRuntime()
		val res = runtime.exec("ffmpeg.exe -f concat -i out.ffmpeg -c copy output.mp4")
		System.out.println(res)

	}

	

	
<<<<<<< HEAD

	

	/***
	 * Check a videoGen model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 */

	def void videoGenTestModel(VideoGeneratorModel videoGen) {
		val logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME)
		checkIds(videoGen, logger)
		videoGenCheckProba(videoGen, logger)
		checkPaths(videoGen, logger)
	}

	/***
	 * Check Paths uniqueness for a videoGen model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 * @param Logger logger : logger used to raise warnings and such
	 */

	def void checkPaths(VideoGeneratorModel videoGen, Logger logger) {
		val alts = <String>newArrayList()
		videoGen.videoseqs.forEach [ videoseq |
=======
	@Test
	def testFFMpegPlaylist() {
		var videoGen = loadVideoGenerator(URI.createURI("les_nuls_edition1.videogen")) 
		assertNotNull(videoGen)		
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
		
		val ArrayList<String> videoFiles = printToFFMpegFile(videoGen)
		val Set<String> hs = new HashSet()
		hs.addAll(videoFiles)
		videoFiles.clear()
		videoFiles.addAll(hs)
		videoFiles.forEach[file|
			genNewVid(file)
		]
		
		generateFile("fileList.txt", videoFiles)
	}
	
	def genNewVid(String file) {
		val userDir = System.getProperty("user.dir")
		println("ffmpeg -y -i " + userDir + file + " -threads 8 -s 640x480 -c:v libvpx-vp9 -crf 10 -b:v 1M -c:a libvorbis -strict experimental " + userDir + file + ".webm")
		val Process pr = Runtime.runtime.exec("ffmpeg -y -i " + userDir + file + " -threads 8 -s 640x480 -c:v libvpx-vp9 -crf 10 -b:v 1M -c:a libvorbis -b:a 128k -strict experimental " + userDir + file + ".webm");
		while(pr.isAlive) {}
		Runtime.runtime.exec("rm " + userDir + file);
		//Runtime.runtime.exec("mv " + userDir + file + "_new.mp4" + " " + userDir + file)
	}
	
	@Test
	def testGenSeq() {
		var videoGen = loadVideoGenerator(URI.createURI("les_nuls_edition1.videogen"))
		assertNotNull(videoGen)
		
		val ArrayList<String> finalSeq = new ArrayList()
		
		videoGen.videoseqs.forEach[videoSeq | 
			if(videoSeq instanceof MandatoryVideoSeq) {
				val desc = (videoSeq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				finalSeq.add("file '" + desc.location + "'")
			}
			if(videoSeq instanceof OptionalVideoSeq) {
				val desc = (videoSeq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				val probability = Math.random() * 100
				println("Probability : " + probability)
				println("Include seq : " + (probability < desc.probability))
				if((probability < desc.probability)) {
					finalSeq.add("file '" + desc.location + "'")
				}
			}
			if(videoSeq instanceof AlternativeVideoSeq) {
				val altvid = (videoSeq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
				
				val altSeqNumber = new Double(Math.random() * altvid.videodescs.size())
				println("AltSeq : " + altSeqNumber.intValue)
				val altSeq = altvid.videodescs.get(altSeqNumber.intValue);
				finalSeq.add("file '" + altSeq.location + "'")
			}
		]
		
		generateFile("finalSeq.txt", finalSeq);
	}
	
	@Test
	def void testGenPlaylist() {
		
		new PlaylistStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		var videoGen = loadVideoGenerator(URI.createURI("les_nuls_edition1.videogen"))
		assertNotNull(videoGen)
		
		val PlaylistFactory playlistFactory = new PlaylistFactoryImpl()
		val PlaylistGeneratorModel playlistGen = playlistFactory.createPlaylistGeneratorModel()
		
		videoGen.videoseqs.forEach[videoSeq | 
			if(videoSeq instanceof MandatoryVideoSeq) {
				val desc = (videoSeq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				val Mediafile mediafile = playlistFactory.createMediafile()
				mediafile.setId(desc.videoid)
				mediafile.setLocation(System.getProperty("user.dir") + desc.location)
				val duration = getDuration(mediafile.getLocation())
				println("Duration : " + duration)
				mediafile.setDuration(duration)
				playlistGen.mediafiles.add(mediafile)
			}
			if(videoSeq instanceof OptionalVideoSeq) {
				val desc = (videoSeq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				val probability = Math.random() * 100
				
				println("Probability : " + probability)
				println("Include seq : " + (probability < desc.probability))
				
				if((probability < desc.probability)) {
					val Mediafile mediafile = playlistFactory.createMediafile()
					mediafile.setId(desc.videoid)
					mediafile.setLocation(System.getProperty("user.dir") + desc.location)
					val duration = getDuration(mediafile.getLocation())
					println("Seq : " + desc.location)
					println("Duration : " + duration)
					mediafile.setDuration(duration)
					playlistGen.mediafiles.add(mediafile)
				}
			}
			if(videoSeq instanceof AlternativeVideoSeq) {
				val altvid = (videoSeq as AlternativeVideoSeq)
				var VideoDescription selectedSeq = null
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				val probability = Math.random() * 100
				var cumulativeProbability = 0
				println("Alt probability : " + probability)
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					if(probability > cumulativeProbability && probability <= vdesc.probability + cumulativeProbability) selectedSeq = vdesc
					cumulativeProbability += vdesc.probability
					println("cumulative : " + cumulativeProbability)
					if(cumulativeProbability > 100) {
						throw new Exception("Probability could not exceed 100 !")
					}
				}
				println("AltSeq : " + selectedSeq.videoid + " name : " + selectedSeq.location)
				val Mediafile mediafile = playlistFactory.createMediafile()
				mediafile.setLocation(System.getProperty("user.dir") + selectedSeq.location)
				mediafile.setId(selectedSeq.videoid)
				val duration = getDuration(mediafile.getLocation())
				println("Duration : " + duration)
				mediafile.setDuration(duration)
				playlistGen.mediafiles.add(mediafile)
			}
		]
		assertNotNull(playlistGen)
		savePlaylistGenerator(URI.createURI("les_nuls_edition1.xmi"), playlistGen)
		savePlaylistGenerator(URI.createURI("les_nuls_edition1.playlist"), playlistGen)
	}
	
	@Test
	def void generateVideoGenDuration() {
		
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		var videoGen = loadVideoGenerator(URI.createURI("les_nuls_edition1.videogen"))
		assertNotNull(videoGen)
		
		videoGen.videoseqs.forEach[videoSeq | 
			if(videoSeq instanceof MandatoryVideoSeq) {
				val desc = (videoSeq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				desc.duration = getDuration(System.getProperty("user.dir") + desc.location)
			}
			if(videoSeq instanceof OptionalVideoSeq) {
				val desc = (videoSeq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				desc.duration = getDuration(System.getProperty("user.dir") + desc.location)
			}
			if(videoSeq instanceof AlternativeVideoSeq) {
				val altvid = (videoSeq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					vdesc.duration = getDuration(System.getProperty("user.dir") + vdesc.location)
					vdesc.probability = 25
				}
			}
		]
		saveVideoGenerator(URI.createURI("les_nuls_edition1.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("les_nuls_edition1bis.videogen"), videoGen)
	}
	
	@Test
	def void generateM3UExtentdPlaylist() {
		var playlistGen = loadPlaylistGenerator(URI.createURI("les_nuls_edition1.playlist")) 
		assertNotNull(playlistGen)
		val ArrayList<String> files = new ArrayList()
		
		val M3UHeader = "#EXTM3U"
		val M3UDiscontinuity = "#EXT-X-DISCONTINUITY"
		val M3UInf = "#EXTINF:"
		val M3UEnd = "#EXT-X-ENDLIST"
		
		files.add(M3UHeader)
		
		for(mediafile: playlistGen.mediafiles) {
			println(mediafile.location)
			files.add(M3UDiscontinuity)
			files.add(M3UInf + mediafile.duration + ',' + mediafile.id)
			files.add(mediafile.location)	
		}
		
		files.add(M3UEnd)
		
		generateFile("playlist_ext.m3u", files)
	}
	
	/*
	/@Test
	def void generateThumbnailsPlaylist() {
		var playlistGen = loadPlaylistGenerator(URI.createURI("les_nuls_edition1.playlist")) 
		assertNotNull(playlistGen)
		
		for(mediafile: playlistGen.mediafiles) {
			Runtime.getRuntime().exec("ffmpeg -i " + mediafile.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + mediafile.id + ".png")
		}
	}
	*/
	
	@Test
	def void generateThumbnailsVideoGen() {
		var videoGen = loadVideoGenerator(URI.createURI("les_nuls_edition1.videogen"))
		assertNotNull(videoGen)
		
		videoGen.videoseqs.forEach[videoSeq | 
			if(videoSeq instanceof MandatoryVideoSeq) {
				val desc = (videoSeq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				println("ffmpeg -i " + System.getProperty("user.dir") + desc.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + desc.videoid + ".png")
				Runtime.getRuntime().exec("ffmpeg -i " + System.getProperty("user.dir") + desc.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + desc.videoid + ".png")
			}
			if(videoSeq instanceof OptionalVideoSeq) {
				val desc = (videoSeq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				"ffmpeg -i " + System.getProperty("user.dir") + desc.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + desc.videoid + ".png"
				Runtime.getRuntime().exec("ffmpeg -i " + System.getProperty("user.dir") + desc.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + desc.videoid + ".png")
			}
			if(videoSeq instanceof AlternativeVideoSeq) {
				val altvid = (videoSeq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					println("ffmpeg -i " + System.getProperty("user.dir") + vdesc.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + vdesc.videoid + ".png")
					Runtime.getRuntime().exec("ffmpeg -i " + System.getProperty("user.dir") + vdesc.location + " -ss 00:05 -vframes 1 " + System.getProperty("user.dir") + "/ressources/thumbs/" + vdesc.videoid + ".png")
				}
			}
		]
	}
	
	@Test
	def void testGenM3uPlaylist(){
		var playlistGen = loadPlaylistGenerator(URI.createURI("les_nuls_edition1.playlist")) 
		assertNotNull(playlistGen)
		val ArrayList<String> files = new ArrayList()
		
		for(mediafile: playlistGen.mediafiles) {
			println(mediafile.location)
			files.add(mediafile.location)	
		}
		
		generateFile("les_nuls_edition1_playlist.m3u", files)
	}
	
	def void printToHTML(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach[videoseq | 
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
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


	/***
	 * Check Ids uniqueness for a videoGen model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 * @param Logger logger : logger used to raise warnings and such
	 */
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


	/***
	 * Check videos probabilities for a videoGen model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 * @param Logger logger : logger used to raise warnings and such
	 */

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


	
/*
	@Test
	def testFilters() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("test.videogen"))
		for(video : videoGen.videoseqs) {
			if(video instanceof MandatoryVideoSeq) {
				var videoMandatory = (video as MandatoryVideoSeq)
				var filter = videoMandatory.description.filter
				var location = videoMandatory.description.location
				var ffmpegHelper = new FFMPEGHelper
				var f = filter.filter
				ffmpegHelper.applyFilter(f, location, "filteredVideos/" + location)
			}
			else if (video instanceof OptionalVideoSeq) {
				val random = (Math.random() * 2) as int
				if(random == 1) {
					var videoOptional = (video as OptionalVideoSeq)
					var filter = videoOptional.description.filter
					var location = videoOptional.description.location
					var f = filter.filter
					var ffmpegHelper = new FFMPEGHelper
					ffmpegHelper.applyFilter(f, location, "filteredVideos/" + location)
				}
			}
			else {
				val alts = (video as AlternativeVideoSeq).videodescs
				val random = (Math.random() * alts.size) as int
				var videoAlt = alts.get(random)
				var location = videoAlt.location;
				var filter = videoAlt.filter
				var f = filter.filter
				var ffmpegHelper = new FFMPEGHelper
				ffmpegHelper.applyFilter(f, location, "filteredVideos/" + location)
			}
		}
	}*/

	@Test
	def testIncrustTextToVideo() {
		// loading

		var videoGen = loadVideoGenerator(URI.createURI("test.videogen"))
		for(video : videoGen.videoseqs) {
			if(video instanceof MandatoryVideoSeq) {
				var videoMandatory = (video as MandatoryVideoSeq)
				var text = videoMandatory.description.text
				if(text != null) {
					var location = videoMandatory.description.location
					var content = text.content
					var position = text.position
					var color = text.color
					var size = text.size
					var ffmpegHelper = new FFMPEGHelper
					ffmpegHelper.applyTextToVideo(content, color, position, size, location, "textIncrustedVideos/" + location)
				}
			}
			else if (video instanceof OptionalVideoSeq) {
				val random = (Math.random() * 2) as int
				if(random == 1) {
					var videoOptional = (video as OptionalVideoSeq)
					var text = videoOptional.description.text
					if(text != null) {
						var location = videoOptional.description.location
						var content = text.content
						var position = text.position
						var color = text.color
						var size = text.size
						var ffmpegHelper = new FFMPEGHelper
						ffmpegHelper.applyTextToVideo(content, color, position, size, location, "textIncrustedVideos/" + location)
					}
				}
			}
			else {
				val alts = (video as AlternativeVideoSeq).videodescs
				val random = (Math.random() * alts.size) as int
				var videoAlt = alts.get(random)
				var text = videoAlt.text
				if(text != null) {
					var location = videoAlt.location
					var content = text.content
					var position = text.position
					var color = text.color
					var size = text.size
					var ffmpegHelper = new FFMPEGHelper
					ffmpegHelper.applyTextToVideo(content, color, position, size, location, "textIncrustedVideos/" + location)
				}
			}
		}
	}


		

	
<<<<<<< HEAD



	


	




	/***
	 * Add HTML info for a video to var 'content'
	 * @param VideoDescription desc : video description
	 */
	def void createWepPageVideo(VideoDescription desc) {
		val name = getVideoName(desc.location)
		content += "<img height='150' width='200' src='../data/thumbnails/" + name + ".png' />"
		content += "<span>" + name + "</span>"
		content += "<span>time: " + desc.duration + "s</span><br>"
	}

	

	/***
	 * Generate video thumbnail with FFMPEG
	 * @param String path : path to the video
	 * Current path is "src/main/webapp/data/thumbnails/"
	 */
	def void ffmpegThumbail(String path) {
		val pwd = System.getProperty("user.dir")
		val current = new File(pwd)
		var name = getVideoName(path)
		var cmd2 = "ffmpeg -y -i " + path +
			" -r 1 -t 00:00:01 -ss 00:00:02 -f image2 src/main/webapp/data/thumbnails/" + name + ".png"
		try {
			val pb = new ProcessBuilder("CMD", "/C", cmd2)
			pb.directory(current)
			pb.redirectErrorStream(true)
			val p = pb.start();
			p.waitFor()

		} catch (IOException ex) {
			println("error: " + ex)
		}

=======
	def ArrayList<String> printToFFMpegFile(VideoGeneratorModel videoGen) {
		
		val ArrayList<String> res = newArrayList()
		
		videoGen.videoseqs.forEach[videoseq | 
			if(videoseq instanceof MandatoryVideoSeq) {
				if(!videoseq.description.videoid.isNullOrEmpty) {
					res.add(videoseq.description.location)
				}
			}
			else if(videoseq instanceof OptionalVideoSeq) {
				if(!videoseq.description.videoid.isNullOrEmpty) {
					res.add(videoseq.description.location)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				altvid.videodescs.forEach[altVideoSeq |
					res.add(altVideoSeq.location)
				]
			}
		]
		return res
	}
	
	def void generateFile(String filename, ArrayList<String> files) {
		val BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))
		try {
			files.forEach[file |
				buffer.write(file + "\n")
			]
		}
		catch(IOException e) {
			throw e
		}
		finally {
			buffer.close()
		}
	}
	
	static var i = 0;
	
	def genID() {
		"v" + i++
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
	}


	
	
<<<<<<< HEAD

		

	

	


	def computeDuration(String location){
		var cmd = "/usr/bin/ffprobe ffprobe -i "+location+
		 " -show_entries format=duration -v quiet -of csv=\"p=0\""

		var Process process = Runtime.getRuntime().exec(cmd)
		process.wait()
		val str = convertStreamToString(process.inputStream)
		Double::parseDouble(str.trim())
	}

	//Question 7-2
	def static String convertStreamToString(InputStream is){
		val scanner = new Scanner(is).useDelimiter("\\A");
		if(scanner.hasNext()) {scanner.next;}
		else "";
	}




	def test1() {

		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("question8.m3u"))
		pw.println("#EXTM3U")

		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				pw.println("#EXT-X-DISCONTINUITY")
				pw.println("")
				pw.println("#EXTINF:" + desc.duration)
				pw.println(desc.location)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description

				var coin = new Random().nextInt(1)
				if(coin == 1) {
					pw.println("#EXT-X-DISCONTINUITY")
					pw.println("")
					pw.println("#EXTINF:" + desc.duration)
					pw.println(desc.location)
				}

				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var coin = new Random().nextInt(altvid.videodescs.size)
				var desc = altvid.videodescs.get(coin)
				pw.println("#EXT-X-DISCONTINUITY")
				pw.println("")
				pw.println("#EXTINF:" + desc.duration)
				pw.println(desc.location)
			}
		]
		pw.println("#EXT-X-ENDLIST")
		pw.close();

	}

	



	/***
	 * Return video duration with FFMPEG
	 * @param String path : path to the video
	 */
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

			i = time.indexOf(".")
			time = time.substring(0, i)

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

	

	


	
	


	def generateVignettes(String location, String name){
		var cmd = "/usr/bin/ffmpeg -y -i " +location+ " -r 1 -t 00:00:01 -ss 00:00:$2 -f image2 images/" +name+".png"

		var  process = Runtime.getRuntime().exec(cmd)
		process.wait()
	}
		
	



	
	@Test
		def test10() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("q10.html"))
		// Model to model

		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()


       val outputFile = new File("outagain.txt");

       val out = new FileWriter(outputFile);
       out.write("<html><h3>liste de ")
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq |

			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description


				val duration = computeDuration(desc.location)
				generateVignettes( desc.location, desc.description)
				out.write("<img src='"+desc.location+"''>")
				desc.duration = duration as int

			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(1)
				if(optional.nextInt()==1)
				{
					val desc = (videoseq as OptionalVideoSeq).description
				val duration = computeDuration(desc.location)
				generateVignettes( desc.location, desc.description)
				out.write("<img src='"+desc.location+"''>")
				desc.duration = duration as int

				}

			}

			else {
				val altvid = videoseq as AlternativeVideoSeq
				for (vdesc : altvid.videodescs) {
				val duration = computeDuration(vdesc.location)
				generateVignettes( vdesc.location, vdesc.description)
				out.write("<img src='"+vdesc.location+"''>")
				vdesc.duration = duration as int
				}
			}
		]
		assertNotNull(videoGen)
	assertEquals(7, videoGen.videoseqs.size)
			
	
		


	}



		@Test
		def Qsuplement1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("qsub.videogen"))
		// Model to model

		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()


       //val outputFile = new File("outagain.txt");

       // val out = new FileWriter(outputFile);
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq |

			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description


				convertToBlackWhite(desc.location,"/black/"+desc.location)

			}



			]
			//out.close


	}



	def static void convertToBlackWhite(String location , String output){

		var cmd = "ffmpeg -i "+location+
		 " -vf hue=s=0 -c:a copy "+output

		var  process = Runtime.getRuntime().exec(cmd)
		process.waitFor



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


	def void modelToText(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				println("file '"+desc.location+"'")
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(Math.random()*1>0.5)
					println("file '"+desc.location+"'")
			}
			else{
				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("file '"+altvid.videodescs.get((Math.random()*altvid.videodescs.size) as int).location+"'")
			}
		]
	}





	def void printToFile(VideoGeneratorModel videoGen) {

		var file = new File("Q1.txt")
     	var fileWriter = new FileWriter(file)


		for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					fileWriter.write("file '"+desc.location+"' \n")
					fileWriter.flush()
				}

			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)

				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {
						fileWriter.write("file '"+desc.location+"' \n")
						fileWriter.flush();


				   }

				}
				}else {

					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)
					var vdesc = altvid.videodescs.get(random);


			      	if(!vdesc.videoid.isNullOrEmpty) {
						fileWriter.write("file '"+vdesc.location+"' \n")
						fileWriter.flush();
					}

				}

			}
		fileWriter.close()
	}

	def void printToFileQ9(VideoGeneratorModel videoGen) {


     	var vi = new Command


		for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){

					vi.vignette(desc.location,desc.videoid)

				}

			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)

				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {

       					vi.vignette(desc.location,desc.videoid)


				   }

				}
				}else {

					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)

					var vdesc = altvid.videodescs.get(random);


			      	if(!vdesc.videoid.isNullOrEmpty) {

			      		vi.vignette(vdesc.location,vdesc.videoid)

					}

				}

			}
	}

	def void printToGIF(VideoGeneratorModel videoGen) {

     	var vi = new Command


		for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					println(desc.location+" "+desc.videoid)
					vi.gif(desc.location,desc.videoid)


				}

			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)

				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {

       					vi.gif(desc.location,desc.videoid)


				   }

				}
				}else {

					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)

					var vdesc = altvid.videodescs.get(random);


			      	if(!vdesc.videoid.isNullOrEmpty) {

			      		vi.gif(vdesc.location,vdesc.videoid)

					}

				}

			}
	}

	def void printToFilter(VideoGeneratorModel videoGen) {

     	var vi = new Command


		for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					println(desc.location+" "+desc.videoid)
					vi.filter(desc.location,desc.videoid)


				}

			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)

				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {

       					vi.filter(desc.location,desc.videoid)


				   }

				}
				}else {

					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)

					var vdesc = altvid.videodescs.get(random);


			      	if(!vdesc.videoid.isNullOrEmpty) {

			      		vi.filter(vdesc.location,vdesc.videoid)

					}

				}

			}
	}

	




	def void verifyQ11(VideoGeneratorModel videoGen) {

		var file = new File("Q11.txt")
     	var fileWriter = new FileWriter(file)
     	val String[] mondatory = newArrayOfSize(10)
     	val String[] optional = newArrayOfSize(10)
     	val String[] alternative = newArrayOfSize(10)

		for(videoseq : videoGen.videoseqs){

			if(videoseq instanceof MandatoryVideoSeq){

				val desc = (videoseq as MandatoryVideoSeq).description
				var location = desc.videoid
				mondatory.add(location)

			}else if(videoseq instanceof OptionalVideoSeq){

				val desc = (videoseq as OptionalVideoSeq).description
				var location = desc.videoid
				optional.add(location)

			}else{

				val altvid = (videoseq as AlternativeVideoSeq)
				var location = altvid.videoid
				alternative.add(location)
			}
		}
		for(m : mondatory){
			for(m2 : mondatory){

			}
		}
	}


	def void addText(VideoGeneratorModel videoGen) {

     	var vi = new Command



		for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){



					// vi.text(desc.location, desc.videoid, desc.text)


				}

			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)
				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {

       					vi.gif(desc.location,desc.videoid)


				   }

				}
				}else {

					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)
					var vdesc = altvid.videodescs.get(random);


			      	if(!vdesc.videoid.isNullOrEmpty) {

			      		vi.gif(vdesc.location,vdesc.videoid)

					}

				}

			}
	}


def void printToDuration(VideoGeneratorModel videoGen) {

     	for(videoseq : videoGen.videoseqs){

			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					var commandDuration = "ffprobe -i " + desc.location +" -show_entries format=duration -v quiet -of csv=p=0";
					var p = Runtime.getRuntime().exec(commandDuration);
					p.waitFor();
	       			var str = new Scanner(p.inputStream).useDelimiter("\\A")
	       			if(str.hasNext())
	       				println(str.next().trim)


				}

			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)
				//println(" ro " +rdm)
				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {

       					var commandDuration = "ffprobe -i " + desc.location +" -show_entries format=duration -v quiet -of csv=p=0";
						println(commandDuration)
						var p = Runtime.getRuntime().exec(commandDuration);
						p.waitFor();
	       				var str = new Scanner(p.inputStream).useDelimiter("\\A")
	       				if(str.hasNext())
	       					println(str.next().trim)


				   }

				}
				}else {

					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)
					//print(" ra "+random+"\n")
					var vdesc = altvid.videodescs.get(random);


			      	if(!vdesc.videoid.isNullOrEmpty) {

			      		var commandDuration = "ffprobe -i " + vdesc.location +" -show_entries format=duration -v quiet -of csv=p=0";
						var p = Runtime.getRuntime().exec(commandDuration);
						p.waitFor();
	       				var str = new Scanner(p.inputStream).useDelimiter("\\A")
	       				if(str.hasNext())

	       					println(str.next().trim)

					}

				}

			}



	}





	/***
	 * Return a random double from range [0.0, 1.0]
	 */
	def randomNumber() {
		var d = Math.random()
		return d
	}

	/***
	 * Return a random double from range [0.00, value]
	 * @param double value : max value
	 */
	def double randomNumberIntervalle(double value) {
		return (Math.random() * (value - 0.00 ) + 0.00)
	}

	






	def outputPrint(String s){
		println ("file '" + s + "'")
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

	
	

	def createVignette(String location) {
		var cmd = "ffmpeg -i " + location + " -f image2 -ss 5 -vframes 1 -s 160x120 " + location + ".jpg"
		var process = Runtime.runtime.exec(cmd)
	}


	def textOnVideo(String text){

		var cmd= "ffmpeg -i v1.mp4 -vf drawtext=\"fontfile=/path/to/font.ttf: \\
text="+text+": fontcolor=white: fontsize=24: box=1: boxcolor=black@0.5: \\
boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/2\" -codec:a copy output.mp4"
println(cmd)
Runtime.getRuntime().exec(cmd)
	}


	

	
	def int getDuration(String path) {
		var Process process = Runtime.getRuntime().exec("ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"" + path + "\"");
		//System.out.println("ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"" + path + "\"")
		process.waitFor();

		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
	    return Math.round(Float.parseFloat(outputJson))-1;
	}

  	

  	def String addText(String path, String text, String positionX, String positionY) {
		var Process process = Runtime.getRuntime().exec("ffmpeg -i "+path+" -vf drawtext='fontfile=/Windows/Fonts/arial.ttf:text="+text+":fontcolor=white:fontsize=44:box=1:boxcolor=black@0.5:boxborderw=5:x="+positionX+":y="+positionY+"' -codec:a copy 2" + path + " -y" );
		System.out.println("ffmpeg -i "+path+" -vf drawtext='fontfile=/Windows/Fonts/arial.ttf:text="+text+":fontcolor=white:fontsize=44:box=1:boxcolor=black@0.5:boxborderw=5:x="+positionX+":y="+positionY+"' -codec:a copy 2" + path + " -y")
		process.waitFor();

		return "2" + path
	}

  	def void toGIF(String path, String filename, String width, String length) {
		var Process process = Runtime.getRuntime().exec("ffmpeg -i " + path + " -ss 00:00:00.000 -pix_fmt rgb24 -r 10 -s "+width+"x"+length+" -t 00:00:10.000 gif/"+filename+".gif -y" );
		System.out.println("ffmpeg -i " + path + " -ss 00:00:00.000 -pix_fmt rgb24 -r 10 -s "+width+"x"+length+" -t 00:00:10.000 gif/"+filename+".gif")
		process.waitFor();
	}

	def toGIFHD(String path, String filename, Integer size){
		var Process process = Runtime.getRuntime().exec("ffmpeg -y -ss 0 -t 3 -i "+path+" -vf fps=10,scale="+size+":-1:flags=lanczos,palettegen png/"+filename+".png -y" );
		System.out.println("ffmpeg -y -ss 0 -t 3 -i "+path+" -vf fps=10,scale="+size+":-1:flags=lanczos,palettegen png/"+filename+".png")
		process.waitFor();

		var Process process2 = Runtime.getRuntime().exec("ffmpeg -ss 0 -t 3 -i "+path+" -i png/"+filename+".png -filter_complex \"fps=10,scale="+size+":-1:flags=lanczos[x];[x][1:v]paletteuse\" gifHD/"+filename+".gif -y" );
		System.out.println("ffmpeg -ss 0 -t 3 -i "+path+" -i png/"+filename+".png -filter_complex \"fps=10,scale="+size+":-1:flags=lanczos[x];[x][1:v]paletteuse\" gifHD/"+filename+".gif")
		process2.waitFor();


	}




}
=======
	def Float getDuration(String videoLocation) {
		val durationCommand = "ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "
		val Process pr = Runtime.getRuntime().exec(durationCommand + videoLocation)
		val BufferedReader resBuffer = new BufferedReader(new InputStreamReader(pr.getInputStream()))
		return Float.parseFloat(resBuffer.readLine())
	}
	
	@Test
	def testVideoGenerator() {
		var VideoGenerator video = new VideoGenerator()
		
		video.generateVideoFile("les_nuls_edition1.videogen", "test.webm", System.getProperty("user.dir"))
	}
	
}
>>>>>>> e529713dc2ce4273a0bbf2a0634beb68235d51ef
