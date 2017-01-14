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
				
				val i = new Random().nextInt(1)
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
	val playlistOnString = convertPlaylistIntoFormat(playlist, "M3U")
		
	 var file = new File ("playlist.m3u")
	 var filewriter = new FileWriter(file)
      filewriter.write( playlistOnString );
      filewriter.flush
      filewriter.close 
			
	}
	
	def static convertPlaylistIntoFormat(PlayList playlist,String ext) {
		var data =""
		
		if("M3U".equals(ext)){
			
			val vids = playlist.vids
			for(MediaFile f : vids){
				
				data += f.location+'\n'
				
			}
			
			
		}
		data
		
	}

def public static void main(String[] args){
	
	 modelToPlayList()
}
}