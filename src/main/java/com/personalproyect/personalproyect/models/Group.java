package com.personalproyect.personalproyect.models;

import jakarta.persistence.*;
import jakarta.persistence.Entity;

@Entity
@Table (name = "groups")
public class Group {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name= "id_group")
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name= "academy_id" , nullable = true, referencedColumnName = "id_academy")
    Academy academy;

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name= "category_id" , nullable = true, referencedColumnName = "id_category")
    Category category;
    
    public Group() {
    }

    public Group(Long id, String name, Academy academy, Category category) {
        this.id = id;
        this.name = name;
        this.academy = academy;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Academy getAcademy() {
        return academy;
    }

    public void setAcademy(Academy academy) {
        this.academy = academy;
    }
    
}
