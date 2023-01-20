package com.example.ooad.entity;

import org.springframework.stereotype.Component;

import com.example.ooad.model.IModel;
import com.example.ooad.utils.Observable;

import jakarta.persistence.*;

/**
 * A Database Entity that stores details of the Comments.
 */
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

    /**
     * Constructs a Comment Entity with all null values.
     */
    public Comment() {
    }

    /**
     * Constructs a Comment Entity with specified values. Id is automatically
     * generated.
     *
     * @param date    The date of the comment.
     * @param message The message of the comment.
     * @param project The project associated to the comment.
     * @param admin   The admin associated to the comment.
     */
    public Comment(String date, String message, Project project, Admin admin) {
        this.date = date;
        this.project = project;
        this.message = message;
        this.admin = admin;
    }

    /**
     * Gets and Returns the ID of the Comment.
     *
     * @return A UUID-type ID of the Comment.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Update and changes the ID of the Comment based on parameter given.
     *
     * @param id The new id of the Coment.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets and Returns the Date of the Comment.
     *
     * @return A String-type Date of the Comment.
     */
    public String getDate() {
        return this.date;
    }

    /**
     * Update and changes the Date of the Comment based on parameter given.
     *
     * @param date The new date of the Comment.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Gets and Returns the Projects of the Comment.
     *
     * @return A Project-type project of the Comment.
     */
    public Project getProject() {
        return this.project;
    }

    /**
     * Update and changes the Project of the Comment based on parameter given.
     *
     * @param project The new project of the Comment.
     */
    public void setProject(Project project) {
        this.project = project;
    }

    /**
     * Gets and Returns the Message of the Comment.
     *
     * @return A String-type Message of the Comment.
     */
    public String getMessage() {
        return this.message;
    }

    /**
     * Update and changes the Message of the Comment based on parameter given.
     *
     * @param message The new Message of the Comment.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets and Returns the Admin of the Comment.
     *
     * @return A Admin-type Admin of the Comment.
     */
    public Admin getAdmin() {
        return this.admin;
    }

    /**
     * Update and changes the Admin of the Comment based on parameter given.
     *
     * @param admin The new Admin of the Comment.
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
