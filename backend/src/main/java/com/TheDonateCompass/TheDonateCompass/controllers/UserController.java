package com.TheDonateCompass.TheDonateCompass.controllers;

import com.TheDonateCompass.TheDonateCompass.dto.UserDto;
import com.TheDonateCompass.TheDonateCompass.entities.User;
import com.TheDonateCompass.TheDonateCompass.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.registerUser(userDto), HttpStatus.OK);
    }

    @GetMapping("/byCity/{city}")
    public List<User> getUsersByCity(@PathVariable String city) {
        return userService.getUsersByCity(city);
    }

    @PostMapping("/new")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        String message = userService.createUser(user);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {
        System.out.println("email: " + email);
        return userService.findByEmail(email);
    }

}