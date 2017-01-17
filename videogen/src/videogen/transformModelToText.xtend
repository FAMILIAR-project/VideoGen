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

import playlist.Playlist
import java.io.BufferedReader
import java.io.InputStreamReader

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
//	Q3
	def playlist(){
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist;
		
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
		// la dernière instruction est un return
	}
	//Q3
	def transformationPlaylistToFileM3U(Playlist playlist){
		//ecrire dans un fichier
		val writer=new PrintWriter("result.m3u")
		for(element : playlist.videos)
			writer.write(element.location+"\n")
			
		writer.close()
	}
	//Q4
	def transformationPlaylistToFileffmpeg(Playlist playlist){
		//ecrire dans un fichier
		val writer=new PrintWriter("result.ffmpeg")
		for(element : playlist.videos)
			writer.write("file "+element.location+"\n")
			
		writer.close()
	}
	//Q5-Q8
	def transformationPlaylistToFileM3UEtendu(Playlist playlist){
		//ecrire dans un fichier
		val writer=new PrintWriter("resultEtendu.m3u")
		writer.write("#EXTM3U \n")
		
		for(element : playlist.videos)
			writer.write("#EXT-X-DISCONTINUITY"+" \n"+" #EXTINF :"+element.duration+"\n" +element.location+"\n")
		writer.write("#EXT-X-ENDLIST")	
		writer.close()
	}
	//Q7-1
	def transformAjoutDuree(){
	var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen")) 
  
	  val random=new Random()
	  random.nextInt(101)	
				// writer.println(random.nextInt(101))	
		
		videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				var duree=(videoseq as MandatoryVideoSeq).description.duration
				 duree=calculDuree(desc).intValue()
				
	             			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				calculDuree(desc)
				//println("proba optional "+(videoseq as OptionalVideoSeq).description.probability);
			     var proba=random.nextInt(1)
				//if((videoseq as OptionalVideoSeq).description.probability == 0)
					//(videoseq as OptionalVideoSeq).description.probability = 50
				
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa=altvid.videodescs.get(proba)
				//var cumulproba = 100
				
					 	
				}
			
		]
			
		
	}
	//Q7-2
	def playlistWithDuration(){
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist;
		
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen")) 
	  val random=new Random()
	  
	  videoGen.videoseqs.forEach[videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
					var duree=(videoseq as MandatoryVideoSeq).description.duration
				 duree=calculDuree(desc).intValue()
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				MF.location = desc
				MF.duration=duree
				playlist.videos.add(MF)
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				 var duree=(videoseq as OptionalVideoSeq).description.duration
				 duree=calculDuree(desc).intValue()
			     var proba=random.nextInt(1)
				if(proba==1){
				 	var MF = PlaylistFactory.eINSTANCE.createMediaFile()
					MF.location = desc
					MF.duration=duree
					playlist.videos.add(MF)
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa=altvid.videodescs.get(proba)
				 var duree=(videoseq as MandatoryVideoSeq).description.duration
				
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				 duree=calculDuree(vaa.location).intValue()
				 MF.location = vaa.location
				 MF.duration=duree
					playlist.videos.add(MF)
				}
			
		]
		playlist
		// la dernière instruction est un return
	}
	//Q7
	def calculDuree(String videoLocation){
//		println("duration : "+videoLocation)
		var cmd = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " +videoLocation 
		var p =Runtime.runtime.exec(cmd)
		var reader= new BufferedReader(new InputStreamReader(p.inputStream))
		var line=0.0
		var truc = reader.readLine()
		if(truc != null){
	      line =Double.parseDouble(truc)
	      line
		}
		else
			1
		
	}
	//Q9
	def creationVignette(String videoLocation,int tempsCapture,String chemin){
    	var p1 =Runtime.runtime.exec("pwd")
		var reader1= new BufferedReader(new InputStreamReader(p1.inputStream))
		var pwd = reader1.readLine()
//		println("vignette : "+pwd+"/"+videoLocation +" to "+pwd+"/"+chemin+ " at "+tempsCapture+"s")
		println("vignette : "+videoLocation +" to "+chemin+ " at "+tempsCapture+"s") 
		var cmd = "ffmpeg -y -i "+videoLocation+ " -r 1 -t 00:00:01 -ss 00:00:"+tempsCapture+ " "+chemin 
		println("with cmd : "+cmd)
		var p =Runtime.runtime.exec(cmd)
		while(p.alive)
			if(!p.alive)
				return	
	}
	//Q9
	def playlistVignette(Playlist playlist){
		//ecrire dans un fichier
		
		for(element : playlist.videos)
		creationVignette(element.location,1,element.location+".png")
	}
	//Q10
	def void printToHTML(VideoGeneratorModel videoGen) {
		val writer=new PrintWriter("PageHTMLvideogen.html")
			
		//var numSeq = 1
		println("<ul>")
		writer.write("<ul>\n")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				creationVignette(desc,calculDuree(desc).intValue/2,desc+".png")
				println ("<li>" +"<img src="+desc+".png/></li>")  	
				writer.write("<li>" +"Mandatory<img src="+desc+".png/></li>\n")			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				
					creationVignette(desc,calculDuree(desc).intValue/2,desc+".png")
				  println ("<li>" +"<img src="+desc+".png/></li>")	
				writer.write("<li>" +"Optional<img src="+desc+".png/></li>\n")	  
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
	
					
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")	
				writer.write("<ul>\n")	
				for (vdesc : altvid.videodescs) {
					creationVignette(vdesc.location,calculDuree(vdesc.location).intValue/2,vdesc.location+".png")
				  println ("<li>" +"<img src="+vdesc.location+".png/></li>")  	
				writer.write("<li>" +"Alternative<img src="+vdesc.location+".png/></li>\n")	
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("</ul>")	
				writer.write("</ul>\n")	
			}
		]
		println("</ul>")
		writer.write("<ul>\n")	
		writer.close()
}
//Q11
def verify(){
	var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen")) 
   val random=new Random()
	  random.nextInt(101)
	  var idOp=""
	  var idAl=""
	  var idM=""
	 // val idM=1	
				// writer.println(random.nextInt(101))	
		
		for(videoseq :videoGen.videoseqs){
			if (videoseq instanceof MandatoryVideoSeq) {
			idM = (videoseq as MandatoryVideoSeq).description.videoid
				 if(idM.isNullOrEmpty) idM = genID()
							
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val probabilite = (videoseq as OptionalVideoSeq).description.probability
				//println("proba optional "+(videoseq as OptionalVideoSeq).description.probability);
			    
				 	 idOp=(videoseq as OptionalVideoSeq).description.videoid
				 	  if(idOp.isNullOrEmpty) idOp = genID()
				 	  if(probabilite>1)
				 	  throw new Exception()
				 	 
			
			
			}
			else {
			
				var totalProb=0
				val altvid = (videoseq as AlternativeVideoSeq)
		       for (vdesc : altvid.videodescs) {
				 idAl= vdesc.videoid
				 val probabilite=vdesc.probability
				  if(idAl.isNullOrEmpty) idAl = genID()
				  if(idAl==idOp || idAl==idM || idM==idOp)
				  	throw new Exception()
				  
				 totalProb+=probabilite
				}
				if(totalProb>1)
				throw new Exception()
				
			
		}
	
	  
	}
		
	//Q12
	}
	def void printToHTMLWithRandom(VideoGeneratorModel playlist) {
		val writer=new PrintWriter("PageHTMLvideogen2.html")
			val random=new Random()
		//var numSeq = 1
		println("<ul>")
		writer.write("<ul>\n")
		playlist.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				creationVignette(desc,calculDuree(desc).intValue/2,desc+".png")
				println ("<li>" +"<img src="+desc+".png/></li>")  	
				writer.write("<li>" +"Mandatory<img src="+desc+".png/></li>\n")			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				 var proba=random.nextInt(2)
				 println("proba :"+proba)
				 if(proba==1){
					creationVignette(desc,calculDuree(desc).intValue/2,desc+".png")
				  println ("<li>" +"<img src="+desc+".png/></li>")	
				writer.write("<li>" +"Optional<img src="+desc+".png/></li>\n")	  
				 }
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
	
					
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")	
				writer.write("<ul>\n")	
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa=altvid.videodescs.get(proba)
					creationVignette(vaa.location,calculDuree(vaa.location).intValue/2,vaa.location+".png")
				  println ("<li>" +"<img src="+vaa.location+".png/></li>")  	
				writer.write("<li>" +"Alternative<img src="+vaa.location+".png/></li>\n")	
				}
					println ("</ul>")	
				writer.write("</ul>\n")	
		]
		println("</ul>")
		writer.write("<ul>\n")	
		writer.close()}
	
	//QSUP1
	def createVideoGen(String path){
		
		val writer=new PrintWriter("creationAutomatique.videogen");
		var cmd = "" 
		var execCommande =Runtime.runtime.exec(cmd)
		 
		
		}
