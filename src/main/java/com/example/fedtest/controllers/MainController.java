package com.example.fedtest.controllers;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
