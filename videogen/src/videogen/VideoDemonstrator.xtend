package videogen

import java.io.FileWriter
import java.util.HashMap
import java.util.Random
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.junit.Test
import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.xtext.example.mydsl.playlist.MediaFile
import org.xtext.example.mydsl.playlist.Playlist
import org.xtext.example.mydsl.playlist.PlaylistFactory
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel

import static org.junit.Assert.*
import java.io.BufferedWriter
import java.util.logging.Logger
import java.io.File
import java.io.FileReader
import java.nio.file.Files
import java.nio.file.Path

class VideoDemonstrator {
	
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
	def void modelToTextToFile(){
		val filename = "vdgtest"
		var videoGen = loadVideoGenerator(URI.createURI(filename + ".videogen")) 
		assertNotNull(videoGen)
		val generatedFile = new FileWriter(filename + ".txt")
		assertNotNull(generatedFile)
		modelToText(videoGen,generatedFile)
	}
	
	@Test
	def void modelToModelToTxt(){
		val filename = "vdgtest"
		var videoGen = loadVideoGenerator(URI.createURI(filename + ".videogen")) 
		assertNotNull(videoGen)
		val playlist = modelToModel(videoGen, filename);
		convertPlaylistToTxt(playlist,filename)
	}
	
	@Test
	def void modelToModelToM3U(){
		val filename = "vdgtest"
		var videoGen = loadVideoGenerator(URI.createURI(filename + ".videogen")) 
		assertNotNull(videoGen)
		val playlist = modelToModel(videoGen, filename);
		convertPlaylistToM3U(playlist,filename)
	}
	
	@Test
	def void modelToModelToM3UExtended(){
		val filename = "vdgtest"
		var videoGen = loadVideoGenerator(URI.createURI(filename + ".videogen")) 
		assertNotNull(videoGen)
		val playlist = modelToModel(videoGen, filename);
		convertPlaylistToM3UEtendu(playlist,filename)
	}
	
	@Test 
	def void verifieVideoGen(){
		val filename = URI.createURI("vdgtest.videogen")
		val VideoGenVerificator verificator = new VideoGenVerificator()
		println("\nVérification de la specification Videogen : "+ filename)
		verificator.verifieVideoGen(filename);
	}
	
