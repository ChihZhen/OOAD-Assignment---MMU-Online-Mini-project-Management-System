package com.example.ooad.entity;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.ooad.model.IModel;
import com.example.ooad.utils.Observable;

import jakarta.persistence.*;

@Entity
@Table(name = "Comment")
@Component
public class Comment extends Observable<IModel> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;

    private String message;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Admin admin;

    public Comment() {
    }

    public Comment(String date, String message, Project project, Admin admin) {
        this.date = date;
        this.project = project;
        this.message = message;
        this.admin = admin;
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

    public Project getProject() {
        return this.project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Admin getAdmin() {
        return this.admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    // public void set(Comment comment) {
    // if (comment != null) {
    // this.id = comment.getId();
    // this.message = comment.getMessage();
    // this.date = comment.getDate();
    // this.admin = comment.getAdmin();
    // this.project = comment.getProject();
    // }
    // notifyObservers();
    // }

    // public void reset() {
    // this.id = null;
    // this.message = null;
    // this.date = null;
    // this.admin = null;
    // this.project = null;
    // notifyObservers();
    // }
}
