package com.istic.m2miage.lesnulsgenerator.web.rest;

import com.istic.m2miage.lesnulsgenerator.service.VideogenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for the videogen service
 */
@RestController
@RequestMapping("/api/videogen")
public class VideoResource {
    private final VideogenService videogenService = new VideogenService();

    @GetMapping("/generateSequence")
    public void generateSequence() {
        //@todo
    }

    @GetMapping("/thumbnails")
    public String generateThumbnails() {
        return this.videogenService.generateConfigThumbnails();
    }

    @GetMapping("/generateVideo")
    public String generateVideo() {
        String video = this.videogenService.generateVideofile();
        return "{ video:" + video + "}";
    }
}
