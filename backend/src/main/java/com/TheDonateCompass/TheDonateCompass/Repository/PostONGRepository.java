package com.TheDonateCompass.TheDonateCompass.Repository;

import com.TheDonateCompass.TheDonateCompass.Entity.PostONGEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostONGRepository extends JpaRepository<PostONGEntity, Long> {

    @Query("SELECT p FROM PostONGEntity p " +
            "WHERE (:location IS NULL OR p.location LIKE %:location%) " +
            "AND (:severity IS NULL OR p.severity = :severity)")
    Page<PostONGEntity> findAllByFilter(String location, String severity, Pageable pageable);

    @Query("SELECT DISTINCT location FROM PostONGEntity")
    List<String> findAllLocations();
}