	def void modelToText(VideoGeneratorModel videoGen, FileWriter file){
		val r = new Random();
		println ('This is a comment')
		file.write('This is a comment\n')
		// loading 			
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description

				if(!desc.videoid.isNullOrEmpty){
					desc.videoid = genID()
					println("file "  + "'"+ desc.location+"'")
					file.write("file "  + "'"+ desc.location+"'\n")
				}  
				
				  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					if(r.nextBoolean()){
						desc.videoid = genID() 
						println("file "  + "'"+ desc.location+"'")
						file.write("file "  + "'"+ desc.location+"'\n")
					}
				} 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
					val vdesc = altvid.videodescs.get(r.nextInt(altvid.videodescs.size));
					if(!vdesc.videoid.isNullOrEmpty){
					 vdesc.videoid = genID()
					println("file " + "'"+ vdesc.location+"'")
					file.write("file "  + "'"+ vdesc.location+"'\n")
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("vdgtest.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("vdgtest.videogen"), videoGen)
		
	file.close
	}
	
	def Playlist modelToModel(VideoGeneratorModel videoGen, String filename){
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist();
		val r = new Random();
		val ffmpeg = new FfmpegHelper()
		val StringBuilder sb = new StringBuilder();
		generateHeader(sb)
		sb.append("<div>")
		
		println ('This is a comment')
		// MODEL MANAGEMENT (ANALYSIS, TRANSFORMATION)
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description

				if(!desc.videoid.isNullOrEmpty){
					desc.videoid = genID()
					desc.setDuration(ffmpeg.getDuration(desc.location))
					println("file "  + "'"+ desc.location+"'")
					ffmpeg.generateVignette(desc.location)
		
					//Q10				
					sb.append("<img src=../" + desc.location.substring(0, desc.location.lastIndexOf('.'))+ ".jpg width=\"100\" height=\"100\">")
					
					val MediaFile mediaFile = PlaylistFactory.eINSTANCE.createMediaFile
					mediaFile.location = desc.location
					mediaFile.duration = desc.duration
					playlist.getVids().add(mediaFile)
				}  	
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty){
					if(r.nextBoolean()){
						desc.videoid = genID() 
						desc.setDuration(ffmpeg.getDuration(desc.location))
						println("file "  + "'"+ desc.location+"'")
						ffmpeg.generateVignette(desc.location)
						
						//Q10
						sb.append("<img src=../" + desc.location.substring(0, desc.location.lastIndexOf('.'))+ ".jpg width=\"100\" height=\"100\">")
						
						val MediaFile mediaFile = PlaylistFactory.eINSTANCE.createMediaFile
						mediaFile.location = desc.location
						mediaFile.duration = desc.duration
						playlist.getVids().add(mediaFile)
					}
				} 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(altvid.videoid.isNullOrEmpty) altvid.videoid = genID()
					val vdesc = altvid.videodescs.get(r.nextInt(altvid.videodescs.size));
					if(!vdesc.videoid.isNullOrEmpty){
					 vdesc.videoid = genID()
					 vdesc.setDuration(ffmpeg.getDuration(vdesc.location))
					 println("file " + "'"+ vdesc.location+"'")
					 ffmpeg.generateVignette(vdesc.location)
					 
					 //Q10
					 sb.append("</div>")
					 sb.append("</br>")
					 sb.append("<div>")
					 sb.append("<img src=../" + vdesc.location.substring(0, vdesc.location.lastIndexOf('.'))+ ".jpg width=\"100\" height=\"100\">")
					 sb.append("</div>")
					 
					val MediaFile mediaFile = PlaylistFactory.eINSTANCE.createMediaFile
					mediaFile.location = vdesc.location
					mediaFile.duration = vdesc.duration
					playlist.getVids().add(mediaFile)
					
					generateEndOfHtmlFile(sb);
					writeHtmlFile(sb)
				}
			}
		]
	// serializing
	saveVideoGenerator(URI.createURI("vdgtest.xmi"), videoGen)
	saveVideoGenerator(URI.createURI("vdgtest.videogen"), videoGen)
	
	return playlist;
		
	}
	
	/* Converti une playlist au txt */
	def void convertPlaylistToTxt(Playlist playlist,String filename){		
		val FileWriter f = new FileWriter(filename + ".txt")
		println("\nCONVERTION PLAYLIST AU FORMAT txt")
		println("Fichier de sortie : " + filename + ".txt")
		
		for (i : playlist.getVids().size >.. 0) {
			val element = playlist.getVids().get(i)
			f.write("file '" + element.location+"'" + "\n")
		}	
		f.close()
	}
	
	/* Converti une playlist au format m3u */
	def void convertPlaylistToM3U(Playlist playlist,String filename){
		val FileWriter f = new FileWriter(filename + ".m3u")
		println("\nCONVERTION PLAYLIST AU FORMAT M3U")
		println("Fichier de sortie : " + filename + ".m3u")
		
		for (i : playlist.getVids().size >.. 0) {
			val element = playlist.getVids().get(i)
			f.write(element.location + "\n")
		}	
		f.close()
	}
	
	/* Converti une playlist au format m3u étendu */
	//QUESTION 8
	def void convertPlaylistToM3UEtendu(Playlist playlist,String filename){
		
		val FileWriter f = new FileWriter(filename + "_extended.m3u")
		println("\nCONVERTION PLAYLIST AU FORMAT M3U ETENDU")
		println("Fichier de sortie : " + filename + "_extended.m3u")
		
		f.write("#EXTM3U \n")
		for (i : playlist.getVids().size >.. 0) {
			val element = playlist.getVids().get(i)
			f.write("#EXT-X-DISCONTINUITY\n")
			f.write("#EXTINF:"+ element.duration + "\n")
			f.write(element.location + "\n")
			f.write("\n")		
		}
		f.write("#EXT-X-ENDLIST")
		f.close()
	}
	
	/* HTML */
	//Q10
	def StringBuilder generateHeader(StringBuilder sb){
	    sb.append("<html>");
	    sb.append("<head>");
	    sb.append("<title>Title Of the page");
	    sb.append("</title>");
	    sb.append("</head>");
	    sb.append("<body>");
		return sb
	}
	
	//Q10
	def StringBuilder generateEndOfHtmlFile(StringBuilder sb){
		sb.append("</body>");
    	sb.append("</html>");
	}
	
	//Q10
	def writeHtmlFile(StringBuilder sb){
		    val FileWriter fstream = new FileWriter("output/vignette.html");
		    val BufferedWriter out = new BufferedWriter(fstream);
		    out.write(sb.toString());
		    out.close();
	}
	
	def void printToHTML(VideoGeneratorModel videoGen) {
		println("\nPRINT TO HML :")
		//var numSeq = 1
		println("<ul>")
		videoGen.videoseqs.forEach[videoseq | 
			if (videoseq instanceof MandatoryVideoSeq) {
				val desc = (videoseq as MandatoryVideoSeq).description
				if(!desc.videoid.isNullOrEmpty)  
					println ("<li>" + desc.videoid + "</li>")  				
			}
			else if (videoseq instanceof OptionalVideoSeq) {
				val desc = (videoseq as OptionalVideoSeq).description
				if(!desc.videoid.isNullOrEmpty) 
					println ("<li>" + desc.videoid + "</li>") 
			}
			else {
				val altvid = (videoseq as AlternativeVideoSeq)
				if(!altvid.videoid.isNullOrEmpty) 
					println ("<li>" + altvid.videoid + "</li>")
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("<ul>")
				for (vdesc : altvid.videodescs) {
					if(!vdesc.videoid.isNullOrEmpty) 
						println ("<li>" + vdesc.videoid + "</li>")
				}
				if (altvid.videodescs.size > 0) // there are vid seq alternatives
					println ("</ul>")
			}
		]
		println("</ul>")
	}
	
	static var i = 0;
	
	Object logger
	
	def genID() {
		"v" + i++
	}
	
}