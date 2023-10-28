package com.TheDonateCompass.TheDonateCompass.Controller;

import com.TheDonateCompass.TheDonateCompass.Entity.PostONGEntity;
import com.TheDonateCompass.TheDonateCompass.Service.PostONGService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postong")
public class PostONGController {
    @Autowired
    private PostONGService service;

    @GetMapping("/")
    public ResponseEntity getAllPosts() {
        List<PostONGEntity> posts = service.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity getAllLocations() {
        List<String> locations = service.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity getFilteredONGPosts(@RequestParam(value = "location", required = false) String location, @RequestParam(value = "severity", required = false) String severity, Pageable pageable) {
        return new ResponseEntity<>(service.filterONGPosts(location, severity, pageable), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity createPost(@RequestBody PostONGEntity postONGEntity) {
        service.createPost(postONGEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePostById(@PathVariable Long id) {
        return new ResponseEntity<>(service.deletePostById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost(@RequestBody PostONGEntity postONGEntity, @PathVariable Long id) {
        return new ResponseEntity<>(service.updatePost(postONGEntity, id), HttpStatus.OK);
    }
}
