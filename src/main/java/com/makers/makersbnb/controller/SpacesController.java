package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

@RestController
public class SpacesController {

    @Autowired
    SpaceRepository spaceRepository;
    @GetMapping("/spaces")
    public ModelAndView listSpaces() {
        ModelAndView modelAndView = new ModelAndView("spaces/index");

        Iterable<Space> spaces = spaceRepository.findAll();
        modelAndView.addObject("spaces", spaces);

        Space space = new Space();
        modelAndView.addObject("space", space);

        return modelAndView;
    }

    @PostMapping("/spaces")
    // Spring Boot uses the form data to create an instance of space
    // which is then passed in as an arg here
    public RedirectView create(Space space) {
        spaceRepository.save(space);
        return new RedirectView("/spaces");
    }
}
