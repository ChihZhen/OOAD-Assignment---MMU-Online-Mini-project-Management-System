package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.Lecturer;

@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, Long> {

}