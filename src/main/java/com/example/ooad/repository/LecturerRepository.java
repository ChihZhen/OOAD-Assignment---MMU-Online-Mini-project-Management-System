package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.LecturerModel;

@Repository
public interface LecturerRepository extends JpaRepository<LecturerModel, Long> {
    public LecturerModel findOneById(Long id);
}