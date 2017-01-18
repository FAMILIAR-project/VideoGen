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
import java.util.Random
import java.io.File
import java.io.BufferedWriter
import java.io.FileWriter
import java.io.IOException

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
		var videoGen = loadVideoGenerator(URI.createURI("fooVideos.videogen")) 
		assertNotNull(videoGen)
		//Condition prof
		// assertEquals(7, videoGen.videoseqs.size)			
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
		
	printToFFmpeg(videoGen)
		 		
	}
	def void printToFFmpeg(VideoGeneratorModel videoGen) {
		//var numSeq = 1
		
			println("#this is a comment")
		
		videoGen.videoseqs.forEach[videoseq | 
			
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				
				if(!desc.videoid.isNullOrEmpty)  
				playList += 'file \'' + desc.location + '\''+ System.lineSeparator();
					//println ("file" + "'" + desc.location + "'")  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val unsurDeux = new Random().nextInt(2);
				val desc = (videoseq as OptionalVideoSeq).description
				if(unsurDeux ==0)
					playList += 'file \'' + desc.location + '\''+ System.lineSeparator();
					//println ("file" + "'" + desc.location + "'")  
					// en optional on prend 1 fichier sur 2
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val nbrFichier = altvid.videodescs.size;
				val numFichier = new Random().nextInt(nbrFichier);
				if(!altvid.videoid.isNullOrEmpty) 
				
						//println ("file" + "'" + altvid.videodescs.get(numFichier).location + "'")
					playList += 'file \'' + altvid.videodescs.get(numFichier).location + '\''+ System.lineSeparator();
					//altvid est un array 
					// en alternative on selectionne 1 parmi ceux qui sont 
					
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("file")
				
					if(!altvid.videodescs.get(numFichier).videoid.isNullOrEmpty) 
						//println ("file" + "'" + altvid.videodescs.get(numFichier).location + "'")
						
					playList += 'file \'' + altvid.videodescs.get(numFichier).location + '\''+ System.lineSeparator();
						
				
			}
			
		]
		
		// New file 
		try {
			println("je suis la ");
			val ffmpeg = new File("C:\\Users\\kaoutar\\git\\VideoGen\\videogen\\ffmpeg.txt");
			if (!ffmpeg.exists()) {
				ffmpeg.createNewFile();
			}
			println(ffmpeg.path);
			val fw = new FileWriter(ffmpeg.getAbsoluteFile());
			val bw = new BufferedWriter(fw);
			bw.write(playList);
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace
		}
	
	}
	/* 
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
	}*/
	
	static var i = 0;
	
	String playList = ""
	
	def genID() {
		"v" + i++
	}
	
	
}