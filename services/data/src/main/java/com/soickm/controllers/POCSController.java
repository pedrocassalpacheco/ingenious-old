package com.soickm.controllers;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.soickm.domain.POC;
import com.soickm.repositories.POCSRepository;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@RestController
public class POCSController {

    private static final Logger logger = LoggerFactory.getLogger(POCSController.class);

    @Autowired
    private POCSRepository repository;

    public POCSController(POCSRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    @CrossOrigin(origins = "*")
    @GetMapping("/pocs")
    public Iterable<POC> run() {
        MongoCollection<Document> collection =  mongoTemplate.getDb().getCollection("pocs");
        FindIterable<Document> iterDoc = collection.find();
        // Getting the iterator
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        logger.info("Documents:" + repository.count());
        logger.info("Documents:" + repository.count());
        return repository.findAll();
    }

}
