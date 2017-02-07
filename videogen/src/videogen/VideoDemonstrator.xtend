package videogen

import java.io.File
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
import org.junit.Assert
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import videogen.vignette.FFMPEGHelper

import static org.junit.Assert.*

import java.util.ArrayList
import java.util.List

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

import java.util.LinkedHashMap
import java.util.Map



import java.util.Random
import org.tritcorp.playlist.model.Playlist.*
import org.tritcorp.playlist.model.Playlist.impl.*

import java.io.FileWriter
import java.io.File
import java.io.FileReader
import java.util.Random
import playlist.Playlist
import playlist.PlaylistFactory
import java.io.InputStream
import java.util.Scanner


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


	/***
	 * Return all the video to the user
	 */
	def LinkedHashMap<String, String> videoGenToJhipster() {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))
		generateThumbnail(videoGen)
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
	 * Return a random playlist to the user (random mode)
	 */
	def ArrayList<String> generateFromJhipster() {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))
		assertNotNull(videoGen)
		setProba(videoGen)
		transformVideoDuration(videoGen)
		saveVideoGenerator(URI.createURI("test1.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("test1bis.videogen"), videoGen)

		val playlist = videoGenToPlaylist(videoGen)
		return printToFfmpegString(playlist)
	}

	/***
	 * Set probabilities depending of user's choices (config mode)
	 * if a video is picked by the user => probability = 100%
	 * else probability = 0%
	 * Add text on the given videos
	 * Return an ArrayList<String> made of user's video choices
	 * @param ArrayList<String> choices : list of user's video choices
	 * @param ArrayList<String> choices : list of user's video with text choices
	 * @param String text : text to add
	 * @param String position : position of the text to add
	 */
	def ArrayList<String> setProbaFromUserChoicesWithText(ArrayList<String> choices, ArrayList<String> choices2,
		String text, String position) {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability != 100) desc.probability = 100
				if(choices2.contains(getVideoName(desc.location))) desc.text = text
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if (choices.contains(getVideoName(desc.location))) {
					desc.probability = 100
					if(choices2.contains(getVideoName(desc.location))) desc.text = text
				} else {
					desc.probability = 0
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					if (choices.contains(getVideoName(vdesc.location))) {
						vdesc.probability = 100
						if(choices2.contains(getVideoName(vdesc.location))) vdesc.text = text
					} else {
						vdesc.probability = 0
					}
				}
			}
		]
		val playlist = videoGenToPlaylistWithText(videoGen, position)
		return printToFfmpegString(playlist)
	}

	/***
	 * Set probabilities depending of user's choices (config mode)
	 * if a video is picked by the user => probability = 100%
	 * else probability = 0%
	 * Return an ArrayList<String> made of user's video choices
	 * @param ArrayList<String> choices : list of user's choices
	 */
	def ArrayList<String> setProbaFromUserChoices(ArrayList<String> choices) {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability != 100) desc.probability = 100
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if (choices.contains(getVideoName(desc.location))) {
					desc.probability = 100
				} else {
					desc.probability = 0
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					if (choices.contains(getVideoName(vdesc.location))) {
						vdesc.probability = 100
					} else {
						vdesc.probability = 0
					}
				}
			}
		]
		val playlist = videoGenToPlaylist(videoGen)
		return printToFfmpegString(playlist)
	}

	/***
	 * Set probabilities for a given videoGen model
	 * @param VideoGeneratorModel videoGen : videoGen model
	 */
	def void setProba(VideoGeneratorModel videoGen) {
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
	}

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

		transformVideoDuration(videoGen)
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
	 * Return a playlist from a videoGen model and create new videos with text
	 * @param VideoGeneratorModel videoGen : videoGen model
	 * @param String position : text position in the video
	 */
	def ArrayList<String> generateFromJhipsterWithText(ArrayList<String> videos, String text, String position) {
		var videoGen = loadVideoGenerator(URI.createURI("data\\test1.videogen"))
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (videos.contains(getVideoName(desc.location))) {
					desc.text = text
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (videos.contains(getVideoName(desc.location))) {
					desc.text = text
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if (videos.contains(getVideoName(vdesc.location))) {
						vdesc.text = text
					}
				}
			}
		]

		assertNotNull(videoGen)
		setProba(videoGen)
		transformVideoDuration(videoGen)
		val playlist = videoGenToPlaylistWithText(videoGen, position)
		return printToFfmpegString(playlist)
	}

	/***
	 * Return a playlist from a videoGen model and create new videos with text
	 * @param VideoGeneratorModel videoGen : videoGen model
	 * @param String position : text position in the video
	 */
	def PlaylistModel videoGenToPlaylistWithText(VideoGeneratorModel videoGen, String position) {
		val factory = PlaylistFactoryImpl.eINSTANCE
		val playlist = factory.createPlaylistModel

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					if (!desc.text.isNullOrEmpty) {
						var s = generateVideoWithText(desc.location, desc.text, position)
						desc.location = s
					}
					addVideoToPlaylist(factory, playlist, desc);
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					if (randomNumber() <= desc.probability / 100 as double) {
						if (!desc.text.isNullOrEmpty) {
							var s = generateVideoWithText(desc.location, desc.text, position)
							desc.location = s
						}
						addVideoToPlaylist(factory, playlist, desc);
					}
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if (!altvid.videoid.isNullOrEmpty)
				if (altvid.videodescs.size > 0) {
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
						iterate++
					}

					var x = randomNumber();
					var index = -1
					for (v : 0 ..< arr.size) {
						if (index == -1 && x < arr.get(v)) {
							if (!alts.keySet().get(v).text.isNullOrEmpty) {
								var s = generateVideoWithText(alts.keySet().get(v).location, alts.keySet().get(v).text,
									position)
								alts.keySet().get(v).location = s
							}
							addVideoToPlaylist(factory, playlist, alts.keySet().get(v));
							index = 0
						}
					}
				}
			}
		]
		return playlist
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
	def test11() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("test1.videogen"))
		assertNotNull(videoGen)
		// assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGenTestModel(videoGen)

	@Test
	def void testCommandExec() {
		val String[] command = #['ls']
		val commandExec = Utils.commandExec(command)
		println("output : \n" + commandExec)
	}

	@Test
	def void testRandomGenerationVideo() {
		val fileName = FFMPEGHelper.randomGenerationVideo(5);
		Assert.assertTrue(new File(fileName).exists)
		val commandExec = Utils.commandExec(#['ls'])
		Assert.assertTrue(commandExec.contains(fileName))

		new File(fileName).delete
	}

	@Test
	def void testComputeGif() {
		val d = 2
		val fileName = FFMPEGHelper.randomGenerationVideo(d);
		Assert.assertTrue(new File(fileName).exists)
		val gifPath = FFMPEGHelper.generateGif(fileName)
		Assert.assertTrue(new File(gifPath).exists)

		new File(fileName).delete
		new File(gifPath).delete
	}

	@Test
	def void testComputeDuration() {
		val d = 5
		val fileName = FFMPEGHelper.randomGenerationVideo(d);
		Assert.assertTrue(new File(fileName).exists)
		val duration = FFMPEGHelper.computeDuration(fileName);
		Assert.assertEquals(d, duration);

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
	def void testQ3() {
		// loading
		val createURI = URI.createURI("foo2.videogen")
		var videoGen = loadVideoGenerator(createURI)
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)

		val playlist = Q3ModelToModelSwitch.convertVideogenToPlaylist(videoGen)
		println(playlist)

	}

	@Test
	def void testQ3bis() {
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

	@Test
	def void test4() {
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
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()

			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability == 0) desc.probability = 50

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
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
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

		// transformVideoDuration(videoGen)
		var a = <String>newArrayList()
		a.add("Great-Teacher-Onizuka-Episode-1")
		a.add("SampleVideo")
		a.add("Great-Teacher-Onizuka-Episode-33")
		// generateGif(a);
		generateFromJhipsterWithText(a, "kapow", "bottom")
		// generateThumbnail(videoGen)
		// generateWebPage(videoGen)
		// serializing
		// saveVideoGenerator(URI.createURI("test1.xmi"), videoGen)
		//saveVideoGenerator(URI.createURI("test1bis.videogen"), videoGen)

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


	/***
	 * Generate a HTML file representing a given videoGenerator model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 */

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

	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		
	//printToHTML(videoGen)	
	modelToText(videoGen)
}
	
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
	}
	
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
	

		// serializing
		saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)

		printToHTML(videoGen)

	}



	def void printToHTML(VideoGeneratorModel videoGen) {
		// var numSeq = 1
		println("<ul>")



	
	def  playlistToM3U(Playlist playlist){
		playlist.getFiles().forEach[file |
			println(file.getPath())
		]
	}
	
	def  playlistToFFMPEG(Playlist playlist){
		playlist.getFiles().forEach[file |
			println("File '"+file.getPath()+"'")
		]
	}
	 
	def Playlist testM2M() {
		
		// load model (videogen)
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)		
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		// model2model
		val plf = PlaylistFactoryImpl.init()
		val pl = plf.createPlaylist()
		//Instancier modele PLaylist
		// iterate over videogen model
		
		videoGen.videoseqs.forEach[videoseq | 
			val rand = new Random()
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty){
					var mf = plf.createMediaFile()
					mf.setPath(desc.location)
					pl.getFiles.add(mf)
					}
					  
									
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val p = desc.probability
				val res = rand.nextInt(100)
				if(p > 0){
					if(!desc.location.isNullOrEmpty && res <= p){
						var mf = plf.createMediaFile()
						mf.setPath(desc.location)
						pl.getFiles.add(mf)
					}
						 
				}
				else
				if(!desc.location.isNullOrEmpty && res <= 50){
					var mf = plf.createMediaFile()
					mf.setPath(desc.location)
					pl.getFiles.add(mf)
				}
					
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)	
				val l = altvid.getVideodescs()
				val r = l.length
				
				var boolean found = false
				var pr = 0
				for(vdesc: altvid.videodescs){
					if(vdesc.probability>0)
						pr = vdesc.probability
				}
				var i = 0
				if(pr==0){
					do{
						i = 0
						for (vdesc : altvid.videodescs) {					
							if(!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(r)%r							
								if(p==i && ! found){
									var mf = plf.createMediaFile()
									mf.setPath(vdesc.location)
									pl.getFiles.add(mf)
									found = true
								}	
							i++
							}
						}
					}while(! found)
				}
				else{
					do{
						i = 0
						for (vdesc : altvid.videodescs) {					
							if(!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(100)							
								if(p<=pr && ! found){
									var mf = plf.createMediaFile()
									mf.setPath(vdesc.location)
									pl.getFiles.add(mf)
									found = true
								}	
							i++
							}
						}
					}while(! found)
				}
			}
		]
		
		return pl
	}
	
	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		//assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)

		videoGen.videoseqs.forEach[videoseq | 

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
		val htmlFile = new File(pwd + "\\web\\videogen.html")
		val writer = new FileWriter(htmlFile)
		writer.write(page)
		writer.close()

	}

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
	 * Generate videos thumbnails for a given videoGen model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 */
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

				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability == 0) desc.probability = 50

			}
		]
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

	}

	/***
	 * Add videos duration to the given videoGen model
	 * @param VideoGeneratorModel videoGen : videoGenerator model
	 */
	def void transformVideoDuration(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				desc.duration = ffmpegDuration(desc.location)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).descriptio

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


	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		
	//printToHTML(videoGen)

	printToFfmpeg(videoGen)
	

	}

	def void createWepPageVideo(VideoDescription desc) {
		val name = getVideoName(desc.location)
		content += "<img height='150' width='200' src='../data/thumbnails/" + name + ".png' />"
		content += "<span>" + name + "</span>"
		content += "<span>time: " + desc.duration + "s</span><br>"
	}

	def void generateThumbnail(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach [ videoseq |

	val videoGen1 = loadVideoGenerator(URI.createURI("foo2bis.videogen"))
	//printVideoList(videoGen1)
	val playlist=testM2M()
	
	println("M3U")
	playlistToM3U(playlist)
	println("\nFFMPEG")
	playlistToFFMPEG(playlist)
	}
	

	
	def void printVideoList(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq | 
			val rand = new Random()
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
		val pw = new PrintWriter(new File("question3.m3u"))
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
		//loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("question3.txt"))
		pw.println("#Ceci est un commentaire")
					
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
		var videoGen = loadVideoGenerator(URI.createURI("test.videogen")) 
		assertNotNull(videoGen)
		assertEquals(2, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("question7.txt"))
		pw.println("#Ceci est un commentaire")
					
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				val duration = computeDuration(desc.location)
				desc.duration = duration as int				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val duration = computeDuration(desc.location)
				desc.duration = duration as int
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs){
					val duration = computeDuration(vdesc.location)
					vdesc.duration = duration as int
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

		
	//Question 7-1
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
	
	
	@Test

	def testQ8() {

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
	
	@Test
	def testQ9() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)					
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				generateVignettes(desc.location, desc.videoid)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				generateVignettes(desc.location, desc.videoid)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs){
					generateVignettes(vdesc.location, vdesc.videoid)
				}
			}
		]
	}



	/***
	 * Return video duration with FFMPEG
	 * @param String path : path to the video
	 */
	def int ffmpegDuration(String path) {
		val pwd = System.getProperty("user.dir")

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

	/***
	 * Print an HTML list of all the videos
	 * @param VideoGeneratorModel videoGen : videoGenerator model instance
	 */

	//Question 9-1
	def generateVignettes(String location, String name){
		var cmd = "/usr/bin/ffmpeg -y -i " +location+ " -r 1 -t 00:00:01 -ss 00:00:$2 -f image2 " +
		"images/" +name+".png"
		var Process process = Runtime.getRuntime().exec(cmd)
		process.wait()
	}
	
	
	@Test
	def testQ10() {
		//loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		val pw = new PrintWriter(new File("question10.html"))
		pw.println("<html>Question 10</html>")
		pw.println("<h1>Question 10</h1>")
					
	@Test
	def test3() {
		
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		        
       val outputFile = new File("outagain.txt"); 
       
        val out = new FileWriter(outputFile); 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val chem = (videoseq as MandatoryVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(2)
				if(optional.nextInt()==1)
				{
					val chem = (videoseq as OptionalVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				
				}
				
			}
			
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val size = altvid.videodescs.size()
				
				val optional = new Random().nextInt(altvid.videodescs.size())
				out.write(altvid.videodescs.get(optional).location+"\n")
				 				
		}
			]
			out.close
	// serializing
		 
			
	}
	
	@Test
	def test4() {
		
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		// Model to model
		
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()
		
		
       val outputFile = new File("outagain.txt"); 
       
        val out = new FileWriter(outputFile); 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val chem = (videoseq as MandatoryVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				
				val mediafile = PlaylistFactory.eINSTANCE.createMediafile()
				mediafile.location = chem
				playlist.videos.add(mediafile)
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(1)
				if(optional.nextInt()==1)
				{
					val chem = (videoseq as OptionalVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				
				val mediafile = PlaylistFactory.eINSTANCE.createMediafile()
				mediafile.location = chem
				playlist.videos.add(mediafile)
				
				}
				
			}
			
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val size = altvid.videodescs.size()
				
				val optional = new Random().nextInt(altvid.videodescs.size())
				out.write(altvid.videodescs.get(optional).location+"\n")
				
				val mediafile = PlaylistFactory.eINSTANCE.createMediafile()
				mediafile.location = altvid.videodescs.get(optional).location
				playlist.videos.add(mediafile)
				 				
		}
			]
			out.close
	// serializing
	
		 convertPlaylistIntoFormat(playlist, "m3u")
			
	}
	
	
		@Test
		def test7() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		// Model to model
		
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()
		
		
       //val outputFile = new File("outagain.txt"); 
       
       // val out = new FileWriter(outputFile); 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
			
				
				val duration = computeDuration(desc.location)
				desc.duration = duration as int
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(1)
				if(optional.nextInt()==1)
				{
					val desc = (videoseq as OptionalVideoSeq).description
				val duration = computeDuration(desc.location)
				desc.duration = duration as int
				
				}
				
			}
			
			else {
				val altvid = videoseq as AlternativeVideoSeq
				for (vdesc : altvid.videodescs){
				val duration = computeDuration(vdesc.location)
				vdesc.duration = duration as int
				}
				}
				
				 				
			]
			//out.close
	
			
	}
	
	@Test
		def test8() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		// Model to model
		
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()
		
		
       val outputFile = new File("outagain8.txt"); 
       
        val out = new FileWriter(outputFile);
        out.write("#EXTM3U") 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
			
				
				val duration = computeDuration(desc.location)
				out.write("#EXT-X-DISCONTINUITY \n #EXTINF:"+duration+"\n"+desc.location)
				desc.duration = duration as int
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(1)
				if(optional.nextInt()==1)
				{
					val desc = (videoseq as OptionalVideoSeq).description
				val duration = computeDuration(desc.location)
				out.write("#EXT-X-DISCONTINUITY \n #EXTINF:"+duration+"\n"+desc.location)
				desc.duration = duration as int
				
				}
				
			}
			
			else {
				val altvid = videoseq as AlternativeVideoSeq
				for (vdesc : altvid.videodescs){
				val duration = computeDuration(vdesc.location)
				out.write("#EXT-X-DISCONTINUITY \n #EXTINF:"+duration+"\n"+vdesc.location)
				vdesc.duration = duration as int
				}
				}
				
				
				
				 				
			]
			out.write("#EXT-X-ENDLIST")
			out.close
	
			
	}
	
	
	def generateVignettes(String location, String name){
		var cmd = "/usr/bin/ffmpeg -y -i " +location+ " -r 1 -t 00:00:01 -ss 00:00:$2 -f image2 images/" +name+".png"

		var  process = Runtime.getRuntime().exec(cmd)
		process.wait()
	}
		def computeDuration(String location){
		var cmd = " ffprobe -i "+location+
		 " -show_entries format=duration -v quiet -of csv=\"p=0\""

		var  process = Runtime.getRuntime().exec(cmd)
		process.wait()
		val str = convertStreamToString(process.inputStream)
		Double::parseDouble(str.trim())
	}
	
	@Test
		def test9() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		// Model to model
		
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()
		
		
       //val outputFile = new File("outagain.txt"); 
       
       // val out = new FileWriter(outputFile); 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
			
				
				val duration = computeDuration(desc.location)
				generateVignettes( desc.location, desc.description)
				desc.duration = duration as int
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(1)
				if(optional.nextInt()==1)
				{
					val desc = (videoseq as OptionalVideoSeq).description
				val duration = computeDuration(desc.location)
				generateVignettes( desc.location, desc.description)
				desc.duration = duration as int
				
				}
				
			}
			
			else {
				val altvid = videoseq as AlternativeVideoSeq
				for (vdesc : altvid.videodescs){
				val duration = computeDuration(vdesc.location)
				generateVignettes( vdesc.location, vdesc.description)
				vdesc.duration = duration as int
				}
				}
				
				 				
			]
			//out.close
	
			
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
				for (vdesc : altvid.videodescs){
				val duration = computeDuration(vdesc.location)
				generateVignettes( vdesc.location, vdesc.description)
				out.write("<img src='"+vdesc.location+"''>")
				vdesc.duration = duration as int
				}
				}
				
				 				
			]
			//out.close
	
			
	}

	
	def static String convertStreamToString(InputStream is){
		val scanner = new Scanner(is).useDelimiter("\\A");
		if(scanner.hasNext()) {scanner.next;}
		else "";	
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
	
	
	def convertPlaylistIntoFormat(Playlist p, String format)
	{
		 
		p.videos.forEach[ video|
			val str = video.location+"."+format
			video.location=str
			
        System.out.println(video.location+"\n")
        
        
			
			
		]
		
		
	}
	
	def void printToHTML(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("<ul>")

		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				generateVignettes(desc.location, desc.videoid)
				pw.println("<img src='" + desc.location + "' />");
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				generateVignettes(desc.location, desc.videoid)
				pw.println("<img src='" + desc.location + "' />");
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs){
					generateVignettes(vdesc.location, vdesc.videoid)
					pw.println("<img src='" + vdesc.location + "' />");
				}
			}
		]
		pw.println("</html>")
		pw.close();
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


	/***
	 * Pick videos by applying probas (for Optional and Alternatives) and return a playlist composed of the picked-up videos
	 * @param VideoGeneratorModel videoGen : videoGenerator model instance
	 */

	def PlaylistModel videoGenToPlaylist(VideoGeneratorModel videoGen) {
		val factory = PlaylistFactoryImpl.eINSTANCE
		val playlist = factory.createPlaylistModel

		videoGen.videoseqs.forEach [ videoseq |

			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) addVideoToPlaylist(factory, playlist, desc);
			} else if (videoseq instanceof OptionalVideoSeq) {

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

				if (altvid.videodescs.size > 0) {

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

	/***
	 * Print a playlist in FFMPEG format
	 * @param PlaylistModel playlist : playlist model instance
	 */
	def void printToFfmpeg(PlaylistModel playlist) {
		playlist.media.forEach [ media |
			if (media instanceof VideoMedia) {
				println("file '" + media.location + "'")

			}
		]
		return playlist
	}


	var s = <String>newArrayList()

	/***
	 * Return an ArrayList of strings containing all paths for a playlist
	 * @param PlaylistModel playlist : playlist model instance
	 */
	def ArrayList<String> printToFfmpegString(PlaylistModel playlist) {
		s = <String>newArrayList()
		playlist.media.forEach [ media |
			if (media instanceof VideoMedia) {
				s.add(media.location)
			}
		]
		return s
	}

	/***
	 * Print a playlist in M3U Extended format
	 * @param PlaylistModel playlist : playlist model instance
	 */

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



	def void printToFfmpeg(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				println ("Mandatory")
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)
					outputPrint(desc.location)   				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				println ("Optional")
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					if(randomNumber() <= desc.probability / 100 as double) outputPrint(desc.location)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					println ("Alternative")
				if (altvid.videodescs.size > 0){
					// there are vid seq alternatives
					var empty = 0
					val double[] arr = newDoubleArrayOfSize(altvid.videodescs.size)
					val alts = <String, Double>newLinkedHashMap()
					for (vdesc : altvid.videodescs) {
						if(!vdesc.videoid.isNullOrEmpty){
							if(vdesc.probability != 0) alts.put(vdesc.location, vdesc.probability / 100 as double)
						}
					}
					
					var iterate = 0
					var previous = 0.00
					for(Double d : alts.values){
						if(d != 0.00){
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
        				if(index == -1 && x < arr.get(v)){
        					outputPrint(alts.keySet().get(v))
        					index = 0
        				}
    				}
				} 
			}
		]
	}
	

	static var i = 0;

	def genID() {
		"v" + i++
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

	/***
	 * Add a video to a playlist
	 * @param PlaylistFactory factory : playlist factory instance
	 * @param PlaylistModel playlist : playlist model instance
	 * @param VideoDescription desc : VideoDescription instance
	 */
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

	/***
	 * Return the video name
	 * @param String s : video path
	 */

	def getVideoName(String s) {
		return s.substring(s.lastIndexOf("/") + 1, s.indexOf("."))
	}


}


	
	def outputPrint(String s){
		println ("file '" + s + "'") 
	}
	
	def randomNumber(){
		var d = Math.random()
		println ("Random: " + d) 
		return d
	}
}

