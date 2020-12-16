package com.tientt.graphqldemo.controller;

import com.tientt.graphqldemo.pojo.pojo.entities.Author;
import com.tientt.graphqldemo.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainRestController {
    @Autowired
    AuthorRepository repository;

    @GetMapping("/api/v1/author")
    public List<Author> getAuthors(){

        return repository.findAll();
    }
}
