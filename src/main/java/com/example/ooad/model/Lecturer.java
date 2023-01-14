package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Lecturer extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "creator")
    private List<ProjectModel> projects = new ArrayList<ProjectModel>();

    public Lecturer() {
    };

    public Lecturer(String password, String fullName, String role, String accountId) {
        super(password, fullName, role, accountId);
    }

    public List<ProjectModel> getProjects() {
        return this.projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }

}