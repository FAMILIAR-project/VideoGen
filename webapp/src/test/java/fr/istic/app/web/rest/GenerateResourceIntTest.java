package fr.istic.app.web.rest;

import fr.istic.app.WebappApp;

import fr.istic.app.domain.Generate;
import fr.istic.app.repository.GenerateRepository;

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
 * Test class for the GenerateResource REST controller.
 *
 * @see GenerateResource
 */
@RunWith(SpringRunner.class)

@SpringBootTest(classes = WebappApp.class)

public class GenerateResourceIntTest {

    @Inject
    private GenerateRepository generateRepository;

    @Inject
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Inject
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Inject
    private EntityManager em;

    private MockMvc restGenerateMockMvc;

    private Generate generate;

    @PostConstruct
    public void setup() {
        MockitoAnnotations.initMocks(this);
        GenerateResource generateResource = new GenerateResource();
        ReflectionTestUtils.setField(generateResource, "generateRepository", generateRepository);
        this.restGenerateMockMvc = MockMvcBuilders.standaloneSetup(generateResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Generate createEntity(EntityManager em) {
        Generate generate = new Generate();
        return generate;
    }

    @Before
    public void initTest() {
        generate = createEntity(em);
    }

    @Test
    @Transactional
    public void createGenerate() throws Exception {
        int databaseSizeBeforeCreate = generateRepository.findAll().size();

        // Create the Generate

        restGenerateMockMvc.perform(post("/api/generates")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(generate)))
                .andExpect(status().isCreated());

        // Validate the Generate in the database
        List<Generate> generates = generateRepository.findAll();
        assertThat(generates).hasSize(databaseSizeBeforeCreate + 1);
        Generate testGenerate = generates.get(generates.size() - 1);
    }

    @Test
    @Transactional
    public void getAllGenerates() throws Exception {
        // Initialize the database
        generateRepository.saveAndFlush(generate);

        // Get all the generates
        restGenerateMockMvc.perform(get("/api/generates?sort=id,desc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(generate.getId().intValue())));
    }

    @Test
    @Transactional
    public void getGenerate() throws Exception {
        // Initialize the database
        generateRepository.saveAndFlush(generate);

        // Get the generate
        restGenerateMockMvc.perform(get("/api/generates/{id}", generate.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(generate.getId().intValue()));
    }

    @Test
    @Transactional
    public void getNonExistingGenerate() throws Exception {
        // Get the generate
        restGenerateMockMvc.perform(get("/api/generates/{id}", Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateGenerate() throws Exception {
        // Initialize the database
        generateRepository.saveAndFlush(generate);
        int databaseSizeBeforeUpdate = generateRepository.findAll().size();

        // Update the generate
        Generate updatedGenerate = generateRepository.findOne(generate.getId());

        restGenerateMockMvc.perform(put("/api/generates")
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(updatedGenerate)))
                .andExpect(status().isOk());

        // Validate the Generate in the database
        List<Generate> generates = generateRepository.findAll();
        assertThat(generates).hasSize(databaseSizeBeforeUpdate);
        Generate testGenerate = generates.get(generates.size() - 1);
    }

    @Test
    @Transactional
    public void deleteGenerate() throws Exception {
        // Initialize the database
        generateRepository.saveAndFlush(generate);
        int databaseSizeBeforeDelete = generateRepository.findAll().size();

        // Get the generate
        restGenerateMockMvc.perform(delete("/api/generates/{id}", generate.getId())
                .accept(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk());

        // Validate the database is empty
        List<Generate> generates = generateRepository.findAll();
        assertThat(generates).hasSize(databaseSizeBeforeDelete - 1);
    }
}
