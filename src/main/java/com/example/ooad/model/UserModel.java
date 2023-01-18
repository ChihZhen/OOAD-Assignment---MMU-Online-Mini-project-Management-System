package com.example.ooad.model;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Admin;
import com.example.ooad.entity.User;
import com.example.ooad.repository.UserRepository;

@Component
public class UserModel extends Model<User> {
    private UserRepository repository;

    public UserModel(UserRepository repository) {
        super(repository);
        this.repository = repository;

        initDB();
    }

    public User findByAccountId(String accountId) {
        return repository.findByAccountId(accountId);
    }

    private void initDB() {
        User user = repository.findByAccountId("root");
        if (user == null) {
            repository.save(new Admin("Root Admin", "Admin", "root", "123"));
        }
    }
}
