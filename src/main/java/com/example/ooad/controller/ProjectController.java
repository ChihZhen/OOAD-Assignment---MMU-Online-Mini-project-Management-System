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
    private ProjectView addProjectView;
    private ProjectRepository projectRepository;
    private ProjectListModel projectTableModel;
    private ProjectModel projectModel;

    public void showAddProject() {
        addProjectView.setTitle("New Project");
        addProjectView.setVisible(true);
    }

    public void showEditProject(int index) {
        addProjectView.setTitle("Edit Project");
        projectModel.set(projectTableModel.getProject(index));
        addProjectView.setVisible(true);
    }

    public ProjectController(ProjectView addProjectView, ProjectRepository projectRepository,
            ProjectListModel projectTableModel, ProjectModel projectModel) {
        this.addProjectView = addProjectView;
        this.projectModel = projectModel;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepository;
        init();
    }

    private void init() {
        addProjectView.addClickSubmitListener(new ClickSubmitButtonListener());
        // show();
        // addProjectView.setVisible(true);
    }

    class ClickSubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            addProjectView.setProjectModel();
            projectRepository.save(projectModel);
            List<ProjectModel> projects = projectRepository.findAll();
            projectTableModel.setProjects(projects);
            projectModel.reset();
            System.out.println("clickbuttonlistener");
            addProjectView.dispose();
        }
    }
}
