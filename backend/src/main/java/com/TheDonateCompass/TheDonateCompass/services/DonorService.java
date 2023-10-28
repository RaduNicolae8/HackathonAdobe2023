package com.TheDonateCompass.TheDonateCompass.services;

import com.TheDonateCompass.TheDonateCompass.modells.Donor;
import com.TheDonateCompass.TheDonateCompass.repositories.DonorRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DonorService {
    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getDonorsByCity(String city) {
        return donorRepository.findByCity(city);
    }
}

