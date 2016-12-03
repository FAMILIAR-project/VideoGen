package videogen

import org.xtext.example.mydsl.VideoGenStandaloneSetupGenerated
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.common.util.URI
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel
import java.util.Random
import org.xtext.example.mydsl.videoGen.MandatoryVideoSeq
import org.xtext.example.mydsl.videoGen.OptionalVideoSeq
import org.xtext.example.mydsl.videoGen.AlternativeVideoSeq
import java.io.FileWriter

//import playlist.*
import playlist.Playlist
import playlist.Video
import playlist.PlaylistFactory
import playlist.Comment
import playlist.Content

class VideogenToPlaylist {
	def loadVideoGenerator(URI uri) {
		new VideoGenStandaloneSetupGenerated().createInjectorAndDoEMFRegistration()
		var res = new ResourceSetImpl().getResource(uri, true);
		res.contents.get(0) as VideoGeneratorModel
	}
	
	def void videogenToPlaylist(URI uri,FileWriter fout,String ext){
		var videogen = loadVideoGenerator(uri)
		val rnd = new Random()
		val playlist = PlaylistFactory.eINSTANCE.createPlaylist
		//println("# this is a comment")
		//fout.write("# this is a comment\n")
		videogen.videoseqs.forEach[vid|
			if (vid instanceof MandatoryVideoSeq){
				//println("file '"+vid.description.location+"'")
				//fout.write("file '"+vid.description.location+"'\n")
				//var path = AbsolutePath.
				val video = PlaylistFactory.eINSTANCE.createVideo
				video.setPath(vid.description.location)
				playlist.contents.add(video)
				//playlist.
				//playlist.contents.add(AbsolutePath.setDir(vid.description.location))
			}
			if (vid instanceof OptionalVideoSeq){
				if (rnd.nextBoolean()){
					//println("file '"+vid.description.location+"'")
					//fout.write("file '"+vid.description.location+"'\n")
					val video = PlaylistFactory.eINSTANCE.createVideo
					video.setPath(vid.description.location)
					playlist.contents.add(video)
				}
			}
			if (vid instanceof AlternativeVideoSeq){
				
				var n = rnd.nextInt(vid.videodescs.size)
				//println("file '"+vid.videodescs.get(n).location+"'")
				//fout.write("file '"+vid.videodescs.get(n).location+"'\n")
				val video = PlaylistFactory.eINSTANCE.createVideo
				video.setPath(vid.videodescs.get(n).location)
				playlist.contents.add(video)
			}
		]
		//var ext = fout.
		convertPlaylistIntoFormat(playlist, ext, fout)
		//fout.write(playlistStr)
		fout.close()
	}
	
	def void convertPlaylistIntoFormat(Playlist playlist, String format, FileWriter fout){
		//convertir en fichier texte
		//var out = ""
		if (format.equals("M3U")){
			playlist.contents.forEach[vid|
				if (vid instanceof Comment){
					fout.write("# "+vid.comment+"\n")
				}
				if (vid instanceof Video){
					fout.write(vid.path+"\n")
				}
			]
		}
		if (format.equals("txt")){
			playlist.contents.forEach[vid|
				if (vid instanceof Comment){
					fout.write("# "+vid.comment+"\n")
				}
				if (vid instanceof Video){
					fout.write("file '"+vid.path+"'\n")
				}
			]
		}
	}
	
	def static void main(String[] args) {
		//var in = args.get(1)
		val mtt = new VideogenToPlaylist
		val fout = new FileWriter("foo2.txt")
		val ext = "txt" //ou "m3u", pas de vérification de concordance avec l'extension de fichier
		mtt.videogenToPlaylist(URI.createURI("foo2.videogen"),fout,ext)
	}
}