package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Admin")
@Component
public class AdminModel extends UserModel {
    @Id
    private Long id;

    @OneToMany(mappedBy = "creator")
    private List<ProjectModel> projects = new ArrayList<ProjectModel>();

    public AdminModel() {

    }

    public AdminModel(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    public AdminModel(String fullName, String role, String accountId, String password) {
        super(fullName, role, accountId, password);
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