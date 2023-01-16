package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.AdminModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.model.UserModel;
import com.example.ooad.repository.StudentRepository;
import com.example.ooad.repository.UserRepository;
import com.example.ooad.view.CreateUserView;

import java.awt.event.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@Controller
public class CreateUserController {
    private CreateUserView createUserView;
    // private ProjectRepository projectRepository;
    // private ProjectListModel projectTableModel;
    // private UserModel userModel;
    private AdminModel adminModel;
    private StudentModel studentModel;
    private LecturerModel lecturerModel;
    private UserRepository userRepository;
    private StudentRepository studentRepository;

    // public void showAddProject() {
    // createUserView.setTitle("New Project");
    // createUserView.setVisible(true);
    // }

    // public void showEditProject(int index) {
    // createUserView.setTitle("Edit Project");
    // // userModel.set(userModel.getProject(index));
    // createUserView.setVisible(true);
    // }

    public void show() {
        createUserView.setVisible(true);
    }

    public CreateUserController(CreateUserView createUserView, AdminModel adminModel, StudentModel studentModel,
            LecturerModel lecturerModel, UserRepository userRepository, StudentRepository studentRepository) {
        this.createUserView = createUserView;
        this.lecturerModel = lecturerModel;
        this.adminModel = adminModel;
        this.studentModel = studentModel;
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        // this.projectModel = projectModel;
        // this.projectTableModel = projectTableModel;
        // this.projectRepository = projectRepository;

        createUserView.addClickSubmitListener(new ClickSubmitButtonListener());
        createUserView.addSelectRoleListener(new SelectRoleListener());
        // init();
    }

    // private void init() {
    // createUserView.addClickSubmitListener(new ClickSubmitButtonListener());
    // createUserView.addSelectRoleListener(new SelectRoleListener());
    // // show();
    // // createUserView.setVisible(true);
    // // createUserView.setModal(true);
    // }

    private class ClickSubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // createUserView.setProjectModel();
            // System.out.println("createUserView.actionPerformed");
            UserModel userModel = createUserView.getUserModel();
            userModel.generateRandomPassword();
            if (userModel.isValid()) {
                if (userRepository.findByAccountId(userModel.getAccountId()) == null) {
                    userRepository.save(userModel);
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf,
                            "Id: " + userModel.getAccountId() + ", Password: " + userModel.getPassword(),
                            "Account Created Successfully", 1, null);

                } else {
                    JFrame jf = new JFrame();
                    JOptionPane.showMessageDialog(jf,
                            "Id already created",
                            "Account Created Failed", 2, null);
                }
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please enter all fields",
                        "Invalid Input", 2, null);
            }

        }
    }

    private class SelectRoleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (createUserView.getRoleInput().getSelectedItem().toString().equals("Student")) {
                createUserView.getSpecializationLabel().setVisible(true);
                createUserView.getSpecializationInput().setVisible(true);
            } else {
                createUserView.getSpecializationLabel().setVisible(false);
                createUserView.getSpecializationInput().setVisible(false);
            }
        }
    }
}
