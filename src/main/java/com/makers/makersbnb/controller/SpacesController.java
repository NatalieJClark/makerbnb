package com.makers.makersbnb.controller;

import com.makers.makersbnb.model.Space;
import com.makers.makersbnb.repository.SpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Map;

@RestController
public class SpacesController {

    @Autowired
    SpaceRepository spaceRepository;
    @GetMapping("/spaces")
    public ModelAndView listSpaces(@AuthenticationPrincipal OAuth2User principal) {
        ModelAndView modelAndView = new ModelAndView("spaces/index");

        // getAttributes
        Map attributes = principal.getAttributes();
        // they will then be printed when you go to "/spaces"
        System.out.println(attributes);

        String username = attributes.get("login").toString();
        System.out.println(username);
        modelAndView.addObject("username", username);

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
