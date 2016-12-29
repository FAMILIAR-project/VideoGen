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
	
	//ATTENTION Changer les paths suivant l'endroit ou se trouve la console FFMpeg et les vid�os
	var static pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
	var static pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/"
	
	//Cr�ation des variables qui vont servir pour le m�trique
	final int nbVariante = 1;
	final HashMap<Integer,Integer> tailleVar = new HashMap<Integer,Integer>() //HashMap nombre de video par variante
	final HashMap<Integer,Integer> dureeVar = new HashMap<Integer,Integer>() //HashMap dur�e vid�o par variante
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
			
	    // Appel de la fonction pour calculer les m�triques	 
		printCalcMetrique(videoGen)		
	}
	
	//Fonction qui va calculer des m�triques
	def void printCalcMetrique(VideoGeneratorModel videoGen) {
		
		videoGen.videoseqs.forEach[videoseq | 
			//Cas video obligatoire
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					//Calculer dur�e
					var duree = getDuration(pathVideo+desc.location)
					//Si les hashMap sont vide: on va cr�er la premi�re variante
					if(tailleVar.empty){
						tailleVar.put(1,1) //on va rajouter un � la taille de la s�quence
						dureeVar.put(1,duree) //On rajoute la dur�e de la vid�o
						idVar.put(1,desc.videoid) //On rajoute l'id de la video
					//Sinon on va parcourir chaque hashmap et rajouter  les infos pour chaque element,variante:
					}else{
						for(variante: tailleVar.entrySet){
							tailleVar.put(variante.key,variante.value+1) //+1 � la taille de la s�quence
						}
						for(variante: dureeVar.entrySet){
							dureeVar.put(variante.key,variante.value+duree) // la dur�e de la video
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
					//Calculer dur�e
					var duree = getDuration(pathVideo+desc.location)
					//Si les hashMap sont vide: on va cr�er la premi�re variante avec la video et une seconde sans
					if(tailleVar.empty){
						tailleVar.put(1,1) //on va rajouter un � la taille de la s�quence
						dureeVar.put(1,duree) //On rajoute la dur�e de la vid�oy
						idVar.put(1,desc.videoid) //On rajoute l'id de la video
						tailleVar.put(2,0) //on va rajouter un � la taille de la s�quence
						dureeVar.put(2,0) //On rajoute la dur�e de la vid�o
						idVar.put(2,"") //On rajoute l'id de la video
					//Sinon on va parcourir chaque hashmap et chaque variante.Pour chaque variante:
					//On va cr�er une nouvelle variante dans les hashmap qui ont les m�mes donn�es que la variante auquelle on ajoute les donn�es de la vid�o
					}else{
						//On va rajouter des elements en m�me temps qu'on lit: dangereux 
						//on fait donc des hashmap pour contenir les nouveaux elements � rajouter qu'on ajoutera � nos hashmap � la fin
						var HashMap<Integer,Integer> tailleVarNew = new HashMap<Integer,Integer>();  
						var HashMap<Integer,Integer> dureeVarNew = new HashMap<Integer,Integer>();  
						var HashMap<Integer,String> idVarNew = new HashMap<Integer,String>();
						
						//compteurs qui indique le nb d'element qu'on a rajout� (pour �viter qu'une nouvelle variante �crase une autre)
						var int t=0
						var int d= 0
						var int i= 0
						for(variantet: tailleVar.entrySet){
							t++
							tailleVarNew.put(tailleVar.size()+t,variantet.value+1) //+1 � la taille de la s�quence
						}
						for(varianted: dureeVar.entrySet){
							d++
							dureeVarNew.put(dureeVar.size()+d,varianted.value+duree) // la dur�e de la video
						}
						for(variantei: idVar.entrySet){
							i++
							idVarNew.put(idVar.size()+i,variantei.value+" "+desc.videoid) //On rajoute l'id de la video
						}
						
						//Maintenant qu'on nos nouvelles variantes dans les nouvelles hashmap : on rajoute leur contenu dans les hashmap du calcul
						tailleVar.putAll(tailleVarNew);
						dureeVar.putAll(dureeVarNew);
						idVar.putAll(idVarNew);
					}
					
				}
			}
			//Cas video alternative
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				//on fait donc des hashmap pour contenir les nouveaux elements � rajouter qu'on ajoutera � nos hashmap � la fin
				var HashMap<Integer,Integer> tailleVarNew = new HashMap<Integer,Integer>();  
				var HashMap<Integer,Integer> dureeVarNew = new HashMap<Integer,Integer>();  
				var HashMap<Integer,String> idVarNew = new HashMap<Integer,String>();
						
				//compteurs qui indique le nb d'element qu'on a rajout� (pour �viter qu'une nouvelle variante �crase une autre)
				var int t=0
				var int d= 0
				var int i= 0
				for(vdesc: altvid.videodescs){
					//Calculer dur�e
					var duree = getDuration(pathVideo+vdesc.location)
					//On va cr�er une nouvelle variante dans les hashmap qui ont les m�mes donn�es que la variante auquelle on ajoute les donn�es de la vid�o
					for(variantet: tailleVar.entrySet){
						t++
						tailleVarNew.put(tailleVar.size()+t,variantet.value+1) //+1 � la taille de la s�quence
					}
					for(varianted: dureeVar.entrySet){
						d++
						dureeVarNew.put(dureeVar.size()+d,varianted.value+duree) // la dur�e de la video
					}
					for(variantei: idVar.entrySet){
						i++
						idVarNew.put(idVar.size()+i,variantei.value+" "+vdesc.videoid) //On rajoute l'id de la video
					}
						
						
				}
				//Maintenant qu'on nos nouvelles variantes dans les nouvelles hashmap : on rajoute leur contenu dans les hashmap du calcul
				tailleVar.putAll(tailleVarNew);
				dureeVar.putAll(dureeVarNew);
				idVar.putAll(idVarNew);
			}
		]
		println(tailleVar)
		println(dureeVar)
		println(idVar)
		println("Nb s�quence: "+tailleVar.size)
		//TODO: futur appelle � une m�thoe pour generer un csv propres (nb variante = taille hashmap)
	}
	
	//M�thode pour calculer la dur�e d'une vid�o (avec FFmpeg)
	def static int getDuration(String path) {
		//On lance une commande ...
		var pathnorm = path.replace("/","\\")
		var Process process = Runtime.getRuntime().exec(pathFFmpeg+ "ffprobe -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 \"" + pathnorm + "\"")
		process.waitFor()	// ...on attends le r�sultat ...	
		var BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))
		var String line = "";
		var String outputJson = "";
	   while ((line = reader.readLine()) != null) {
	       outputJson = outputJson + line;
	   }
	   return Math.round(Float.parseFloat(outputJson))-1; //... on retourne la dur�e de la vid�o r�cup�r�e
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
}