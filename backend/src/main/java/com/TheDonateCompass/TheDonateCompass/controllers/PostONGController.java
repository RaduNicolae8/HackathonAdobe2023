package com.TheDonateCompass.TheDonateCompass.controllers;

import com.TheDonateCompass.TheDonateCompass.entities.PostONGEntity;
import com.TheDonateCompass.TheDonateCompass.services.PostONGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/postong")
public class PostONGController {
    @Autowired
    private PostONGService service;

    @PostMapping("/")
    public ResponseEntity<?> createPost(@RequestBody PostONGEntity postONGEntity) {
        return service.createPost(postONGEntity);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllPosts() {
        return new ResponseEntity<>(service.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity<?> getAllLocations() {
        return new ResponseEntity<>(service.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> getFilteredONGPosts(@RequestParam(value = "location", required = false) String location, @RequestParam(value = "severity", required = false) String severity, Pageable pageable) {
        return new ResponseEntity<>(service.filterONGPosts(location, severity, pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@RequestBody PostONGEntity postONGEntity, @PathVariable Long id) {
        return service.updatePost(postONGEntity, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable Long id) {
        return service.deletePostById(id);
    }
}
