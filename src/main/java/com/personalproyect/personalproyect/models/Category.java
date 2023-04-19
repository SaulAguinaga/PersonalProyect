package com.personalproyect.personalproyect.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table (name = "categories")
public class Category {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name= "id_category")
    private Long id;
    
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Group> group;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
}
