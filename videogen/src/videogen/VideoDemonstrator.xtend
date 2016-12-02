package videogen

import java.io.FileWriter
import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.MediaFile
import org.xtext.example.mydsl.playlist.Playlist
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*
import javafx.scene.media.MediaPlayer

class VideoDemonstrator {
	
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
	
	@Test
	def test1() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)			
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
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		
	printToHTML(videoGen)
		 
			
	}
	
	@Test
	def void modelToTextToFile(){
		var videoGen = loadVideoGenerator(URI.createURI("foo3.videogen")) 
		assertNotNull(videoGen)
		val generatedFile = new FileWriter("result.txt")
		assertNotNull(generatedFile)
		modelToText(videoGen,generatedFile)
		
	}
	
	def void modelToText(VideoGeneratorModel videoGen, FileWriter file){
		val r = new Random();
		println ('This is a comment')
		file.write('This is a comment\n')
		// loading 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description

				if(!desc.videoid.isNullOrEmpty){
					desc.videoid = genID()
					println("file "  + "'"+ desc.location+"'")
					file.write("file "  + "'"+ desc.location+"'\n")
				}  
				
				  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					if(r.nextBoolean()){
						desc.videoid = genID() 
						println("file "  + "'"+ desc.location+"'")
						file.write("file "  + "'"+ desc.location+"'\n")
					}
				} 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
					val vdesc = altvid.videodescs.get(r.nextInt(altvid.videodescs.size));
					if(!vdesc.videoid.isNullOrEmpty){
					 vdesc.videoid = genID()
					println("file " + "'"+ vdesc.location+"'")
					file.write("file "  + "'"+ vdesc.location+"'\n")
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("Fichier3bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("Fichier3bis.videogen"), videoGen)
		
	file.close
	}
	
	def void ModelToModel(VideoGeneratorModel videoGen){
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist();
		val r = new Random();
		
		println ('This is a comment')
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description

				if(!desc.videoid.isNullOrEmpty){
					desc.videoid = genID()
					println("file "  + "'"+ desc.location+"'")
					val MediaFile mediaFile = PlaylistFactory.eINSTANCE.createMediaFile
					mediaFile.location = desc.location
					playlist.getVids().add(mediaFile)
				}  
				
				
				  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					if(r.nextBoolean()){
						desc.videoid = genID() 
						println("file "  + "'"+ desc.location+"'")
						val MediaFile mediaFile = PlaylistFactory.eINSTANCE.createMediaFile
						mediaFile.location = desc.location
						playlist.getVids().add(mediaFile)
					}
				} 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
					val vdesc = altvid.videodescs.get(r.nextInt(altvid.videodescs.size));
					if(!vdesc.videoid.isNullOrEmpty){
					 vdesc.videoid = genID()
					println("file " + "'"+ vdesc.location+"'")
					val MediaFile mediaFile = PlaylistFactory.eINSTANCE.createMediaFile
					mediaFile.location = vdesc.location
					playlist.getVids().add(mediaFile)
					
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("Fichier3bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("Fichier3bis.videogen"), videoGen)
	
	convertPlaylistIntoFormat(playlist,"M3U")
		
	}
	
	@Test
	def void convertPlaylistIntoFormat(Playlist playlist, String format){
		val FileWriter f = new FileWriter("videogen.m3u");
		for(MediaPlayer mp : playlist.getVids()){
			
		}
		
	}
	
	
	def void printToHTML(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  
					println ("<li>" + desc.videoid + "</li>")  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) 
					println ("<li>" + desc.videoid + "</li>") 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					println ("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")
				for (vdesc : altvid.videodescs) {
					if(!vdesc.videoid.isNullOrEmpty) 
						println ("<li>" + vdesc.videoid + "</li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("</ul>")
			}
		]
		println("</ul>")
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}