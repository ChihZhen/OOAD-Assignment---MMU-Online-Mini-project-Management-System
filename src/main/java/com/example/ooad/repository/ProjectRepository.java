package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.ProjectModel;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectModel, Long> {

}
