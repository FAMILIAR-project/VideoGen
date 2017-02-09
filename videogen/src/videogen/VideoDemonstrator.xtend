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

import org.xtext.example.mydsl.PlaylistStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.PlaylistGeneratorModel
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.playlist.impl.PlaylistFactoryImpl
import org.xtext.example.mydsl.playlist.Mediafile

import static org.junit.Assert.*
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

class VideoDemonstrator {

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
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
	}
	
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