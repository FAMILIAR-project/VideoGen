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
import java.io.FileWriter
import java.io.File
import java.io.FileReader
import java.util.Random
import playlist.Playlist
import playlist.PlaylistFactory

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
	def test3() {
		
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		assertNotNull(videoGen)
		assertEquals(7, videoGen.videoseqs.size)
		        
       val outputFile = new File("outagain.txt"); 
       
        val out = new FileWriter(outputFile); 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val chem = (videoseq as MandatoryVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(2)
				if(optional.nextInt()==1)
				{
					val chem = (videoseq as OptionalVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				
				}
				
			}
			
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val size = altvid.videodescs.size()
				
				val optional = new Random().nextInt(altvid.videodescs.size())
				out.write(altvid.videodescs.get(optional).location+"\n")
				 				
		}
			]
			out.close
	// serializing
		 
			
	}
	
	@Test
	def test4() {
		
		// loading
		var videoGen = loadVideoGenerator(URI.createURI("foo2.videogen")) 
		// Model to model
		
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist()
		
		
       val outputFile = new File("outagain.txt"); 
       
        val out = new FileWriter(outputFile); 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val chem = (videoseq as MandatoryVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				
				val mediafile = PlaylistFactory.eINSTANCE.createMediafile()
				mediafile.location = chem
				playlist.videos.add(mediafile)
				 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val optional = new Random(1)
				if(optional.nextInt()==1)
				{
					val chem = (videoseq as OptionalVideoSeq).description.location
				out.write(chem)
				out.write("\n")
				
				val mediafile = PlaylistFactory.eINSTANCE.createMediafile()
				mediafile.location = chem
				playlist.videos.add(mediafile)
				
				}
				
			}
			
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val size = altvid.videodescs.size()
				
				val optional = new Random().nextInt(altvid.videodescs.size())
				out.write(altvid.videodescs.get(optional).location+"\n")
				
				val mediafile = PlaylistFactory.eINSTANCE.createMediafile()
				mediafile.location = altvid.videodescs.get(optional).location
				playlist.videos.add(mediafile)
				 				
		}
			]
			out.close
	// serializing
	
		 convertPlaylistIntoFormat(playlist, "m3u")
			
	}
	

	
	
	def convertPlaylistIntoFormat(Playlist p, String format)
	{
		 
		p.videos.forEach[ video|
			val str = video.location+"."+format
			video.location=str
			
        System.out.println(video.location+"\n")
        
        
			
			
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