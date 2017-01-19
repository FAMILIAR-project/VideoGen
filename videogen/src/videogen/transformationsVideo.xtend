package videogen

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.ArrayList
import java.io.PrintWriter
import java.util.Random
import playlist.PlaylistFactory
import playlist.Playlist
import java.io.BufferedReader
import java.io.InputStreamReader

class transformationsVideo {
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}

//	Question1:transformation(model-to-text)
	def transform() {
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		val writer = new PrintWriter("videogenresult.txt", "UTF-8")
		val random = new Random()
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				writer.println("file" + " " + "'" + desc + "'" + "\n")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				var proba = random.nextInt(1)
				if (proba == 1)
					writer.println("file" + " " + "'" + desc + "'" + "\n")
				println("proba " + desc + " " + proba)
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa = altvid.videodescs.get(proba)
				writer.println("file" + " " + "'" + vaa.location + "'" + "\n")
			}

		]
		writer.close()
	}

	static var i = 0;

	def genID() {
		"v" + i++
	}
/*Question 2 : Voir le nouveau projet qu'on a crée pour définir la playlist,
 nommé : projet idm Q2*/

/* 	Question3:transformation model-to-model qui prend en entrée une spécification
VideoGen et qui produit en sortie une instance de playlist*/
	def playlist() {
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist;

		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		val random = new Random()

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				MF.location = desc
				playlist.videos.add(MF)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				var proba = random.nextInt(1)
				if (proba == 1) {
					var MF = PlaylistFactory.eINSTANCE.createMediaFile()
					MF.location = desc
					playlist.videos.add(MF)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa = altvid.videodescs.get(proba)
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				MF.location = vaa.location
				playlist.videos.add(MF)
			}

		]
		playlist

	}

	/*  Question 3:transformation model-to-text qui prend en entrée un modèle de playlist et 
	  qui produit en sortie un fichier texte .m3u compréhensible par VLC*/
	def transformationPlaylistToFileM3U(Playlist playlist) {
		// ecrire dans un fichier
		val writer = new PrintWriter("result.m3u")
		for (element : playlist.videos)
			writer.write(element.location + "\n")
		writer.close()
	}

	/*  Question 4:transformation model-to-text qui prend en entrée un modèle de playlist et
qui produit en sortie une liste compréhensible par ffmpeg
	 * 
	 * */
	 
	def transformationPlaylistToFileffmpeg(Playlist playlist) {
		// ecrire dans un fichier
		val writer = new PrintWriter("result.ffmpeg")
		for (element : playlist.videos)
			writer.write("file " + element.location + "\n")
          //fermeture fichier
		writer.close()
	}

	/*  Question 5-Q8:transformation model-to-text qui prend en entrée un modèle conforme au
	 *  métamodèle de playlist et qui produit en sortie un fichier texte au format
        “M3U étendu”  
	 */
	def transformationPlaylistToFileM3UEtendu(Playlist playlist) {
		// ecrire dans un fichier
		val writer = new PrintWriter("resultEtendu.m3u")
		writer.write("#EXTM3U \n")

		for (element : playlist.videos)
			writer.write(
				"#EXT-X-DISCONTINUITY" + " \n" + " #EXTINF :" + element.duration + "\n" + element.location + "\n")
		writer.write("#EXT-X-ENDLIST")
		 //fermeture fichier
		writer.close()
	}
	//Question 6 : voir README.txt

	/* Question 7:transformation qui prend en entrée une spécification VideoGen et qui
        assigne une valeur « durée » pour chaque séquence vidéo*/ 

	def playlistWithDuration() {
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist;

		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		val random = new Random()

		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				var duree = (videoseq as MandatoryVideoSeq).description.duration
				duree = calculDuree(desc).intValue()
				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				MF.location = desc
				MF.duration = duree
				playlist.videos.add(MF)
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				var duree = (videoseq as OptionalVideoSeq).description.duration
				duree = calculDuree(desc).intValue()
				var proba = random.nextInt(1)
				if (proba == 1) {
					var MF = PlaylistFactory.eINSTANCE.createMediaFile()
					MF.location = desc
					MF.duration = duree
					playlist.videos.add(MF)
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				var l = new ArrayList()
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa = altvid.videodescs.get(proba)
				var duree = (videoseq as MandatoryVideoSeq).description.duration

				var MF = PlaylistFactory.eINSTANCE.createMediaFile()
				duree = calculDuree(vaa.location).intValue()
				MF.location = vaa.location
				MF.duration = duree
				playlist.videos.add(MF)
			}

		]
		playlist

	}

	// Question 7: Fonction de calcul de la durée
	def calculDuree(
		String videoLocation) {
		var cmd = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of default=noprint_wrappers=1:nokey=1 -i " +
			videoLocation
		var p = Runtime.runtime.exec(cmd)
		var reader = new BufferedReader(new InputStreamReader(p.inputStream))
		var line = 0.0
		var truc = reader.readLine()
		if (truc != null) {
			line = Double.parseDouble(truc)
			line
		} else
			1

	}

	// Question 9:Fonction de création des vignettes à partir de la localisation des séquences vidéos 
	def creationVignette(String videoLocation, int tempsCapture, String chemin) {
		var p1 = Runtime.runtime.exec("pwd")
		var reader1 = new BufferedReader(new InputStreamReader(p1.inputStream))
		var pwd = reader1.readLine()

		println("vignette : " + videoLocation + " to " + chemin + " at " + tempsCapture + "s")
		var cmd = "ffmpeg -y -i " + videoLocation + " -r 1 -t 00:00:01 -ss 00:00:" + tempsCapture + " " + chemin
		println("with cmd : " + cmd)
		var p = Runtime.runtime.exec(cmd)
		while (p.alive)
			if (!p.alive)
				return
	}

	/*  Question 9:transformation qui prend en entrée une spécification VideoGen et qui
    génère en sortie un ensemble de vignettes pour toutes les séquences vidéos*/

	def playlistVignette(Playlist playlist) {
		// ecrire dans un fichier
		for (element : playlist.videos)
			creationVignette(element.location, 1, element.location + ".png")
	}

	/*  Question 10:transformation qui prend en entrée une spécification VideoGen et qui
génère en sortie une page Web affichant les vignettes*/

	def void printToHTML(VideoGeneratorModel videoGen) {
		val writer = new PrintWriter("PageHTMLvideogen.html")

		
		println("<ul>")
		writer.write("<ul>\n")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				creationVignette(desc, calculDuree(desc).intValue / 2, desc + ".png")
				println("<li>" + "<img src=" + desc + ".png/></li>")
				writer.write("<li>" + "Mandatory<img src=" + desc + ".png/></li>\n")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location

				creationVignette(desc, calculDuree(desc).intValue / 2, desc + ".png")
				println("<li>" + "<img src=" + desc + ".png/></li>")
				writer.write("<li>" + "Optional<img src=" + desc + ".png/></li>\n")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("<ul>")
				writer.write("<ul>\n")
				for (vdesc : altvid.videodescs) {
					creationVignette(vdesc.location, calculDuree(vdesc.location).intValue / 2, vdesc.location + ".png")
					println("<li>" + "<img src=" + vdesc.location + ".png/></li>")
					writer.write("<li>" + "Alternative<img src=" + vdesc.location + ".png/></li>\n")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("</ul>")
				writer.write("</ul>\n")
			}
		]
		println("</ul>")
		writer.write("<ul>\n")
		writer.close()
	}

