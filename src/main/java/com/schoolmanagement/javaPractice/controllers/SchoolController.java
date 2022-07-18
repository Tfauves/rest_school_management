package com.schoolmanagement.javaPractice.controllers;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.repositories.SchoolRepository;
import com.schoolmanagement.javaPractice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

    @Autowired
    SchoolRepository repository;

    @PostMapping
    public ResponseEntity<School> createSchools(@RequestBody School newSchool) {
        return new ResponseEntity<>(repository.save(newSchool), HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    List<School> readAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<School> getOne(@PathVariable Long id) {
        School school = schoolService.findSchool(id);

        return ResponseEntity.ok(school);
    }

}
