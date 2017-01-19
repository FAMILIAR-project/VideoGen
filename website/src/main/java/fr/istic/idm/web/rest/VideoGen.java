package fr.istic.idm.web.rest;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

import org.apache.commons.io.Charsets;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.io.Files;

import playlist.Playlist;
import videogen.EnhancedVideoGen;

@RestController
@RequestMapping("/api")
public class VideoGen {
	
	Logger logger = LoggerFactory.getLogger(VideoGen.class);
	
	@RequestMapping(value = "video-gen",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Playlist> getPlaylist()
	{
		try {
			String specification = Files.readLines(new File("mastaconcat.videogen"), Charsets.UTF_8).stream().collect(Collectors.joining());
			return new ResponseEntity<Playlist>(EnhancedVideoGen.main(new String[] {specification}),
					HttpStatus.OK);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
		return new ResponseEntity<Playlist>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@RequestMapping(value = "video-gen/specification",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Playlist> getPlaylist(@RequestBody String specification)
	{
		return new ResponseEntity<Playlist>(EnhancedVideoGen.main(new String[] {specification}),
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "video-gen/configurateur",
			method=RequestMethod.GET,
			produces=MediaType.APPLICATION_XHTML_XML_VALUE)
	public ResponseEntity<String> getConfigurateur(@RequestBody(required=false) String specification)
	{
		try {
			specification = Files.readLines(new File("mastaconcat.videogen"), Charsets.UTF_8).stream().collect(Collectors.joining());
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		if(!(new File("videogen.css")).exists())
		{
			try {
				Files.write(EnhancedVideoGen.getCssFile(), new File("videogen.css"), Charsets.UTF_8);
			} catch (IOException e) {
				logger.error(e.getMessage(), e);
			}
		}
		return new ResponseEntity<String>(EnhancedVideoGen.printToHTMLext(specification), HttpStatus.OK);
	}
}
