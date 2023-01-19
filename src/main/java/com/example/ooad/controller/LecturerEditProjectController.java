package com.example.ooad.controller;

import java.awt.event.*;
import org.springframework.stereotype.*;

// ============= ENTITY
import com.example.ooad.entity.*;
// ============= MODEL
import com.example.ooad.model.*;
// ============= VIEW
import com.example.ooad.view.*;

@Controller
public class LecturerEditProjectController implements IController {
    // ========================= Variables
    private LecturerEditProjectView view;
    private ProjectModel projectModel;

    // ========================= Constructor
    public LecturerEditProjectController(LecturerEditProjectView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;
        // Initialize the event listener for the submit button
        this.view.getSubmitButton().addActionListener(new SubmitButtonListener());
    }

    // This will set the view to visible
    public void show() {
        view.setVisible(true);
    }

    // This will set the view to non-visible
    public void hide() {
        view.setVisible(false);
    }

    // This will trigger when user click on the submit button
    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the input value from the individual field from the edit project view
            Project project = projectModel.getCurrent();
            String title = view.getTitleInput().getText();
            String specialization = view.getSpecializationInput().getSelectedItem().toString();
            String status = view.getStatusInput().getSelectedItem().toString();
            String description = view.getDescriptionInput().getText();

            // Use setter to set the value retrieved from the view
            project.setTitle(title);
            project.setSpecialization(specialization);
            project.setStatus(status);
            project.setDescription(description);

            // Update the updates to database
            projectModel.update(project);

            // Get the list of projects back
            projectModel.loadLecturerData();

            // Clean up the view
            view.dispose();
        }
    }
}
