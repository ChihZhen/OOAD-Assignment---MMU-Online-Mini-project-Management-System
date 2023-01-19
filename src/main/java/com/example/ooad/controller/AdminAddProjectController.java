package com.example.ooad.controller;

import java.awt.event.*;
// ============= ENTITY
import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Project;
// ============= MODEL
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
// ============= CONTROLLER
import org.springframework.stereotype.Controller;
// ============= VIEW
import com.example.ooad.view.AdminAddProjectView;

@Controller
public class AdminAddProjectController
        implements IController {

    // ========================= Variables
    private AdminAddProjectView view;
    private ProjectModel projectModel;
    private LecturerModel lecturerModel;

    // ========================= Constructor
    public AdminAddProjectController(AdminAddProjectView view,
            ProjectModel projectModel, LecturerModel lecturerModel) {
        this.view = view;
        this.projectModel = projectModel;
        this.lecturerModel = lecturerModel;
        // Initialize the event listener for the submit button
        view.getSubmitButton().addActionListener(new SubmitButtonListener());
    }

    // It will get a list of lecturers and unhide the add project view
    public void show() {
        // Call the .findAll method and returns a list of lecturer
        lecturerModel.load();
        view.setVisible(true);
    }

    // Hide the Add project view
    public void hide() {
        view.setVisible(false);
    }

    // This will call when user click on submit button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input value from the individual field from the Add project view
            String title = view.getTitleInput().getText();
            String specialization = view.getSpecializationInput().getSelectedItem().toString();
            String status = view.getStatusInput().getSelectedItem().toString();
            String description = view.getDescriptionInput().getText();
            int lecturerIndex = view.getLecturerInput().getSelectedIndex();

            // The lecturer index will return a number and passed into
            // the get function, the get funciton will retrieve the particular
            // lecturer on the index number
            Lecturer lecturer = lecturerModel.get(lecturerIndex);
            // Create a new project instance to be saved later on
            Project project = new Project(title, description, status, specialization, lecturer);

            // Save the project to database
            projectModel.create(project);
            // Call the .findAll() method for project and set it to a list
            projectModel.loadAdminData();

            // Clean up the view
            view.dispose();
        }
    }
}
