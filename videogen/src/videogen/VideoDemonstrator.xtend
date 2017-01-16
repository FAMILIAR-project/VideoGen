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
		
	//printToHTML(videoGen)
	printToFile(videoGen)
	
		 
			
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
		//var numSeq = 1
		//println("<ul>")
		var file = new File("test.txt")
		//var string = "hihihi amel"
     	var fileWriter = new FileWriter(file)
     	
		
		println(" avant for")		
		for(videoseq : videoGen.videoseqs){
	
			//println(" je suis après le for")
			if (videoseq instanceof MandatoryVideoSeq){
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){ 
					println ("<li>" + desc.videoid + "</li>")  
					fileWriter.write("file "+desc.location+"\n")
					fileWriter.flush()
			      	//fileWriter.close()
				}
									
			}else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				var rdm = new Random().nextInt(1)
				
				if(rdm == 1){
					if(!desc.videoid.isNullOrEmpty) {
						println ("<li>" + desc.videoid + "</li>") 
						fileWriter.write("file "+desc.location+"\n")
						fileWriter.flush();
				      	//fileWriter.close()
				     
				   	}
					
				}
				}else {
				
					val altvid = (videoseq as AlternativeVideoSeq)
					var random = new Random().nextInt(altvid.videodescs.size)
					print(" r "+random+"\n")
					var vdesc = altvid.videodescs.get(random);
					
				
			      	if(!vdesc.videoid.isNullOrEmpty) {
						println ("<li>" + vdesc.videoid + "</li>")
						fileWriter.write("file "+vdesc.videoid+"\n")
						fileWriter.flush();
			      		//SfileWriter.close()
					}
				
				}
			
			}
			
		
		
			
		fileWriter.flush();
		fileWriter.close()
		
		
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}