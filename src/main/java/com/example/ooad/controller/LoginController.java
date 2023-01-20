package com.example.ooad.controller;

import javax.swing.*;
import java.awt.event.*;
import org.springframework.stereotype.*;
import org.springframework.context.annotation.*;

// ============= ENTITY
import com.example.ooad.entity.*;
// ============= MODEL
import com.example.ooad.model.*;
// ============= VIEW
import com.example.ooad.view.*;

@Controller
public class LoginController implements IController {

    // ========================= Variables
    private LoginView view;
    private UserModel userModel;
    private StudentDashboardontroller studentProjectListController;
    private LecturerDashboardController projectListController;
    private AdminDashboardController adminProjectListController;

    // ========================= Constructor
    public LoginController(LoginView view, UserModel userModel,
            StudentDashboardontroller studentProjectListController,
            LecturerDashboardController projectListController,
            @Lazy AdminDashboardController adminProjectListController) {

        this.userModel = userModel;
        this.view = view;
        this.studentProjectListController = studentProjectListController;
        this.projectListController = projectListController;
        this.adminProjectListController = adminProjectListController;
        // Initialize the event listener for the login button
        this.view.getLoginButton().addActionListener(new SubmitListener());
    }

    // This will set the view to visible
    public void show() {
        view.setVisible(true);
    }

    // This will set the view to non-visible
    public void hide() {
        view.setVisible(false);
    }

    // This will trigger when user click on the submit button
    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input value from the individual field from the login view
            String accountId = view.getIdInput().getText();
            String password = view.getPasswordInput().getText();

            // Find user by it's account id
            // Return error if no such user
            // otherwise check if the password match
            // if match, then set the current authenticated user to that user
            // and render the view according to the user's role
            User user = userModel.findByAccountId(accountId);
            if (user == null) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "Account not found", "Login Failed", 2, null);
            } else if (user.checkPassword(password)) {
                userModel.setAuthUser(user);
                if (user instanceof Admin) {
                    adminProjectListController.show();
                } else if (user instanceof Lecturer) {
                    projectListController.show();
                } else if (user instanceof Student) {
                    studentProjectListController.show();
                }

                // Reset the input field back to default value
                view.getIdInput().setText("");
                view.getPasswordInput().setText("");

                // Hide the view
                view.setVisible(false);
            } else {
                // If the password is incorrect
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "Password incorrect", "Login Failed", 2, null);
            }
        }

    }

}
