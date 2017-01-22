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
import java.io.PrintWriter
import java.io.IOException

/**
 * Transformation xtend pour faire des calculs métriques (projet 1)
 **/
class VideoDemonstratorCalculMetrique {
	
	//ATTENTION Changer les paths suivant l'endroit ou se trouve la console FFMpeg et les vidéos
	var static pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
	var static pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/"
	
	//Constante qui représente la borne à ne pas dépasser (nb de sequence max dans le CSV)
	var static borneCsv = 100;
	
	//Création des variables qui vont contenir les données qui vont servir pour le métrique
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
		// Loading
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
		// Serializing
		saveVideoGenerator(URI.createURI("fooRealOut.xmi"), videoGen)
		saveVideoGenerator(URI.createURI("fooRealOut.videogen"), videoGen)	
			
	    // Appel de la fonction pour determiner les séquences
		findSequence(videoGen)		
	}
	
	//Fonction qui va determiner les différentes séquences possibles et récuperer/stocker les données métriques de celles-ci 
	def void findSequence(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach[videoseq | 
			/*Cas video obligatoire*/
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					
					//Calculer durée
					var duree = getDuration(pathVideo+desc.location)
					
					//Si les hashMap sont vides: on va créer la premiére variante
					if(tailleVar.empty){
						tailleVar.put(1,1) //On va rajouter un à la taille de la séquence
						dureeVar.put(1,duree) //On rajoute la durée de la vidéo
						idVar.put(1,desc.videoid) //On rajoute l'id de la video
					
					//Sinon on va parcourir chaque hashmap et rajouter les infos pour chaque element, variante:
					}else{
						for(variante: tailleVar.entrySet){
							tailleVar.put(variante.key,variante.value+1) //+1 à la taille de la séquence
						}
						for(variante: dureeVar.entrySet){
							dureeVar.put(variante.key,variante.value+duree) ///On rajoute la durée de la video
						}
						for(variante: idVar.entrySet){
							idVar.put(variante.key,variante.value+" "+desc.videoid) //On rajoute l'id de la video
						}
					}
					
				} 	  				
			}
			
			/*Cas video optionnelle*/
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					//Calculer durée
					var duree = getDuration(pathVideo+desc.location)
					
					//Si les hashMap sont vide: on va créer la premiére variante avec la video et une seconde sans
					if(tailleVar.empty){
						tailleVar.put(1,1) //On va rajouter un à la taille de la séquence
						dureeVar.put(1,duree) //On rajoute la durée de la vidéoy
						idVar.put(1,desc.videoid) //On rajoute l'id de la video
						tailleVar.put(2,0) //On va rajouter un à la taille de la séquence
						dureeVar.put(2,0) //On rajoute la durée de la vidéo
						idVar.put(2,"") //On rajoute l'id de la video
					
					//Sinon on va parcourir chaque hashmap et chaque variante.Pour chaque variante:
					//On va créer une nouvelle variante dans les hashmap qui ont les mêmes données que la variante auquel on ajoute les données de la vidéo
					}else{
						//On fait donc des hashmap pour contenir les nouveaux elements à rajouter qu'on ajoutera à nos premiers hashmap à la fin
						//Car il ne faut jamais parcourir une map et la modifier en même temps (Donc on ne fait pas l'ajout directement dans les trois hashmap définit avant)
						var HashMap<Integer,Integer> tailleVarNew = new HashMap<Integer,Integer>();  
						var HashMap<Integer,Integer> dureeVarNew = new HashMap<Integer,Integer>();  
						var HashMap<Integer,String> idVarNew = new HashMap<Integer,String>();
						
						//Compteurs qui indique le nb d'element qu'on a rajouté (pour éviter qu'une nouvelle variante écrase une autre)
						var int t=0
						var int d= 0
						var int i= 0
						for(variantet: tailleVar.entrySet){
							t++
							tailleVarNew.put(tailleVar.size()+t,variantet.value+1) //+1 à la taille de la séquence
						}
						for(varianted: dureeVar.entrySet){
							d++
							dureeVarNew.put(dureeVar.size()+d,varianted.value+duree) // la durée de la video
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
			
			/*Cas video alternative*/
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				
				//Si les hashMap sont vides: on va créer n premiere variantes (n= nombre d'alternatives)
				if(tailleVar.empty){
					for(vdesc: altvid.videodescs){
						//Calculer durée
						var duree = getDuration(pathVideo+vdesc.location)
						tailleVar.put(tailleVar.size+1,1) //On va rajouter un à la taille de la séquence
						dureeVar.put(dureeVar.size+1,duree) //On rajoute la durée de la vidéo
						idVar.put(idVar.size+1,vdesc.videoid) //On rajoute l'id de la video
					}
				
				//Sinon on va parcourir chaque hashmap et rajouter les infos pour chaque element, variante:
				}else{	
					//On fait donc des hashmap pour contenir les nouveaux elements à rajouter qu'on ajoutera à nos premiers hashmap à la fin
					//Car il ne faut jamais parcourir une map et la modifier en même temps (Donc on ne fait pas l'ajout directement dans les trois hashmap définit avant)
					var HashMap<Integer,Integer> tailleVarNew = new HashMap<Integer,Integer>();  
					var HashMap<Integer,Integer> dureeVarNew = new HashMap<Integer,Integer>();  
					var HashMap<Integer,String> idVarNew = new HashMap<Integer,String>();
							
					//Compteurs qui indique le nb d'element qu'on a rajouté (pour éviter qu'une nouvelle variante écrase une autre)
					var int t=0
					var int d= 0
					var int i= 0
					var boolean first = true;
					
					//Pour la premiere alternative (first = true) on va completer les variantes actuelles 
					//pour les autres alternatives on va créer une nouvelle variante pour chaque variantes actuelles
					//Et dans tout les cas on rajoute les donneés de la vidéo alternative
					for(vdesc: altvid.videodescs){
						//Calculer durée
						var duree = getDuration(pathVideo+vdesc.location)
						
						//Cas premiere alternatives: on complete les variantes actuels
						if (first) {
							for(variante: tailleVar.entrySet){
								tailleVarNew.put(variante.key,variante.value+1) //+1 à la taille de la séquence
							}
							for(variante: dureeVar.entrySet){
								dureeVarNew.put(variante.key,variante.value+duree) ///On rajoute la durée de la video
							}
							for(variante: idVar.entrySet){
								idVarNew.put(variante.key,variante.value+" "+vdesc.videoid) //On rajoute l'id de la video
							}
							first= false; //on indique que le premier element à été traité
						
						//Cas autre alternative: on crée de nouvelles variantes
						}else{
							for(variantet: tailleVar.entrySet){
								t++
								tailleVarNew.put(tailleVar.size()+t,variantet.value+1) //+1 à la taille de la séquence
							}
							for(varianted: dureeVar.entrySet){
								d++
								dureeVarNew.put(dureeVar.size()+d,varianted.value+duree) // la durée de la video
							}
							for(variantei: idVar.entrySet){
								i++
								idVarNew.put(idVar.size()+i,variantei.value+" "+vdesc.videoid) //On rajoute l'id de la video
							}	
						}
							
							
					}
					//Maintenant qu'on nos nouvelles variantes dans les nouvelles hashmap : on rajoute leur contenu dans les hashmap du calcul
					tailleVar.putAll(tailleVarNew);
					dureeVar.putAll(dureeVarNew);
					idVar.putAll(idVarNew);
				}
			}
		]
		println(tailleVar)
		println(dureeVar)
		println(idVar)
		//Appel de la méthode pour les variables clefs et l'export
		exportCSV(tailleVar,dureeVar,idVar);
	}
	
	//Méthode pour exporter un csv et afficher les variables clefs des métriques
	def static void exportCSV(HashMap<Integer,Integer> tailleVar,HashMap<Integer,Integer> dureeVar,HashMap<Integer,String> idVar){
		/*Création des variables clefs*/
		var int tailleMin=-1; //-1 Indique qu'on fait aucun calcul pour cette variable
		var int tailleMoy=-1;
		var int tailleMax=-1;
		
		var int dureeMin=-1;
		var int dureeMoy=-1;
		var int dureeMax=-1;
		
		var nbsequence=tailleVar.size;
		
		/*Création du String qui contient les infos pour le fichier csv */
		var contentsCSV="Sequence;Taille;Duree\n"
		
		/*On va parcourir les tableaux pour remplir toutes les variables*/
		//Un premier parcourt pour remplir le CSV
		var int i= 1;
		//On n'oublie pas de vérifier qu'on dépasse pas la borne (taille max csv)
		while (i <nbsequence && i < borneCsv){
			//On rajoute la liste des id dans le contenu du CSV
			contentsCSV+=idVar.get(i)+";";
			//On rajoute la taille dans le contenu du CSV
			contentsCSV+=tailleVar.get(i)+";";
			//On rajoute la duree dans le contenu du CSV
			contentsCSV+=dureeVar.get(i)+"\n";
			i++;
		}
		
		//Deux boucles pour les variables clefs
		for(variantet: tailleVar.entrySet){
			//On verifie si c'est la taille minimum
			if(tailleMin==-1 || tailleMin > variantet.value){
				tailleMin = variantet.value; //si c'est le cas on l'enregistre dans une variable
			}
			//On vérifie si c'est la taille maximum	
			if(tailleMax==-1 || tailleMax < variantet.value){
				tailleMax = variantet.value; //si c'est le cas on l'enregistre dans une variable
			}
			//On rajoute dans TailleMoy la taille
			tailleMoy+=variantet.value;	
		}
		for(varianted: dureeVar.entrySet){
			//On verifie si c'est la durée minimum
			if(dureeMin==-1 || dureeMin > varianted.value){
				dureeMin = varianted.value; //si c'est le cas on l'enregistre dans une variable
			}
			//On vérfie si c'est la durée maximum	
			if(dureeMax==-1 || dureeMax < varianted.value){
				dureeMax = varianted.value; //si c'est le cas on l'enregistre dans une variable
			}
			//On rajoute dans TailleMoy la taille
			dureeMoy+=varianted.value;
		}
		//On calcule la moyenne durée et taille
		dureeMoy=dureeMoy/nbsequence;
		tailleMoy=tailleMoy/nbsequence;
		
		/*Affichage des variables clefs*/
		System.out.println("Taille max: "+tailleMax+" Taille min: "+tailleMin+ " Taille moy: "+tailleMoy);
		System.out.println("Duree max: "+dureeMax+" Duree min: "+dureeMin+ " Duree moy: "+dureeMoy);
		System.out.println("Nb Séquence: "+nbsequence);
		
		/*Création et remplissage du csv*/
		try{
    	var PrintWriter writer = new PrintWriter("exportCsv.csv", "UTF-8");
    	writer.println(contentsCSV);
    	writer.close();
		} catch (IOException e) {
   			System.out.println(e.stackTrace);
		}
		
		
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