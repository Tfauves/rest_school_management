package com.schoolmanagement.javaPractice.service;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.models.Teacher;
import com.schoolmanagement.javaPractice.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Teacher findTeacher(Long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Teacher> getSchoolTeachers(School school) { return teacherRepository.findAllBySchool_id(school.getId()); }
}


