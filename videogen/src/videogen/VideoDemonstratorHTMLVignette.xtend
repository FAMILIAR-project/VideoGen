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
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Transformation xtend pour generer les vignettes des vidéos + un script html
 **/
class VideoDemonstratorHTMLVignette {
	
	//ATTENTION Changer les paths suivant l'endroit ou se trouve la console FFMpeg,les vidéos et le dossier pour les vignettes
	var static pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
	var static pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/"
	var static pathVignette = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/Vignettes/"
	
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
		var videoGen = loadVideoGenerator(URI.createURI("fooReal.videogen")) 
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
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
				for (vdesc : altvid.videodescs) {
					if(vdesc.videoid.isNullOrEmpty) vdesc.videoid = genID()
				}
			}
		]
	
	printHTMLVign(videoGen) //Appel méthode pour faire le html
	
	// serializing
	saveVideoGenerator(URI.createURI("fooRealOut.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("fooRealOut.videogen"), videoGen)		
	}
	
	//méthode qui va faire le html et la génération des ressources (ici les vingettes)
	def void printHTMLVign(VideoGeneratorModel videoGen) {
		//En-tête html
		println("<!doctype html>
<html lang='fr'>
<head>
	<meta charset='utf-8'>
	<title>VideoGen</title>
</head>
<body bgcolor=black>
	<h1 style='color:white'>VideoGen</h1>")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty)  
					getVignette(pathVideo+desc.location,desc.videoid,getDuration(pathVideo+desc.location)) //On appelle la fonction pour faire des vignettes
					println("	<div style='background-color: #FFFFFF;'><h3>Video:</h3><img style='width:304px;height:228px;' src=\""+pathVignette+desc.videoid+".png\"></div>"); //on genere le code html pour afficher la vignette 				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					getVignette(pathVideo+desc.location,desc.videoid,getDuration(pathVideo+desc.location))
					println("	<div style='background-color: #FFFFFF;'><h3>Videos optionel:</h3><img style='width:304px;height:228px;' src=\""+pathVignette+desc.videoid+".png\"></div>");    	 	
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
					println("	<div style='background-color: #FFFFFF;'><h3>Videos alternatives:</h3>"); 
				for(vdesc: altvid.videodescs){
					getVignette(pathVideo+vdesc.location,vdesc.videoid,getDuration(pathVideo+vdesc.location)) 
					println("	<img style='width:304px;height:228px;' src=\""+pathVignette+vdesc.videoid+".png\">"); 
				}
				println("</div>");
			}
		]
		println("</body></html>")
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
	//Appel fonction pour créer une vignette avec une commande puis la stocker dans un dossier
	def static void getVignette(String path, String name, int duration) {
		var pathnorm = path.replace("/","\\")
		var Process process = Runtime.getRuntime().exec(pathFFmpeg+"ffmpeg -y -i "+ pathnorm +" -r 1 -t 00:00:01 -ss 00:00:02 -f image2 "+pathVignette+name+".png")
		process.waitFor()//Attention peut etre long à faire
	}

	//Méthode pour calculer la durée d'une vidéo 
	def static int getDuration(String path) {
		var pathnorm = path.replace("/","\\")
		
		var Process process = Runtime.getRuntime().exec(pathFFmpeg+ "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"" + pathnorm + "\"")
		
		process.waitFor()		
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
		var String line = "";
		var String outputJson = "";
	   while ((line = reader.readLine()) != null) {
	       outputJson = outputJson + line;
	   }
	   return Math.round(Float.parseFloat(outputJson))-1;
	}
	
}