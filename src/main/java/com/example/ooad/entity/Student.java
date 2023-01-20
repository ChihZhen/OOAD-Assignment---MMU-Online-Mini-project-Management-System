package com.example.ooad.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String specialization;

    @OneToOne(mappedBy = "student")
    private Project project;

    public Student() {

    }

    public Student(String fullName, String role, String accountId, String specialization) {
        super(fullName, role, accountId);
        this.specialization = specialization;
    }

    public Student(String fullName, String role, String accountId, String specialization, String password) {
        super(fullName, role, accountId, password);
        this.specialization = specialization;
    }

    public Long getId() {
        return this.id;
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