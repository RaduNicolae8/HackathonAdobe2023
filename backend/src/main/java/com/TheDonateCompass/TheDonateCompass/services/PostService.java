package com.TheDonateCompass.TheDonateCompass.services;

import com.TheDonateCompass.TheDonateCompass.entities.PostEntity;
import com.TheDonateCompass.TheDonateCompass.repositories.PostRepository;
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
public class PostService {
    @Autowired
    private PostRepository repository;

    public ResponseEntity<?> createPost(PostEntity postEntity) {
        try {
            repository.save(postEntity);

            return new ResponseEntity<>("Post created successfully", HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>("Failed to create the post.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public List<PostEntity> getAllPosts() {
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

    public Page<PostEntity> filterPosts(String location, String state, String productType, Pageable pageable) {
        try {
            return repository.findAllByFilter(location, state, productType, pageable);
        } catch (DataAccessException e) {
            throw new RuntimeException("Failed to filter posts.", e);
        }
    }

    public ResponseEntity<?> updatePost(PostEntity postEntity, Long id) {
        try {
            PostEntity post = repository.findById(id).orElseThrow(() -> new NoSuchElementException("Post not found"));

            if (postEntity.getDescription() != null) {
                post.setDescription(postEntity.getDescription());
            }
            if (postEntity.getImageURL() != null) {
                post.setImageURL(postEntity.getImageURL());
            }
            if (postEntity.getState() != null) {
                post.setState(postEntity.getState());
            }
            if (postEntity.getLocation() != null) {
                post.setLocation(postEntity.getLocation());
            }
            if (postEntity.getProductType() != null) {
                post.setProductType(postEntity.getProductType());
            }
            if (postEntity.getTitle() != null) {
                post.setTitle(postEntity.getTitle());
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
