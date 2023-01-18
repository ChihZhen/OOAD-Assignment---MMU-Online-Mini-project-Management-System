package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Project;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AdminAddProjectView;

import java.awt.event.*;
import java.util.List;

@Controller
public class AdminAddProjectController
        implements IController {
    private AdminAddProjectView view;
    private ProjectModel projectModel;
    private LecturerModel lecturerModel;

    public AdminAddProjectController(AdminAddProjectView view,
            ProjectModel projectModel, LecturerModel lecturerModel) {
        this.view = view;
        this.projectModel = projectModel;
        this.lecturerModel = lecturerModel;

        view.getSubmitButton().addActionListener(new SubmitButtonListener());
    }

    public void show() {
        lecturerModel.load();
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
            int lecturerIndex = view.getLecturerInput().getSelectedIndex();

            Lecturer lecturer = lecturerModel.get(lecturerIndex);
            Project project = new Project(title, description, status, specialization, lecturer);

            projectModel.create(project);
            projectModel.loadAdminData();

            // view.getTitleInput().setText("");
            // view.getSpecializationInput().setSelectedIndex(0);
            // view.getStatusInput().setSelectedIndex(0);
            // view.getDescriptionInput().setText("");
            // view.getLecturerInput().setSelectedIndex(0);

            view.dispose();
        }
    }
}
