package com.TheDonateCompass.TheDonateCompass.controllers;

import com.TheDonateCompass.TheDonateCompass.modells.Donor;
import com.TheDonateCompass.TheDonateCompass.services.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {
    @Autowired
    private DonorService donorService;

    @GetMapping("/ByCity/{city}")
    public List<Donor> getDonorsByCity(@RequestParam String city) {
        return donorService.getDonorsByCity(city);
    }
}