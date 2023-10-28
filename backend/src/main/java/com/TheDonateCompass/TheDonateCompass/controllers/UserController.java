package com.TheDonateCompass.TheDonateCompass.controllers;

import com.TheDonateCompass.TheDonateCompass.dto.UserDto;
import com.TheDonateCompass.TheDonateCompass.modells.User;
import com.TheDonateCompass.TheDonateCompass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/donors")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/ByCity/{city}")
    public List<User> getUsersByCity(@RequestParam String city) {
        return userService.getUsersByCity(city);
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.OK);
    }
}