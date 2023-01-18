package com.example.ooad.view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

import com.example.ooad.model.*;
import com.example.ooad.utils.*;


@Component
@Primary
public class LecturerAddProjectView extends JDialog {

    protected JButton submitButton;
    protected JTextField titleInput;
    protected JComboBox<String> specializationInput;
    protected JComboBox<String> statusInput;
    protected JTextArea descriptionInput;
    protected ProjectModel projectModel;

    public LecturerAddProjectView(ProjectModel projectModel) {

        this.projectModel = projectModel;

        this.setModal(true);
        this.setTitle("New Project");
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

        // ===== Title Label
        JLabel titleLabel = new JLabel("Title");
        GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0)
                .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();

        this.add(titleLabel, gridCtr.getConstraint());

        // ===== Title Input
        titleInput = new JTextField();
        titleInput.setPreferredSize(new Dimension(200, 22));
        titleInput.setMinimumSize(new Dimension(200, 22));
        GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setX(1).build();
        this.add(titleInput, gridCtr_2.getConstraint());

        // ===== Specialization Title
        JLabel specializationTitle = new JLabel("Specialization");
        GridBagAdder gridCtr_3 = new GridBagAdder.GridBagAdderBuilder().setY(1)
                .marginR(15).build();
        this.add(specializationTitle, gridCtr_3.getConstraint());

        // ===== Specialization Input
        specializationInput = new JComboBox<String>(
                new String[] { "Software Engineer", "Data Science", "Game Development", "Cyber Security" });
        specializationInput.setPreferredSize(new Dimension(200, 22));
        specializationInput.setMinimumSize(new Dimension(200, 22));
        GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(20).marginB(20).build();
        this.add(specializationInput, gridCtr_4.getConstraint());

        // ===== Status Title
        JLabel statusTitle = new JLabel("Status");
        GridBagAdder gridCtr_5 = new GridBagAdder.GridBagAdderBuilder().setY(2)
                .anchor(GridBagConstraints.BASELINE_LEADING)
                .build();
        this.add(statusTitle, gridCtr_5.getConstraint());
        // ===== Status Input
        statusInput = new JComboBox<String>(
                new String[] { "Active", "Inactive" });
        statusInput.setPreferredSize(new Dimension(200, 22));
        statusInput.setMinimumSize(new Dimension(200, 22));
        GridBagAdder gridCtr_6 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginB(20).build();
        this.add(statusInput, gridCtr_6.getConstraint());

        // ===== Description Title
        JLabel descriptionTitle = new JLabel("Description");
        GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setY(3)
                .anchor(GridBagConstraints.BASELINE_LEADING).build();
        this.add(descriptionTitle, gridCtr_7.getConstraint());

        descriptionInput = new JTextArea();
        descriptionInput.setPreferredSize(new Dimension(200, 84));
        descriptionInput.setMinimumSize(new Dimension(200, 84));
        GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).build();
        this.add(descriptionInput, gridCtr_8.getConstraint());

        // ===== Submit Button
        submitButton = new JButton("Submit");
        GridBagAdder gridCtr_9 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).marginT(30)
                .anchor(GridBagConstraints.LINE_END).build();
        this.add(submitButton, gridCtr_9.getConstraint());

    }
    // public static void main(String[] args) {
    // new AddProjectView();
    // }

    public JButton getSubmitButton() {
        return this.submitButton;
    }

    public void setSubmitButton(JButton submitButton) {
        this.submitButton = submitButton;
    }

    public JTextField getTitleInput() {
        return this.titleInput;
    }

    public void setTitleInput(JTextField titleInput) {
        this.titleInput = titleInput;
    }

    public JComboBox<String> getSpecializationInput() {
        return this.specializationInput;
    }

    public void setSpecializationInput(JComboBox<String> specializationInput) {
        this.specializationInput = specializationInput;
    }

    public JComboBox<String> getStatusInput() {
        return this.statusInput;
    }

    public void setStatusInput(JComboBox<String> statusInput) {
        this.statusInput = statusInput;
    }

    public JTextArea getDescriptionInput() {
        return this.descriptionInput;
    }

    public void setDescriptionInput(JTextArea descriptionInput) {
        this.descriptionInput = descriptionInput;
    }

    public ProjectModel getProjectModel() {
        return this.projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }
}
