package com.vitorpereira.courseProject.resources;

import com.vitorpereira.courseProject.entities.Product;
import com.vitorpereira.courseProject.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductServices productServices;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productServices.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = productServices.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productServices.deleteProductById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product entity = productServices.addProduct(product);
        return ResponseEntity.ok(entity);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Product> updateById(@PathVariable Long id, @RequestBody Product product){
        Product entity = productServices.updateById(id, product);
        return ResponseEntity.ok(entity);
    }
}
