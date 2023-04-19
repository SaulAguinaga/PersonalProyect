package com.personalproyect.personalproyect.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.personalproyect.personalproyect.exception.CategoryNotFoundException;
import com.personalproyect.personalproyect.models.Category;
import com.personalproyect.personalproyect.repositories.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
public class CategoryService implements BaseService<Category>{
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Category findById(Long id) {
        return categoryRepository.findById(id)
        .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    @Transactional
    public void saveCategory(Long id, Category category) {
        Category categoryToAdd = new Category(id, category.getName());
        categoryRepository.save(categoryToAdd);
    }

    @Override
    public void deleteById(Long id) {
        Category categoryDelete = findById(id);
        categoryRepository.deleteById(categoryDelete.getId());
    }
    
    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = findById(id);
        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category save(Category entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
}
