package com.example.ooad.controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AdminProjectDetailView;
import java.awt.event.*;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class AdminProjectDetailController {
  private AdminProjectDetailView view;
  private ProjectModel projectModel;

  public AdminProjectDetailController(AdminProjectDetailView view, ProjectModel projectModel) {
    this.view = view;
    this.projectModel = projectModel;
  }

  // public void init() {

  // loadData();az
  // studentProjectListView.setVisible(true);
  // }

  // public void loadData(long id) {
  // ProjectModel newProject = projectRepository.findById(id).orElse(null);
  // projectModel.set(newProject);
  // }

  // public void show(ProjectModel project) {
  // loadData(project.getId());
  // adminProjectDetailView.setVisible(true);
  // }

  public void resetView() {
    view.getContentPane().removeAll();
    view.getContentPane().revalidate();
    view.getContentPane().repaint();
    view.comp();
  }

  public void show() {
    // loadData(project.getId());
    view.setVisible(true);
  }

  public void hide() {
    view.setVisible(false);
  }

}
