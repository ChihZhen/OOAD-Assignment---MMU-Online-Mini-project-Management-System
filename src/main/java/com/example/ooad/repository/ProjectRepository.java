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

  public List<Project> findByStudentIsNull();

  public List<Project> findByStudentIsNotNull();

  // public List<Project> findByLecturer(Lecturer lecturer);

  public List<Project> findByCommentsIsNull();

  public List<Project> findByCommentsIsNotNull();

  public List<Project> findByLecturerId(Long id);

  public List<Project> findByLecturerAccountId(String id);

  // public List<ProjectModel> findByCreator();

}
