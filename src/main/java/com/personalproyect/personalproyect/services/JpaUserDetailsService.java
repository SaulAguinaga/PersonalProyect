package com.personalproyect.personalproyect.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.personalproyect.personalproyect.models.SecurityUser;
import com.personalproyect.personalproyect.repositories.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

    private UserRepository repository;

    public JpaUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository 
            .findByUsername(username)
            .map(SecurityUser::new)
            .orElseThrow(()-> new UsernameNotFoundException("User not found:" + username));
    }

   

}