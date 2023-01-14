package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectView;

import java.awt.event.*;
import java.util.List;

@Controller
public class ProjectController {
    private ProjectView projectView;
    private ProjectRepository projectRepository;
    private ProjectListModel projectTableModel;
    private ProjectModel projectModel;

    public void showAddProject() {
        projectView.setTitle("New Project");
        projectView.setVisible(true);
    }

    public void showEditProject(int index) {
        projectView.setTitle("Edit Project");
        projectModel.set(projectTableModel.getProject(index));
        projectView.setVisible(true);
    }

    public ProjectController(ProjectView addProjectView, ProjectRepository projectRepository,
            ProjectListModel projectTableModel, ProjectModel projectModel) {
        this.projectView = addProjectView;
        this.projectModel = projectModel;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepository;
        init();
    }

    private void init() {
        projectView.addClickSubmitListener(new ClickSubmitButtonListener());
        // show();
        // projectView.setVisible(true);
    }

    class ClickSubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            projectView.setProjectModel();
            projectRepository.save(projectModel);
            List<ProjectModel> projects = projectRepository.findAll();
            projectTableModel.setProjects(projects);
            projectModel.reset();
            System.out.println("clickbuttonlistener");
            projectView.dispose();
        }
    }
}
