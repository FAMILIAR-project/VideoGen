package videogen

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.common.util.URI
import org.junit.Test
import static org.junit.Assert.*
import java.util.ArrayList
import java.util.logging.Logger

class Specifications {
	
	private static final Logger LOGGER = Logger.getLogger(Specifications.getClass().getName());
	
	var locationList = new ArrayList<String>();
	var nameList = new ArrayList<String>();

	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

	@Test
	def CheckSpecs() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen"))
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		
		
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				
				var path = (videoseq as MandatoryVideoSeq).description.location
				var name = (videoseq as MandatoryVideoSeq).description.videoid
				
				if(locationList.contains(path)){
					LOGGER.warning("duplicate use of path: "+path);
				}
				locationList.add(path);
				
				if((name!=null)&&nameList.contains(name)){
					LOGGER.warning("duplicate id for video: "+name);
				}
				if(name!=null)nameList.add(name);
			} else if (videoseq instanceof OptionalVideoSeq) {
				
				var path = (videoseq as OptionalVideoSeq).description.location
				var name = (videoseq as OptionalVideoSeq).description.videoid
				
				if(locationList.contains(path)){
					LOGGER.warning("duplicate use of path: "+path);
				}
				locationList.add(path);
				
				if((name!=null)&&nameList.contains(name)){
					LOGGER.warning("duplicate id for video: "+name);
				}
				if(name!=null)nameList.add(name);
				
				
				if((videoseq as OptionalVideoSeq).description.probability>100){
					LOGGER.severe("probability >100 for video: "+name);
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					var path = vdesc.location
					var name = vdesc.videoid
					
					if(locationList.contains(path)){
						LOGGER.warning("duplicate use of path: "+path);
					}
					locationList.add(path);
					
					if((name!=null)&&nameList.contains(name)){
						LOGGER.warning("duplicate id for video: "+name);
					}
					if(name!=null)nameList.add(name);
				}
			}
		]
	}
}
