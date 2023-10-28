package com.TheDonateCompass.TheDonateCompass.services;

import com.TheDonateCompass.TheDonateCompass.dto.UserDto;
import com.TheDonateCompass.TheDonateCompass.modells.User;
import com.TheDonateCompass.TheDonateCompass.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersByCity(String city) {
        return userRepository.findByCity(city);
    }

    public String registerUser(UserDto userDto) {
        try {
            userRepository.save(User.builder()
                    .password(userDto.getPassword())
                    .email(userDto.getEmail())
                    .firstName(userDto.getFirstName())
                    .lastName(userDto.getLastName())
                    .phoneNumber(userDto.getPhoneNumber())
                    .city(userDto.getCity())
                    .name(userDto.getName())
                    .activity(userDto.getActivity())
                    .address(userDto.getAddress())
                    .isOng(userDto.getIsOng())
                    .build());
        } catch (Exception e) {
            if(e.getMessage().contains("Duplicate entry")) {
                log.error("User with phone number {} already exists", userDto.getPhoneNumber());
                return "User with phone number " + userDto.getPhoneNumber() + " already exists";
            }
            return "Error registering user";
        }
        return "User registered successfully";
    }
}

