package com.example.ooad.controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AdminProjectDetailView;
import java.awt.event.*;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class AdminProjectDetailController {
  private AdminProjectDetailView adminProjectDetailView;
  private ProjectModel projectModel;
  private ProjectRepository projectRepository;

  public AdminProjectDetailController(AdminProjectDetailView adminProjectDetailView, ProjectModel projectModel,
      ProjectRepository projectRepository) {
    this.adminProjectDetailView = adminProjectDetailView;
    this.projectModel = projectModel;
    this.projectRepository = projectRepository;
  }

  public void init() {

    // loadData();az
    // studentProjectListView.setVisible(true);
  }

  public void loadData(long id) {
    ProjectModel newProject = projectRepository.findById(id).orElse(null);
    projectModel.set(newProject);
  }

  public void show(ProjectModel project) {
    loadData(project.getId());
    adminProjectDetailView.setVisible(true);
  }

}
