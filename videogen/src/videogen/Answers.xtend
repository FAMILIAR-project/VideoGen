package videogen

import java.util.ArrayList
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.junit.Test
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*

class Answers {

	@Test
	def test1() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("foo2.videogen"))
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
		IdmUtil.saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
		IdmUtil.saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)

		printToHTML(videoGen)

	}

	@Test
	def quest1Ffmg() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("foo2.videogen"))
		// check videogen
		IdmUtil.checkVideoGen(videoGen)

		var ffmpegStr = ""
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val location = (videoseq as MandatoryVideoSeq).description.location
				ffmpegStr += "file '" + location + "'\n"
			}

			if (videoseq instanceof OptionalVideoSeq) {
				val i = new Random().nextInt(2)

				if (i == 0) {
					val location = (videoseq as OptionalVideoSeq).description.location
					ffmpegStr += "file '" + location + "'\n"
				}

			}

			if (videoseq instanceof AlternativeVideoSeq) {
				val atlVideoSeq = (videoseq as AlternativeVideoSeq)
				val size = atlVideoSeq.videodescs.size

				if (size > 1) {
					val location = atlVideoSeq.videodescs.get(new Random().nextInt(size)).location
					ffmpegStr += "file '" + location + "'\n"
				} else {
					val location = atlVideoSeq.videodescs.get(0).location
					ffmpegStr += "file '" + location + "'\n"
				}
			}
		}

		IdmUtil.createFile("quest_files_gen/quest2Ffmpeg.txt", ffmpegStr)
	}
	
	
	
	
	
	
	@Test
	def quest9_10() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("videos.videogen"))
		// check videogen
		IdmUtil.checkVideoGen(videoGen)

		// html string
		var html = "<!DOCTYPE html><html><body>"
		
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for (videoseq : videoGen.videoseqs) {
			// mandatory
			if (videoseq instanceof MandatoryVideoSeq) {
				// create mediaFile with location, videoid and duration
				var location = videoseq.description.location
				var filename = videoseq.description.videoid
				
				// write to file
				html += "<p><b>Mandatory</b></p>
						<img src = " + IdmUtil.createVignette(location, filename) + " width='150px' height=auto/><br/>"
			}

			// optional
			if (videoseq instanceof OptionalVideoSeq) {
				
				var location = videoseq.description.location
				var filename = videoseq.description.videoid
			
				// write to file
				html += "<p><b>Optional</b></p>
						<img src = " + IdmUtil.createVignette(location, filename) + " width='150px' height=auto/><br/>"
			}

			// alternatives
			if (videoseq instanceof AlternativeVideoSeq) {
				val atlVideoSeq = (videoseq as AlternativeVideoSeq)
				
				html += "<p><b>Alternatives</b></p>"
				// loop over alt videos
				for(videoseqAlt: atlVideoSeq.videodescs) {
					var location = videoseqAlt.location
					var filename = videoseqAlt.videoid
				
					// write to file
					html += "<img src = " + IdmUtil.createVignette(location, filename) + " width='150px' height=auto/><br/>"
				}
			}
		}
		
		html += "</html></body>"
		// create file
		IdmUtil.createFile("quest_files_gen/quest9_10.html", html)
	}
	
	@Test
	def quest11() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("videos.videogen"))
		// check videogen
		IdmUtil.checkVideoGen(videoGen)
		
		var idList = new ArrayList<String>()
		var probabilitiesSum = 0
		
		// html string
		var html = "<!DOCTYPE html><html><body>"
		
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		for (videoseq : videoGen.videoseqs) {
			// mandatory
			if (videoseq instanceof MandatoryVideoSeq) {	
				// test id
				var id = videoseq.description.videoid
				if (id.isNullOrEmpty || idList.contains(id)) {
					id = genID()
				}
				// add id to list
				idList.add(id)
				
				// test location
				var location = videoseq.description.location

				// write to file
				html += "<p><b>Mandatory</b></p>
						<img src = " + IdmUtil.createVignette(location, id) + " width='150px' height=auto/><br/>"
			
			}

			// optional
			if (videoseq instanceof OptionalVideoSeq) {
				// test probability
				var probability = videoseq.description.probability
				
				// proba
				val i = new Random().nextInt(100/probability) == 0
				if (i) {
					
				}

				// test id
				var id = videoseq.description.videoid
				if (id.isNullOrEmpty || idList.contains(id)) {
					id = genID()
				}
				// add id to list
				idList.add(id)
				
				// test location
				var location = videoseq.description.location

				// write to file
				html += "<p><b>Optional : probability = 1/" + 100/probability + "</b></p>
							<img src = " + IdmUtil.createVignette(location, id) + " width='150px' height=auto/><br/>"
			}

			// alternatives
			if (videoseq instanceof AlternativeVideoSeq) {
				val atlVideoSeq = (videoseq as AlternativeVideoSeq)
				
				html += "<p><b>Alternatives</b></p>"
				// loop over alt videos
				for(videoseqAlt: atlVideoSeq.videodescs) {
					// test id
					var id = videoseqAlt.videoid
					if (id.isNullOrEmpty || idList.contains(id)) {
						id = genID()
					}
					// add id to list
					idList.add(id)
					
					// test location
					var location = videoseqAlt.location
	
					// write to file
					html += "<img src = " + IdmUtil.createVignette(location, id) + " width='150px' height=auto/><br/>"
				}
			}
		}
		
		html += "</html></body>"
		// create file
		IdmUtil.createFile("quest_files_gen/quest11.html", html)
	}
	
	@Test
	def quest11failProba() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("videos-fail-proba.videogen"))
		// check videogen
		IdmUtil.checkVideoGen(videoGen)
	}
	
	@Test
	def quest11failLocation() {
		// loading
		var videoGen = IdmUtil.loadVideoGenerator(URI.createURI("videos-fail-location.videogen"))
		// check videogen
		IdmUtil.checkVideoGen(videoGen)
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
