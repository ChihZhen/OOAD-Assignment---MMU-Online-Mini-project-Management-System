package com.example.ooad.model;

import java.util.Random;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "\"User\"")
public class UserModel extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String password = "123456";

    private String fullName;

    private String role;

    private String accountId;

    protected UserModel() {
    }

    protected UserModel(String fullName, String role, String accountId) {
        this.fullName = fullName;
        this.role = role;
        this.accountId = accountId;
    }

    protected UserModel(String fullName, String role, String accountId, String password) {
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

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }

    public void generateRandomPassword() {
        // return "123456";
        String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String Small_chars = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "!@#$%^&*_=+-/.?<>)";

        String values = Capital_chars + Small_chars +
                numbers + symbols;

        // Using random method
        Random rndm_method = new Random();

        char[] password = new char[6];

        for (int i = 0; i < 6; i++) {
            // Use of charAt() method : to get character value
            // Use of nextInt() as it is scanning the value as int
            password[i] = values.charAt(rndm_method.nextInt(values.length()));

        }
        this.password = password.toString();
        // return password;
    }
}