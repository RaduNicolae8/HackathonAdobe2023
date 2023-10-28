package com.TheDonateCompass.TheDonateCompass.Controller;

import com.TheDonateCompass.TheDonateCompass.Entity.PostEntity;
import com.TheDonateCompass.TheDonateCompass.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService service;

    @PostMapping("/")
    public ResponseEntity createPost(@RequestBody PostEntity postEntity) {
        service.createPost(postEntity);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity getAllPosts() {
        List<PostEntity> posts = service.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/location")
    public ResponseEntity getAllLocations() {
        List<String> locations = service.getAllLocations();
        return new ResponseEntity<>(locations, HttpStatus.OK);
    }

    @GetMapping("/filter")
    public ResponseEntity getFilteredPosts(@RequestParam(value = "location", required = false) String location, @RequestParam(value = "state", required = false) String state, @RequestParam(value = "productType", required = false) String productType, Pageable pageable) {
        return new ResponseEntity<>(service.filterPosts(location, state, productType, pageable), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePost(@RequestBody PostEntity postEntity, @PathVariable Long id) {

        return new ResponseEntity<>(service.updatePost(postEntity, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePostById(@PathVariable Long id) {

        return new ResponseEntity<>(service.deletePostById(id), HttpStatus.OK);
    }
}
