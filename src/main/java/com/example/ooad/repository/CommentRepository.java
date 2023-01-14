package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.CommentModel;

@Repository
public interface CommentRepository extends JpaRepository<CommentModel, Long> {

}
