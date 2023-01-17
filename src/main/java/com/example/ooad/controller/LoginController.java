package com.example.ooad.controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Admin;
import com.example.ooad.entity.User;
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
    private LecturerDashboardController projectListController;
    private AdminDashboardController adminProjectListController;
    private OoadApplication ooadApplication;

    @Autowired
    private AdminModel adminModel;

    // @Autowired
    public LoginController(LoginView loginView, UserRepository userRepository, StudentRepository studentRepository,
            StudentProjectListController studentProjectListController, @Lazy OoadApplication ooadApplication,
            LecturerDashboardController projectListController,
            @Lazy AdminDashboardController adminProjectListController) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.loginView = loginView;
        this.studentProjectListController = studentProjectListController;
        this.ooadApplication = ooadApplication;
        this.projectListController = projectListController;
        this.adminProjectListController = adminProjectListController;
        // this.loginModel = loginView.getLoginModel();

        this.loginView.addSubmitEventListener(new SubmitListener());

        initDB();
    }

    // public void init() {
    // this.loginView.addSubmitEventListener(new SubmitListener());
    // // this.loginView.setVisible(true);
    // }

    public void show() {
        adminModel.load();
        // System.out.println("login--------------------------------------------------------------");
        loginView.setVisible(true);
    }

    public void hide() {
        loginView.setVisible(false);
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Student student = new Student("123", "lcz", "student", "1201101263",
            // "data-science");
            // studentRepository.save(student);
            loginModel = loginView.getLoginModel();

            // if (loginModel.isRoot()) {
            // if (loginModel.checkRoot()) {
            // } else {
            // JFrame jf = new JFrame();
            // JOptionPane.showMessageDialog(jf, "Password incorrect", "Login Failed", 2,
            // null);
            // }
            // } else {
            User user = userRepository.findByAccountId(loginModel.getId());
                if (user == null) {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf, "Account not found", "Login Failed", 2, null);
                    // System.out.println("Account not found");
                } else if (loginModel.checkPassword(user.getPassword())) {
                    OoadApplication.setLoginUser(user);
                    loginView.setVisible(false);
                    if (user.getRole().equals("Admin")) {
                        adminProjectListController.show();
                    } else if (user.getRole().equals("Lecturer")) {
                        projectListController.show();
                    } else if (user.getRole().equals("Student")) {
                        studentProjectListController.show();
                    }
                } else {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf, "Password incorrect", "Login Failed", 2, null);
                    // System.out.println("password not correct");
                }
                // }
        }

        // public boolean isRoot(LoginModel loginModel) {
        // return loginModel.getId().equals("root");
        // }

        // public boolean checkRoot(LoginModel loginModel) {
        // return loginModel.getPassword().equals("123");
        // }
    }

    private void initDB() {
        User user = userRepository.findByAccountId("root");
        if (user == null) {
            userRepository.save(new Admin("Root Admin", "Admin", "root", "123"));
        }
    }
}
