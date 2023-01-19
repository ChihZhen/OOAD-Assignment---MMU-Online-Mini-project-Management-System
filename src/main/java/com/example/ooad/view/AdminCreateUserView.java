package com.example.ooad.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.utils.GridBagAdder;

@Component
public class AdminCreateUserView extends JDialog {

    private JTextField usernameInput;
    private JTextField idInput;
    private JLabel specializationLabel;
    private JComboBox<String> roleInput;
    private JComboBox<String> specializationInput;
    private JButton submitButton;

    public AdminCreateUserView() {

        this.setModal(true);
        this.setTitle("Create User");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                usernameInput.setText("");
                idInput.setText("");
                roleInput.setSelectedIndex(0);
                specializationInput.setSelectedIndex(0);
            }
        });

        GridBagAdder gridBagAdder;

        JLabel usernameLabel = new JLabel("Username");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().marginR(20).anchor(GridBagConstraints.BASELINE).build();
        this.add(usernameLabel, gridBagAdder.getConstraint());

        usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(200, 22));
        usernameInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).build();
        this.add(usernameInput, gridBagAdder.getConstraint());

        JLabel idLabel = new JLabel("Id");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(1).build();
        this.add(idLabel, gridBagAdder.getConstraint());

        idInput = new JTextField();
        idInput.setPreferredSize(new Dimension(200, 22));
        idInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(20).marginB(20)
                .anchor(GridBagConstraints.BASELINE).build();
        this.add(idInput, gridBagAdder.getConstraint());

        JLabel roleLabel = new JLabel("Role");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(2).anchor(GridBagConstraints.BASELINE).build();
        this.add(roleLabel, gridBagAdder.getConstraint());

        roleInput = new JComboBox<String>(
                new String[] { "Lecturer", "Admin", "Student" });
        roleInput.setPreferredSize(new Dimension(200, 22));
        roleInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginB(20).build();
        this.add(roleInput, gridBagAdder.getConstraint());

        specializationLabel = new JLabel("Specialization");
        specializationLabel.setVisible(false);
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(3).marginR(15).marginB(20).build();
        this.add(specializationLabel, gridBagAdder.getConstraint());

        specializationInput = new JComboBox<String>(
                new String[] { "Software Engineer", "Data Science", "Game Development", "Cyber Security" });
        specializationInput.setPreferredSize(new Dimension(200, 22));
        specializationInput.setMinimumSize(new Dimension(200, 22));
        specializationInput.setVisible(false);
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).marginB(20).build();
        this.add(specializationInput, gridBagAdder.getConstraint());

        submitButton = new JButton("Submit");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).marginT(30)
                .anchor(GridBagConstraints.LINE_END).build();
        this.add(submitButton, gridBagAdder.getConstraint());
    }

    // Getter and Setter
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

    public JLabel getSpecializationLabel() {
        return this.specializationLabel;
    }

    public void setSpecializationLabel(JLabel specializationLabel) {
        this.specializationLabel = specializationLabel;
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
}
