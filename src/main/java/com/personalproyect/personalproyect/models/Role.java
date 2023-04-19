package com.personalproyect.personalproyect.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="id_role")
    private Long id_role;

    @Column(nullable = false)
    private String role;

    @ManyToMany(mappedBy = "roles")
    List<User> users;
    
    public Role() {}

    public Role(Long id_role, String role) {
        this.id_role = id_role;
        this.role = role;
    }

    public Long getId_role() {
        return id_role;
    }

    public void setId_role(Long id_role) {
        this.id_role = id_role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    
    
}
