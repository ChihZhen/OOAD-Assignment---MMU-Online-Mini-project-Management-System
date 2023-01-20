package com.example.ooad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.entity.Project;
import com.example.ooad.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findStudentBySpecializationAndProject(String specialization, Project project);

    public Student findStudentById(Long id);

    public List<Student> findBySpecializationAndProjectIsNull(String specialization);

}
