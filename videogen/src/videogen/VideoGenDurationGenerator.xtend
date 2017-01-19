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
import java.io.InputStreamReader
import java.io.BufferedReader
import java.util.Scanner
import java.util.regex.Pattern

class VideoGenDurationGenerator {
	
	@Test
	def generateDuration(){
		var videoGen = loadVideoGenerator(URI.createURI("videos/montage.videogen")) 
		assertNotNull(videoGen)
		assertEquals(3, videoGen.videoseqs.size)			
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
	saveVideoGenerator(URI.createURI("videos/montage.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("videos/montage.videogen"), videoGen)
		
	//printToHTML(videoGen)	
	modelToTextM3U(videoGen)
	}
	
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
	
	def void modelToTextM3U(VideoGeneratorModel videoGen){
		println("#EXTM3U\n")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				println("#EXTINF:"+genDuration(desc.location)+"\n"+desc.location+'\n')
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(Math.random()*1>0.5){
					println("#EXTINF:"+genDuration(desc.location)+"\n"+desc.location+'\n')
					
				}
			}
			else{
				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videodescs.size > 0){ // there are vid seq alternatives
					var i = (Math.random()*altvid.videodescs.size)
					println("#EXTINF:"+genDuration(altvid.videodescs.get(i as int).location)+"\n"+altvid.videodescs.get(i as int).location+'\n')
				}
			}
		]		
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
	def int genDuration(String path){
		var cmd = "ffprobe -i "+path;
		var r = Runtime.getRuntime();
		var p = r.exec(cmd);
		var sc = new Scanner(p.getErrorStream());
		
        // Find duration
        var durPattern = Pattern.compile("(?<=Duration: )[^,]*");
        var dur = sc.findWithinHorizon(durPattern, 0);
        if (dur == null)
          throw new RuntimeException("Could not parse duration.");
        var String[] hms = dur.split(":");
        var totalSecs = Integer.parseInt(hms.get(0)) * 3600
                         + Integer.parseInt(hms.get(1)) *   60
                         + Double.parseDouble(hms.get(2));
		return totalSecs as int;
	}
}