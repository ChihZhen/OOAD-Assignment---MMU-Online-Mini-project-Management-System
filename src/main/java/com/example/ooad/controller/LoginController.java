package com.example.ooad.controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.model.*;
import com.example.ooad.repository.StudentRepository;
import com.example.ooad.repository.UserRepository;
import com.example.ooad.view.LoginView;
import com.example.ooad.view.StudentProjectListView;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private LoginView loginView;
    private LoginModel loginModel;
    private UserRepository userRepository;
    private StudentRepository studentRepository;
    private StudentProjectListController studentProjectListController;
    private OoadApplication ooadApplication;

    @Autowired
    public LoginController(LoginView loginView, UserRepository userRepository, StudentRepository studentRepository,
            StudentProjectListController studentProjectListController, @Lazy OoadApplication ooadApplication) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.loginView = loginView;
        this.studentProjectListController = studentProjectListController;
        this.ooadApplication = ooadApplication;
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
                UserModel user = userRepository.findByAccountId(loginModel.getId());
                if (user == null) {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf, "Account not found", "Login Failed", 2, null);
                    // System.out.println("Account not found");
                } else if (loginModel.checkPassword(user.getPassword())) {
                    ooadApplication.setLoginUser(user);
                    loginView.setVisible(false);
                    if (user.getRole().equals("Admin")) {

                    } else if (user.getRole().equals("Lecturer")) {

                    } else if (user.getRole().equals("Student")) {
                        studentProjectListController.show();
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
