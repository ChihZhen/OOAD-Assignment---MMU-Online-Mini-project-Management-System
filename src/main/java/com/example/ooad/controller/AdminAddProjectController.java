package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.LecturerListModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AdminAddProjectView;

import java.awt.event.*;
import java.util.List;

@Controller
public class AdminAddProjectController {
    private AdminAddProjectView adminAddProjectView;
    private ProjectRepository projectRepository;
    private ProjectListModel projectTableModel;
    private ProjectModel projectModel;
    private LecturerListModel lecturerListModel;
    private LecturerRepository lecturerRepository;

    public void show() {
        adminAddProjectView.setVisible(true);
    }

    public AdminAddProjectController(AdminAddProjectView adminAddProjectView, ProjectRepository projectRepository,
            ProjectListModel projectTableModel, ProjectModel projectModel, LecturerListModel lecturerListModel,
            LecturerRepository lecturerRepository) {
        this.adminAddProjectView = adminAddProjectView;
        this.projectModel = projectModel;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepository;
        this.lecturerListModel = lecturerListModel;
        this.lecturerRepository = lecturerRepository;
        adminAddProjectView.addClickSubmitListener(new ClickSubmitButtonListener());

        init();
    }

    public void loadData() {
        List<LecturerModel> lecturers = lecturerRepository.findAll();
        lecturerListModel.setLecturers(lecturers);

    }

    private void init() {
        loadData();
        // show();
        // projectView.setVisible(true);
    }

    class ClickSubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // projectModel.reset();
            System.out.println(projectModel.getId());
            System.out.println(projectModel.getStudent());
            adminAddProjectView.setProjectModel();
            projectRepository.save(projectModel);
            List<ProjectModel> projects = projectRepository.findAll();
            projectTableModel.setProjects(projects);
            projectModel.reset();
            System.out.println("clickbuttonlistener");
            // adminAddProjectView.dispose();
        }
    }
}
