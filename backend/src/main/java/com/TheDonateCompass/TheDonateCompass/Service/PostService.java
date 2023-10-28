package com.TheDonateCompass.TheDonateCompass.Service;

import com.TheDonateCompass.TheDonateCompass.Entity.PostEntity;
import com.TheDonateCompass.TheDonateCompass.Repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PostService {
    @Autowired
    private PostRepository repository;

    public void createPost(PostEntity postEntity) {
        repository.save(postEntity);
    }

    public List<PostEntity> getAllPosts() {
        return repository.findAll();
    }

    public List<String> getAllLocations() {
        return repository.findAllLocations();
    }

    public Page<PostEntity> filterPosts(String location, String state, String productType, Pageable pageable) {
        return repository.findAllByFilter(location, state, productType, pageable);
    }


    public String updatePost(PostEntity postEntity, Long id) {
        PostEntity post = repository.findById(id).orElse(null);

        if (post != null) {
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
