package com.personalproyect.personalproyect.payloads;

import jakarta.persistence.*;

public class AcademyPayload {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    private String contact;
    private String phone;
    private String image;

    public AcademyPayload() {
    }

    public AcademyPayload(Long id, String name, String location, String contact, String phone, String image) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.contact = contact;
        this.phone = phone;
        this.image = image;
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
    
