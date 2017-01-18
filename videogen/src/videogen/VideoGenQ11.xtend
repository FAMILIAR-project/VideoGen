package videogen

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq

class VideoGenQ11 {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	@Test
	def void checkConformity() {
		var videoGen = loadVideoGenerator(URI.createURI("foo4.videogen")) 
		checkLocation(videoGen)
		checkIdentifiers(videoGen)
		checkProbability(videoGen)
	}
	
	def checkLocation(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					checkLocation(desc.location, videoGen)
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					checkLocation(desc.location, videoGen)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if(!vdesc.location.isNullOrEmpty) {
						checkLocation(vdesc.location, videoGen)
					}
				}
			}
		]
	}
	
	def checkLocation(String location, VideoGeneratorModel videoGen) {
		i = 0
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  {
					if (desc.videoid == location) {
						i++;
					}
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) {
					if (desc.videoid == location) {
						i++;
					}
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if(vdesc.location.isNullOrEmpty) {
						if (vdesc.videoid == location) {
							i++;
						}
					}
				}
			}
		]
		if (i>1) {
			println("error : location checks : the same video location was found more than once ! " + location)
		}
		else {
			println("info : location checks : no problem found on the video location : " + location)
		}
	}
	
	def checkIdentifiers(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  {
					checkIdentifiers(desc.videoid, videoGen)
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) {
					checkIdentifiers(desc.videoid, videoGen)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if(!vdesc.videoid.isNullOrEmpty) {
						checkIdentifiers(vdesc.videoid, videoGen)
					}
				}
			}
		]
	}
	static var i = 0
	def checkIdentifiers(String videoid, VideoGeneratorModel videoGen) {
		i = 0
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  {
					if (desc.videoid == videoid) {
						i++;
					}
				} 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) {
					if (desc.videoid == videoid) {
						i++;
					}
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) {
						if (vdesc.videoid == videoid) {
							i++;
						}
					}
				}
			}
		]
		if (i>1) {
			println("error : identifier checks : the same video was found more than once ! " + videoid)
		}
		else {
			println("info : identifier checks : no problem found on the identifier " + videoid)
		}
	}
	
	def checkProbability(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				// nothing to do				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (desc.probability <100){
					println("error : probability checks : optional video with more than 100% probability ! " + desc.videoid)
				}
				else {
					println("info : probability checks : optional video with less than 100% probability : " + desc.videoid)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var sizeAll = 0;
				for (vdesc : altvid.videodescs) {
					sizeAll += vdesc.probability;
				}
				if (sizeAll <100){
					println("error : probability checks : alternative video with more than 100% probability ! " + sizeAll)
				}
				else {
					println("info : probability checks : alternative video with less than 100% probability : " + sizeAll)
				}
			}
		]
	}
	
	
}