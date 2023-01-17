package com.example.ooad.controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Project;
import com.example.ooad.entity.Student;
import com.example.ooad.entity.User;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.LecturerDashboardView;
import com.example.ooad.view.LecturerAddProjectView;
import com.example.ooad.view.StudentProjectListView;

import java.awt.event.*;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

@Controller
public class StudentProjectListController {
  private StudentProjectListView studentProjectListView;
  private ProjectModel projectModel;
  // private Project projectModel;
  // private ProjectRepository projectRepository;
  // private OoadApplication ooadApplication;
  private Student student;

  public StudentProjectListController(StudentProjectListView studentProjectListView, ProjectModel projectTableModel,
      Project projectModel,
      ProjectRepository projectRepository, @Lazy OoadApplication ooadApplication, Student student) {
    this.studentProjectListView = studentProjectListView;
    // this.projectTableModel = projectTableModel;
    // this.projectModel = projectModel;
    // this.projectRepository = projectRepository;
    // this.ooadApplication = ooadApplication;
    this.student = student;

    // init();
    // studentProjectListView.setVisible(true);
    studentProjectListView.addClickRowListener(new ClickRowListener());
  }

  public void loadData() {
    this.student = (Student) OoadApplication.getLoginUser();
    // List<Project> projects =
    // projectRepository.findBySpecializationAndStatus(student.getSpecialization(),
    // "Active");
    // if (student != null) {
    // System.out.println("special-------------------------->" +
    // student.getId());
    // }

    // Project project = projectRepository.findByStudentId(student.getId());

    // projectTableModel.setProjects(projects);
    // projectModel.set(project);
  }

  // public void init() {
  // studentProjectListView.addClickRowListener(new ClickRowListener());
  // ;
  // // loadData();az
  // // studentProjectListView.setVisible(true);
  // }

  public void show() {
    this.student = (Student) OoadApplication.getLoginUser();
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
