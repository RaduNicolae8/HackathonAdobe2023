package com.TheDonateCompass.TheDonateCompass.repositories;

import com.TheDonateCompass.TheDonateCompass.modells.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByCity(String city);

    User findByEmail(String email);
}
