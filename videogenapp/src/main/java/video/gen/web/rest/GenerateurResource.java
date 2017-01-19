package video.gen.web.rest;

import com.codahale.metrics.annotation.Timed;

import playlist.Playlist;
import video.gen.domain.Generateur;

import video.gen.repository.GenerateurRepository;
import video.gen.web.rest.util.HeaderUtil;
import videogen.transformationsVideo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xtext.example.mydsl.videoGen.VideoGeneratorModel;

import javax.inject.Inject;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Generateur.
 */
@RestController
@RequestMapping("/api")
public class GenerateurResource {

    private final Logger log = LoggerFactory.getLogger(GenerateurResource.class);
        
    @Inject
    private GenerateurRepository generateurRepository;

    /**
     * POST  /generateurs : Create a new generateur.
     *
     * @param generateur the generateur to create
     * @return the ResponseEntity with status 201 (Created) and with body the new generateur, or with status 400 (Bad Request) if the generateur has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/generateurs",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Generateur> createGenerateur(@RequestBody Generateur generateur) throws URISyntaxException {
        log.debug("REST request to save Generateur : {}", generateur);
        if (generateur.getId() != null) {
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("generateur", "idexists", "A new generateur cannot already have an ID")).body(null);
        }
        Generateur result = generateurRepository.save(generateur);
        return ResponseEntity.created(new URI("/api/generateurs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert("generateur", result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /generateurs : Updates an existing generateur.
     *
     * @param generateur the generateur to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated generateur,
     * or with status 400 (Bad Request) if the generateur is not valid,
     * or with status 500 (Internal Server Error) if the generateur couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @RequestMapping(value = "/generateurs",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Generateur> updateGenerateur(@RequestBody Generateur generateur) throws URISyntaxException {
        log.debug("REST request to update Generateur : {}", generateur);
        if (generateur.getId() == null) {
            return createGenerateur(generateur);
        }
        Generateur result = generateurRepository.save(generateur);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert("generateur", generateur.getId().toString()))
            .body(result);
    }

    /**
     * GET  /generateurs : get all the generateurs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of generateurs in body
     */
    @RequestMapping(value = "/generateurs",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public List<Generateur> getAllGenerateurs() {
        log.debug("REST request to get all Generateurs");
        List<Generateur> generateurs = generateurRepository.findAll();
        return generateurs;
    }

    /**
     * GET  /generateurs/:id : get the "id" generateur.
     *
     * @param id the id of the generateur to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the generateur, or with status 404 (Not Found)
     */
    @RequestMapping(value = "/generateurs/{id}",
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public ResponseEntity<Generateur> getGenerateur(@PathVariable Long id) {
        log.debug("REST request to get Generateur : {}", id);
        Generateur generateur = generateurRepository.findOne(id);
        return Optional.ofNullable(generateur)
            .map(result -> new ResponseEntity<>(
                result,
                HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * DELETE  /generateurs/:id : delete the "id" generateur.
     *
     * @param id the id of the generateur to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @RequestMapping(value = "/generateurs/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    public void deleteGenerateur(@PathVariable Long id) {
		transformationsVideo vv=new transformationsVideo()
				//Playlist playlist = vv.playlist();
		VideoGeneratorModel videoGen = vv.loadVideoGenerator(URI.createURI("foo1.videogen")) ;
			vv.printToHTML(videoGen);
       // return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert("generateur", id.toString())).build();
    }

}
