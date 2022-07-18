package com.schoolmanagement.javaPractice.service;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.models.Student;
import com.schoolmanagement.javaPractice.models.Teacher;
import com.schoolmanagement.javaPractice.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<Student> findStudents(String name) {
        return studentRepository.findAllByName(name);
    }

    public List<Student> findStudents(Teacher teacher) {
        return studentRepository.findAllByTeacher_id(teacher.getId());
    }

    public List<Student> findStudents(School school) {
        return studentRepository.findAllBySchool_id(school.getId());
    }
}