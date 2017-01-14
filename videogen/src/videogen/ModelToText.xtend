package videogen

import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.io.FileWriter
import java.io.File
import java.io.BufferedWriter

class ModelToText {

	
	def static loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri); 
		rs.getContents.add(pollS); 
		rs.save(new HashMap());
	}
	
	def transform(VideoGeneratorModel videoGen){
		
	}

/* 
def public static void main(String[] args){
	
	 
	  var title = "foo3.videogen"
			
	   var  data="# this is a comment\n"
			
		var videoGen = loadVideoGenerator(URI.createURI(title)) 
			
	
	
			for(videoseq : videoGen.videoseqs){
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  
				
					data+="file "+desc.location+"\n"				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) 
				
				if (new Random().nextInt(1) == 0)
							data+="file "+desc.location+"\n"		
			}
			else {
				
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					data+="file "+altvid.videodescs.get(new Random().nextInt(altvid.videodescs.size)).location+"\n"
			}
		}
	
	  var file = new File ("result.txt")
	  var filewriter = new FileWriter(file)
      filewriter.write( data );
      filewriter.flush
      filewriter.close
	

	
}

*/

def public static void main(String[] args){
	
	 
	  var title = "foo3.videogen"
			
	   var  data="# this is a comment\n"
			
		var videoGen = loadVideoGenerator(URI.createURI(title)) 
			
	
	
			for(videoseq : videoGen.videoseqs){
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  
				
					data+="file "+desc.location+"\n"				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.location.isNullOrEmpty) 
				
				if (new Random().nextInt(1) == 0)
							data+="file "+desc.location+"\n"		
			}
			else {
				
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					data+="file "+altvid.videodescs.get(new Random().nextInt(altvid.videodescs.size)).location+"\n"
			}
		}
	
	var file = new File ("result.txt")
	 var filewriter = new FileWriter(file)
      filewriter.write( data );
      filewriter.flush
      filewriter.close
	

	
}


}