package fr.istic.idm.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import playlist.Playlist;
import videogen.EnhancedVideoGen;

@RestController
@RequestMapping("/api")
public class VideoGen {
	
	@RequestMapping(value = "video-gen",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Playlist> getPlaylist()
	{
		return new ResponseEntity<Playlist>(EnhancedVideoGen.main(new String[] {}),
				HttpStatus.OK);
	}
}
