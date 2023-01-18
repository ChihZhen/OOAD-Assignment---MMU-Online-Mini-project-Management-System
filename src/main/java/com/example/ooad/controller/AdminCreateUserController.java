package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.Admin;
import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Student;
import com.example.ooad.entity.User;
import com.example.ooad.model.UserModel;

import com.example.ooad.view.AdminCreateUserView;

import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@Controller
public class AdminCreateUserController implements IController {
    private AdminCreateUserView view;
    private UserModel userModel;

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    public String generateRandomPassword() {

        String numbers = "0123456789";

        Random rndm_method = new Random();

        char[] password = new char[6];
        System.out.println(password.toString());

        for (int i = 0; i < 6; i++) {
            System.out.println(password.toString());

            password[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));

        }
        System.out.println(password.toString());

        return new String(password);
        // return password;
    }

    public AdminCreateUserController(AdminCreateUserView view, UserModel userModel) {
        this.view = view;
        this.userModel = userModel;

        // view.addClickSubmitListener(new ClickSubmitButtonListener());
        view.getSubmitButton().addActionListener(new SubmitButtonListener());
        // view.addSelectRoleListener(new SelectRoleListener());
        view.getRoleInput().addActionListener(new SelectRoleListener());
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = view.getUsernameInput().getText();
            String role = view.getRoleInput().getSelectedItem().toString();
            String accountId = view.getIdInput().getText();
            System.out.println(userModel.findByAccountId(accountId));
            if (username.isBlank() | accountId.isBlank()) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please enter all fields",
                        "Invalid Input", 2, null);
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
                // view.getUsernameInput().setText("");
                // view.getRoleInput().setSelectedIndex(0);
                // view.getIdInput().setText("");

                view.dispose();
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Id already created",
                        "Account Created Failed", 2, null);
            }
        }
    }

    private class SelectRoleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
