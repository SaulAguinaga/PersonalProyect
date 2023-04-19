package com.personalproyect.personalproyect.services;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.personalproyect.personalproyect.models.User;
import com.personalproyect.personalproyect.repositories.UserRepository;

@Service
public class RegisterService {

    private UserRepository repository;
    
    
    public RegisterService(UserRepository repository) {
        this.repository = repository;
    }


    public void save(User user) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());

        user.setPassword(encodePassword);

        repository.save(user);
    }
}