/*
 * Question 11 : transformation qui prend en entrée une spécification VideoGen et qui
    vérifie:
    * L'unicité des ID
    * L'unicité des localisations des videos seq 
    * une probabilité d’une séquence vidéo “optionnelle” ne peut dépasser 1 (100%); 
    * la somme des probabilités ne doit pas dépasser 100% pour les séquences video “alternatif”
 */
	def verify() {
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		var idOp = ""
		var idAl = ""
		var idM = ""

		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				idM = (videoseq as MandatoryVideoSeq).description.videoid
				if(idM.isNullOrEmpty) idM = genID()
				if ((idM == idOp || idM == idAl))
					throw new Exception()

			} else if (videoseq instanceof OptionalVideoSeq) {
				val probabilite = (videoseq as OptionalVideoSeq).description.probability
				// println("proba optional "+(videoseq as OptionalVideoSeq).description.probability);
				idOp = (videoseq as OptionalVideoSeq).description.videoid
				if(idOp.isNullOrEmpty) idOp = genID()
				if ((idOp == idM || idOp == idAl) || probabilite > 1)
					throw new Exception()
			} else {

				var totalProb = 0
				val altvid = (videoseq as AlternativeVideoSeq)
				for (vdesc : altvid.videodescs) {
					idAl = vdesc.videoid
					val probabilite = vdesc.probability
					if(idAl.isNullOrEmpty) idAl = genID()
					if (idAl == idOp || idAl == idM)
						throw new Exception()

					totalProb += probabilite
				}
				if (totalProb > 1)
					throw new Exception()

			}

		}

	
	}
	//Question 11Bis : voir le fichier README.txt
