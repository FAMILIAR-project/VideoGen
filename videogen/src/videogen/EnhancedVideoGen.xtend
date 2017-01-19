package videogen

import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStreamReader
import java.io.PrintWriter
import java.nio.file.Files
import java.nio.file.Paths
import java.util.ArrayList
import java.util.Collections
import java.util.HashMap
import java.util.List
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.BlackWhiteFilter
import org.xtext.example.mydsl.videoGen.FlipFilter
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.NegateFilter
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoDescription
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import playlist.Playlist
import playlist.PlaylistFactory

class EnhancedVideoGen {
	def static loadVideoGenerator(String specification) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var resSet = new ResourceSetImpl()
		var res = resSet.createResource(URI.createURI("dummy:/example.videogen"));
		var in = new ByteArrayInputStream(specification.getBytes());
		res.load(in, resSet.loadOptions)
		res.contents.get(0) as VideoGeneratorModel
	}

	def static saveVideoGenerator(URI uri, VideoGeneratorModel pollS) {
		var Resource rs = new ResourceSetImpl().createResource(uri);
		rs.getContents.add(pollS);
		rs.save(new HashMap());
	}

	/**
	 * A partir d'un fichier videogen
	 * vérifie la cohérence des informations
	 * crée une playlist
	 * enregistre les images des vidéos choisies
	 * sauvegarde la playlist en m3u
	 * ecrit la page HTML de la playlist
	 */
	def static Playlist main(String[] args) {
		var videoGen = loadVideoGenerator(args.get(0))
		val rand = new Random()
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist

		println("Vérification des informations ...")
		val codeErreur = verifInfo(videoGen)
		if (codeErreur == 2) {
			println("Annulation de la génération")
			return playlist;
		}

		println("Création de la playlist...")
		videoGen.videoseqs.forEach [ videoseq |
			var String filtered = null
			
			if (videoseq instanceof MandatoryVideoSeq) {
				// Test la présence d'un ID
				if(videoseq.description.videoid.isNullOrEmpty) videoseq.description.videoid = genID()
				// Création d'une vidéo
				val mediafile = PlaylistFactory.eINSTANCE.createVideo
				mediafile.url = videoseq.description.location
				if (videoseq.description.duration == 0) {
					// Génération de la durée si non indiquée
					mediafile.duration = extractDuration(videoseq.description.location).intValue
				} else {
					mediafile.duration = videoseq.description.duration
				}
				// Enregistrement d'une image pour la vidéo
				mediafile.thumbnail = extractThumbnail(videoseq.description.location, videoseq.description.videoid)
				
				// enregistrement du filtre et remplacement de la vidéo s'il y en a un
				val desc = (videoseq as MandatoryVideoSeq).description
				if(desc.filter != null){
					filtered = applyFilter(desc)
				}
				if(filtered != null){
					mediafile.url = filtered
				}
				
				// Ajout de la vidéo à la playlist
				playlist.videos.add(mediafile)
			}
			if (videoseq instanceof OptionalVideoSeq) {
				if(videoseq.description.videoid.isNullOrEmpty) videoseq.description.videoid = genID()
				if (rand.nextInt(2) == 1) { // 50%
					val mediafile = PlaylistFactory.eINSTANCE.createVideo
					mediafile.url = videoseq.description.location
					if (videoseq.description.duration == 0) {
						mediafile.duration = extractDuration(videoseq.description.location).intValue
					} else {
						mediafile.duration = videoseq.description.duration
					}
					mediafile.thumbnail = extractThumbnail(videoseq.description.location, videoseq.description.videoid)
					
					val desc = (videoseq as OptionalVideoSeq).description
					if(desc.filter != null){
						filtered = applyFilter(desc)
					}
					if(filtered != null){
						mediafile.url = filtered
					}
					
					playlist.videos.add(mediafile)
				}
			}
			if (videoseq instanceof AlternativeVideoSeq) {

				if(videoseq.videoid.isNullOrEmpty) videoseq.videoid = genID

				val listAlt = (videoseq as AlternativeVideoSeq).videodescs

				listAlt.forEach [ alt |
					if(alt.videoid.isNullOrEmpty) alt.videoid = genID
				]

				val quicesera = rand.nextInt(listAlt.size) // Equiprobabilite
				val mediafile = PlaylistFactory.eINSTANCE.createVideo
				mediafile.url = listAlt.get(quicesera).location
				if (listAlt.get(quicesera).duration == 0) {
					mediafile.duration = extractDuration(listAlt.get(quicesera).location).intValue
				} else {
					mediafile.duration = listAlt.get(quicesera).duration
				}
				mediafile.thumbnail = extractThumbnail(listAlt.get(quicesera).location, listAlt.get(quicesera).videoid)
				
				val desc = listAlt.get(quicesera)
				if(desc.filter != null){
					filtered = applyFilter(desc)
				}
				if(filtered != null){
					mediafile.url = filtered
				}
				
				playlist.videos.add(mediafile)
			}
		]

		// Ecriture de la playlist en M3U
		println("Ecriture de play.m3u ...")
		Files.write(
			Paths.get("play.m3u"),
			Collections.singletonList(PlaylistToText.playlistToText(playlist, "m3u"))
		)
		playlist.url = "play.m3u"

		// Ecriture de la page HTML
		println("Ecriture de videogen.html ...")
		printToHTML(videoGen, "videogen.html")

		return playlist
	}

	/**
	 * Retourne la durée d'une vidéo
	 * @param location Chemin de la vidéo
	 */
	def private static extractDuration(String location) {
		val cmd = "ffprobe -v error -select_streams v:0 -show_entries stream=duration -of " +
			"default=noprint_wrappers=1:nokey=1 %s"

		val checkCmd = String.format(cmd, location)
		val process = Runtime.runtime.exec(String.format(checkCmd, location))
		process.waitFor
		val in = new BufferedReader(new InputStreamReader(process.getInputStream()))
		val value = in.readLine
		return Double::parseDouble(value)
	}

	/**
	 * Sauvegarde une image JPG correspondant à une vidéo
	 * @param location Chemin de la vidéo
	 * @param name nom de l'image
	 */
	def private static extractThumbnail(String location, String name) {
		val thumbnailsDir = "src/main/webapp/thumbnails"
		var cmd = "ffmpeg -i %s -ss 00:00:01.000 -vframes 1 " + thumbnailsDir + "/%s.jpg -y"
		cmd = String.format(cmd, location, name)
		if (!Files.exists(Paths.get(thumbnailsDir))) {
			Files.createDirectory(Paths.get(thumbnailsDir))
		}
		val process = Runtime.runtime.exec(String.format(cmd, location))
		process.waitFor
		return String.format("thumbnails/%s.jpg", name)
	}

	private static int i = 0;

	def private static genID() {
		"_autogenerated" + i++
	}

	/**
	 * Ecrit le fichier HTML d'un videoGen
	 */
	def static void printToHTML(VideoGeneratorModel videoGen, String outputPath) {
		val output = new File(outputPath)
		val pw = new PrintWriter(output)

		val cssPath = new File(output.parent, "videogen.css").path
		saveCssFile(cssPath)

		pw.println("<!DOCTYPE html>")
		pw.println("<html>")
		pw.println("<head>")
		pw.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + cssPath + "\">")
		pw.println("</head>")
		pw.println("<body>")
		pw.println("<ul>")
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if (!desc.videoid.isNullOrEmpty)
					pw.println(vidToHtml(desc))
			} else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty)
					pw.println(vidToHtml(desc))
			} else {
				val altvid = (videoseq as AlternativeVideoSeq)
//				if(!altvid.videoid.isNullOrEmpty) 
//					pw.println ("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					pw.println("<ul id=\"alternatives\">")
				for (vdesc : altvid.videodescs) {
					if (!vdesc.videoid.isNullOrEmpty)
						pw.println(vidToHtml(vdesc))
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					pw.println("</ul>")
			}
		]
		pw.println("</ul>")
		pw.println("</body>")
		pw.println("</html>")
		pw.flush
		pw.close
	}

	def static String printToHTMLext(String specification) {
		val StringBuilder builder = new StringBuilder()

		// val cssPath = new File(output.parent, "videogen.css").path
		// saveCssFile(cssPath)
		var videoGen = loadVideoGenerator(specification)
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if (!desc.videoid.isNullOrEmpty) {
					builder.append("<div class=\"col-md-1\">")
					builder.append("<div class=\"thumbnail\">")
					builder.append(vidToHtmlExt(desc))
					builder.append("</div></div>")
				}
			} else if (videoseq instanceof AlternativeVideoSeq) {

				val altvid = (videoseq as AlternativeVideoSeq)
				if (altvid.videodescs.size > 0) {
					// there are vid seq alternatives
					for (vdesc : altvid.videodescs) {
						if (!vdesc.videoid.isNullOrEmpty) {
							builder.append("<div class=\"col-md-" + altvid.videodescs.size + "\">")
							builder.append("<div class=\"thumbnail\">");
							builder.append(vidToHtmlExt(vdesc))
							builder.append("</div></div>")
						}
					}
				}
			} else {
				val vid = (videoseq as MandatoryVideoSeq)
				extractThumbnail(vid.description.location, vid.description.videoid)
			}
		]
		builder.toString
	}

	/**
	 * Ecrit le fichier CSS utilisé par la page HTML
	 */
	def private static saveCssFile(String outputPath) {
		val output = new File(outputPath)
		val pw = new PrintWriter(output)

		pw.println("ul#alternatives li { 
display : inline;
}
ul{
list-style-type : none;
padding : 0;
}
il{
padding : 0;
}")

		pw.flush
		pw.close
	}

	def static String getCssFile() {
		"ul#alternatives li { 
display : inline;
}
ul{
list-style-type : none;
padding : 0;
}
il{
padding : 0;
}"
	}

	/**
	 * Retourne la chaîne de caractères HTML correspondant à une vidéo
	 * Et enregistre une image pour la vidéo
	 */
	def private static String vidToHtml(VideoDescription vdesc) {
		val result = new StringBuilder
		val thumbnail = extractThumbnail(vdesc.location, vdesc.videoid)
		val id = vdesc.videoid

		result.append("<li>")
		result.append("<img src=\"" + thumbnail + "\" alt=\"" + id + "\" width=\"100\" height=\"100\">")
		result.append("</li>")

		result.toString
	}

	def private static String vidToHtmlExt(VideoDescription vdesc) {
		val result = new StringBuilder
		val thumbnail = extractThumbnail(vdesc.location, vdesc.videoid)
		val id = vdesc.videoid
		result.append("<img src=\"" + thumbnail + "\" alt=\"" + id + "\"/>")
		result.toString
	}

	/**
	 * Vérifie les informations du modèle videoGen :
	 * 
	 * ERROR : identifiants de vidéos non uniques (déjà vérifié par l'éditeur de videogen)
	 * ERROR : probabilités d'alternatives > 100%
	 * ERROR : probabilités d'alternatives < 100%
	 * 
	 * WARNING : vidéo utilisée plusieurs fois
	 * WARNING : vidéo optionnelle avec probabilité >= 100%
	 * WARNING : vidéo obligatoire avec précision de probabilité
	 * WARNING : vidéos alternatives jamais utilisables (proba des autres = 100%)
	 * 
	 * @return code d'erreur : 0 si OK, 1 si WARNING, 2 si ERROR
	 */
	def static verifInfo(VideoGeneratorModel videoGen) {
		val List<String> identifiers = new ArrayList
		val List<String> locations = new ArrayList

		val error = new ErrorManager

		// Génération
		videoGen.videoseqs.forEach [ videoseq |
			if (videoseq instanceof MandatoryVideoSeq) {
				if (!videoseq.description.videoid.isNullOrEmpty) {
					identifiers.add(videoseq.description.videoid)
				}
				locations.add(videoseq.description.location)
				val proba = videoseq.description.probability
				if (proba != 0) {
					error.warning(
						String.format(
							"La probabilité de la vidéo obligatoire %s est inutile et sera ignorée",
							if(videoseq.description.videoid.nullOrEmpty) "???" else videoseq.description.videoid
						)
					)
				}
			} else if (videoseq instanceof OptionalVideoSeq) {
				if (!videoseq.description.videoid.isNullOrEmpty) {
					identifiers.add(videoseq.description.videoid)
				}
				locations.add(videoseq.description.location)
				if (videoseq.description.probability != 0) {
					val proba = videoseq.description.probability
					if (proba >= 100) {
						error.warning(
							String.
								format(
									"La vidéo optionnelle %s peut être remplacée par une vidéo obligatoire (probabilité de %d%%)",
									if (videoseq.description.videoid.isNullOrEmpty)
										"???"
									else
										videoseq.description.videoid,
									proba
								)
						)
					}
				}
			} else if (videoseq instanceof AlternativeVideoSeq) {
				videoseq.videodescs.forEach [ desc |
					if (!desc.videoid.nullOrEmpty) {
						identifiers.add(desc.videoid)
					}
					locations.add(desc.location)
				]

				val probaTotale = videoseq.videodescs.fold(0)[acc, desc|acc + desc.probability]
				val oneEmpty = videoseq.videodescs.exists[desc|desc.probability == 0]

				if (probaTotale > 100) {
					error.error(
						String.format(
							"La somme des probabilités de l'alternative %s est trop élevée : %d%%",
							if(videoseq.videoid.nullOrEmpty) "???" else videoseq.videoid,
							probaTotale
						)
					)
				}
				if (probaTotale < 100 && !oneEmpty) {
					error.error(
						String.format(
							"La somme des probabilités de l'alternative %s est trop faible : %d%%",
							if(videoseq.videoid.nullOrEmpty) "???" else videoseq.videoid,
							probaTotale
						)
					)
				}
				if (probaTotale == 100 && oneEmpty) {
					error.warning(
						String.format(
							"Certaines vidéos de l'alternative %s ne seront jamais utilisées",
							if(videoseq.videoid.nullOrEmpty) "???" else videoseq.videoid
						)
					)
				}
			}
		]

		// Vérification identifiants uniques
		while (identifiers.size > 0) {
			val id = identifiers.get(0)
			identifiers.remove(0)
			if (identifiers.contains(id)) {
				error.error("L'identifiant n'est pas unique : " + id)
			}
		}

		// Vérifications "locations"
		while (locations.size > 0) {
			val location = locations.get(0)
			locations.remove(0)
			if (locations.contains(location)) {
				error.warning("La vidéo est utilisée plusieurs fois : " + location)
			}
		}

		return error.code
	}
	
	/**
	 * A partir d'une VideoDescription, si elle contient un filtre : enregistre la vidéo avec le filtre
	 * Retourne le chemin de la nouvelle vidéo
	 * Retourne null en cas d'erreur ou si la vidéo n'a pas de filtre
	 */
	def static applyFilter(VideoDescription desc) {
		val filter = desc.filter
		if(filter != null){
			val input = desc.location
			val inputFile = new File(input)
			if(!inputFile.exists){
				return null
			}
			
			val outputBasename = inputFile.name.substring(0, inputFile.name.lastIndexOf('.'))
			val outputExtension = inputFile.name.substring(inputFile.name.lastIndexOf('.'))
			
			var String outputName = null
			var String filtre = null
			
			if(filter instanceof FlipFilter){
				val flip = filter as FlipFilter
				if(flip.orientation.equalsIgnoreCase("h") 
					|| flip.orientation.equalsIgnoreCase("horizontal")){
					
					outputName = outputBasename + "_hflip" + outputExtension
					filtre = "-vf hflip"
				
				}else if(flip.orientation.equalsIgnoreCase("v") 
					|| flip.orientation.equalsIgnoreCase("vertical")){
					
					outputName = outputBasename + "_hflip" + outputExtension
					filtre = "-vf vflip"
					
				}
			}else if(filter instanceof NegateFilter){
				
				outputName = outputBasename + "_negate" + outputExtension
				filtre = "-vf negate"
				
			}else if(filter instanceof BlackWhiteFilter){
				
				outputName = outputBasename + "_bw" + outputExtension
				filtre = "-vf hue=s=0"
				
			}
			
			if(outputName != null && filtre != null){
				val filteredDir = new File(inputFile.parentFile, "filtered")
				filteredDir.mkdirs
				val outputPath = filteredDir.path + "/" + outputName
				
				if(!(new File(outputPath)).exists){
					val cmd = "ffmpeg -i "+ input + " " + filtre + " " + outputPath
					println("Applique le filtre sur : "+input)
					println(cmd)
					val process = Runtime.runtime.exec(cmd)
					process.waitFor
					println("Enregistré dans : "+outputPath)
				}
				
				return outputPath
			}
		}
		return null
	}

}
