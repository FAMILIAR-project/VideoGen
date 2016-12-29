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
 * Transformation xtend pour generer un script FFmpeg (Question 1)
 **/
class VideoDemonstratorCalculMetrique {
	
	//ATTENTION Changer les paths suivant l'endroit ou se trouve la console FFMpeg et les vidéos
	var static pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
	var static pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/"
	
	//Création des variables qui vont servir pour le métrique
	final HashMap<Integer,Integer> tailleVar = new HashMap<Integer,Integer>() //HashMap nombre de video par variante
	final HashMap<Integer,Integer> dureeVar = new HashMap<Integer,Integer>() //HashMap durée vidéo par variante
	final HashMap<Integer,String> idVar = new HashMap<Integer,String>() //HashMap id video par variante
		
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
		// serializing
		saveVideoGenerator(URI.createURI("fooRealOut.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("fooRealOut.videogen"), videoGen)	
			
	    // Appel de la fonction pour calculer les métriques	 
		printCalcMetrique(videoGen)		
	}
	
	//Fonction qui va calculer des métriques
	def void printCalcMetrique(VideoGeneratorModel videoGen) {
		
		videoGen.videoseqs.forEach[videoseq | 
			//Cas video obligatoire
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					//Calculer durée
					var duree = getDuration(pathVideo+desc.location)
					//Si les hashMap sont vide: on va créer la premiére variante
					if(tailleVar.empty){
						tailleVar.put(1,1) //on va rajouter un à la taille de la séquence
						dureeVar.put(1,duree) //On rajoute la durée de la vidéo
						idVar.put(1,desc.videoid) //On rajoute l'id de la video
					//Sinon on va parcourir chaque hashmap et rajouter  les infos pour chaque element,variante:
					}else{
						for(variante: tailleVar.entrySet){
							tailleVar.put(variante.key,variante.value+1) //+1 à la taille de la séquence
						}
						for(variante: dureeVar.entrySet){
							dureeVar.put(variante.key,variante.value+duree) // la durée de la video
						}
						for(variante: idVar.entrySet){
							idVar.put(variante.key,variante.value+" "+desc.videoid) //On rajoute l'id de la video
						}
					}
					
				} 	  				
			}
			//Cas video optionnelle
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					//TODO
					//Calculer durée
					var durée = getDuration(pathVideo+desc.location)
					//Parcourir chaque hashmap et rajouter pour chaque variante: 
					//Créer un nouvelle element dans les hashmap qui ont les mêmes donnée que la variante et rajouter en plus: +1 à la taille, la durée de la video,l'id de la vidéo	
				}
			}
			//Cas video alternative
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for(vdesc: altvid.videodescs){
					//TODO
					//Calculer durée
					var durée = getDuration(pathVideo+vdesc.location)
					//Parcourir chaque hashmap et rajouter pour chaque variante: 
					//Si c'est le preimier choix: on maj la variante sinon:
					//Créer un nouvelle element (variante) dans les hashmap qui ont les mêmes donnée que la variante et rajouter en plus: +1 à la taille, la durée de la video,l'id de la vidéo	
				}
			}
		]
		println(tailleVar)
		println(dureeVar)
		println(idVar)
		println("Nb séquence: "+tailleVar.size)
		//TODO: futur appelle à une méthoe pour generer un csv propres (nb variante = taille hashmap)
	}
	
	//Méthode pour calculer la durée d'une vidéo (avec FFmpeg)
	def static int getDuration(String path) {
		//On lance une commande ...
		var pathnorm = path.replace("/","\\")
		var Process process = Runtime.getRuntime().exec(pathFFmpeg+ "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"" + pathnorm + "\"")
		process.waitFor()	// ...on attends le résultat ...	
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
		var String line = "";
		var String outputJson = "";
	   while ((line = reader.readLine()) != null) {
	       outputJson = outputJson + line;
	   }
	   return Math.round(Float.parseFloat(outputJson))-1; //... on retourne la durée de la vidéo récupérée
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}