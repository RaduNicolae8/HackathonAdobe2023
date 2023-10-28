package com.TheDonateCompass.TheDonateCompass.services;

import com.TheDonateCompass.TheDonateCompass.dto.UserDto;
import com.TheDonateCompass.TheDonateCompass.modells.User;
import com.TheDonateCompass.TheDonateCompass.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.TheDonateCompass.TheDonateCompass.security.WebSecurity.bCryptPasswordEncoder;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String registerUser(UserDto userDto) {
        try {
            userRepository.save(User.builder()
                    .password(bCryptPasswordEncoder().encode(userDto.getPassword()))
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

    public List<User> getUsersByCity(String city) {
        try {
            return userRepository.findByCity(city);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching the donors data", ex);
        }
    }
    public String createUser(User user) {
        try {
            userRepository.save(user);
            return "Donor successfully created.";
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred trying to create a new donor", ex);
        }
    }

    public ResponseEntity<String> updateUser(Long id, User updatedDonor) {
        try {
            User existingDonor = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Donor not found"));

            if (updatedDonor.getFirstName() != null) {
                existingDonor.setFirstName(updatedDonor.getFirstName());
            }
            if (updatedDonor.getLastName() != null) {
                existingDonor.setLastName(updatedDonor.getLastName());
            }
            if (updatedDonor.getEmail() != null) {
                existingDonor.setEmail(updatedDonor.getEmail());
            }
            if (updatedDonor.getPhoneNumber() != null) {
                existingDonor.setPhoneNumber(updatedDonor.getPhoneNumber());
            }
            if (updatedDonor.getCity() != null) {
                existingDonor.setCity(updatedDonor.getCity());
            }

            userRepository.save(existingDonor);
            return new ResponseEntity<>("The donor with the id "+existingDonor.getId()+" was updated sccuessfully", HttpStatus.OK);
        } catch (ResponseStatusException ex) {
            String message = "Donor not found";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while updating the donor's data", ex);
        }
    }

    public ResponseEntity<String> deleteUser(Long id) {
        try {
            if (!userRepository.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Donor not found");
            }
            userRepository.deleteById(id);
            return new ResponseEntity<>("The donor with the id "+id+" was deleted sccuessfully", HttpStatus.OK);
        } catch (ResponseStatusException ex) {
            String message = "Donor not found";
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while deleting the donor", ex);
        }
    }

    public ResponseEntity<User> findByEmail(String email) {
        try {
            User user = userRepository.findByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while fetching the donor's data", ex);
        }
    }
}

