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
import java.util.Random

class DurationComputation {
	//Partie 3
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
				//var cmd = "/usr/local/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " + videoLocation
				val duration = computeDuration(vid.description.location) //<-- calculer la durée
				vid.description.duration = duration
			}
			if (vid instanceof OptionalVideoSeq){
				val duration = computeDuration(vid.description.location) //<-- calculer la durée
				vid.description.duration = duration
			}
			if (vid instanceof AlternativeVideoSeq){
				for (videodesc:vid.videodescs){
					val duration = computeDuration(videodesc.location)
					videodesc.duration = duration as int
				}

			}
		]
		saveVideoGenerator(out,videogen)
	}
	
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
		var cmd = "/usr/bin/ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i \"" + videoLocation+"\""
		var Process process = Runtime.getRuntime().exec(cmd)
		process.waitFor()
		process.getInputStream().read
		}
		
	def static void main(String[] args) {
		val dc = new DurationComputation
		val fin = URI.createURI("foo2.videogen")
		val fout = URI.createURI("foo2duration.videogen")
		val m3uext = "foo2.m3u"
		dc.durationCompute(fin,fout)
		dc.modelToM3UExtended(fout,m3uext)
	}
}