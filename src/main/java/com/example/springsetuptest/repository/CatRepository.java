package com.example.springsetuptest.repository;

import com.example.springsetuptest.persistence.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * a spring data repository to handle all the CRUD operations on the cat.
 * and exported as a REST API.
 * @author kamar baraka*/

@RepositoryRestResource
public interface CatRepository extends JpaRepository<Cat, Long> {

    Cat findCatByName(String name);
}
