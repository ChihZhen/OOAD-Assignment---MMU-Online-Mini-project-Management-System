package com.example.ooad.view;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.LecturerListModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;

import java.awt.*;
import java.awt.event.*;

@Component
public class AdminAddProjectView extends JDialog implements Observer {

    private JButton submitButton;
    private JTextField titleInput;
    private JComboBox<String> specializationInput;
    private JComboBox<String> statusInput;
    private JComboBox<String> lecturerInput;
    private JTextArea descriptionInput;

    private ProjectModel projectModel;
    private LecturerListModel lecturerListModel;

    public AdminAddProjectView(ProjectModel projectModel, LecturerListModel lecturerListModel) {
        // public AdminAddProjectView() {

        this.projectModel = projectModel;
        this.lecturerListModel = lecturerListModel;
        // projectModel.registerObserver(this);

        // this.setModal(true);
        lecturerListModel.registerObserver(this);
        this.setTitle("New Project");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                // update();
                // projectModel.reset();
            }
        });

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

        JLabel lecturerTitle = new JLabel("Lecturer");
        gridCtr_5 = new GridBagAdder.GridBagAdderBuilder().setY(3)
                .anchor(GridBagConstraints.BASELINE_LEADING)
                .build();
        this.add(lecturerTitle, gridCtr_5.getConstraint());

        lecturerInput = new JComboBox<String>();
        lecturerInput.setPreferredSize(new Dimension(200, 22));
        lecturerInput.setMinimumSize(new Dimension(200, 22));
        gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).marginB(20).build();
        this.add(lecturerInput, gridCtr.getConstraint());

        // ===== Description Title
        JLabel descriptionTitle = new JLabel("Description");
        GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setY(4)
                .anchor(GridBagConstraints.BASELINE_LEADING).build();
        this.add(descriptionTitle, gridCtr_7.getConstraint());

        descriptionInput = new JTextArea();
        descriptionInput.setPreferredSize(new Dimension(200, 84));
        descriptionInput.setMinimumSize(new Dimension(200, 84));
        GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).build();
        this.add(descriptionInput, gridCtr_8.getConstraint());

        // ===== Submit Button
        submitButton = new JButton("Submit");
        GridBagAdder gridCtr_9 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(5).marginT(30)
                .anchor(GridBagConstraints.LINE_END).build();
        this.add(submitButton, gridCtr_9.getConstraint());
        // this.setVisible(true);
    }

    // public static void main(String[] args) {
    // new AdminAddProjectView();
    // }

    public void addClickSubmitListener(ActionListener Listener) {
        submitButton.addActionListener(Listener);
    }

    public void setProjectModel() {
        projectModel.setTitle(titleInput.getText());
        projectModel.setDescription(descriptionInput.getText());
        projectModel.setSpecialization(specializationInput.getSelectedItem().toString());
        projectModel.setStatus(statusInput.getSelectedItem().toString());
        projectModel.setLecturer(lecturerListModel.getLecturer(lecturerInput.getSelectedIndex()));
    }

    public void update() {
        System.out.println("AdminAddProjectView.update: ->>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        lecturerInput.setModel(lecturerListModel.getComboBox());
        // titleInput.setText(projectModel.getTitle());
        // descriptionInput.setText(projectModel.getDescription());
        // specializationInput.setSelectedItem(projectModel.getSpecialization());
        // statusInput.setSelectedItem(projectModel.getStatus());
    }

    public void setEditable(boolean editable) {
        titleInput.setEditable(editable);
        descriptionInput.setEditable(editable);
        specializationInput.setEditable(editable);
        statusInput.setEditable(editable);
    }
}
