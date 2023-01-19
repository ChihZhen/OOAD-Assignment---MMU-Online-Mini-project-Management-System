package com.example.ooad.controller;

import java.awt.event.*;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.stereotype.Controller;
// ============= ENTITY
import com.example.ooad.entity.Admin;
import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Student;
import com.example.ooad.entity.User;
// ============= MODEL
import com.example.ooad.model.UserModel;
// ============= VIEW
import com.example.ooad.view.AdminCreateUserView;

@Controller
public class AdminCreateUserController implements IController {
    // ========================= Variables
    private AdminCreateUserView view;
    private UserModel userModel;

    // ========================= Constructor
    public AdminCreateUserController(AdminCreateUserView view, UserModel userModel) {
        this.view = view;
        this.userModel = userModel;

        view.getSubmitButton().addActionListener(new SubmitButtonListener());
        view.getRoleInput().addActionListener(new SelectRoleListener());
    }

    // Set the create user view to visible
    public void show() {
        view.setVisible(true);
    }

    // set the create user view to non visible
    public void hide() {
        view.setVisible(false);
    }

    // This function will generate a random password for newly created user that is
    // based in number format
    public String generateRandomPassword() {
        String numbers = "0123456789";
        Random random = new Random();
        char[] password = new char[6];

        for (int i = 0; i < 6; i++) {
            password[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(password);
    }

    // This will call when user click on submit button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input value from the individual field from the Add User view
            String username = view.getUsernameInput().getText();
            String role = view.getRoleInput().getSelectedItem().toString();
            String accountId = view.getIdInput().getText();

            // Check if username or account id field is blank or not
            // =================
            // Show dialog message and remind them to fill in if the field is blank
            // =================
            // Otherwise check if the account id already exist
            // If not, generate a random password for it, and check for the role
            // Create an instance according to the role and finally save the user
            // After that show a dialog that has the username and user's password
            // on it
            // =================
            // If account already created, then show message dialog
            // saying that the account already exist
            if (username.isBlank() | accountId.isBlank()) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please enter all fields",
                        "Invalid Input", 2, null);
                return;
            } else if (userModel.findByAccountId(accountId) == null) {
                User user;
                String password = generateRandomPassword();
                if (role.equals("Lecturer")) {
                    user = new Lecturer(username, role, accountId, password);
                } else if (role.equals("Admin")) {
                    user = new Admin(username, role, accountId, password);
                } else {
                    String specialization = view.getSpecializationInput().getSelectedItem().toString();
                    user = new Student(username, role, accountId, specialization, password);
                }
                userModel.create(user);
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Id: " + accountId + ", Password: " + password,
                        "Account Created Successfully", 1, null);

                view.dispose();
                return;
            }
            JFrame jf = new JFrame();
            JOptionPane.showMessageDialog(jf,
                    "Id already created",
                    "Account Created Failed", 2, null);

        }
    }

    // This will trigger when the user select the role dropdown
    private class SelectRoleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // If the selected role is student, it will show the
            // specialization label and input
            // ============================
            // Otherwise it will hide the specialization input and label
            if (view.getRoleInput().getSelectedItem().toString().equals("Student")) {
                view.getSpecializationLabel().setVisible(true);
                view.getSpecializationInput().setVisible(true);
            } else {
                view.getSpecializationLabel().setVisible(false);
                view.getSpecializationInput().setVisible(false);
            }
        }
    }
}
