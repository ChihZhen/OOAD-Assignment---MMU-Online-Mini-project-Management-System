package com.example.ooad.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
public class CommentModel {
    @Id
    private Long id;
    private Date date;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    @ManyToOne
    private AdminModel admin;

    public CommentModel() {
    }

    public CommentModel(Long id, Date date, String comment, ProjectModel project, AdminModel admin) {
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

    public ProjectModel getProject() {
        return this.project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public AdminModel getAdmin() {
        return this.admin;
    }

    public void setAdmin(AdminModel admin) {
        this.admin = admin;
    }

}
