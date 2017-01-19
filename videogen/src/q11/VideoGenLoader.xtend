package q11

import java.util.HashMap
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import q8.VideoReparator
import java.nio.file.Paths

/**
 * Check VideoGenModel
 */
public class VideoGenLoader {
	
	public VideoGeneratorModel videoGen
	
	/**
	 * Load
	 */
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	/**
	 * Save
	 */
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	@Test
	def void generate() {
		
		// Loading
		var videoReparator = new VideoReparator()
		var videoGen =videoReparator.getRepair()	
		
		checkID(videoGen)
		checkProbability(videoGen)
		
	}
	
	def VideoGeneratorModel load(String path){
		// Loading
		var videoReparator = new VideoReparator()
		var videoGen =videoReparator.getRepaired(path)
		
		checkID(videoGen)
		checkProbability(videoGen)
		
		videoGen
	}
	
	def save(VideoGeneratorModel videoGen, String path){
		saveVideoGenerator(URI.createURI(path),videoGen)
	}

	def printWarning(String text){
		println("Warning : " + text)
	}
	
	
	
	def boolean checkID(VideoGeneratorModel videoGen){
		for(videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(containID(videoGen, desc)){
					printWarning("Two same id -> \'"+desc.videoid+"\'")
					return true
				}
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(containID(videoGen, desc)){
					printWarning("Two same id -> \'"+desc.videoid+"\'")
					return true
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(containIDAlt(videoGen, altvid)){
					printWarning("Two same id -> \'"+altvid.videoid+"\'")
					return true
				}
				for (vdesc : altvid.videodescs) {
					if(containID(videoGen, vdesc)){
						printWarning("Two same id -> \'"+vdesc.videoid+"\'")
						return true
					}
				}
				
			}
		}
		false
	}
	
	def boolean containID(VideoGeneratorModel videoGen,VideoDescription descVid){
		for(videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc!=descVid){
					if(desc.videoid.equals(descVid.videoid)){
						return true
					}
				}
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc!=descVid){
					if(desc.videoid.equals(descVid.videoid)){
						return true
					}
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if(vdesc!=descVid){
					if(vdesc.videoid.equals(descVid.videoid)){
						return true
					}
				}
				}
				
			}
		}
		false
	}
	
	def boolean containIDAlt(VideoGeneratorModel videoGen,AlternativeVideoSeq alt){
		for(videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.equals(alt.videoid)){
					return true
				}
				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.equals(alt.videoid)){
					return true
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid!=alt){
					if(altvid.videoid.equals(alt.videoid)){
						return true
					}
				}
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.equals(alt.videoid)){
						return true
					}
				}
				
			}
		}
		false
	}
	
	
	
	def boolean checkProbability(VideoGeneratorModel videoGen){
		for(videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.probability>100){
					printWarning("Probality -> "+desc.probability+" for video \'"+desc.videoid+"\'")
					return true
				}
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.probability>100){
					printWarning("Probality -> "+desc.probability+" for video \'"+desc.videoid+"\'")
					return true
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var prob=0;
				for (vdesc : altvid.videodescs) {
					if(vdesc.probability>100){
						printWarning("Probality -> "+vdesc.probability+" for video \'"+vdesc.videoid+"\'")
						return true
					}
					prob+=vdesc.probability
					if(prob>100){
						printWarning("Video probability for alternative \""+altvid.videoid+"\" > 100")
						return true
					}
				}
				
			}
		}
		false
	}
	
		
}
	
	
	