//QSUP3
	def createFeatureModel(){
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		 val random=new Random() 
		val writer = new PrintWriter("fmVideoGen.fm")
		var c1=""
		var c2=""
		var c3=""
		var c4=""
		var c5=""
		var c6=""	 
		 c1="fmVideoGen=FM(VideoGen:"
     writer.write(c1)
			for(videoseq :videoGen.videoseqs){
				if (videoseq instanceof MandatoryVideoSeq) {
					c2=(videoseq as MandatoryVideoSeq).description.videoid
				if(c2.isNullOrEmpty) 
				   c2= genID()
				writer.write(c2)     			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				c3=(videoseq as OptionalVideoSeq).description.videoid
				
				if(c3.isNullOrEmpty)
				
				c3=genID()
				writer.write("["+c3+"]")
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				c6=altvid.videoid
				if(c6.isNullOrEmpty)
				c6=genID()
				c4=c6+";"+c6+":("
				writer.write(c4)
				 	var count=altvid.videodescs.size
				 for (vdesc : altvid.videodescs) {
				 	
					if(count > 1){
			 	         
					 	c5=vdesc.videoid
					 	
					 	if(c5.isNullOrEmpty)
					 	c5=genID()
					 	writer.write(c5+"|")
					 	}
				 	else {
				 
				 	
					 	c5=vdesc.videoid
					 	
					 	if(c5.isNullOrEmpty)
					 	
					 	c5=genID()
					 	writer.write(c5+");")
					 	}
					 	count = (count -1)
					}
					
					}
				}
			writer.close()
		
		
	}//fmVideoGen=FM(VideoGen:v1[v2]v3;v3:(v30|v31|v32);v4;v4:(v40|v41);v5[v6]v7;v7:(v71);