// Question 12: generation video+concatenation

	def void printToHTMLWithRandom(VideoGeneratorModel playlist) {
		val writer = new PrintWriter("PageHTMLvideogen2.html")
		val writer2 = new PrintWriter("ffmpegConcatFile")
		val random = new Random()
		// var numSeq = 1
		println("<ul>")
		writer.write("<ul>\n")
		playlist.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				creationVignette(desc, calculDuree(desc).intValue / 2, desc + ".png")
				println("<li>" + "<img src=" + desc + ".png/></li>")
				writer.write("<li>" + "Mandatory<img src=" + desc + ".png/></li>\n")
				writer2.write("file \'" + desc + "\'\n")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				var proba = random.nextInt(2)
				println("proba :" + proba)
				if (proba == 1) {
					creationVignette(desc, calculDuree(desc).intValue / 2, desc + ".png")
					println("<li>" + "<img src=" + desc + ".png/></li>")
					writer.write("<li>" + "Optional<img src=" + desc + ".png/></li>\n")
					writer2.write("file \'" + desc + "\'\n")
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("<ul>")
				writer.write("<ul>\n")
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa = altvid.videodescs.get(proba)
				creationVignette(vaa.location, calculDuree(vaa.location).intValue / 2, vaa.location + ".png")
				println("<li>" + "<img src=" + vaa.location + ".png/></li>")
				writer.write("<li>" + "Alternative<img src=" + vaa.location + ".png/></li>\n")
				writer2.write("file \'" + vaa.location + "\'\n")
			}
			println("</ul>")
			writer.write("</ul>\n")
		]
		println("</ul>")
		writer.write("<ul>\n")
		writer.close()
		writer2.close

		var cmd = "ffmpeg -f concat -i ffmpegConcatFile -c copy output.mp4"
		var p = Runtime.runtime.exec(cmd)
		while (p.alive)
			if (!p.alive)
				return
	}

	// Exercice SUP1 : Synthétiser une spécification VideoGen
	def createVideoGen() {

		var cmd = "./scriptVG.sh"
		var execCommande = Runtime.runtime.exec(cmd)
		while (execCommande.alive)
			if (!execCommande.alive)
				return

	}

