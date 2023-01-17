package com.example.ooad.entity;

import jakarta.persistence.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Admin")
@Component
public class Admin extends User {
    @Id
    private Long id;

    public Admin() {
    }

    public Admin(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    public Admin(String fullName, String role, String accountId, String password) {
        super(fullName, role, accountId, password);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}