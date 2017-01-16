package videogen

import org.eclipse.emf.common.util.URI

class Main {
	def static void main(String[] args) {
		val vv=new transformModelToText()
//		Q1:
//		vv.transform()
//		Q2
		var playlist = vv.playlist()
//		vv.transformationPlaylistToFileM3U(playlist)
//		Q4
//		vv.transformationPlaylistToFileffmpeg(playlist)
//		Q5
//	vv.playlistVignette(playlist);
	var videoGen = vv.loadVideoGenerator(URI.createURI("foo1.videogen"))
//	vv.printToHTML(videoGen);
	
	//Q12 genere une pageHTML
	vv.printToHTMLWithRandom(videoGen)
	}
	
}
