package videogen




class Main {
	def static void main(String[] args) {
		val vv=new transformModelToText()
//		Q1:
//		vv.transform()
//		Q2
		var playlist = vv.playlist()
		vv.transformationPlaylistToFileM3U(playlist)
//		Q4
		vv.transformationPlaylistToFileffmpeg(playlist)
//		Q5

	}
	
}
