package com.example.ooad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
  public List<Project> findBySpecializationAndStatus(String specialization, String status);

  public Project findByStudentId(Long id);

  public List<Project> findBySpecialization(String specialization);

  public List<Project> findByStatus(String status);

  public List<Project> findByStudentIsNull();

  public List<Project> findByStudentIsNotNull();

  public List<Project> findByCommentsIsNull();

  public List<Project> findByCommentsIsNotNull();

  public List<Project> findByLecturerAccountId(String id);
}
