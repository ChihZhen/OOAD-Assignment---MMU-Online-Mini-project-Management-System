package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
