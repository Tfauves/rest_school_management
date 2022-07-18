package com.schoolmanagement.javaPractice.service;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.models.Student;
import com.schoolmanagement.javaPractice.models.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataService implements ApplicationRunner {

    @Autowired
    SchoolService schoolService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    StudentService studentService;

    public void run(ApplicationArguments args) {
        List<School> schools = schoolService.findSchools();
        if (schools.size() == 0) {
            School cd = schoolService.saveSchool(new School("Careerdevs"));
            Teacher cliff = teacherService.saveTeacher(new Teacher("Cliff", 50000_00, cd));
            Teacher arnell = teacherService.saveTeacher(new Teacher("Arnell", 60000_00, cd));
            Student jim = studentService.saveStudent(new Student("jim", "7", cliff, cliff.getSchool()));
            Student matt = studentService.saveStudent(new Student("matt", "12", cliff, cd));
            Student keith = studentService.saveStudent(new Student("keith", "15", arnell, cd));
            Student travis = studentService.saveStudent(new Student("travis", "11", arnell, cd));
        }
    }
}