package videogen


class PlaylistToText {
	
	/**
	 * Ecrit la playlist donnee dans un certain format de playlist
	 * Le format "m3uext" necessite que les videos de la playlist aient une duree renseignee
	 * @param playlist playlist a ecrire
	 * @param format format de la liste a choisir entre "ffmpeg", "m3u" et "m3uext"
	 * @return texte representant la playlist
	 */
	def static playlistToText(Playlist playlist, String format){
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
		else if(format.equals("m3uext")){
			result.append("#EXTM3U"+System.lineSeparator)
			playlist.videos.forEach[vid |
				if(vid.duration != null){
					result.append("#EXT-X-DISCONTINUITY"+System.lineSeparator)
					result.append("#EXTINF:"+vid.duration+System.lineSeparator)
					result.append(vid.url+System.lineSeparator)
				}
			]
			result.append("#EXT-X-ENDLIST")
		}
		result.toString
	}
	
}