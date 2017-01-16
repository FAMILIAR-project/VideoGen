package fr.istic.app.web.rest;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import videogen.playlist.PlaylistDemonstrator;

@RestController
@RequestMapping("/")
public class VideoGenResource {

    private final Logger log = LoggerFactory.getLogger(VideoGenResource.class);

    @RequestMapping(value = "random",
        method = RequestMethod.GET)
    public void generate() {
        File f = null;
        try {
            f = new File(getClass().getResource("/").getPath() + "../videogen/test.m3u");
            System.out.println(f.getAbsolutePath());
            if(!f.exists()) {
            	f.createNewFile();
            }
        }
        catch (IOException ioe) {
        	ioe.printStackTrace();
        }
        PlaylistDemonstrator playlistDemonstrator = new PlaylistDemonstrator();
        playlistDemonstrator.videogenToPlaylist();
    }
}
