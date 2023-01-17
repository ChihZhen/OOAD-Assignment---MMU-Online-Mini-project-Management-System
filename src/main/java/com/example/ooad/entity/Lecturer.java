package com.example.ooad.entity;

import jakarta.persistence.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Lecturer")
@Component
public class Lecturer extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
    private List<Project> projects = new ArrayList<Project>();

    public Lecturer() {
    };

    public Lecturer(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    public Lecturer(String fullName, String role, String accountId, String password) {
        super(password, fullName, role, accountId);
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}