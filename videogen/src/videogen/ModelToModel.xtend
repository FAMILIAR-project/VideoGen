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
import playList.PlayList
import playList.PlayListFactory

class ModelToModel {
	
	
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
	
	
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
			
		// MODEL 2 MODEL
		// MODEL (video gen) 2 PLAYLIST MODEL
		
		val playlist = PlayListFactory.eINSTANCE.createPlayList
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
			val mediaFile = PlayListFactory.eINSTANCE.createMediaFile
				mediaFile.location = desc.location
				//playlist.files.add(mediaFile)
				
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				//val duration = ffmpeg.camputeDuration(vdesc.location)
				//desc.duration = duration as int
					//ffmpeg.generateThumbmail(vdesc.location,vdesc.videoid)
			
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					//val duration = ffmpeg.camputeDuration(vdesc.location)
					//vdesc.duration = duration as int
					//ffmpeg.generateThumbmail(vdesc.location,vdesc.videoid)
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		 
			
	}
	
}