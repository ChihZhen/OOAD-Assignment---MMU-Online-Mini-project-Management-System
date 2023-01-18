package com.example.ooad.view;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.IModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;

@Component
public class AdminAddProjectView extends JDialog implements Observer<IModel> {
    private LecturerModel lecturerModel;

    private JButton submitButton;
    private JTextField titleInput;
    private JTextArea descriptionInput;
    private JComboBox<String> specializationInput;
    private JComboBox<String> statusInput;
    private JComboBox<String> lecturerInput;

    public AdminAddProjectView(LecturerModel lecturerModel) {
        this.lecturerModel = lecturerModel;
        lecturerModel.registerObserver(this);

        this.setModal(true);
        this.setTitle("New Project");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                titleInput.setText("");
                specializationInput.setSelectedIndex(0);
                statusInput.setSelectedIndex(0);
                lecturerInput.setSelectedIndex(0);
                descriptionInput.setText("");
            }
        });

        GridBagAdder gridBagAdder;

        // ===== Title Label
        JLabel titleLabel = new JLabel("Title");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0)
                .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();

        this.add(titleLabel, gridBagAdder.getConstraint());

        // ===== Title Input
        titleInput = new JTextField();
        titleInput.setPreferredSize(new Dimension(200, 22));
        titleInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).build();

        this.add(titleInput, gridBagAdder.getConstraint());

        // ===== Specialization Title
        JLabel specializationTitle = new JLabel("Specialization");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(1)
                .marginR(15).build();

        this.add(specializationTitle, gridBagAdder.getConstraint());

        // ===== Specialization Input
        specializationInput = new JComboBox<String>(
                new String[] { "Software Engineer", "Data Science", "Game Development", "Cyber Security" });
        specializationInput.setPreferredSize(new Dimension(200, 22));
        specializationInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(20).marginB(20).build();

        this.add(specializationInput, gridBagAdder.getConstraint());

        // ===== Status Title
        JLabel statusTitle = new JLabel("Status");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(2)
                .anchor(GridBagConstraints.BASELINE_LEADING)
                .build();

        this.add(statusTitle, gridBagAdder.getConstraint());

        // ===== Status Input
        statusInput = new JComboBox<String>(
                new String[] { "Active", "Inactive" });
        statusInput.setPreferredSize(new Dimension(200, 22));
        statusInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginB(20).build();

        this.add(statusInput, gridBagAdder.getConstraint());

        JLabel lecturerTitle = new JLabel("Lecturer");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(3)
                .anchor(GridBagConstraints.BASELINE_LEADING)
                .build();

        this.add(lecturerTitle, gridBagAdder.getConstraint());

        lecturerInput = new JComboBox<String>();
        lecturerInput.setPreferredSize(new Dimension(200, 22));
        lecturerInput.setMinimumSize(new Dimension(200, 22));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).marginB(20).build();
        this.add(lecturerInput, gridBagAdder.getConstraint());

        // ===== Description Title
        JLabel descriptionTitle = new JLabel("Description");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(4)
                .anchor(GridBagConstraints.BASELINE_LEADING).build();
        this.add(descriptionTitle, gridBagAdder.getConstraint());

        descriptionInput = new JTextArea();
        descriptionInput.setPreferredSize(new Dimension(200, 84));
        descriptionInput.setMinimumSize(new Dimension(200, 84));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).build();
        this.add(descriptionInput, gridBagAdder.getConstraint());

        // ===== Submit Button
        submitButton = new JButton("Submit");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(5).marginT(30)
                .anchor(GridBagConstraints.LINE_END).build();
        this.add(submitButton, gridBagAdder.getConstraint());
    }

    public void update(Observable<IModel> _observable, IModel model) {
        if (model instanceof LecturerModel) {
            lecturerInput.setModel(new DefaultComboBoxModel<>(lecturerModel.getNameAndId()));
        }
    }

    // Getter and Setter
    public LecturerModel getLecturerModel() {
        return this.lecturerModel;
    }

    public void setLecturerModel(LecturerModel lecturerModel) {
        this.lecturerModel = lecturerModel;
    }

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

    public JTextArea getDescriptionInput() {
        return this.descriptionInput;
    }

    public void setDescriptionInput(JTextArea descriptionInput) {
        this.descriptionInput = descriptionInput;
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

    public JComboBox<String> getLecturerInput() {
        return this.lecturerInput;
    }

    public void setLecturerInput(JComboBox<String> lecturerInput) {
        this.lecturerInput = lecturerInput;
    }
}
