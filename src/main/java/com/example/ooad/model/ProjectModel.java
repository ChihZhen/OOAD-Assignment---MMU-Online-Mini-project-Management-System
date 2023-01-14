package com.example.ooad.model;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Project")
@Component
public class ProjectModel extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, description, status, specialization;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel creator;

    @OneToOne
    private StudentModel student;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private List<CommentModel> comments;

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

    public List<CommentModel> getComments() {
        return this.comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public UserModel getCreator() {
        return this.creator;
    }

    public void setCreator(UserModel creator) {
        this.creator = creator;
    }

    public StudentModel getStudent() {
        return this.student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public Vector<String> getLecturerVector() {
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

    public boolean isValid() {
        return !(title.isBlank() | description.isBlank());
    }

    public void set(ProjectModel project) {
        this.id = project.getId();
        this.title = project.getTitle();
        this.description = project.getDescription();
        this.status = project.getStatus();
        this.specialization = project.getSpecialization();
        this.student = project.getStudent();
        this.creator = project.getCreator();
        this.comments = project.getComments();
        notifyObservers();
    }

    public void reset() {
        this.id = null;
        this.title = null;
        this.description = null;
        this.specialization = "Computer Science";
        this.status = "Active";
        this.student = null;
        this.creator = null;
        this.comments = new ArrayList<CommentModel>();
        notifyObservers();
    }

}
