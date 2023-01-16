package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.ProjectModel;
import java.util.*;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
  public List<ProjectModel> findBySpecializationAndStatus(String specialization, String status);

  public ProjectModel findByStudentId(Long id);

  // public List<ProjectModel> findByCreator();

}
