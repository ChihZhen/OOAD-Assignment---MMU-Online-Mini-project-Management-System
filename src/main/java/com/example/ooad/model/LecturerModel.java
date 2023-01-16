package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "Lecturer")
@Component
public class LecturerModel extends UserModel {
    @Id
    private Long id;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.EAGER)
    private List<ProjectModel> projects = new ArrayList<ProjectModel>();

    public LecturerModel() {
    };

    public LecturerModel(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    public LecturerModel(String fullName, String role, String accountId, String password) {
        super(password, fullName, role, accountId);
    }

    public List<ProjectModel> getProjects() {
        return this.projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
    }
}