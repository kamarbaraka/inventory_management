package com.example.springsetuptest;

import com.example.springsetuptest.persistence.Cat;
import com.example.springsetuptest.repository.CatRepository;
import org.assertj.core.util.Streams;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.Stream;

/**
 * a test class for the spring application.
 * @author kamar baraka.*/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class SpringSetupTestApplicationTests {

    /*inject springMVC mock*/
    @Autowired
    private MockMvc mock;

    /*inject the cats' repository*/
    @Autowired
    private CatRepository catRepository;

    /*construct and persist three instances of the cat before each test.*/
    @Before
    public void before(){

        /*create a stream of cat names and use it to create the cats.*/
        Stream.of("berry", "cherry", "cookie").forEach(name -> catRepository.save(new Cat(name)));
    }

    /*test for cats persistence and if reflected in read*/
    @Test
    void catsTestInRead() throws Exception{

        /*define the media type*/
        MediaType halJson = new MediaType("application/hal+json;Charset=UTF-8");

        /*perform the mock*/
        this.mock.perform(MockMvcRequestBuilders.get("/cats")).andExpect(MockMvcResultMatchers.status().isOk()).
                andExpect(MockMvcResultMatchers.content().contentType(halJson));

    }

    @Test
    void contextLoads() {
    }

}
