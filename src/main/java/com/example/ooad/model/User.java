package com.example.ooad.model;

import jakarta.persistence.*;

@MappedSuperclass
public class User {
    @Id
    private Long id;

    private String password;

    private String full_name;

    private String role;

    private Integer account_id;

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
        return this.full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getAccount_id() {
        return this.account_id;
    }

    public void setAccount_id(Integer account_id) {

        this.account_id = account_id;
    }

}
