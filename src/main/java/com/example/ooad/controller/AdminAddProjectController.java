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
public class AdminAddProjectController {
    private ProjectModel projectModel;
    private LecturerModel lecturerModel;
    private AdminAddProjectView adminAddProjectView;

    public AdminAddProjectController(AdminAddProjectView adminAddProjectView,
            ProjectModel projectModel, LecturerModel lecturerModel) {
        this.adminAddProjectView = adminAddProjectView;
        this.projectModel = projectModel;
        // this.projectTableModel = projectTableModel;
        // this.projectRepository = projectRepository;
        this.lecturerModel = lecturerModel;
        // this.lecturerRepository = lecturerRepository;
        adminAddProjectView.getSubmitButton().addActionListener(new SubmitButtonListener());
        // adminAddProjectView.addClickSubmitListener(new ClickSubmitButtonListener());
    }

    public void show() {
        lecturerModel.load();
        adminAddProjectView.setVisible(true);
    }

    public void hide() {
        adminAddProjectView.setVisible(false);
    }

    // public void loadData() {
    // List<Lecturer> lecturers = lecturerRepository.findAll();
    // lecturerListModel.setLecturers(lecturers);
    // }

    class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminAddProjectView.getTitleInput().getText();
            String specialization = adminAddProjectView.getSpecializationInput().getSelectedItem().toString();
            String status = adminAddProjectView.getStatusInput().getSelectedItem().toString();
            String description = adminAddProjectView.getDescriptionInput().getText();
            int lecturerIndex = adminAddProjectView.getLecturerInput().getSelectedIndex();

            // adminAddProjectView.setProjectModel();
            Lecturer lecturer = lecturerModel.get(lecturerIndex);
            Project project = new Project(title, description, status, specialization, lecturer);
            // projectRepository.save(projectModel);
            projectModel.create(project);
            // List<Project> projects = projectRepository.findAll();
            // projectTableModel.setProjects(projects);
            // projectModel.reset();
            // System.out.println("clickbuttonlistener");
            adminAddProjectView.dispose();
        }
    }
}
