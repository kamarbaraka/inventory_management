package com.example.springsetuptest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class BasicControllerTest {

    /*declare variable to hold our mock dependency*/
    MockMvc mockMvc;

    @BeforeEach
    public void setup(){
        /*initialize the mock before each test*/
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BasicController()).build();

    }

    @Test
    public void basicTest() throws Exception{

        /*perform the test*/
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/welcome").accept(MediaType.parseMediaType("application/html;charset=UTF-8"))
        ).andExpect(status().isOk()).andExpect(content().contentType("application/html;charset=UTF-8")).andExpect(
                content().string("welcome to my first application")
        );
    }

}