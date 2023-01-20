package com.example.ooad.entity;

import jakarta.persistence.*;

/**
 * A Database Entity that stores details of the Admin.
 */
@Entity
@Table(name = "Admin")
public class Admin extends User {
    @Id
    private Long id;

    /**
     * Constructs a Admin Entity with all null values.
     */
    public Admin() {
    }

    /**
     * Constructs a Admin Entity with specified values. Id is automatically
     * generated.
     *
     * @param fullName  The name of the admin.
     * @param role      The role of the admin.
     * @param accoutnId The accountId of the admin.
     */
    public Admin(String fullName, String role, String accountId) {
        super(fullName, role, accountId);
    }

    /**
     * Constructs a Admin Entity with specified values. Id is automatically
     * generated.
     *
     * @param fullName  The name of the admin.
     * @param role      The role of the admin.
     * @param accoutnId The accountId of the admin.
     * @param password  The password of the admin.
     */
    public Admin(String fullName, String role, String accountId, String password) {
        super(fullName, role, accountId, password);
    }

    /**
     * Gets and Returns the ID of the Admin.
     *
     * @return A UUID-type ID of the Admin.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Update and changes the ID of the Admin based on parameter given.
     *
     * @param id The new id of the Admin.
     */
    public void setId(Long id) {
        this.id = id;
    }
}