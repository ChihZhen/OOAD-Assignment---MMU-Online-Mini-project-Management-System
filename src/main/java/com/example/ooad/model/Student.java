package com.example.ooad.model;

import jakarta.persistence.*;

@Entity
public class Student extends User {
    @Id
    private Long id;

    private String specialization;

    @OneToOne(mappedBy = "student")
    // @JoinColumn(name = "project_id")
    private Project project;

    public Student(String password, String fullName, String role, String accountId, String specialization,
            Project project) {
        super(password, fullName, role, accountId);
        this.specialization = specialization;
        this.project = project;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}