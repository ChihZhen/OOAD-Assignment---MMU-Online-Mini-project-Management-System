package com.example.ooad.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Admin extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "creator")
    private List<ProjectModel> projects = new ArrayList<ProjectModel>();

    public Admin() {

    }
    public Admin(String password, String fullName, String role, String accountId) {
        super(password, fullName, role, accountId);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProjectModel> getProjects() {
        return this.projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }

}