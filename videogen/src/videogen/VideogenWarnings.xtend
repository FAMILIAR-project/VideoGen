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
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.io.BufferedWriter
import videogenPlaylist.impl.VideogenPlaylistFactoryImpl
import java.util.concurrent.TimeUnit
import org.xtext.example.mydsl.videoGen.VideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.util.List
import java.util.ArrayList

/**
 * Vignettes
 */
class VideogenWarnings {
	
	String thumbnail = ""
	List thumbsId = new ArrayList<Integer>();
	List thumbsPath = new ArrayList<String>();

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


	def static String createThumbnail(String path, String filename) {
			
		var String cmdThumbnail = "C:\\Users\\Robin\\Desktop\\ffmpeg-3.2.2-win64-static\\bin\\ffmpeg -i " + path + " -ss 00:00:01.000 -vframes 1 thumbnails/" + filename + "1.png"
			
		var Process process = Runtime.getRuntime().exec(cmdThumbnail);
		process.waitFor(2000, TimeUnit.MILLISECONDS);

		return filename + "1.png"
	}

	@Test
	def test() {
		var videoGen = loadVideoGenerator(URI.createURI("testVideos.videogen"))
		var factory = new VideogenPlaylistFactoryImpl()
		var playlist= factory.createPlaylist()
		assertNotNull(videoGen)

		for (VideoSeq video : videoGen.videoseqs) {
			// mandatory
			if (video instanceof MandatoryVideoSeq) {
				val path = (video as MandatoryVideoSeq).description.location;
				var id = (video as MandatoryVideoSeq).description.videoid;
				if(id.isNullOrEmpty) id = genID()

				var mediafile = factory.createMediaFile()
				mediafile.path = path

				thumbnail += "<img src = " + videogen.VideogenToThumbnails.createThumbnail(path, id) + " width='400px' height=auto/><br/>"

				if (thumbsPath.contains(mediafile.path)) {
						thumbnail += "<p>Cette video obligatoire existe deja" + "<b>" + mediafile.path + "</b>" +"</p>"
					} else if (thumbsId.contains(id)) {
						thumbnail += "<p>L'identifiant de cette video obligatoire n'est pas unique" + "<b>" + id + "</b>" +"</p>"
					} else {
						thumbsPath.add(mediafile.path)
						thumbsId.add(id)
						playlist.mediaFile.add(mediafile)
					}
				
			// optional
			} else if (video instanceof OptionalVideoSeq) {
					val path = (video as OptionalVideoSeq).description.location;
					var id = (video as OptionalVideoSeq).description.videoid;
					if(id.isNullOrEmpty) id = genID()

					var mediafile = factory.createMediaFile()
					mediafile.path = path
					
					thumbnail += "<img src= " + videogen.VideogenToThumbnails.createThumbnail(path, id) + " width='400px' height=auto/><br/>"
					
					if (thumbsPath.contains(mediafile.path)) {
						thumbnail += "<p>Cette video optionelle existe deja" + "<b>" + mediafile.path + "</b>" +"</p>"
					} else if (thumbsId.contains(id)) {
						thumbnail += "<p>L'identifiant de cette video optionelle n'est pas unique" + "<b>" + id + "</b>" +"</p>"
					} else {
						thumbsPath.add(mediafile.path)
						thumbsId.add(id)
						playlist.mediaFile.add(mediafile)
					}
														
			// alternatives
			} else {				
				for (VideoDescription alt : (video as AlternativeVideoSeq).videodescs) {
					var path = alt.location;
					var id = alt.videoid
					if(id.isNullOrEmpty) id = genID()
					
					var mediafile = factory.createMediaFile()
					mediafile.path = path
					thumbnail += "<img src=" + videogen.VideogenToThumbnails.createThumbnail(path, id) + " width='400px' height=auto/><br/>"
					
					if (thumbsPath.contains(mediafile.path)) {
						thumbnail += "<p>Cette video alternative existe deja" + "<b>" + mediafile.path + "</b>" +"</p>"
					} else if (thumbsId.contains(id)) {
						thumbnail += "<p>L'identifiant de cette video alternative n'est pas unique" + "<b>" + id + "</b>" +"</p>"
					} else {
						thumbsPath.add(mediafile.path)
						thumbsId.add(id)
						playlist.mediaFile.add(mediafile)
					}
				}
			}
		}

		try {
			val file = new File("thumbnails/thumbnailsQ9.html");
			if (!file.exists()) {
				file.createNewFile();
			} else {
				file.delete();
			}
			val fw = new FileWriter(file.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write("<!DOCTYPE html> \n");
			bw.write("<head> \n");
			bw.write("<link rel=\"stylesheet\" href=\"style.css\"/> \n");
			bw.write("</head> \n");
			bw.write("<body> \n");
			bw.write(thumbnail  + "\n");
			bw.write("</body> \n");
			bw.write("</html> \n");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace
		}
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}

}