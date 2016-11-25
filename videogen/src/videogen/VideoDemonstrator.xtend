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
import java.util.LinkedList
import org.xtext.example.mydsl.videoGen.VideoDescription
import java.util.List
import java.util.Random
import org.tritcorp.com.Playlist.Playlist.*
import org.tritcorp.com.Playlist.Playlist.impl.PlaylistFactoryImpl

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
	
	 
	def Playlist testM2M() {
		
		// load model (videogen)
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)		
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		// model2model
		val plf = PlaylistFactoryImpl.init()
		val pl = plf.createPlaylist()
		//Instancier modele PLaylist
		// iterate over videogen model
		
		videoGen.videoseqs.forEach[videoseq | 
			val rand = new Random()
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  
					pl.getFiles.add(desc.location)  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val p = desc.probability
				val res = rand.nextInt(100)
				if(p > 0){
					if(!desc.location.isNullOrEmpty && res <= p)
						pl.getFiles.add(desc.location) 
				}
				else
				if(!desc.location.isNullOrEmpty && res <= 50) 
					pl.getFiles.add(desc.location)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)	
				val l = altvid.getVideodescs()
				val r = l.length
				
				var boolean found = false
				var pr = 0
				for(vdesc: altvid.videodescs){
					if(vdesc.probability>0)
						pr = vdesc.probability
				}
				var i = 0
				if(pr==0){
					do{
						i = 0
						for (vdesc : altvid.videodescs) {					
							if(!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(r)%r							
								if(p==i && ! found){
									pl.getFiles.add(vdesc.location)
									found = true
								}	
							i++
							}
						}
					}while(! found)
				}
				else{
					do{
						i = 0
						for (vdesc : altvid.videodescs) {					
							if(!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(100)							
								if(p<=pr && ! found){
									pl.getFiles.add(vdesc.location)
									found = true
								}	
							i++
							}
						}
					}while(! found)
				}
			}
		]
		
		return pl
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
	val videoGen1 = loadVideoGenerator(URI.createURI("foo2bis.videogen"))
	printVideoList(videoGen1)
	val playlist=testM2M()
		playlist.getFiles().forEach[file |
			println(file)
		]
	}
	
	
	
	
	
	
	def void printVideoList(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq | 
			val rand = new Random()
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.location.isNullOrEmpty)  
					println ("file '" + desc.location+"'")  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				val p = desc.probability
				val res = rand.nextInt(100)
				if(p > 0){
					if(!desc.location.isNullOrEmpty && res <= p)
						println ("file '" + desc.location+"'") 
				}
				else
				if(!desc.location.isNullOrEmpty && res <= 50) 
					println ("file '" + desc.location+"'") 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)	
				val l = altvid.getVideodescs()
				val r = l.length
				
				var boolean found = false
				var pr = 0
				for(vdesc: altvid.videodescs){
					if(vdesc.probability>0)
						pr = vdesc.probability
				}
				var i = 0
				if(pr==0){
					do{
						i = 0
						for (vdesc : altvid.videodescs) {					
							if(!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(r)%r							
								if(p==i && ! found){
									println ("file '" + vdesc.location + "'")
									found = true
								}	
							i++
							}
						}
					}while(! found)
				}
				else{
					do{
						i = 0
						for (vdesc : altvid.videodescs) {					
							if(!vdesc.location.isNullOrEmpty) {
								val p = rand.nextInt(100)							
								if(p<=pr && ! found){
									println ("file '" + vdesc.location + "'")
									found = true
								}	
							i++
							}
						}
					}while(! found)
				}
			}
		]
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