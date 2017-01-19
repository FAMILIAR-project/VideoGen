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
import java.nio.file.Paths

class VideoGenVignettesGenerator {
	
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
	modelToVignettes(videoGen)
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
	
	def void modelToVignettes(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				genVignette(desc.location);
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(Math.random()*1>0.5){
					genVignette(desc.location);
				}
			}
			else{
				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videodescs.size > 0){ // there are vid seq alternatives
					var i = (Math.random()*altvid.videodescs.size)
					genVignette((altvid.videodescs.get(i as int).location));
				}
			}
		]
	}
	
	def genVignette(String path) {
		var cmd = "ffmpeg -y -i "+path+" -r 1 -t 00:00:01 -f image2 "+Paths.get(path).getParent().getFileName().toString()+"/vignette-"+Paths.get(path).getFileName().toString().replaceFirst("[.][^.]+$", "")+".png";
		var r = Runtime.getRuntime();
		var p = r.exec(cmd);
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
}