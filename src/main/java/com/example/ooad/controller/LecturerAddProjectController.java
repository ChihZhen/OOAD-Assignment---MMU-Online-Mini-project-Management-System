package com.example.ooad.controller;

import java.awt.event.*;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.*;
import com.example.ooad.model.*;
import com.example.ooad.view.*;

@Controller
public class LecturerAddProjectController implements IController {
    protected LecturerAddProjectView view;
    protected ProjectModel projectModel;

    public LecturerAddProjectController(LecturerAddProjectView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;
        view.getSubmitButton().addActionListener(new SubmitButtonListener());
    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = view.getTitleInput().getText();
            String specialization = view.getSpecializationInput().getSelectedItem().toString();
            String status = view.getStatusInput().getSelectedItem().toString();
            String description = view.getDescriptionInput().getText();

            Project project = new Project(title, description, status, specialization,
                    (Lecturer) projectModel.getAuthUser());
            projectModel.create(project);
            // projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
            projectModel.loadLecturerData();

            view.getTitleInput().setText("");
            view.getSpecializationInput().setSelectedIndex(0);
            view.getStatusInput().setSelectedIndex(0);
            view.getDescriptionInput().setText("");

            view.dispose();
        }
    }
}
