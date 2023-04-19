package com.personalproyect.personalproyect.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personalproyect.personalproyect.models.User;
import com.personalproyect.personalproyect.services.RegisterService;

@RestController
@RequestMapping(path = "/api")
public class RegisterController {
    private RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    //usar payload para registrar tanto perfil como usuario 
    @PostMapping(value = "/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody User user) {
        
        try {
            /* User userDB =  */service.save(user);
            Map<String, String> json = new HashMap<>();

            /* json.put("username", userDB.getUsername()); */
            json.put("message", "successful sign up");
            return ResponseEntity.status(HttpStatus.CREATED).body(json);
        } catch (Exception e) {
            Map<String, String> json = new HashMap<>();

            json.put("prolem", e.getMessage());
            json.put("message", "Error to sign up");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(json);        }
        
    }
}
