package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticPageController {
    @GetMapping("/")
    public String landingPage() {
        return "Welcome to MakersBnB!";
    }

    @GetMapping("/contactus")
    public String contactPage() {
        return "info@makersbnb.com";
    }

    @GetMapping("/termsandconditions")
    public String tcPage() {
        return "Coming soon! In the meantime, please behave yourselves.";
    }
}
