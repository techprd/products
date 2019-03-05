package com.example.fedtest.controllers;

import com.example.fedtest.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class ApiController {

    @GetMapping(value = "/api/products", produces = "application/json")
    Product[] getProducts() throws IOException {
        File file = ResourceUtils.getFile("classpath:products.json");
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(file, Product[].class);
    }
}
