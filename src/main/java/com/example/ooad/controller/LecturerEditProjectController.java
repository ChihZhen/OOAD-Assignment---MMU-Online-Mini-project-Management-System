package com.example.ooad.controller;

import java.awt.event.*;

import org.springframework.stereotype.*;

import com.example.ooad.entity.*;
import com.example.ooad.model.*;
import com.example.ooad.view.*;

@Controller
public class LecturerEditProjectController implements IController {
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
            // projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
            projectModel.loadLecturerData();

            view.dispose();
        }
    }
}
