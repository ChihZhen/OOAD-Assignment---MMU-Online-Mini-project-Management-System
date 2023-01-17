package com.example.ooad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Lecturer;
import com.example.ooad.entity.Project;
import com.example.ooad.entity.User;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectView;

import java.awt.event.*;
import java.util.List;

@Controller
public class ProjectController {
    private ProjectView projectView;
    private ProjectRepository projectRepository;
    private ProjectModel projectTableModel;
    private Project projectModel;

    @Autowired
    private LecturerRepository lecturerRepository;

    public void showAddProject() {
        projectView.setTitle("New Project");
        projectView.setVisible(true);
    }

    public void showEditProject(int index) {
        projectView.setTitle("Edit Project");
        // projectModel.set(projectModel.get(index));
        projectView.setVisible(true);
    }

    public ProjectController(ProjectView addProjectView, ProjectRepository projectRepository,
            ProjectModel projectTableModel, Project projectModel) {
        this.projectView = addProjectView;
        this.projectModel = projectModel;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepository;
        // init();

        projectView.addClickSubmitListener(new ClickSubmitButtonListener());
    }

    // private void init() {
    // projectView.addClickSubmitListener(new ClickSubmitButtonListener());
    // // show();
    // // projectView.setVisible(true);
    // }

    class ClickSubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            projectView.setProjectModel();
            Lecturer lecturer = (Lecturer) OoadApplication.getLoginUser();
            projectModel.setLecturer(lecturer);
            projectRepository.save(projectModel);

            if (OoadApplication.getLoginUser().getRole().equals("Lecturer")) {
                User user = OoadApplication.getLoginUser();
                // List<Project> projects = lecturerRepository
                // .findOneById(user.getId()).getProjects();
                // projectTableModel.setProjects(projects);
            } else {
                List<Project> projects = projectRepository.findAll();
                // projectTableModel.setProjects(projects);
            }
            projectModel.reset();
            projectView.dispose();
        }
    }
}