//Exercice SUP2 : Appliquer des traitements sur les vidéos
	def applyFilter(String filter, String inputVideo) {
		println("appel filter")
		var cmd = "ffmpeg -i " + inputVideo + " -strict -2  -vf \"format=yuva444p9, " + filter + "\"  " + inputVideo +
			".avecfilter.mp4"
		println("cmd :" + cmd)
		var execCommande = Runtime.runtime.exec(cmd)
		println("exit code : " + execCommande.waitFor)
		println(
			"la commande est bonne, si vous copier la cmd depuis le dossier videogen dans un terminal elle fonctionne")

		var reader = new BufferedReader(new InputStreamReader(execCommande.inputStream))
		var truc = reader.readLine()
		while (truc != null) {
			println(truc)
			truc = reader.readLine()
		}
		println("leaving filter")
	}

	def filters(VideoGeneratorModel playlist) {
		 // ffmpeg -i v5.mp4 -strict -2  -vf "format=yuva444p9, vectorscope"  jj.mp4
		// ffmpeg -i v5.mp4 -strict -2  -vf "format=yuva444p9, waveform"  jj.mp4
	   // ffmpeg -i v5.mp4 -strict -2  -vf "format=yuva444p9, crop=320:240"  jj.mp4
	  // ffmpeg -i v5.mp4 -strict -2  -vf "format=yuva444p9, ciescope"  jj.mp4
		val writer = new PrintWriter("PageHTMLvideogen2.html")
		val writer2 = new PrintWriter("ffmpegConcatFile")
		val random = new Random()
		// var numSeq = 1
		println("<ul>")
		writer.write("<ul>\n")
		playlist.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description.location
				creationVignette(desc, calculDuree(desc).intValue / 2, desc + ".png")
				println("<li>" + "<img src=" + desc + ".png/></li>")
				if (!(videoseq as MandatoryVideoSeq).description.filter.isNullOrEmpty) {
					applyFilter((videoseq as MandatoryVideoSeq).description.filter, desc)
					writer2.write("file \'" + desc + ".avecfilter.mp4\'\n")
				} else {
					writer2.write("file \'" + desc + "\'\n")
				}
				writer.write("<li>" + "Mandatory<img src=" + desc + ".png/></li>\n")
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description.location
				var proba = random.nextInt(2)
				println("proba :" + proba)
				if (proba == 1) {
					creationVignette(desc, calculDuree(desc).intValue / 2, desc + ".png")
					println("<li>" + "<img src=" + desc + ".png/></li>")
					if (!(videoseq as OptionalVideoSeq).description.filter.isNullOrEmpty) {
						applyFilter((videoseq as MandatoryVideoSeq).description.filter, desc)
						writer2.write("file \'" + desc + ".avecfilter.mp4\'\n")
					} else {
						writer2.write("file \'" + desc + "\'\n")
					}
					writer.write("<li>" + "Optional<img src=" + desc + ".png/></li>\n")
				}
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)

				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println("<ul>")
				writer.write("<ul>\n")
				var proba = random.nextInt(altvid.videodescs.size)
				val vaa = altvid.videodescs.get(proba)
				creationVignette(vaa.location, calculDuree(vaa.location).intValue / 2, vaa.location + ".png")
				println("<li>" + "<img src=" + vaa.location + ".png/></li>")
				writer.write("<li>" + "Alternative<img src=" + vaa.location + ".png/></li>\n")
				if (!vaa.filter.isNullOrEmpty) {
					applyFilter((videoseq as MandatoryVideoSeq).description.filter, vaa.location)
					writer2.write("file \'" + vaa.location + ".avecfilter.mp4\'\n")
				} else {
					writer2.write("file \'" + vaa.location + "\'\n")
				}
			}
			println("</ul>")
			writer.write("</ul>\n")
		]
		println("</ul>")
		writer.write("<ul>\n")
		writer.close()
		writer2.close

		var cmd = "ffmpeg -f concat -i ffmpegConcatFile -c copy output.mp4"
		var p = Runtime.runtime.exec(cmd)
		while (p.alive)
			if (!p.alive)
				return
	}


	// Exercice SUP3: Extraire un feature model à partir d’une spécification VideoGen
	def createFeatureModel() {
		var videoGen = loadVideoGenerator(URI.createURI("foo1.videogen"))
		val random = new Random()
		val writer = new PrintWriter("fmVideoGen.fm")
		var c1 = ""
		var c2 = ""
		var c3 = ""
		var c6 = ""
		var c8 = ""
		var c9 = ""
		var c10 = ""
		c1 = "fmVideoGen=FM(VideoGen:"
		writer.write(c1)
		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof MandatoryVideoSeq) {
				c2 = (videoseq as MandatoryVideoSeq).description.videoid
				if (c2.isNullOrEmpty)
					c2 = genID()
				writer.write(c2)
			} else if (videoseq instanceof OptionalVideoSeq) {
				c3 = (videoseq as OptionalVideoSeq).description.videoid

				if (c3.isNullOrEmpty)
					c3 = genID()
				writer.write("[" + c3 + "]")
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
				c6 = altvid.videoid
				if (c6.isNullOrEmpty)
					c6 = genID()

				writer.write(c6)

			}
		}
		for (videoseq : videoGen.videoseqs) {
			if (videoseq instanceof AlternativeVideoSeq) {
				val altvid = (videoseq as AlternativeVideoSeq)
				c8 = altvid.videoid
				var count = altvid.videodescs.size
				if (c8.isNullOrEmpty)
					c8 = genID()
				if (altvid.videodescs.size > 1) {
					c9 = ";" + c8 + ":" + "("
					writer.write(c9)

					for (vdesc : altvid.videodescs) {

						if (count > 1) {

							c10 = vdesc.videoid

							if (c10.isNullOrEmpty)
								c10 = genID()
							writer.write(c10 + "|")

						} else {
							c10 = vdesc.videoid

							if (c10.isNullOrEmpty)
								c10 = genID()
							writer.write(c10 + ")")
						}
						count = (count - 1)

					}
				} else {
					c9 = ";" + c8 + ":"
					writer.write(c9)
					for (vdesc : altvid.videodescs) {
						c10 = vdesc.videoid

						if (c10.isNullOrEmpty)
							c10 = genID()
						writer.write(c10)
					}

				}

			}

		}
		writer.write(";)")
		writer.close()
	}

}
