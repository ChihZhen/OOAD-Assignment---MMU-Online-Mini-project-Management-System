package com.example.ooad.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    public Comment() {
    }

    public Comment(Long id, Date date, ProjectModel project) {
        this.id = id;
        this.date = date;
        this.project = project;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ProjectModel getProject() {
        return this.project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }
}
