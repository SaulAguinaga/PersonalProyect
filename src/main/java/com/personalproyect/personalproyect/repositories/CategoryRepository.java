package com.personalproyect.personalproyect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personalproyect.personalproyect.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
