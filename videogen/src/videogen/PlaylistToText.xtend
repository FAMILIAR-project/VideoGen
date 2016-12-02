package videogen

import playlist.Playlist

class PlaylistToText {
	
	/**
	 * Ecrit la playlist donnee dans un certain format de playlist
	 * @param playlist playlist a ecrire
	 * @param format format de la liste a choisir entre "ffmpeg" et "m3u"
	 * @return texte representant la playlist
	 */
	def playlistToText(Playlist playlist, String format){
		val result = new StringBuilder()
		if(format.equals("m3u")){
			playlist.videos.forEach[vid |
				result.append(vid.url+System.lineSeparator)
			]
		}
		else if(format.equals("ffmpeg")){
			playlist.videos.forEach[vid |
				result.append("file '"+vid.url+"'"+System.lineSeparator)
			]
		}
		result.toString()
	}
	
}