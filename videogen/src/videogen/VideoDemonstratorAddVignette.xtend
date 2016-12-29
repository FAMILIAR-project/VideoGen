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
import java.io.BufferedReader
import java.io.InputStreamReader

/**
 * Transformation xtend pour generer une vignette des vidéos
 **/
class VideoDemonstratorAddVignette {
	
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
	
	addVignette(videoGen) //Appel fonction pour rajouter une vignette
	
	// serializing
	saveVideoGenerator(URI.createURI("fooRealOut.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("fooRealOut.videogen"), videoGen)		
	}
	
	//Fonction qui pour chaque vidéo chosit va créer une vignette
	def void addVignette(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty)  
					getVignette(pathVideo+desc.location,desc.videoid,getDuration(pathVideo+desc.location)) //Appel fonction pour créer une vignette			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					val test = new Random().nextInt(100) 
					if(test <= 50){
						getVignette(pathVideo+desc.location,desc.videoid,getDuration(pathVideo+desc.location)) //Appel fonction pour créer une vignette	 
					} 	 	
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				val choix = new Random().nextInt(altvid.videodescs.size)
				val vdesc = altvid.videodescs.get(choix)	 
				if(!vdesc.videoid.isNullOrEmpty && !vdesc.location.isNullOrEmpty) 
					getVignette(pathVideo+vdesc.location,vdesc.videoid,getDuration(pathVideo+vdesc.location)) //Appel fonction pour créer une vignette	
			}
		]
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
	//Appel fonction pour créer une vignette avec une commande puis la stocker dans un dossier
	def static void getVignette(String path, String name, int duration) {
		//On lance une commande...
		var pathnorm = path.replace("/","\\")
		var Process process = Runtime.getRuntime().exec(pathFFmpeg+"ffmpeg -y -i "+ pathnorm +" -r 1 -t 00:00:01 -ss 00:00:02 -f image2 "+pathVignette+name+".png")
		process.waitFor() //...on attends la fin du traitement
		//Attention peut etre long à faire avec la durée totale c'est pour ça qu'on la réduit à une seconde ici
		//pathFFmpeg+"ffmpeg -y -i "+ pathnorm +" -r 1 -t 00:00:01 -ss 00:00:"+duration+" -f image2 "+pathVignette+name+".png");
	}
	
	//Méthode pour calculer la durée d'une vidéo (pour avoir la durée réelle de la video)
	def static int getDuration(String path) {
		//On lance une commande ...
		var pathnorm = path.replace("/","\\")
		var Process process = Runtime.getRuntime().exec(pathFFmpeg+ "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"" + pathnorm + "\"")
		process.waitFor() // ...on attends le résultat ...			
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
		var String line = "";
		var String outputJson = "";
	   while ((line = reader.readLine()) != null) {
	       outputJson = outputJson + line;
	   }
	   return Math.round(Float.parseFloat(outputJson))-1; //... on retourne la durée de la vidéo récupérée
	}
	
}