package videogen

import org.eclipse.emf.common.util.URI

class Main {
	def static void main(String[] args) {
		val vv=new transformationsVideo()
//		Test Question 1:
		vv.transform()
//		Test Question 3:
		var playlist = vv.playlist()
		vv.transformationPlaylistToFileM3U(playlist)
//		Test Question 4:
		vv.transformationPlaylistToFileffmpeg(playlist)
//		Test Question 5:
        vv.transformationPlaylistToFileM3UEtendu(playlist)
//		Test Question 7:      
        vv.playlistWithDuration()
//		Test Question 9:
	    vv.playlistVignette(playlist);
 //		Test Question 10:
	    var videoGen = vv.loadVideoGenerator(URI.createURI("foo1.videogen"))
	    vv.printToHTML(videoGen);
 //		Test Question 11:
	    vv.verify
//		Test Question 12:
	    vv.printToHTMLWithRandom(videoGen)
//		Test Exercice SUPP 1:
	    vv.createVideoGen
//		Test Exercice SUPP 2:
	    vv.filters(videoGen)
//		Test Exercice SUPP 3:
	    vv.createFeatureModel()
	}
}
