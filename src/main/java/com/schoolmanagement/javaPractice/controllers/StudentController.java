package com.schoolmanagement.javaPractice.controllers;

import com.schoolmanagement.javaPractice.models.School;
import com.schoolmanagement.javaPractice.models.Student;
import com.schoolmanagement.javaPractice.models.Teacher;
import com.schoolmanagement.javaPractice.payloads.request.StudentFeePay;
import com.schoolmanagement.javaPractice.payloads.response.MessageResponse;
import com.schoolmanagement.javaPractice.service.SchoolService;
import com.schoolmanagement.javaPractice.service.StudentService;
import com.schoolmanagement.javaPractice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    SchoolService schoolService;

    @PostMapping("/")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Teacher teacher = teacherService.findTeacher(student.getTeacher().getId());

        student.setTeacher(teacher);
        student.setSchool(teacher.getSchool());

        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @PostMapping("/teacher/{teacherId}")
    public ResponseEntity<Student> createStudent(@RequestBody Student student, @PathVariable Long teacherId) {
        Teacher teacher = teacherService.findTeacher(teacherId);

        student.setTeacher(teacher);
        student.setSchool(teacher.getSchool());

        return ResponseEntity.ok(studentService.saveStudent(student));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudent(id));
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<List<Student>> getByTeacher(@PathVariable Long teacherId) {
        Teacher teacher = teacherService.findTeacher(teacherId);
        return ResponseEntity.ok(studentService.findStudents(teacher));
    }

    @GetMapping("/school/{schoolId}")
    public ResponseEntity<List<Student>> getBySchool(@PathVariable Long schoolId) {
        School school = schoolService.findSchool(schoolId);
        return ResponseEntity.ok(studentService.findStudents(school));
    }

    @PostMapping("/{studentId}/payFees")
    public ResponseEntity<MessageResponse> payFees(@RequestBody StudentFeePay feePay, @PathVariable Long studentId) {
        Student student = studentService.findStudent(studentId);

        student.payFees(feePay.getAmount());

        studentService.saveStudent(student);
        return ResponseEntity.ok(new MessageResponse("Payment of " + feePay.getAmount() + " received."));
    }
}