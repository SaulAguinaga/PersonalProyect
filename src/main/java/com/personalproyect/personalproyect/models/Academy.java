package com.personalproyect.personalproyect.models;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table (name = "academies")
public class Academy {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name= "id_academy")
    private Long id;

    private String name;
    private String location;
    private String contact;
    private String phone;
    private String image;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academy")
    private List<Group> groups;

    public Academy() {
    }

    public Academy(Long id, String name, String location, String contact, String phone, String image,
            List<Group> groups) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.phone = phone;
        this.image = image;
        this.groups = groups;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getContact() {
        return contact;
    }



    public void setContact(String contact) {
        this.contact = contact;
    }



    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }
}
    
