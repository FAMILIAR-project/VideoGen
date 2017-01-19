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
import java.util.Random
import playList.MediaFile
import java.io.File
import java.io.FileWriter

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
	
	
	def static modelToPlayList() {
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
			    playlist.vids.add(mediaFile);
				
				
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				
				val i = new Random().nextInt(2)
				if(i==0){
				
				val mediaFile = PlayListFactory.eINSTANCE.createMediaFile
				mediaFile.location = desc.location
			    playlist.vids.add(mediaFile);
				
					
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				 
				val j = new Random().nextInt(altvid.videodescs.size)
				val vid = altvid.videodescs.get(j)
				
				val mediaFile = PlayListFactory.eINSTANCE.createMediaFile
				mediaFile.location = vid.location
			    playlist.vids.add(mediaFile);
				
			
			}
		]
	//val playlistOnString = convertPlaylistIntoFormat(playlist, "M3U")
	val playlistOnString = convertPlaylistIntoFormat(playlist, "txt")
		
	// var file = new File ("playlist.m3u")
	var file = new File ("ffmpeg.txt")
	 var filewriter = new FileWriter(file)
      filewriter.write( playlistOnString );
      filewriter.flush
      filewriter.close 
			
	}
	
	def static convertPlaylistIntoFormat(PlayList playlist,String ext) {
		
		var ffmpeg = new FFMPEGHelpere()
		var data =""
		
		if("M3U".equals(ext)){
			
			val vids = playlist.vids
			for(MediaFile f : vids){
				
				data += f.location+'\n'
				
			}
			
			
		}
		if ("txt".equals(ext)){
			
				val vids = playlist.vids
			for(MediaFile f : vids){
				
				data +="file '"+f.location+"'"+'\n'
				
			}
			
		}
		data
		
	}
	
	def static modelToPlayListWithScreenShot() {
		var ffmpeg = new FFMPEGHelpere()
	
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
			

		val playlist = PlayListFactory.eINSTANCE.createPlayList
		for(videoseq : videoGen.videoseqs){
		//videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
			val desc = (videoseq as MandatoryVideoSeq).description
			val mediaFile = PlayListFactory.eINSTANCE.createMediaFile
				mediaFile.location = desc.location
				
				ffmpeg.executeCmd(desc.location.toString,"v1")
				
			    playlist.vids.add(mediaFile);
			  
				}
			
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				
				val i = new Random().nextInt(2)
				if(i==0){
				
				val mediaFile = PlayListFactory.eINSTANCE.createMediaFile
				mediaFile.location = desc.location
				ffmpeg.executeCmd(desc.location.toString,"v2")
			    playlist.vids.add(mediaFile);
				
					
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				 
				val j = new Random().nextInt(altvid.videodescs.size)
				val vid = altvid.videodescs.get(j)
				
				val mediaFile = PlayListFactory.eINSTANCE.createMediaFile
				mediaFile.location = vid.location
				ffmpeg.executeCmd(vid.location.toString,"v3")
			    playlist.vids.add(mediaFile);
				
			
			}
			
			}
		
	//val playlistOnString = convertPlaylistIntoFormat(playlist, "M3U")
	val playlistOnString = convertPlaylistIntoFormat(playlist, "txt")
		
	// var file = new File ("playlist.m3u")
	var file = new File ("ffmpeg.txt")
	 var filewriter = new FileWriter(file)
      filewriter.write( playlistOnString );
      filewriter.flush
      filewriter.close 
			
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
	
}


def public static void main(String[] args){
	
	filters()
	
	 //printWebPage()
	  
	// generateGIF()
}
}