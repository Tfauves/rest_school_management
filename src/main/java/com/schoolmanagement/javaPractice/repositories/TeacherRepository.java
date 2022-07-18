package com.schoolmanagement.javaPractice.repositories;

import com.schoolmanagement.javaPractice.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllBySchool_id(Long id);
}
