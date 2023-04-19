package com.personalproyect.personalproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalproyect.personalproyect.models.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{
    
}
