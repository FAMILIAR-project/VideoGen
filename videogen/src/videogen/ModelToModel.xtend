package videogen

import java.io.File
import java.io.FileWriter
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

class ModelToModel {
	
	
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
	
	

	
	
	
def static printDurationOfVideos() {
			
		var ffmpeg = new FFMPEGHelpere()
     			
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
	
			
		for(videoseq : videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
				
	     	var temps =	ffmpeg.executeCmdGetDuration(desc.location)
	     	
	         	println(temps)
	
			  
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				
					var temps =	ffmpeg.executeCmdGetDuration(desc.location)
	     	
	             	println(temps)
				
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				 
				for (vdesc : altvid.videodescs) {
					
					var temps =	ffmpeg.executeCmdGetDuration(vdesc.location)
	     	
	         	   println(temps)
				
	
			
			}
			
			}
			
			
	}
	
}
	
	
def static printWebPage() {
			
		var ffmpeg = new FFMPEGHelpere()
		var file = new File ("screenShot.html")
	    var filewriter = new FileWriter(file)
     			
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		filewriter.write("<html> <body>" );
			
		for(videoseq : videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
				
	     		ffmpeg.executeCmd(desc.location.toString,desc.location)
				filewriter.write("<div> <img"+ " src = \"screenshot/"+desc.location+".png\""+  " height = \"300px\""
    +" width = \"300px\""+"\"/></div>");
				
			 filewriter.write("</br>" );
			  
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				
				ffmpeg.executeCmd(desc.location.toString,desc.location)
				filewriter.write("<div> <img"+ " src = \"screenshot/"+desc.location+".png\""+  " height = \"300px\""
    +" width = \"300px\""+"\"/></div>");
			   
				filewriter.write("</br>" );
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				 
				filewriter.write("<div> " );
				for (vdesc : altvid.videodescs) {
					
				
				ffmpeg.executeCmd(vdesc.location.toString,vdesc.location)
				filewriter.write("<img"+ " src = \"screenshot/"+vdesc.location+".png\""+  " height = \"300px\""
    +" width = \"300px\""+"\"/>");
				}
				filewriter.write("</div> " );
			
			}
			
			}
			
			filewriter.write("</body></html> " );
			filewriter.flush
            filewriter.close 
			
	}
	

def static void generateGIF(){
	
		var ffmpeg = new FFMPEGHelpere()
	
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
			
		for(videoseq : videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
				
				ffmpeg.executeCmdGIF(desc.location.toString,desc.location)
				
			  
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				

	    	ffmpeg.executeCmdGIF(desc.location.toString,desc.location)

					
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)

				for (vdesc : altvid.videodescs) {
					
				ffmpeg.executeCmdGIF(vdesc.location.toString,vdesc.location)
	
			
			}
			
			}
}
}

def static void incrustText(){
	
		
		var ffmpeg = new FFMPEGHelpere()
	
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
			
		for(videoseq : videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
				
				if(!desc.textIncrust.isNullOrEmpty)
				ffmpeg.executeCmdIncrustText(desc.location.toString,"incr1",desc.textIncrust)
				
			  
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				

               if(!desc.textIncrust.isNullOrEmpty)
	    	   ffmpeg.executeCmdIncrustText(desc.location.toString,"incr4",desc.textIncrust)

					
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)

				for (vdesc : altvid.videodescs) {
				
				if(!vdesc.textIncrust.isNullOrEmpty)	
				ffmpeg.executeCmdIncrustText(vdesc.location.toString,"incr3",vdesc.textIncrust)
	
			
			}
			
			}
}
	
}

/*
def static void filters(){
	
		
		var ffmpeg = new FFMPEGHelpere()
	
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
			
		for(videoseq : videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
				if((!desc.filter.isNullOrEmpty) &&("blackandwhite".equals(desc.filter)) )
				{
				  ffmpeg.executeCmdFilterBlackAndWhite(desc.location.toString,"blkw1")
				  
				}
				
				if((!desc.filter.isNullOrEmpty) &&("lighter".equals(desc.filter)) )
				{
	
				ffmpeg.executeCmdFilterLighter(desc.location.toString,"lgtr1")}
	
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description

				if((!desc.filter.isNullOrEmpty) &&("blackandwhite".equals(desc.filter)) )
				{
				  ffmpeg.executeCmdFilterBlackAndWhite(desc.location.toString,"blkw1")
				  
				}
				
				if((!desc.filter.isNullOrEmpty) &&("lighter".equals(desc.filter)) )
				{
	
				ffmpeg.executeCmdFilterLighter(desc.location.toString,"lgtr1")}
	
					
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)

				for (vdesc : altvid.videodescs) {
	
				if((!vdesc.filter.isNullOrEmpty) &&("blackandwhite".equals(vdesc.filter)) )
				{
				  ffmpeg.executeCmdFilterBlackAndWhite(vdesc.location.toString,"blkw1")
				  
				}
				
				if((!vdesc.filter.isNullOrEmpty) &&("lighter".equals(vdesc.filter)) )
				{
	
				ffmpeg.executeCmdFilterLighter(vdesc.location.toString,"lgtr1")}
	
				}
			
			
			}
}
	
}*/


def public static void main(String[] args){
	
	printDurationOfVideos()
	
	 //printWebPage()
	  
	// generateGIF()
}
}