package com.example.ooad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Project;
import com.example.ooad.entity.User;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.LecturerAddProjectView;

import java.awt.event.*;
import java.util.List;

@Controller
public class LecturerAddProjectController {
    protected LecturerAddProjectView view;
    protected ProjectModel projectModel;

    public LecturerAddProjectController(LecturerAddProjectView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;
        view.addClickSubmitListener(new SubmitButtonListener());
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
            String title = view.getTitleInput().getText();
            String specialization = view.getSpecializationInput().getSelectedItem().toString();
            String status = view.getStatusInput().getSelectedItem().toString();
            String description = view.getDescriptionInput().getText();

            Project project = new Project(title, description, status, specialization,
                    (Lecturer) projectModel.getAuthUser());
            projectModel.create(project);
            projectModel.load();
            projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
            view.dispose();
        }
    }
}
