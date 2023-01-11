package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
