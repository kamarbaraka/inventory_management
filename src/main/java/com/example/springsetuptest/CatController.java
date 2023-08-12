package com.example.springsetuptest;

import com.example.springsetuptest.persistence.Cat;
import com.example.springsetuptest.repository.CatRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/** a cats controller.
 * @author kamar baraka*/

@Controller
public class CatController {

    private final CatRepository catRepository;

    public CatController(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @GetMapping("/cats")
    @ResponseBody
    public String  doGet(String name){

        return "%s".formatted(catRepository.findCatByName(name).getCatId());
    }

}
