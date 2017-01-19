package fr.istic.videogen.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import videogen.VideoGenGenerator;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by havvok on 19/01/17.
 */
@RestController
@RequestMapping("/api")
public class VideoGenResource {


    private final Logger log = LoggerFactory.getLogger(VideoGenResource.class);

    @RequestMapping(value = "/videogen",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String generate(HttpServletRequest request){
        VideoGenGenerator videoGenGenerator = new VideoGenGenerator();
        return videoGenGenerator.generate("/home/havvok/Documents/testvideogen/montage.videogen");

    }
}
