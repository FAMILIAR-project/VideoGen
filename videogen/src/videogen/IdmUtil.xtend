package videogen

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.Writer
import playlist.Playlist
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import java.util.Random
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayList
import java.io.File
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import java.util.HashMap
import static org.junit.Assert.*

class IdmUtil {
	static Writer writer
	
	def static loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def static saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}
	
	/**
	 * Create a file
	 */
	def static void createFile(String filename, String content) {
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"));
			writer.write(content);
		} catch (IOException ex) {
			System.out.println(ex.message)
		} finally {
			try {
				writer.close();
			} catch (Exception ex) { /*ignore*/
			}
		}
	}
	

	/**
	 * Generate playlist from a videogen model
	 */
	def static void checkVideoGen(VideoGeneratorModel videoGen) {
		assertNotNull(videoGen)
		// test lists
		var locationList = new ArrayList<String>()
		var probabilitiesSum = 0
		
		for (videoseq : videoGen.videoseqs) {
			// mandatory
			if (videoseq instanceof MandatoryVideoSeq) {	
				// test location
				var location = videoseq.description.location
				assertFalse(locationList.contains(location))
				locationList.add(location)		
			}

			// optional
			if (videoseq instanceof OptionalVideoSeq) {
				// test probability
				var probability = videoseq.description.probability
				assertFalse(probability < 0)
				assertFalse(probability > 100)
				assertFalse(probability + probabilitiesSum > 100)
				probabilitiesSum += probability
				
				// test location
				var location = videoseq.description.location
				assertFalse(locationList.contains(location))
				locationList.add(location)
			}

			// alternatives
			if (videoseq instanceof AlternativeVideoSeq) {
				val atlVideoSeq = (videoseq as AlternativeVideoSeq)

				// loop over alt videos
				for(videoseqAlt: atlVideoSeq.videodescs) {		
					// test location
					var location = videoseqAlt.location
					assertFalse(locationList.contains(location))
					locationList.add(location)
				}
			}
		}
	}
	
	/**
	 * Get duration of a video
	 */
	def static double getDuration(String videoLocation) {
		// exec ffmpeg command
		var cmd = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation
		var result = Runtime.runtime.exec(cmd)
		
		// convert to String
		var bufferReader = new BufferedReader(new InputStreamReader(result.inputStream))
		var stringBuilder = new StringBuilder();
		var line = "";
		while ( (line = bufferReader.readLine()) != null) {
		   stringBuilder.append(line);
		}
		var resultString = stringBuilder.toString();

		// parse to double
		return Double.parseDouble(resultString)
	}
	
	/**
	 * Create a vignette for a video
	 */
	def static String createVignette(String videoLocation, String filename) {
		var vignettesLocation = "/home/paul/Vidéos/idm/vignettes/"
		
		// exec ffmpeg command		
		var cmd = "ffmpeg -i " + videoLocation + " -ss 00:00:01.000 -vframes 1 " + vignettesLocation + filename + ".png -y"
		var result = Runtime.runtime.exec(cmd)
		result.waitFor()
		
		return vignettesLocation + filename + ".png"
	}
	
	static var i = 0;

	def static String genID() {
		"v" + i++
	}
	
	def static String getFilenameWithoutExtension(String fileLocation) {
		return new File(fileLocation).getName().replaceFirst("[.][^.]+$", "")
	}
	
	def static String getFilenameWithExtension(String fileLocation) {
		return new File(fileLocation).getName()
	}
	
	def static String getFilLocationWithoutExtension(String fileLocation) {
		return fileLocation.replaceFirst("[.][^.]+$", "")
	}
	
}