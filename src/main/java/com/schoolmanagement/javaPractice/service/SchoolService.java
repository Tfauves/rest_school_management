package com.schoolmanagement.javaPractice.service;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School findSchool(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public School findSchool(String name) {
        return schoolRepository.findByName(name).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<School> findSchools() {
        return schoolRepository.findAll();
    }

    public Integer totalMoneyEarned(Long id) {
        School school = findSchool(id);

        return school.getMoneyEarned();
    }

    public List<School> getAll() {
        return schoolRepository.findAll();
    }
}