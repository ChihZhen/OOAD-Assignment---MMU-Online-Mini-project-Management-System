package com.example.ooad.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.ooad.model.Observable;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Project")
@Component
public class ProjectModel extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String status;
    private String specialization;

    // @ManyToOne
    // @JoinColumn(name = "lecturer_id")
    // private Lecturer lecturer;

    // @ManyToOne
    // @JoinColumn(name = "admin_id")
    // private Admin admin;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToOne
    private Student student;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private List<Comment> comments;

    public ProjectModel() {
    }

    public ProjectModel(String title, String description, String status, String specialization) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.specialization = specialization;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    // public Lecturer getLecturer() {
    // return this.lecturer;
    // }

    // public void setLecturer(Lecturer lecturer) {
    // this.lecturer = lecturer;
    // }

    public Vector<String> toVector() {
        Vector<String> data = new Vector<>();
        data.add(Long.toString(id));
        data.add(title);
        data.add(specialization);
        data.add(status);
        if (student == null) {
            data.add("ASSIGN");
        } else {
            data.add(student.getFullName());
        }
        data.add("EDIT");
        data.add("DELETE");
        return data;
    }

}
