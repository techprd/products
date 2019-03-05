package com.example.fedtest.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getProducts() throws Exception {
        this.mockMvc.perform(get("/api/products")).andExpect(status().isOk())
                .andExpect(content().json("[" +
                        "{\"index\":0,\"price\":\"$49.99\"," +
                        "\"productImage\":\"Product_1.jpeg\"," +
                        "\"productName\":\"Pure Blonde Crate\"," +
                        "\"type\":\"Beer\",\"sale\":false,\"isSale\":false}" +
                        "]"));
    }
}
