package com.example.springsetuptest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * a class representing the welcome view controller.
 * @author kamar baraka.*/

@Controller
public class BasicViewController {
    @GetMapping(value = "/welcome-view")
    public String welcomeView(ModelMap model){

        model.addAttribute("message", "welcome kamar");

        return "welcome";
    }
}
