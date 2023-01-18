package com.example.ooad.model;

import java.sql.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
@Component
public class CommentModel extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;

    private String message;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private ProjectModel project;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private AdminModel author;

    public CommentModel() {
    }

    public CommentModel(String date, ProjectModel project, String message, AdminModel author) {
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

    public AdminModel getAuthor() {
        return this.author;
    }

    public void setAuthor(AdminModel author) {
        this.author = author;
    }

    public void set(CommentModel comment) {
        if (comment != null) {
            this.id = comment.getId();
            this.message = comment.getMessage();
            this.date = comment.getDate();
            this.author = comment.getAuthor();
            this.project = comment.getProject();
        }
        notifyObservers();
    }

    public void reset() {
        this.id = null;
        this.message = null;
        this.date = null;
        this.author = null;
        this.project = null;
        notifyObservers();
    }
}
