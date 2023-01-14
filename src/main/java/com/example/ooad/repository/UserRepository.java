package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByAccountId(String accountId);
}
