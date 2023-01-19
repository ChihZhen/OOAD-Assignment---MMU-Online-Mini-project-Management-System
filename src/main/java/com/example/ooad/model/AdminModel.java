package com.example.ooad.model;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Admin;
import com.example.ooad.repository.AdminRepository;

@Component
public class AdminModel extends Model<Admin> {
    private AdminRepository repository;

    public AdminModel(AdminRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
