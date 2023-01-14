package com.example.ooad.controller;

import com.example.ooad.model.*;
import com.example.ooad.repository.StudentRepository;
import com.example.ooad.repository.UserRepository;
import com.example.ooad.view.LoginView;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private LoginView loginView;
    private LoginModel loginModel;
    private UserRepository userRepository;
    private StudentRepository studentRepository;

    @Autowired
    public LoginController(LoginView loginView, UserRepository userRepository, StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.loginView = loginView;
        // this.loginModel = loginView.getLoginModel();
        init();
    }

    public void init() {
        this.loginView.addSubmitEventListener(new SubmitListener());
        // this.loginView.setVisible(true);
    }

    public void show() {
        // System.out.println("login--------------------------------------------------------------");
        loginView.setVisible(true);
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Student student = new Student("123", "lcz", "student", "1201101263",
            // "data-science");
            // studentRepository.save(student);
            loginModel = loginView.getLoginModel();

            if (loginModel.isRoot()) {
                if (loginModel.checkRoot()) {
                } else {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf, "Password incorrect", "Login Failed", 2, null);
                }
            } else {
                User user = userRepository.findByAccountId(loginModel.getId());
                if (user == null) {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf, "Account not found", "Login Failed", 2, null);
                    // System.out.println("Account not found");
                } else if (loginModel.checkPassword(user.getPassword())) {
                    loginView.setVisible(false);
                    if (user.getRole().equals("admin")) {

                    } else if (user.getRole().equals("lecturer")) {

                    } else if (user.getRole().equals("student")) {

                    }
                } else {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf, "Password incorrect", "Login Failed", 2, null);
                    // System.out.println("password not correct");
                }
            }
        }

        // public boolean isRoot(LoginModel loginModel) {
        // return loginModel.getId().equals("root");
        // }

        // public boolean checkRoot(LoginModel loginModel) {
        // return loginModel.getPassword().equals("123");
        // }
    }

}
