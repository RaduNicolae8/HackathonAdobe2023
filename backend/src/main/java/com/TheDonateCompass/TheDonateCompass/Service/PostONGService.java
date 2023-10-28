package com.TheDonateCompass.TheDonateCompass.Service;

import com.TheDonateCompass.TheDonateCompass.Entity.PostONGEntity;
import com.TheDonateCompass.TheDonateCompass.Repository.PostONGRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostONGService {
    @Autowired
    private PostONGRepository repository;

    public void createPost(PostONGEntity postONGEntity) {
        repository.save(postONGEntity);
    }

    public List<PostONGEntity> getAllPosts() {
        return repository.findAll();
    }

    public List<String> getAllLocations() {
        return repository.findAllLocations();
    }

    public Object filterONGPosts(String location, String severity, Pageable pageable) {
        return repository.findAllByFilter(location, severity, pageable);
    }

    public String updatePost(PostONGEntity postONGEntity, Long id) {
        PostONGEntity post = repository.findById(id).orElse(null);

        if (post != null) {
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
        } else {
            return "fail";
        }

        return "success";
    }

    public String deletePostById(Long id) {
        if (repository.findById(id).orElse(null) != null) {
            repository.deleteById(id);
        } else {
            return "fail";
        }

        return "success";
    }
}
