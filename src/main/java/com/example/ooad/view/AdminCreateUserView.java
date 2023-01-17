package com.example.ooad.view;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Admin;
import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Student;
import com.example.ooad.entity.User;

import java.awt.*;
import java.awt.event.*;

@Component
public class AdminCreateUserView extends JDialog {

    private JTextField usernameInput;
    private JTextField idInput;
    private JComboBox<String> roleInput;
    private JLabel specializationLabel;
    private JComboBox<String> specializationInput;
    private JButton submitButton;

    // private StudentModel studentModel;

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(2, 2, 2, 2);
        constr.anchor = GridBagConstraints.CENTER;
        dialog.add(comp, constr);
    }

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height, int marginT,
            int marginR,
            int marginB, int marginL) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = GridBagConstraints.CENTER;
        dialog.add(comp, constr);
    }

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height, int marginT,
            int marginR,
            int marginB, int marginL, int anchor) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = anchor;
        dialog.add(comp, constr);
    }

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height, int anchor) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        // constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = anchor;
        dialog.add(comp, constr);
    }

    // public CreateUserView(ProjectModel projectModel) {
    public AdminCreateUserView() {

        // this.studentModel = studentModel;

        // this.setModal(true);
        this.setTitle("Create User");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);
        // this.addWindowListener(new WindowAdapter() {
        // public void windowClosed(WindowEvent e) {
        // // update();
        // // projectModel.reset();
        // }
        // });

        JLabel usernameLabel = new JLabel("Username");
        add(this, usernameLabel, 0, 0, 1, 1, 0, 20, 0, 0, GridBagConstraints.BASELINE);

        usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(200, 22));
        usernameInput.setMinimumSize(new Dimension(200, 22));
        add(this, usernameInput, 1, 0, 1, 1);

        JLabel idLabel = new JLabel("Id");
        add(this, idLabel, 0, 1, 1, 1, GridBagConstraints.BASELINE);

        idInput = new JTextField();
        idInput.setPreferredSize(new Dimension(200, 22));
        idInput.setMinimumSize(new Dimension(200, 22));
        add(this, idInput, 1, 1, 1, 1, 20, 0, 20, 0, GridBagConstraints.BASELINE);

        JLabel roleLabel = new JLabel("Role");
        add(this, roleLabel, 0, 2, 1, 1, GridBagConstraints.BASELINE);

        roleInput = new JComboBox<String>(
                new String[] { "Lecturer", "Admin", "Student" });
        roleInput.setPreferredSize(new Dimension(200, 22));
        roleInput.setMinimumSize(new Dimension(200, 22));
        add(this, roleInput, 1, 2, 1, 1, 0, 0, 20, 0);

        specializationLabel = new JLabel("Specialization");
        specializationLabel.setVisible(false);
        add(this, specializationLabel, 0, 3, 1, 1, 0, 15, 20, 0);
        specializationInput = new JComboBox<String>(
                new String[] { "Software Engineer", "Data Science", "Game Development", "Cyber Security" });
        specializationInput.setPreferredSize(new Dimension(200, 22));
        specializationInput.setMinimumSize(new Dimension(200, 22));
        specializationInput.setVisible(false);
        add(this, specializationInput, 1, 3, 1, 1, 0, 0, 20, 0);

        submitButton = new JButton("Submit");
        add(this, submitButton, 1, 4, 1, 1, 30, 0, 0, 0, GridBagConstraints.LINE_END);
        // this.setVisible(true);
    }

    public static void main(String[] args) {
        new AdminCreateUserView();
    }

    public void addClickSubmitListener(ActionListener Listener) {
        submitButton.addActionListener(Listener);
    }

    public void addSelectRoleListener(ActionListener listener) {
        roleInput.addActionListener(listener);
    }

    public User getUserModel() {
        User userModel;
        if (roleInput.getSelectedItem().toString().equals("Lecturer")) {
            userModel = new Lecturer(usernameInput.getText(),
                    roleInput.getSelectedItem().toString(),
                    idInput.getText());
        } else if (roleInput.getSelectedItem().toString().equals("Admin")) {
            userModel = new Admin(usernameInput.getText(),
                    roleInput.getSelectedItem().toString(),
                    idInput.getText());
        } else {
            userModel = new Student(usernameInput.getText(),
                    roleInput.getSelectedItem().toString(),
                    idInput.getText(), specializationInput.getSelectedItem().toString());
        }
        // userModel.setAccountId(idInput.getText());
        // userModel.setFullName(usernameInput.getText());
        // userModel.setRole(roleInput.getSelectedItem().toString());
        // studentModel.setStatus(statusInput.getSelectedItem().toString());

        return userModel;
    }

    // public void update() {
    // idInput.setText(studentModel.getAccountId());
    // usernameInput.setText(studentModel.getFullName());
    // roleInput.setSelectedItem(new String());
    // }

    // public void setEditable(boolean editable) {
    // titleInput.setEditable(editable);

    public JTextField getUsernameInput() {
        return this.usernameInput;
    }

    public void setUsernameInput(JTextField usernameInput) {
        this.usernameInput = usernameInput;
    }

    public JTextField getIdInput() {
        return this.idInput;
    }

    public void setIdInput(JTextField idInput) {
        this.idInput = idInput;
    }

    public JComboBox<String> getRoleInput() {
        return this.roleInput;
    }

    public void setRoleInput(JComboBox<String> roleInput) {
        this.roleInput = roleInput;
    }

    public JComboBox<String> getSpecializationInput() {
        return this.specializationInput;
    }

    public void setSpecializationInput(JComboBox<String> specializationInput) {
        this.specializationInput = specializationInput;
    }

    public JButton getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JLabel getSpecializationLabel() {
        return this.specializationLabel;
    }

    public void setSpecializationLabel(JLabel specializationLabel) {
        this.specializationLabel = specializationLabel;
    }
    // descriptionInput.setEditable(editable);
    // specializationInput.setEditable(editable);
    // statusInput.setEditable(editable);
    // }
}
