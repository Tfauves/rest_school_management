package com.schoolmanagement.javaPractice.controllers;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.models.Teacher;
import com.schoolmanagement.javaPractice.repositories.TeacherRepository;
import com.schoolmanagement.javaPractice.service.SchoolService;
import com.schoolmanagement.javaPractice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @Autowired
    SchoolService schoolService;

    @PostMapping("/")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {

        School school = schoolService.findSchool(teacher.getSchool().getId());

        teacher.setSchool(school);

        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }

    @PostMapping("/school/{schoolId}")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher, @PathVariable Long schoolId) {

        School school = schoolService.findSchool(schoolId);

        teacher.setSchool(school);

        return ResponseEntity.ok(teacherService.saveTeacher(teacher));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getOne(@PathVariable Long id) {
        Teacher teacher = teacherService.findTeacher(id);

        return ResponseEntity.ok(teacher);
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Teacher>> getTeachers(@PathVariable long schoolId) {
        School school = schoolService.findSchool(schoolId);

        return ResponseEntity.ok(teacherService.getSchoolTeachers(school));
    }


}
