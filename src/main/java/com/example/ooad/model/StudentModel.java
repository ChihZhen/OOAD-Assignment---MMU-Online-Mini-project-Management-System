package com.example.ooad.model;

import java.util.Vector;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
@Component
public class StudentModel extends UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String specialization;

    @OneToOne(mappedBy = "student")
    // @JoinColumn(name = "project_id")
    private ProjectModel project;

    public StudentModel() {
        // super();
    }

    public StudentModel(String fullName, String role, String accountId, String specialization) {
        super(fullName, role, accountId);
        this.specialization = specialization;
    }

    public StudentModel(String fullName, String role, String accountId, String specialization, String password) {
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

    public ProjectModel getProject() {
        return this.project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public Vector<String> toVector() {
        Vector<String> data = new Vector<>();
        data.add(Long.toString(id));
        data.add(super.getAccountId());
        data.add(super.getFullName());
        return data;
    }

    public void reset() {
        setAccountId(null);
        setFullName(null);
        setRole(null);
    }
}