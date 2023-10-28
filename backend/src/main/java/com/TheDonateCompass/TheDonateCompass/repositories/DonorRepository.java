package com.TheDonateCompass.TheDonateCompass.repositories;

import com.TheDonateCompass.TheDonateCompass.modells.Donor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByCity(String city);
}
