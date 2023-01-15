package com.example.ooad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
    public List<StudentModel> findStudentBySpecializationAndProject(String specialization, ProjectModel project);

    public StudentModel findStudentById(Long id);

    // public S
}
