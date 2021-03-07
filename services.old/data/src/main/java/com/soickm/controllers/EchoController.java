package com.soickm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class EchoController {

    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

    @GetMapping("/echo")
    public ResponseEntity<String> echo(@RequestBody(required = false) String body) {
        logger.info("Echoing back" + body);
        return ResponseEntity.status(HttpStatus.OK).body(new String(body));
    }
}
