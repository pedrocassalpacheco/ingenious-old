package com.soickm.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.soickm.domain.Product;
import com.soickm.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/products")
    public Iterable<Product> products() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/products")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        try
        {
            Product newProduct = repository.save(new Product());
            return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
