package com.example.ooad.controller;

import java.awt.event.*;

// ============= ENTITY
import com.example.ooad.entity.*;
// ============= VIEW
import com.example.ooad.view.*;
// ============= CONTROLLER
import org.springframework.stereotype.Controller;
// ============= MODEL
import com.example.ooad.model.*;

@Controller
public class LecturerAddProjectController implements IController {
    // ========================= Variables
    protected LecturerAddProjectView view;
    protected ProjectModel projectModel;

    // ========================= Constructor
    public LecturerAddProjectController(LecturerAddProjectView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;
        // Initialize the event listener for the submit button
        view.getSubmitButton().addActionListener(new SubmitButtonListener());
    }

    // This will set the current view to visible
    public void show() {
        view.setVisible(true);
    }

    // This will set the view to non-visible
    public void hide() {
        view.setVisible(false);
    }

    // This will trigger when the user click the submit button
    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input value from the individual field from the Add project view
            String title = view.getTitleInput().getText();
            String specialization = view.getSpecializationInput().getSelectedItem().toString();
            String status = view.getStatusInput().getSelectedItem().toString();
            String description = view.getDescriptionInput().getText();

            // Create a new project instance to be saved later on
            Project project = new Project(title, description, status, specialization,
                    (Lecturer) projectModel.getAuthUser());

            // Save the project ot database
            projectModel.create(project);

            // Call the findAll() method for project
            projectModel.loadLecturerData();

            // Reset the field back to default value
            // for add project view
            view.getTitleInput().setText("");
            view.getSpecializationInput().setSelectedIndex(0);
            view.getStatusInput().setSelectedIndex(0);
            view.getDescriptionInput().setText("");

            // Clean up the view
            view.dispose();
        }
    }
}
