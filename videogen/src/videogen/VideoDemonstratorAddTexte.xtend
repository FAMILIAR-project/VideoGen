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

/**
 * Transformation xtend pour rajouter du texte dans chaque vidéo
 **/
class VideoDemonstratorAddTexte {	
	//ATTENTION Changer les paths suivant l'endroit ou se trouve la console FFMpeg et les vidéos
	var static pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
	var static pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/"
	var static pathVideoSubtitle = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/Subs" //Pour le dossier de destination des videos transformées
	var static pathFontSubtitle = "C:/Windows/Fonts/Arial.ttf" //Pour le fichier de font des textes
	
	val static COLOR="white" //Couleur par défaut
	val static SIZE=20;  //Taille par défaut
	
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
		var videoGen = loadVideoGenerator(URI.createURI("fooRealSub.videogen")) //On utilise un model avec l'ajout de sous-titre
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

	// serializing
	saveVideoGenerator(URI.createURI("fooRealOutSub.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("fooRealOutSub.videogen"), videoGen)		
	
		
	//Appelle fonction qui va rajouter le texte
	addSub(videoGen)
	
	}
	
	//Fonction qui va parcourir les videos pour leur ajouter du texte
	def void addSub(VideoGeneratorModel videoGen) {
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty)  {
					//On vérifie si on a des sous-titres de demandées
					if(desc.subtitle!= null && !desc.subtitle.text.isNullOrEmpty){
						var String text= desc.subtitle.text; //Si oui on récupére le texte dans une variables
						var String color; //Pour récuperer la couleur du texte
						var int fontSize; //Pour récuperer la taille du texte
						//On vérifie si on a fournit la taille des sous-titre
						if (desc.subtitle.size !=0){
							fontSize= desc.subtitle.size; //Si oui on le récupére
						}else{
							fontSize=SIZE; //Sinon on indique une valeur par défault puisque le paramêtre n'est pas reseigné
						}
						//On vérifie si on a fournit la couleur des sous-titre
						if (!desc.subtitle.colorfont.isNullOrEmpty){
							color= desc.subtitle.colorfont; //Si oui on le récupére
						}else{
							color=COLOR; //Sinon on indique une valeur par défault puisque le paramêtre n'est pas reseigné
						}
						addSubtitle(pathVideo+desc.location,desc.videoid,text,color,fontSize) //Appel d'une fonction pour rajouter des sous-titres  				
					}		
				}
					
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					//On vérifie si on a des sous-titres de demandées
					if(desc.subtitle!= null && !desc.subtitle.text.isNullOrEmpty){
						var String text= desc.subtitle.text; //Si oui on récupére le texte dans une variables
						var String color; //Pour récuperer la couleur du texte
						var int fontSize; //Pour récuperer la taille du texte
						//On vérifie si on a fournit la taille des sous-titre
						if (desc.subtitle.size !=0){
							fontSize= desc.subtitle.size; //Si oui on le récupére
						}else{
							fontSize=SIZE; //Sinon on indique une valeur par défault puisque le paramêtre n'est pas reseigné
						}
						//On vérifie si on a fournit la couleur des sous-titre
						if (!desc.subtitle.colorfont.isNullOrEmpty){
							color= desc.subtitle.colorfont; //Si oui on le récupére
						}else{
							color=COLOR; //Sinon on indique une valeur par défault puisque le paramêtre n'est pas reseigné
						}
						addSubtitle(pathVideo+desc.location,desc.videoid,text,color,fontSize) //Appel d'une fonction pour rajouter des sous-titres  				
					}		
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) { 
					if(!vdesc.videoid.isNullOrEmpty && !vdesc.location.isNullOrEmpty) {
						//On vérifie si on a des sous-titres de demandées
						if(vdesc.subtitle!= null && !vdesc.subtitle.text.isNullOrEmpty){
							var String text= vdesc.subtitle.text; //Si oui on récupére le texte dans une variables
							var String color; //Pour récuperer la couleur du texte
							var int fontSize; //Pour récuperer la taille du texte
							//On vérifie si on a fournit la taille des sous-titre
							if (vdesc.subtitle.size !=0){
								fontSize= vdesc.subtitle.size; //Si oui on le récupére
							}else{
								fontSize=SIZE; //Sinon on indique une valeur par défault puisque le paramêtre n'est pas reseigné
							}
							//On vérifie si on a fournit la couleur des sous-titre
							if (!vdesc.subtitle.colorfont.isNullOrEmpty){
								color= vdesc.subtitle.colorfont; //Si oui on le récupére
							}else{
								color=COLOR; //Sinon on indique une valeur par défault puisque le paramêtre n'est pas reseigné
							}
							addSubtitle(pathVideo+vdesc.location,vdesc.videoid,text,color,fontSize) //Appel d'une fonction pour rajouter des sous-titres  				
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
	
	//Méthode pour calculer la durée d'une vidéo (avec FFmpeg)
	/*Paramêtre:
	 * path: chemin de la video
	 * name: nom de la video 
	 * texte: le texte de la video
	 * color: couleur du texte
	 * size: taille du texte
	 * (Note: on peut jouer sur d'autres paramêtres pour cela completer la grammaire xtext puis les paramêtres de cette fonction)
	 */
	
	def static void addSubtitle(String path,String name,String texte,String color,Integer size) {
		/*Note: la commande ne veut pas fonctionner pour le moment mais le principe est là*/
		System.out.println(pathFFmpeg+"ffmpeg -i " +path+" -vf drawtext=\"fontfile="+pathFontSubtitle+": text='"+texte+"': fontcolor="+color+": fontsize="+size+": box=1: boxcolor=black@0.5: boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/2\" -codec:a copy "+ pathVideoSubtitle+"/"+ name + ".mp4")
		//On lance une commande ...
		//var Process process = Runtime.getRuntime().exec(pathFFmpeg+"ffmpeg -i " +path+" -vf drawtext=\"fontfile="+pathFontSubtitle+": text='"+texte+"': fontcolor="+color+": fontsize="+size+": box=1: boxcolor=black@0.5: boxborderw=5: x=(w-text_w)/2: y=(h-text_h)/2\" -codec:a copy "+ pathVideoSubtitle+"/"+ name + ".mp4");
		//process.waitFor()	// ...on attends le résultat ...	
	}
	
}
