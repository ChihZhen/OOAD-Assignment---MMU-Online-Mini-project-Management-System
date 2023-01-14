package com.example.ooad.model;

import org.springframework.stereotype.Component;

@Component
public class LoginModel {
    private String id, password;

    // public LoginModel() {
    // }

    // public LoginModel(String id, String password) {
    // this.id = id;
    // this.password = password;
    // }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public boolean isRoot() {
        return id.equals("root");
    }

    public boolean checkRoot() {
        return password.equals("123");
    }
}
