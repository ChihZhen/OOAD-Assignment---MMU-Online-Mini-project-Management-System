package com.example.ooad.view;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.ProjectModel;

import java.awt.*;
import java.awt.event.*;

@Component
public class ProjectView extends JDialog implements Observer {

    private JButton submitButton;
    private JTextField titleInput;
    private JComboBox<String> specializationInput;
    private JComboBox<String> statusInput;
    private JTextArea descriptionInput;

    private ProjectModel projectModel;

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

    public ProjectView(ProjectModel projectModel) {

        this.projectModel = projectModel;
        projectModel.registerObserver(this);

        this.setModal(true);
        // this.setTitle("New Project");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                // update();
                projectModel.reset();
            }
        });

        // JLabel formTitle = new JLabel("");
        JLabel titleLabel = new JLabel("Title");
        add(this, titleLabel, 0, 0, 1, 1, GridBagConstraints.BASELINE_LEADING);

        titleInput = new JTextField();
        titleInput.setPreferredSize(new Dimension(200, 22));
        titleInput.setMinimumSize(new Dimension(200, 22));
        add(this, titleInput, 1, 0, 1, 1);

        JLabel specializationTitle = new JLabel("Specialization");
        add(this, specializationTitle, 0, 1, 1, 1, 0, 15, 0, 0);

        specializationInput = new JComboBox<String>(
                new String[] { "Software Engineer", "Data Science", "Game Development", "Cyber Security" });
        specializationInput.setPreferredSize(new Dimension(200, 22));
        specializationInput.setMinimumSize(new Dimension(200, 22));
        add(this, specializationInput, 1, 1, 1, 1, 20, 0, 20, 0);

        JLabel statusTitle = new JLabel("Status");
        add(this, statusTitle, 0, 2, 1, 1, GridBagConstraints.BASELINE_LEADING);

        statusInput = new JComboBox<String>(
                new String[] { "Active", "Inactive" });
        statusInput.setPreferredSize(new Dimension(200, 22));
        statusInput.setMinimumSize(new Dimension(200, 22));
        add(this, statusInput, 1, 2, 1, 1, 0, 0, 20, 0);

        JLabel descriptionTitle = new JLabel("Description");
        add(this, descriptionTitle, 0, 3, 1, 1, GridBagConstraints.BASELINE_LEADING);

        descriptionInput = new JTextArea();
        descriptionInput.setPreferredSize(new Dimension(200, 84));
        descriptionInput.setMinimumSize(new Dimension(200, 84));
        add(this, descriptionInput, 1, 3, 1, 1);

        submitButton = new JButton("Submit");
        add(this, submitButton, 1, 4, 1, 1, 30, 0, 0, 0, GridBagConstraints.LINE_END);
    }

    // public static void main(String[] args) {
    // new AddProjectView();
    // }

    public void addClickSubmitListener(ActionListener Listener) {
        submitButton.addActionListener(Listener);
    }

    public void setProjectModel() {
        projectModel.setTitle(titleInput.getText());
        projectModel.setDescription(descriptionInput.getText());
        projectModel.setSpecialization(specializationInput.getSelectedItem().toString());
        projectModel.setStatus(statusInput.getSelectedItem().toString());
    }

    public void update() {
        titleInput.setText(projectModel.getTitle());
        descriptionInput.setText(projectModel.getDescription());
        specializationInput.setSelectedItem(projectModel.getSpecialization());
        statusInput.setSelectedItem(projectModel.getStatus());
    }

    public void setEditable(boolean editable) {
        titleInput.setEditable(editable);
        descriptionInput.setEditable(editable);
        specializationInput.setEditable(editable);
        statusInput.setEditable(editable);
    }
}