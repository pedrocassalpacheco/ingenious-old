package com.soickm.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Iterator;

@RestController
public class DataLoaderController {

    private static final Logger logger = LoggerFactory.getLogger(DataLoaderController.class);

    @Value("classpath:pocs.json")
    Resource data;

    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping("/load")
    public ResponseEntity run() throws IOException {
        logger.info("Processing " + data.getFilename());
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(data.getInputStream());
        Iterator<JsonNode> itr = json.elements();
        MongoCollection<Document> collection =  mongoTemplate.getDb().getCollection("pocs");
        while(itr.hasNext()) {
            JsonNode node = itr.next();
            String jsonString = node.toString();
            logger.info(jsonString);
            Document doc = Document.parse(jsonString);
            collection.insertOne(doc);
        }

;
        return new ResponseEntity<>(json, HttpStatus.CREATED);

    }
}
