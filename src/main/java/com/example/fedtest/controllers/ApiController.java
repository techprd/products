package com.example.fedtest.controllers;

import com.example.fedtest.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

/**
 * Api Controller to return products as json to be consumed by frontend single page app
 * Author: Ali Shirzad
 */
@RestController
public class ApiController {

    /**
     * Gets the products.json file and returns the content as a json payload
     *
     * @return json payload containing products
     * @throws IOException throws if the json file does not exists
     */
    @GetMapping(value = "/api/products", produces = "application/json")
    Product[] getProducts() throws IOException {
        File productsJsonFile = ResourceUtils.getFile("classpath:products.json");
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(productsJsonFile, Product[].class);
    }
}
