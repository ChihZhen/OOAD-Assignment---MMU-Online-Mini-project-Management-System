package com.example.ooad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ooad.model.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    public UserModel findByAccountId(String accountId);
}
