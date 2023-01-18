package com.example.ooad.controller;

import javax.swing.*;

import java.awt.event.*;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import com.example.ooad.entity.*;
import com.example.ooad.model.*;
import com.example.ooad.view.*;

@Controller
public class LoginController implements IController {

    private LoginView view;
    private UserModel userModel;
    private StudentDashboardController studentProjectListController;
    private LecturerDashboardController projectListController;
    private AdminDashboardController adminProjectListController;

    public LoginController(LoginView view, UserModel userModel,
            StudentDashboardController studentProjectListController,
            LecturerDashboardController projectListController,
            @Lazy AdminDashboardController adminProjectListController) {

        this.userModel = userModel;
        this.view = view;
        this.studentProjectListController = studentProjectListController;
        this.projectListController = projectListController;
        this.adminProjectListController = adminProjectListController;
        this.view.addSubmitEventListener(new SubmitListener());
    }

    public void show() {
        // adminModel.load();

        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String accountId = view.getIdInput().getText();
            String password = view.getPasswordInput().getText();
            // Student student = new Student("123", "lcz", "student", "1201101263",
            // "data-science");
            // studentRepository.save(student);
            // loginModel = view.getLoginModel();

            User user = userModel.findByAccountId(accountId);
            if (user == null) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "Account not found", "Login Failed", 2, null);
                // System.out.println("Account not found");
            } else if (user.checkPassword(password)) {
                userModel.setAuthUser(user);
                if (user instanceof Admin) {
                    adminProjectListController.show();
                } else if (user instanceof Lecturer) {
                    projectListController.show();
                } else if (user instanceof Student) {
                    studentProjectListController.show();
                }

                view.getIdInput().setText("");
                view.getPasswordInput().setText("");

                view.setVisible(false);
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "Password incorrect", "Login Failed", 2, null);
                // System.out.println("password not correct");
            }
        }

    }

}
