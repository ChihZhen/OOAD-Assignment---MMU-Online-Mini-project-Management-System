package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.Project;
import com.example.ooad.model.ProjectModel;

import com.example.ooad.view.LecturerEditProjectView;
import java.awt.event.*;

@Controller
public class LecturerEditProjectController {
    private LecturerEditProjectView view;
    private ProjectModel projectModel;

    public LecturerEditProjectController(LecturerEditProjectView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;

        this.view.getSubmitButton().addActionListener(new SubmitButtonListener());
    }

    public void show() {
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Project project = projectModel.getCurrent();
            String title = view.getTitleInput().getText();
            String specialization = view.getSpecializationInput().getSelectedItem().toString();
            String status = view.getStatusInput().getSelectedItem().toString();
            String description = view.getDescriptionInput().getText();
            project.setTitle(title);
            project.setSpecialization(specialization);
            project.setStatus(status);
            project.setDescription(description);
            projectModel.update(project);
            projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
            view.dispose();
        }
    }
}
