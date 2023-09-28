package com.vitorpereira.courseProject.services;

import com.vitorpereira.courseProject.entities.Product;
import com.vitorpereira.courseProject.repositories.ProductRepository;
import com.vitorpereira.courseProject.services.excepitions.DatabaseException;
import com.vitorpereira.courseProject.services.excepitions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    private ProductRepository repository;

    public ProductServices(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> findAll(){

        return repository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public Product addProduct(Product product){
        return repository.save(product);
    }

    public void deleteProductById(Long id){
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

    public Product updateById(Long id, Product obj){
        try{
            Product entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }
        catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Product entity, Product obj){
        entity.setName(obj.getName());
        entity.setDescription(obj.getDescription());
        entity.setPrice(obj.getPrice());
    }
}
