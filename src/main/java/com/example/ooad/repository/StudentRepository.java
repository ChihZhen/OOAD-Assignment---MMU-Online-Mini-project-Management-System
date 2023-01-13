package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
