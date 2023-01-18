package com.example.ooad.entity;

import jakarta.persistence.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Lecturer")
public class Lecturer extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private List<Project> projects = new ArrayList<Project>();

    public Lecturer() {
    };

    public Lecturer(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    public Lecturer(String fullName, String role, String accountId, String password) {
        super(fullName, role, accountId, password);
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}