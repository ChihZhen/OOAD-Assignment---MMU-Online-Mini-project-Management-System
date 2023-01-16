package com.example.ooad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.UserModel;
import com.example.ooad.OoadApplication;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.LecturerRepository;
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

    @Autowired
    private LecturerRepository lecturerRepository;

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
            LecturerModel lecturer = (LecturerModel) OoadApplication.getLoginUser();
            projectModel.setLecturer(lecturer);
            projectRepository.save(projectModel);

            if (OoadApplication.getLoginUser().getRole().equals("Lecturer")) {
                UserModel user = OoadApplication.getLoginUser();
                List<ProjectModel> projects = lecturerRepository
                        .findOneById(user.getId()).getProjects();
                projectTableModel.setProjects(projects);
            } else {
                List<ProjectModel> projects = projectRepository.findAll();
                projectTableModel.setProjects(projects);
            }
            projectModel.reset();
            projectView.dispose();
        }
    }
}
