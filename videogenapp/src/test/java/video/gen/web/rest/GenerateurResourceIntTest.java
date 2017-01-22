package video.gen.web.rest;

import video.gen.VideoGenApplicationApp;

import video.gen.domain.Generateur;
import video.gen.repository.GenerateurRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.hasItem;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the GenerateurResource REST controller.
 *
 * @see GenerateurResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = VideoGenApplicationApp.class)
public class GenerateurResourceIntTest {

    private static final String DEFAULT_TEST = "AAAAA";
    private static final String UPDATED_TEST = "BBBBB";

    @Inject
    private GenerateurRepository generateurRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restGenerateurMockMvc;

    private Generateur generateur;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        GenerateurResource generateurResource = new GenerateurResource();
        ReflectionTestUtils.setField(generateurResource, "generateurRepository", generateurRepository);
        this.restGenerateurMockMvc = MockMvcBuilders.standaloneSetup(generateurResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Generateur createEntity(EntityManager em) {
        Generateur generateur = new Generateur()
                .test(DEFAULT_TEST);
        return generateur;
    }

    @Before
    public void initTest() {
        generateur = createEntity(em);
    }

    @Test
    @Transactional
    public void createGenerateur() throws Exception {
        int databaseSizeBeforeCreate = generateurRepository.findAll().size();

        // Create the Generateur

        restGenerateurMockMvc.perform(post("/api/generateurs")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(generateur)))
                .andExpect(status().isCreated());

        // Validate the Generateur in the database
        List<Generateur> generateurs = generateurRepository.findAll();
        assertThat(generateurs).hasSize(databaseSizeBeforeCreate + 1);
        Generateur testGenerateur = generateurs.get(generateurs.size() - 1);
        assertThat(testGenerateur.getTest()).isEqualTo(DEFAULT_TEST);
    }

    @Test
    @Transactional
    public void getAllGenerateurs() throws Exception {
        // Initialize the database
        generateurRepository.saveAndFlush(generateur);

        // Get all the generateurs
        restGenerateurMockMvc.perform(get("/api/generateurs?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(generateur.getId().intValue())))
                .andExpect(jsonPath("$.[*].test").value(hasItem(DEFAULT_TEST.toString())));
    }

    @Test
    @Transactional
    public void getGenerateur() throws Exception {
        // Initialize the database
        generateurRepository.saveAndFlush(generateur);

        // Get the generateur
        restGenerateurMockMvc.perform(get("/api/generateurs/{id}", generateur.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(generateur.getId().intValue()))
            .andExpect(jsonPath("$.test").value(DEFAULT_TEST.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingGenerateur() throws Exception {
        // Get the generateur
        restGenerateurMockMvc.perform(get("/api/generateurs/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGenerateur() throws Exception {
        // Initialize the database
        generateurRepository.saveAndFlush(generateur);
        int databaseSizeBeforeUpdate = generateurRepository.findAll().size();

        // Update the generateur
        Generateur updatedGenerateur = generateurRepository.findOne(generateur.getId());
        updatedGenerateur
                .test(UPDATED_TEST);

        restGenerateurMockMvc.perform(put("/api/generateurs")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedGenerateur)))
                .andExpect(status().isOk());

        // Validate the Generateur in the database
        List<Generateur> generateurs = generateurRepository.findAll();
        assertThat(generateurs).hasSize(databaseSizeBeforeUpdate);
        Generateur testGenerateur = generateurs.get(generateurs.size() - 1);
        assertThat(testGenerateur.getTest()).isEqualTo(UPDATED_TEST);
    }

    @Test
    @Transactional
    public void deleteGenerateur() throws Exception {
        // Initialize the database
        generateurRepository.saveAndFlush(generateur);
        int databaseSizeBeforeDelete = generateurRepository.findAll().size();

        // Get the generateur
        restGenerateurMockMvc.perform(delete("/api/generateurs/{id}", generateur.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Generateur> generateurs = generateurRepository.findAll();
        assertThat(generateurs).hasSize(databaseSizeBeforeDelete - 1);
    }
}
