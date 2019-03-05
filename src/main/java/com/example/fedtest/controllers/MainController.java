package com.example.fedtest.controllers;

import com.example.fedtest.model.Product;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Controller
public class MainController {

    @RequestMapping("/ui/**")
    String indexRouting(Model model, GenericApplicationContext resourcePatternResolver) throws IOException {
        Resource[] resources =
                resourcePatternResolver.getResources("classpath*:/public/static/**/chunk-*");

        List<String> staticFiles = new LinkedList<>();
        for (Resource item : resources) {
            if (item.getFilename() != null && item.getFilename().endsWith(".css")) {
                staticFiles.add("/static/css/" + item.getFilename());
            } else if (item.getFilename() != null && item.getFilename().endsWith(".js")) {
                staticFiles.add("/static/js/" + item.getFilename());
            }
        }

        model.addAttribute("staticFiles", staticFiles);

        return "index.html";
    }
}
