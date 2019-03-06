package com.example.fedtest.controllers;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Ali Shirzad
 */
@Controller
public class MainController {

    /**
     * aggregates all static files compile from frontend app from class path
     * and injects them into main html file
     * returns the main html page
     *
     * @param model                   model containing static file to inject into html file
     * @param resourcePatternResolver
     * @return main html page that runs the single page app
     * @throws IOException throws if the html file or static file don't exists
     */
    @RequestMapping("/ui/**")
    String indexRouting(Model model, GenericApplicationContext resourcePatternResolver) throws IOException {
        Resource[] resources =
                resourcePatternResolver.getResources("classpath*:/public/static/**/chunk-*");

        List<String> staticFiles = new LinkedList<>();
        for (Resource resource : resources) {
            if (resource.getFilename() != null && resource.getFilename().endsWith(".css")) {
                staticFiles.add("/static/css/" + resource.getFilename());
            } else if (resource.getFilename() != null && resource.getFilename().endsWith(".js")) {
                staticFiles.add("/static/js/" + resource.getFilename());
            }
        }

        model.addAttribute("staticFiles", staticFiles);

        return "index.html";
    }
}
