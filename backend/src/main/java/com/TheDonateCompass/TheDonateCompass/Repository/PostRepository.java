package com.TheDonateCompass.TheDonateCompass.Repository;

import com.TheDonateCompass.TheDonateCompass.Entity.PostEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    @Query("SELECT p FROM PostEntity p " +
            "WHERE (:location IS NULL OR p.location LIKE %:location%) " +
            "AND (:state IS NULL OR p.state = :state) " +
            "AND (:productType IS NULL OR p.productType = :productType)")
    Page<PostEntity> findAllByFilter(String location, String state, String productType, Pageable pageable);
}