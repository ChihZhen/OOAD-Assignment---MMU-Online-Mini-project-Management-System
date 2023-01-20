package com.example.ooad.entity;

import jakarta.persistence.*;
import java.util.*;

/**
 * A Database Entity that stores details of the Lecturer.
 */
@Entity
@Table(name = "Lecturer")
public class Lecturer extends User {
    @Id
    private Long id;

    @OneToMany(mappedBy = "lecturer", fetch = FetchType.LAZY)
    private List<Project> projects = new ArrayList<Project>();

    /**
     * Constructs a Lecturer Entity with all null values.
     */
    public Lecturer() {
    };

    /**
     * Constructs a Lecturer Entity with specified values. Id is automatically
     * generated.
     *
     * @param fullName  The name of the lecturer.
     * @param role      The role of the lecturer.
     * @param accoutnId The accountId of the lecturer.
     */
    public Lecturer(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    /**
     * Constructs a Lecturer Entity with specified values. Id is automatically
     * generated.
     *
     * @param fullName  The name of the Lecturer.
     * @param role      The role of the Lecturer.
     * @param accoutnId The accountId of the Lecturer.
     * @param password  The password of the Lecturer.
     */
    public Lecturer(String fullName, String role, String accountId, String password) {
        super(fullName, role, accountId, password);
    }

    /**
     * Gets and Returns the project of the Lecturer.
     *
     * @return A Proejct-type project of the lecturer.
     */
    public List<Project> getProjects() {
        return this.projects;
    }

    /**
     * Update and changes the Project of the Lecturer based on parameter given.
     *
     * @param project The new project of the Lecturer.
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}