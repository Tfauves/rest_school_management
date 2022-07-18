package com.schoolmanagement.javaPractice.repositories;

import com.schoolmanagement.javaPractice.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {
    Optional<School> findByName(String Name);
}
