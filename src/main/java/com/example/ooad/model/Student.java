package com.example.ooad.model;

import jakarta.persistence.*;

@Entity
public class Student extends User {
    private String specialization;;

    @OneToOne(mappedBy = "student")
    // @JoinColumn(name = "project_id")
    private Project project;

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