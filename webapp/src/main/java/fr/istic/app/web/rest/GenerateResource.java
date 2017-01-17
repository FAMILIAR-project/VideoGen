package fr.istic.app.web.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.istic.app.repository.GenerateRepository;
import videogen.playlist.PlaylistDemonstrator;

/**
 * REST controller for managing Generate.
 */
@RestController
@RequestMapping("/api")
public class GenerateResource {

    private final Logger log = LoggerFactory.getLogger(GenerateResource.class);

    @Inject
    private GenerateRepository generateRepository;

    @RequestMapping(value = "/random",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> generate() {
        PlaylistDemonstrator playlistDemonstrator = new PlaylistDemonstrator();
        playlistDemonstrator.videogenToPlaylist();
        
        List<String> videos = new ArrayList<String>();
        
        try {
        	BufferedReader br = new BufferedReader(new FileReader("test.m3u"));
            String line = br.readLine();

            while (line != null) {
                videos.add(line);
                line = br.readLine();
            }
            
            br.close();
        }
        catch(IOException io){
        }
        //return JSON
        return videos;
    }

//    /**
//     * POST  /generates : Create a new generate.
//     *
//     * @param generate the generate to create
//     * @return the ResponseEntity with status 201 (Created) and with body the new generate, or with status 400 (Bad Request) if the generate has already an ID
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @RequestMapping(value = "/generates",
//        method = RequestMethod.POST,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
//    public ResponseEntity<Generate> createGenerate(@RequestBody Generate generate) throws URISyntaxException {
//        log.debug("REST request to save Generate : {}", generate);
//        if (generate.getId() != null) {
//            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("generate", "idexists", "A new generate cannot already have an ID")).body(null);
//        }
//        Generate result = generateRepository.save(generate);
//        return ResponseEntity.created(new URI("/api/generates/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert("generate", result.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * PUT  /generates : Updates an existing generate.
//     *
//     * @param generate the generate to update
//     * @return the ResponseEntity with status 200 (OK) and with body the updated generate,
//     * or with status 400 (Bad Request) if the generate is not valid,
//     * or with status 500 (Internal Server Error) if the generate couldnt be updated
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @RequestMapping(value = "/generates",
//        method = RequestMethod.PUT,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
//    public ResponseEntity<Generate> updateGenerate(@RequestBody Generate generate) throws URISyntaxException {
//        log.debug("REST request to update Generate : {}", generate);
//        if (generate.getId() == null) {
//            return createGenerate(generate);
//        }
//        Generate result = generateRepository.save(generate);
//        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert("generate", generate.getId().toString()))
//            .body(result);
//    }
//
//    /**
//     * GET  /generates : get all the generates.
//     *
//     * @return the ResponseEntity with status 200 (OK) and the list of generates in body
//     */
//    @RequestMapping(value = "/generates",
//        method = RequestMethod.GET,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
//    public List<Generate> getAllGenerates() {
//        log.debug("REST request to get all Generates");
//        List<Generate> generates = generateRepository.findAll();
//        return generates;
//    }
//
//    /**
//     * GET  /generates/:id : get the "id" generate.
//     *
//     * @param id the id of the generate to retrieve
//     * @return the ResponseEntity with status 200 (OK) and with body the generate, or with status 404 (Not Found)
//     */
//    @RequestMapping(value = "/generates/{id}",
//        method = RequestMethod.GET,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
//    public ResponseEntity<Generate> getGenerate(@PathVariable Long id) {
//        log.debug("REST request to get Generate : {}", id);
//        Generate generate = generateRepository.findOne(id);
//        return Optional.ofNullable(generate)
//            .map(result -> new ResponseEntity<>(
//                result,
//                HttpStatus.OK))
//            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    /**
//     * DELETE  /generates/:id : delete the "id" generate.
//     *
//     * @param id the id of the generate to delete
//     * @return the ResponseEntity with status 200 (OK)
//     */
//    @RequestMapping(value = "/generates/{id}",
//        method = RequestMethod.DELETE,
//        produces = MediaType.APPLICATION_JSON_VALUE)
//    @Timed
//    public ResponseEntity<Void> deleteGenerate(@PathVariable Long id) {
//        log.debug("REST request to delete Generate : {}", id);
//        generateRepository.delete(id);
//        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("generate", id.toString())).build();
//    }

}
