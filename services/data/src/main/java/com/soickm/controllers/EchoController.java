package com.soickm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
public class EchoController {

    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);

    @GetMapping("/echo/{urlParameter}")
    public ResponseEntity<String> echo(@RequestHeader Map<String, String> headers,@PathVariable("urlParameter") String urlParameter) {
        logger.info("Echoing back" + headers);
        logger.info("Params" + urlParameter);
        return ResponseEntity.status(HttpStatus.OK).body(headers.toString());
    }
}
