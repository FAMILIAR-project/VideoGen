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
import java.util.ArrayList
import java.util.List

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
		//assertEquals(7, videoGen.videoseqs.size)			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.videoid.isNullOrEmpty)  desc.videoid = genID()  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(desc.videoid.isNullOrEmpty) desc.videoid = genID()
				if(desc.probability == 0) desc.probability = 50
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				var i = 0
				var empty = 0
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
					if(vdesc.probability == 0) empty++
					i += vdesc.probability
				}
				var p = 0
				if(i < 100) p = (100 - i) / empty
				for (vdesc : altvid.videodescs) {
					if(vdesc.probability == 0) vdesc.probability = p
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("foo2bis.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("foo2bis.videogen"), videoGen)
		
	//printToHTML(videoGen)
	printToFfmpeg(videoGen)
	
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
	
	def void printToFfmpeg(VideoGeneratorModel videoGen){
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				println ("Mandatory")
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)
					outputPrint(desc.location)   				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				println ("Optional")
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					if(randomNumber() <= desc.probability / 100 as double) outputPrint(desc.location)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					println ("Alternative")
				if (altvid.videodescs.size > 0){
					// there are vid seq alternatives
					var empty = 0
					val double[] arr = newDoubleArrayOfSize(altvid.videodescs.size)
					val alts = <String, Double>newLinkedHashMap()
					for (vdesc : altvid.videodescs) {
						if(!vdesc.videoid.isNullOrEmpty){
							if(vdesc.probability != 0) alts.put(vdesc.location, vdesc.probability / 100 as double)
						}
					}
					
					var iterate = 0
					var previous = 0.00
					for(Double d : alts.values){
						if(d != 0.00){
							previous += d
							arr.set(iterate, previous)
						}
						println("a: " + previous)
						iterate++
					}
					
					var x = randomNumber();
					var index = -1
					for (v : 0 ..< arr.size) {
						println("b: " + v + " -- " + arr.get(v))
        				if(index == -1 && x < arr.get(v)){
        					outputPrint(alts.keySet().get(v))
        					index = 0
        				}
    				}
				} 
			}
		]
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
	def outputPrint(String s){
		println ("file '" + s + "'") 
	}
	
	def randomNumber(){
		var d = Math.random()
		println ("Random: " + d) 
		return d
	}
}