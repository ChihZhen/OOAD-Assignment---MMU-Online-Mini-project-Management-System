package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.ProjectModel;
import com.example.ooad.model.AddProjectModel;
import com.example.ooad.model.ProjectTableModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AddProjectView;
import com.example.ooad.view.ProjectView;

import java.awt.event.*;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@Controller
public class AddProjectController {
    private AddProjectView addProjectView;
    private ProjectRepository projectRepository;
    private ProjectTableModel projectTableModel;
    private ProjectModel projectModel;

    public void show() {
        addProjectView.setTitle("New Project");
        addProjectView.setVisible(true);
    }

    public void showEditProject(int index) {
        addProjectView.setTitle("Edit Project");
        projectModel.set(projectTableModel.getProjectModel(index));
        addProjectView.setVisible(true);
    }

    public AddProjectController(AddProjectView addProjectView, ProjectRepository projectRepsitory,
            ProjectTableModel projectTableModel, ProjectModel projectModel) {
        this.addProjectView = addProjectView;
        this.projectModel = projectModel;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepsitory;
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
            projectTableModel.setData(projects);
            projectModel.reset();
            System.out.println("clickbuttonlistener");
            addProjectView.dispose();
        }
    }
}