//fmVideoGen=FM(VideoGen:v1[v2]v3v4v5[v6]v7;v3:(v30|v31|v32);v4:(v40|v41);v7:(v71);
	//writer.write(c1+c2+c3+c4+c5+")")
	//writer.write(c1+c2+c3+c4)
	
		def createFeatureModel2(){
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		 val random=new Random() 
		val writer = new PrintWriter("fmVideoGen.fm")
		var c1=""
		var c2=""
		var c3=""
		var c4=""
		var c5=""
		var c6=""
		var c7=""
		var c8=""
		var c9=""
		var c10=""	 
		 c1="fmVideoGen=FM(VideoGen:"
     writer.write(c1)
			for(videoseq :videoGen.videoseqs){
				if (videoseq instanceof MandatoryVideoSeq) {
					c2=(videoseq as MandatoryVideoSeq).description.videoid
				if(c2.isNullOrEmpty) 
				   c2= genID()
				writer.write(c2)     			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				c3=(videoseq as OptionalVideoSeq).description.videoid
				
				if(c3.isNullOrEmpty)
				
				c3=genID()
				writer.write("["+c3+"]")
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				c6=altvid.videoid
				if(c6.isNullOrEmpty)
				c6=genID()
				
				writer.write(c6)
					
					}
					}
			for(videoseq :videoGen.videoseqs){
				if(videoseq instanceof AlternativeVideoSeq){
					val altvid = (videoseq as AlternativeVideoSeq)
				c8=altvid.videoid
				if(c8.isNullOrEmpty)
				c8=genID()
				c9=";"+c8+":"+"("
				writer.write(c9)
				 	var count=altvid.videodescs.size
				 for (vdesc : altvid.videodescs) {
				 	
					if(count > 1){
			 	         
					 	c10=vdesc.videoid
					 	
					 	if(c10.isNullOrEmpty)
					 	c10=genID()
					 	writer.write(c10+"|")
					 	}
				 	else {
				 
				 	
					 	c10=vdesc.videoid
					 	
					 	if(c10.isNullOrEmpty)
					 	
					 	c10=genID()
					 	writer.write(c10+")")
					 	}
					 	count = (count -1)
					}
					
					
				}
					
					}
				writer.write(";)")
			writer.close()
		
		
	}
	  	  
}