package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
