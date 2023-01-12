package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Lecturer extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "lecturer")
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