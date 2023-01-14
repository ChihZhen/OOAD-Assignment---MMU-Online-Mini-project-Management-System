package com.example.ooad.repository;

import org.hibernate.annotations.Where;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.ProjectModel;
import java.util.*;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {
  @Where(clause = "status = 'Active'")
  public List<ProjectModel> findBySpecializationAndStatus(String specialization, String status);
}
