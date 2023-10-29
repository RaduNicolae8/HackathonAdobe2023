package com.TheDonateCompass.TheDonateCompass.services;

import com.TheDonateCompass.TheDonateCompass.entities.PostONGEntity;
import com.TheDonateCompass.TheDonateCompass.repositories.PostONGRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@Service
public class PostONGService {
    @Autowired
    private PostONGRepository repository;

    public ResponseEntity<?> createPost(PostONGEntity postONGEntity) {
        try {
            repository.save(postONGEntity);

            return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Failed to create the post.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<PostONGEntity> getAllPosts() {
        try {
            return repository.findAll();
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to retrieve posts.", e);
        }
    }

    public List<String> getAllLocations() {
        try {
            return repository.findAllLocations();
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to retrieve locations.", e);
        }
    }


    public Page<PostONGEntity> filterONGPosts(String location, String severity, Pageable pageable) {
        try {
            return repository.findAllByFilter(location, severity, pageable);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to filter posts.", e);
        }
    }


    public ResponseEntity<?> updatePost(PostONGEntity postONGEntity, Long id) {
        try {
            PostONGEntity post = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));

            if (postONGEntity.getDescription() != null) {
                post.setDescription(postONGEntity.getDescription());
            }
            if (postONGEntity.getLocation() != null) {
                post.setLocation(postONGEntity.getLocation());
            }
            if (postONGEntity.getProductType() != null) {
                post.setProductType(postONGEntity.getProductType());
            }
            if (postONGEntity.getSeverity() != null) {
                post.setSeverity(postONGEntity.getSeverity());
            }
            if (postONGEntity.getTitle() != null) {
                post.setTitle(postONGEntity.getTitle());
            }

            repository.save(post);

            return new ResponseEntity<>("Post updated successfully", HttpStatus.OK);
        } catch (NoSuchElementException  e) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<?> deletePostById(Long id) {
        try {
            repository.deleteById(id);

            return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Post not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}