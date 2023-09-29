package com.vitorpereira.courseProject.services;

import com.vitorpereira.courseProject.entities.Category;
import com.vitorpereira.courseProject.repositories.CategoryRepository;
import com.vitorpereira.courseProject.services.excepitions.DatabaseException;
import com.vitorpereira.courseProject.services.excepitions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServices {

    private CategoryRepository repository;

    public CategoryServices(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll(){

        return repository.findAll();
    }

    public Category findById(Long id){

        Optional<Category> obj = repository.findById(id);

        if(obj.isPresent()) {
            return obj.get();
        }
        throw new ResourceNotFoundException(id);
    }

    public Category createCategory(Category category){
        return repository.save(category);
    }

    public void deleteCategoryById(Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch(DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Category updateById(Long id, Category obj){
        try{
            Category entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Category entity, Category obj){
        entity.setName(obj.getName());
    }
}
