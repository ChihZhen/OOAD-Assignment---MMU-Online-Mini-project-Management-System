package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Project;
import com.example.ooad.entity.Student;

import java.util.*;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
  public List<Project> findBySpecializationAndStatus(String specialization, String status);

  public Project findByStudentId(Long id);

  public List<Project> findBySpecialization(String specialization);

  public List<Project> findByStatus(String status);

  public List<Project> findByStudent(Student student);

  public List<Project> findByStudentNot(Student student);

  public List<Project> findByStudent(Lecturer lecturer);

  public List<Project> findByCommentsId(Long id);

  public List<Project> findByCommentsIdNot(Long id);

  public List<Project> findByLecturerId(Long id);

  // public List<ProjectModel> findByCreator();

}
