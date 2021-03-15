package com.testeNexti.testeNextiBack.controllers;

import com.testeNexti.testeNextiBack.models.Product;
import com.testeNexti.testeNextiBack.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/products"})
public class ProductController {

    private ProductRepository repository;

    ProductController(ProductRepository productRepository) {
        this.repository = productRepository;
    }

    @GetMapping
    public List findAll(){
        return repository.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Product> findById(@PathVariable long id){
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path="/products")
    public Product create(@RequestBody Product product){
        return repository.save(product);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") long id,
                                          @RequestBody Product product){
        return repository.findById(id)
                .map(record -> {
                    record.setSKU(product.getSKU());
                    record.setName(product.getName());
                    record.setDescription(product.getDescription());
                    record.setPrice(product.getPrice());
                    record.setQuantity(product.getQuantity());

                    Product updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity<?> delete(@PathVariable("id") long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }



}
