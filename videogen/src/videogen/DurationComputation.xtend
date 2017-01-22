package videogen

import java.io.FileWriter
import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.ecore.resource.Resource
import java.util.HashMap
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
<<<<<<< dd208ae18ad03eccf30f4fdb6d0b722a7f793ca6
import java.util.Random
import java.io.BufferedReader
import java.io.InputStreamReader

class DurationComputation {
	//Partie 3
=======

//import org.xtext.example.mydsl.videoGen.VideoGenFactory

class DurationComputation {
	
>>>>>>> jusqu'à Q7
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
	
	def durationCompute(URI in, URI out){
		var videogen = loadVideoGenerator(in)
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
<<<<<<< dd208ae18ad03eccf30f4fdb6d0b722a7f793ca6
=======
				//var cmd = "/usr/local/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation
>>>>>>> jusqu'à Q7
				val duration = computeDuration(vid.description.location) //<-- calculer la durée
				vid.description.duration = duration
			}
			if (vid instanceof OptionalVideoSeq){
				val duration = computeDuration(vid.description.location) //<-- calculer la durée
				vid.description.duration = duration
			}
			if (vid instanceof AlternativeVideoSeq){
				for (videodesc:vid.videodescs){
<<<<<<< dd208ae18ad03eccf30f4fdb6d0b722a7f793ca6
					val duration = computeDuration(videodesc.location)
					videodesc.duration = duration
				}
=======
					val duration = computeDuration(videodesc.description.)
					videodesc.description.duration = duration as int
				}

>>>>>>> jusqu'à Q7
			}
		]
		saveVideoGenerator(out,videogen)
	}
	
<<<<<<< dd208ae18ad03eccf30f4fdb6d0b722a7f793ca6
	def modelToM3UExtended(URI in,String out){
		var mod = loadVideoGenerator(in)
		val fout = new FileWriter(out)
		val rnd = new Random()
		mod.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				fout.write("#EXT-X-DISCONTINUITY\n")
				fout.write("#EXTINF:"+vid.description.duration+"\n")
				fout.write(vid.description.location+"\n")
			}
			if (vid instanceof OptionalVideoSeq){
				if (rnd.nextBoolean()){
					fout.write("#EXT-X-DISCONTINUITY\n")
					fout.write("#EXTINF:"+vid.description.duration+"\n")
					fout.write(vid.description.location+"\n")
				}
			}
			if (vid instanceof AlternativeVideoSeq){
				var n = rnd.nextInt(vid.videodescs.size)
				fout.write("#EXT-X-DISCONTINUITY\n")
				fout.write("#EXTINF:"+vid.videodescs.get(n).duration+"\n")
				fout.write(vid.videodescs.get(n).location+"\n")
			}
		]
		fout.write("#EXT-X-ENDLIST")
		fout.close()
	}
	
	
	def int computeDuration(String videoLocation){
		var cmd = "/usr/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation
		var Process process = Runtime.getRuntime().exec(cmd)
		process.waitFor()
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		var String line = "";
		var String outputJson = "";
	    while ((line = reader.readLine()) != null) {
	        outputJson = outputJson + line;
	    }
	    if (process.exitValue()==1){
	    	println(videoLocation)
	    }
	    return Math.round(Float.parseFloat(outputJson))-1;
		}
		
	def static void main(String[] args) {
		val dc = new DurationComputation
		val fin = URI.createURI("perso.videogen")
		val fout = URI.createURI("persoduration.videogen")
		val m3uext = "perso.m3u"
		dc.durationCompute(fin,fout)
		dc.modelToM3UExtended(fout,m3uext)
=======
	def int computeDuration(String videoLocation){
		var cmd = "/usr/local/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation
		var Process process = Runtime.getRuntime().exec(cmd)
		process.waitFor()
		}
		
	def void generateThumbnail(String videoLocation, String name){
		var cmd = "/usr/local/bin/ffmpeg -i " + videoLocation + " -ss 00:00:01.000 -vframes 1 " + "/thumb" + name + ".jpg -y"
		var Process process = Runtime.getRuntime().exec(cmd)
		process.waitFor()
	}
	
	def static void main(String[] args) {
		val dc = new DurationComputation
		val fin = URI.createURI("foo2.videogen")
		val fout = URI.createURI("foo2duration.videogen")
		dc.durationCompute(fin,fout)
>>>>>>> jusqu'à Q7
	}
}