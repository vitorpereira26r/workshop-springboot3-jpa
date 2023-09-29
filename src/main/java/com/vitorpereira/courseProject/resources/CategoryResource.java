package com.vitorpereira.courseProject.resources;

import com.vitorpereira.courseProject.entities.Category;
import com.vitorpereira.courseProject.services.CategoryServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private CategoryServices categoryServices;

    public CategoryResource(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = categoryServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = categoryServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        Category entity = categoryServices.createCategory(category);
        return ResponseEntity.ok(entity);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id){
        categoryServices.deleteCategoryById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Category> updateById(@PathVariable Long id, @RequestBody Category obj){
        Category entity = categoryServices.updateById(id, obj);
        return ResponseEntity.ok(entity);
    }
}
