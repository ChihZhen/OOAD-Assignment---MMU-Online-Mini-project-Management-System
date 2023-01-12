package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Admin extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "admin")
    private List<Project> projects = new ArrayList<Project>();

    public Admin(String password, String fullName, String role, String accountId) {
        super(password, fullName, role, accountId);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}