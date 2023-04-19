package com.personalproyect.personalproyect.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalproyect.personalproyect.models.User;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User>findByUsername(String username);

    
}
