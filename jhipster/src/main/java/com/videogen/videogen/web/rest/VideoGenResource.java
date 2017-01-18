package com.videogen.videogen.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.videogen.videogen.domain.User;
import com.videogen.videogen.web.rest.vm.ManagedUserVM;

import q10.VideoGenerator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing the current user's account.
 */
@RestController
@RequestMapping("/api/videogen")
public class VideoGenResource {

    private final Logger log = LoggerFactory.getLogger(VideoGenResource.class);

    private String videoGenPath="src/main/webapp/videogen/";
   
    /**
     * POST  /register : register the user.
     *
     * @param managedUserVM the managed user View Model
     * @return the ResponseEntity with status 201 (Created) if the user is registered or 400 (Bad Request) if the login or e-mail is already in use
     */
    @RequestMapping(value = "/regenerate",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public Response regenerate() {
        String playlist=(new q12.VideoGenerator()).generatePlaylistForFile(videoGenPath+"test.videogen");
        Response r=new Response();
        r.playlist=playlist;
        return r;
        
    }
    
    
    class Response{
    	boolean done=false;
    	List<String> playlist=new ArrayList<>();
    	
    	
    	

		public List<String> getPlaylist() {
			return playlist;
		}
		public void setPlaylist(List<String> playlist) {
			this.playlist = playlist;
		}
		public boolean isDone() {
			return done;
		}
		public void setDone(boolean done) {
			this.done = done;
		}

    	
    }
   
}
