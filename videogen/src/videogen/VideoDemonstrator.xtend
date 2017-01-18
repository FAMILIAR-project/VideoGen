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

import static org.junit.Assert.*
import java.io.File
import java.io.FileWriter
import java.util.Random
import org.xtext.example.playlist.PlaylistStandaloneSetupGenerated
import org.xtext.example.playlist.playlist.Playlist

class VideoDemonstrator {
	
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def loadPlaylist(URI uri) {
		new PlaylistStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as Playlist
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
			
		//printToHTML(videoGen)
		printToFile(videoGen)	
	}
	
	@Test
	def testQ9() {
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("drole.videogen")) 
		assertNotNull(videoGen)
		assertEquals(4, videoGen.videoseqs.size)			
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
		saveVideoGenerator(URI.createURI("drole.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("drole.videogen"), videoGen)
			
		//printToHTML(videoGen)
		printToFileQ9(videoGen)	
	}
	
	@Test
	def test2() {
		// loading
		var playlist = loadPlaylist(URI.createURI("test.playlist")) 
		assertNotNull(playlist)
		assertEquals(2, playlist.videos.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		
		//printToM3U(playlist)
		printToFileQ4(playlist)	
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
	
	def void printToFile(VideoGeneratorModel videoGen) {
		
		var file = new File("Q1.txt")
     	var fileWriter = new FileWriter(file)
     	
		
		for(videoseq : videoGen.videoseqs){
	
			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){ 
					fileWriter.write("file '"+desc.location+"' \n")
					fileWriter.flush()
				}
									
			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)
				//println(" ro " +rdm)
				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {
						fileWriter.write("file '"+desc.location+"' \n")
						fileWriter.flush();
				      	//fileWriter.close()
				     
				   }
					
				}
				}else {
				
					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)
					//print(" ra "+random+"\n")
					var vdesc = altvid.videodescs.get(random);
					
				
			      	if(!vdesc.videoid.isNullOrEmpty) {
						fileWriter.write("file '"+vdesc.location+"' \n")
						fileWriter.flush();
					}
				
				}
			
			}
		fileWriter.close()	
	}
	
	def void printToFileQ9(VideoGeneratorModel videoGen) {
		
		var file = new File("Q9.txt")
     	var fileWriter = new FileWriter(file)
     	var toto = new Toto
     	
		
		for(videoseq : videoGen.videoseqs){
	
			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){ 
					
					toto.toto(desc.location,desc.videoid)
				
				}
									
			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(2)
				//println(" ro " +rdm)
				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {
						
       					toto.toto(desc.location,desc.videoid)
						
				     
				   }
					
				}
				}else {
				
					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)
					//print(" ra "+random+"\n")
					var vdesc = altvid.videodescs.get(random);
					
				
			      	if(!vdesc.videoid.isNullOrEmpty) {
			      		
			      		toto.toto(vdesc.location,vdesc.videoid)
						
					}
				
				}
			
			}
		fileWriter.close()	
	}
	
	def void printToM3U(Playlist playlist) {
		
		var file = new File("Q3.m3u")
     	var fileWriter = new FileWriter(file)
     		
		for(v : playlist.videos){
			fileWriter.write(v.name+"\n");
		}		
		
		fileWriter.close()		
	}
	
	def void printToFileQ4(Playlist playlist) {
		
		var file = new File("Q4.txt")
     	var fileWriter = new FileWriter(file)
     	
		
		for(v : playlist.videos){
			fileWriter.write("file '"+  v.name+"' \n");
		}		
		
		fileWriter.close()			
		
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}