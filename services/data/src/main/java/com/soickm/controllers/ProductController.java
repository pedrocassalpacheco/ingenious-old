package com.soickm.controllers;

import com.soickm.domain.Product;
import com.soickm.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


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
    @GetMapping("/product/{id}")
    public Optional<Product> product(String id) {
        logger.error("Getting product");
        logger.error(id);
        return repository.findById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/products")
    public ResponseEntity addProduct(@RequestBody Product product)
    {
        try
        {
            repository.save(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/addproduct")
    public ResponseEntity newProduct()
    {
        try
        {
            Product p = new Product();
            p.setProduct("APM");
            p.addFeature("Java Monitoring");
            p.addFeature("Python Monitoring");
            p.addFeature("Container Monitoring");
            repository.save(p);

            p = new Product();
            p.setProduct("EUM");
            p.addFeature("Browser");
            p.addFeature("Android");
            p.addFeature("iOS");
            p.addFeature("React Native");
            repository.save(p);

            p = new Product();
            p.setProduct("IQM");
            p.addFeature("Elastic Search");
            p.addFeature("RabbitMQ");
            p.addFeature("Kafka");
            repository.save(p);

            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
