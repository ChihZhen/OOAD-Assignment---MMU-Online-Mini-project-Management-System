package com.example.ooad.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import com.example.ooad.entity.Admin;
import com.example.ooad.repository.AdminRepository;

@Component
public class AdminModel extends Model<Admin, AdminModel> {
    public AdminModel(AdminRepository adminRepository) {
        super(adminRepository);
    }
    // @Autowired
    // public AdminRepository adminRepository;

    // public void load() {
    // setList(adminRepository.findAll());
    // }

    // public void save() {
    // adminRepository.save(current);
    // }
}
