package com.example.ooad.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
public class Comment {
    @Id
    private Long id;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Comment(Long id, Date date, Project project) {
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

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
