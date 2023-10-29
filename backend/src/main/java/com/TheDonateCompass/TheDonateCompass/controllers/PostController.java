package com.TheDonateCompass.TheDonateCompass.controllers;

import com.TheDonateCompass.TheDonateCompass.entities.PostEntity;
import com.TheDonateCompass.TheDonateCompass.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping("/")
    public ResponseEntity<?> createPost(@RequestBody PostEntity postEntity) {
        return service.createPost(postEntity);
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
    public ResponseEntity<?> getFilteredPosts(@RequestParam(value = "location", required = false) String location, @RequestParam(value = "state", required = false) String state, @RequestParam(value = "productType", required = false) String productType, Pageable pageable) {
        return new ResponseEntity<>(service.filterPosts(location, state, productType, pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePost(@RequestBody PostEntity postEntity, @PathVariable Long id) {

        return service.updatePost(postEntity, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable Long id) {
        return service.deletePostById(id);
    }
}
