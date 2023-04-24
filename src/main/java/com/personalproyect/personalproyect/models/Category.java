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
    private String age;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private List<Group> group;

    public Category() {
    }

    public Category(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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
