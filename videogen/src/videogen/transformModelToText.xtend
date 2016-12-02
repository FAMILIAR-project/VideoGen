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
import java.io.PrintWriter
import java.util.Random
import playlist.PlaylistFactory

class transformModelToText {
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
//	Q1
	def transform(){
	var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen")) 
     val writer=new PrintWriter("/home/yousra/workspaceIDM/VideoGen/videogen/src/videogen/videogenresult.txt","UTF-8")
	  val random=new Random()
	  random.nextInt(101)	
				// writer.println(random.nextInt(101))	
		
		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				 writer.println("file"+" "+"'"+desc+"'"+"\n")				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				//println("proba optional "+(videoseq as OptionalVideoSeq).description.probability);
			     var proba=random.nextInt(1)
				//if((videoseq as OptionalVideoSeq).description.probability == 0)
					//(videoseq as OptionalVideoSeq).description.probability = 50
				if(proba==1)
				 	writer.println("file"+" "+"'"+desc+"'"+"\n")	
				 	println("proba "+desc+" "+proba)
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa=altvid.videodescs.get(proba)
				//var cumulproba = 100
				
					 writer.println("file"+" "+"'"+vaa.location+"'"+"\n")		
				}
			
		]
	
	  
		
		writer.close()
			
		
		
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
//	Q2
	def playlist(){
		val playlist = PlaylistFactory.eINSTANCE.createplaylist;
		
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen")) 
	  val random=new Random()
	  
	  videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				MF.location = desc
				playlist.videos.add(MF)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
			     var proba=random.nextInt(1)
				if(proba==1){
				 	var MF = PlaylistFactory.eINSTANCE.createMediaFile()
					MF.location = desc
					playlist.videos.add(MF)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa=altvid.videodescs.get(proba)
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
					MF.location = vaa.location
					playlist.videos.add(MF)
				}
			
		]
		playlist
	}
	
	def transformationPlaylistToFile(){
		
	}
	
}