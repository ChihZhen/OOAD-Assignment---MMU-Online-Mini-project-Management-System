package com.example.ooad.controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectListView;
import com.example.ooad.view.ProjectView;
import com.example.ooad.view.StudentProjectListView;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.model.UserModel;

import java.awt.event.*;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class StudentProjectListController {
  private StudentProjectListView studentProjectListView;
  private ProjectListModel projectTableModel;
  private ProjectModel projectModel;
  private ProjectRepository projectRepository;
  private OoadApplication ooadApplication;
  private StudentModel student;

  public StudentProjectListController(StudentProjectListView studentProjectListView, ProjectListModel projectTableModel,
      ProjectModel projectModel,
      ProjectRepository projectRepository, @Lazy OoadApplication ooadApplication, StudentModel student) {
    this.studentProjectListView = studentProjectListView;
    this.projectTableModel = projectTableModel;
    this.projectModel = projectModel;
    this.projectRepository = projectRepository;
    this.ooadApplication = ooadApplication;
    this.student = student;

    // init();
    // studentProjectListView.setVisible(true);
    studentProjectListView.addClickRowListener(new ClickRowListener());
  }

  public void loadData() {
    this.student = (StudentModel) OoadApplication.getLoginUser();
    List<ProjectModel> projects = projectRepository.findBySpecializationAndStatus(student.getSpecialization(),
        "Active");
    if (student != null) {
      System.out.println("special-------------------------->" +
          student.getId());
    }

    ProjectModel project = projectRepository.findByStudentId(student.getId());

    projectTableModel.setProjects(projects);
    projectModel.set(project);
  }

  // public void init() {
  // studentProjectListView.addClickRowListener(new ClickRowListener());
  // ;
  // // loadData();az
  // // studentProjectListView.setVisible(true);
  // }

  public void show() {
    this.student = (StudentModel) OoadApplication.getLoginUser();
    loadData();
    studentProjectListView.setVisible(true);
  }

  public void hide() {
    studentProjectListView.setVisible(false);
  }

  private class ClickRowListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
      // TableModel tableModel = projectView.getTableModel();
      // TableModel tableModel = projectView.getTableModel();
      // System.out.println(projectTableModel.getRowCount());
      System.out.println("hi table");
      // projectTableModel.setValueAt("hi", 0, 0);

      // l.setText("Mouse Clicked");
    }

    public void mouseEntered(MouseEvent e) {
      // l.setText("Mouse Entered");
    }

    public void mouseExited(MouseEvent e) {
      // l.setText("Mouse Exited");
    }

    public void mousePressed(MouseEvent e) {
      // l.setText("Mouse Pressed");
    }

    public void mouseReleased(MouseEvent e) {
      // l.setText("Mouse Released");
    }
  }

}
