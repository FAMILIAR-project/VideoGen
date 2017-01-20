package com.istic.videogen.web.rest;

import com.istic.videogen.config.Constants;
import com.codahale.metrics.annotation.Timed;
import com.istic.videogen.domain.User;
import com.istic.videogen.repository.UserRepository;
import com.istic.videogen.security.AuthoritiesConstants;
import com.istic.videogen.service.MailService;
import com.istic.videogen.service.UserService;
import com.istic.videogen.web.rest.vm.ManagedUserVM;

import videogen.VideoDemonstrator;

import com.istic.videogen.web.rest.util.HeaderUtil;
import com.istic.videogen.web.rest.util.PaginationUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * REST controller for managing videogen.
 */
@RestController
@RequestMapping("/api")
public class VideogenResource {

    /**
     * GET  /users : get all users.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and with body all users
     * @throws URISyntaxException if the pagination headers couldn't be generated
     */
    @GetMapping("/videogen/getVideogen")
    @Timed
    public String getVideogen() {
        VideoDemonstrator vDemonstrator = new VideoDemonstrator();
        HashMap<String, String> videos = vDemonstrator.videoGenToJhipster();
        Iterator it = videos.entrySet().iterator();
        String result = "{";
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            result += "\"" + pair.getKey() + "\" : \"" + pair.getValue() + "\",";
        }
        result = result.substring(0, result.length() - 1);
        result += "}";
        return result;
    }

    @GetMapping("/videogen/generatePlaylist")
    @Timed
    public String generatePlaylist(@RequestParam("text") String text, @RequestParam("position") String position, @RequestParam("data") String[] videos) {
        List<String> pathList = new ArrayList<String>();
        VideoDemonstrator vDemonstrator = new VideoDemonstrator();
        if(!videos[0].equals("null") && !text.isEmpty()){
            ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(videos));
            pathList = vDemonstrator.generateFromJhipsterWithText(tmp, text, position);
        }else{
            pathList = vDemonstrator.generateFromJhipster();
        }
        String result = "{";
        int i = 0;
        for (String path : pathList
            ) {
            result += "\"video" + i + "\" : \"" + path + "\",";
            i++;
        }
        result = result.substring(0, result.length() - 1);
        result += "}";
        return result;
    }

    @GetMapping("/videogen/generatePlaylistFromUserChoices")
    @Timed
    public String generatePlaylistFromUserChoices(@RequestParam("data") String[] videos, @RequestParam("text") String text, @RequestParam("position") String position, @RequestParam("data2") String[] videos2) {
        ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(videos));
        List<String> pathList = new ArrayList<String>();
        VideoDemonstrator vDemonstrator = new VideoDemonstrator();
        if(!videos2[0].equals("null") && !text.isEmpty()){
            ArrayList<String> tmp2 = new ArrayList<String>(Arrays.asList(videos2));
            pathList = vDemonstrator.setProbaFromUserChoicesWithText(tmp, tmp2, text, position);
        }else{
            pathList = vDemonstrator.setProbaFromUserChoices(tmp);
        }
        String result = "{";
        int i = 0;
        for (String path : pathList
            ) {
            result += "\"video" + i + "\" : \"" + path + "\",";
            i++;
        }
        result = result.substring(0, result.length() - 1);
        result += "}";
        return result;
    }

    @GetMapping("/videogen/generateGif")
    @Timed
    public String generateGif(@RequestParam("data") String[] tab) {
        ArrayList<String> tmp = new ArrayList<String>(Arrays.asList(tab));
        VideoDemonstrator vDemonstrator = new VideoDemonstrator();
        String gifPath = vDemonstrator.generateGif(tmp);
        String result = "{ \"gifPath\" : \"" + gifPath +"\" }";
        return result;
    }
}
