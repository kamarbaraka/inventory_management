package com.example.springsetuptest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * a class to implement the front controller.
 * @author kamar baraka.*/

@Controller
public class BasicController {

    @RequestMapping(value = "/welcome")
    @ResponseBody
    public String welcome(){
        return "welcome to my first application";
    }
}
