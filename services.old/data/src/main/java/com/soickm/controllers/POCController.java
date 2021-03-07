package com.soickm.controllers;

import com.soickm.domain.POC;
import com.soickm.repositories.POCRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class POCController {

    private static final Logger logger = LoggerFactory.getLogger(POCController.class);
    private POCRepository repository;

    @Autowired
    public POCController(POCRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/pocs")
    public Iterable<POC> run() {
        return repository.findAll();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/hello")
    public String hello() {
        return "world";
    }
}
