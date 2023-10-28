package com.TheDonateCompass.TheDonateCompass.Controller;

import com.TheDonateCompass.TheDonateCompass.Entity.PostONGEntity;
import com.TheDonateCompass.TheDonateCompass.Service.PostONGService;
import org.springframework.beans.factory.annotation.Autowired;
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

//    @GetMapping("/{id}")
//    public PostONGEntity getPostById(@PathVariable Long id) {
//        return service.getPostById(id);
//    }

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
