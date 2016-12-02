package videogen

import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import java.util.HashMap
import java.util.ArrayList
import java.util.Random
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.nio.file.Files
import java.nio.file.Paths

class Question2 {
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
	
	def static main(String[] args)
	{
		
	}
}