package com.example.ooad.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    private Long id;
    private Date date;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    private Admin admin;

    public Comment() {
    }

    public Comment(Long id, Date date, String comment, Project project, Admin admin) {
        this.id = id;
        this.date = date;
        this.comment = comment;
        this.project = project;
        this.admin = admin;
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

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
