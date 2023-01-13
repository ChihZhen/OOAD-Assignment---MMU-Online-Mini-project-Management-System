package com.example.ooad.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Lecturer extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "creator")
    private List<Project> projects = new ArrayList<Project>();

    public Lecturer(String password, String fullName, String role, String accountId) {
        super(password, fullName, role, accountId);
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}