package com.makers.makersbnb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class StaticPageController {
    // Home page
    @GetMapping("/")
    public ModelAndView welcome() {
        return new ModelAndView("/LandingPage");
    }

    @GetMapping("/contactus")
    public String contactPage() {
        return "info@makersbnb.com";
    }

    @GetMapping("/termsandconditions")
    public String termsConditionsPage() {
        return "Coming soon! In the meantime, please behave yourselves.";
    }
}
