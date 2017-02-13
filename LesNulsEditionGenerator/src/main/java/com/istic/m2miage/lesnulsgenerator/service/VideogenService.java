package com.istic.m2miage.lesnulsgenerator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import videogen.VideoGenerator;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

@Service
@Transactional
public class VideogenService {

    private VideoGenerator videoGenerator;

    private final String DEFAULT_VIDEOGEN_PATH = "src/main/resources/default.videogen";
    private final String DEFAULT_THUMB_OUT_PATH = "src/main/webapp/content/images/thumbs";
    private final String DEFAULT_VIDEO_OUT_PATH = "src/main/webapp/content/videos";

    public VideogenService() {
        this.videoGenerator = new VideoGenerator();
    }

    public void generateRandomSequence() {
    }

    public void generateAllThumnails() {
        this.videoGenerator.generateVideogenThumbnails(DEFAULT_VIDEOGEN_PATH, DEFAULT_THUMB_OUT_PATH);
    }

    public String generateConfigThumbnails() {
        String json = "";
        ArrayList<String> files = this.videoGenerator.generateConfigThumbnails(DEFAULT_VIDEOGEN_PATH, DEFAULT_THUMB_OUT_PATH);
        ObjectMapper mapper = new ObjectMapper();
        OutputStream out = new ByteArrayOutputStream();
        try {
            json = mapper.writeValueAsString(files);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

    public String generateVideofile() {
        String filename = "edition.webm";
        this.videoGenerator.generateVideoFile(DEFAULT_VIDEOGEN_PATH, filename, DEFAULT_VIDEO_OUT_PATH);
        return DEFAULT_VIDEO_OUT_PATH + '/' + filename;
    }

    private void generateVideoGenFile(String mode) {
        switch (mode) {
            case "random":
                break;
            case "config":
                break;
            case "crazy":
                break;
            case "probility":
                break;
            default:
        }
    }

}
