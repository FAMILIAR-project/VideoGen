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
import M3u.Playlist
import M3u.impl.PlaylistImpl
import M3u.M3uFactory
import M3u.MediaFile
import java.io.BufferedReader
import java.io.InputStreamReader

class VideoDemonstratorFFmpegPlayList {
	
	var static pathFFmpeg = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/ffmpeg-20161110-872b358-win64-static/bin/";
	var static pathVideo = "C:/Users/PHILIP_Mi/Documents/Divers/Miage/M2/IDM/TP3/FFMpeg/"
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
		var play = M3uFactory.eINSTANCE.createPlaylist(); //On crée l'objet play	
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
	registerPlayList(videoGen,play)
			
	}
	
	def void registerPlayList(VideoGeneratorModel videoGen, Playlist play) {
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty){
					//On enregistre dans la playlist les fichiers
					var mediaFile = M3uFactory.eINSTANCE.createMediaFile();
					mediaFile.location = desc.location;
					play.mediafile.add(mediaFile);
				}			
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty && !desc.location.isNullOrEmpty) {
					val test = new Random().nextInt(100) //Generer un nombre entre 0 et 100
					if(test <= 50){
						//On enregistre dans la playlist les fichiers
						var mediaFile = M3uFactory.eINSTANCE.createMediaFile();
						mediaFile.location = desc.location;
						play.mediafile.add(mediaFile);
					} 	 	
				}
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				//On récupere la taille de la liste et on genere un entier aléatoire pour chosir la video 
				val choix = new Random().nextInt(altvid.videodescs.size)
				//println("#Choix:" + choix)
				val vdesc = altvid.videodescs.get(choix)	 
				if(!vdesc.videoid.isNullOrEmpty && !vdesc.location.isNullOrEmpty){
					//On enregistre dans la playlist les fichiers
					var mediaFile = M3uFactory.eINSTANCE.createMediaFile();
					mediaFile.location = vdesc.location;
					play.mediafile.add(mediaFile);
				}
			}
		]
		createScripts(play); //On appelle la méthode pour créer les scripts avec la playlist
	}
	
	static var i = 0;
	def genID() {
		"v" + i++
	}
	
	//Faire méthode pour generer les 3 fichiers avec la playlist
	def void createScripts(Playlist play){
		System.out.println("Size:"+play.mediafile.size)
		//Transformation FFMpeg
		println("=======FFMpeg======")
		println("#DebutGeneration")
		for (MediaFile f: play.mediafile){
			println ("file '" + f.location + "'")
		}
		println("#FinGeneration")
		println("======M3U======")
		//Transformation M3U
		println("#EXTM3U")
		for (MediaFile f: play.mediafile){
			println("#EXT-X-DISCONTINUITY")
			println("#EXTINF:"+ getDuration(pathVideo+f.location)) 
			println ("" + f.location + "")
		}
		println("#EXT-X-ENDLIST")
		
	}
	
	//Méthode pour calculer la durée d'une vidéo (pour M3u extends)
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