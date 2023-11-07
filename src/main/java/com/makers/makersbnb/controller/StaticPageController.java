package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticPageController {
    @GetMapping("/")
    public String landingpage() {
        return "Welcome to MakersBnB!";
    }

    @GetMapping("/contactus")
    public String contactpage() {
        return "info@makersbnb.com";
    }
}
