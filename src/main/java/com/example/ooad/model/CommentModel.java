package com.example.ooad.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
public class CommentModel {
    @Id
    private Long id;
    private String date;

    private String message;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private UserModel author;

    public CommentModel() {
    }

    public CommentModel(String date, ProjectModel project, String message, UserModel author) {
        this.date = date;
        this.project = project;
        this.message = message;
        this.author = author;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ProjectModel getProject() {
        return this.project;
    }

    public void setProject(ProjectModel project) {
        this.project = project;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserModel getAuthor() {
        return this.author;
    }

    public void setAuthor(UserModel author) {
        this.author = author;
    }

}
