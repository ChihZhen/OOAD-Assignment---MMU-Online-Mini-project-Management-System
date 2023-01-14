package com.example.ooad.entity;

import jakarta.persistence.*;

@Entity
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String specialization;

    @OneToOne(mappedBy = "student")
    // @JoinColumn(name = "project_id")
    private ProjectModel project;

    public Student() {
        // super();
    }

    public Student(String password, String fullName, String role, String accountId, String specialization) {
        super(password, fullName, role, accountId);
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public ProjectModel getProject() {
        return this.project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

}