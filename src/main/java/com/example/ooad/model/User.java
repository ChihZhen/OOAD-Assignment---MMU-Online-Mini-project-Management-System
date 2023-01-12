package com.example.ooad.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "\"User\"")
public class User {
    @Id
    private Long id;

    private String password;

    private String fullName;

    private String role;

    private String accountId;

    protected User(String password, String fullName, String role, String accountId) {
        this.password = password;
        this.fullName = fullName;
        this.role = role;
        this.accountId = accountId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFull_name() {
        return this.fullName;
    }

    public void setFull_name(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccount_id() {
        return this.accountId;
    }

    public void setAccount_id(String accountId) {
        this.accountId = accountId;
    }
}
