package com.example.ooad.controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectListView;
import com.example.ooad.view.ProjectView;
import com.example.ooad.view.StudentProjectListView;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.model.User;

import java.awt.event.*;
import java.util.List;
import org.springframework.stereotype.Controller;

@Controller
public class StudentProjectListController {
  private StudentProjectListView studentProjectListView;
  private ProjectListModel projectTableModel;
  private ProjectRepository projectRepository;

  public StudentProjectListController(StudentProjectListView studentProjectListView, ProjectListModel projectTableModel,
      ProjectRepository projectRepository) {
    this.studentProjectListView = studentProjectListView;
    this.projectTableModel = projectTableModel;
    this.projectRepository = projectRepository;

    init();
    studentProjectListView.setVisible(true);

  }

  public void loadData() {
    List<ProjectModel> project = projectRepository.findBySpecializationAndStatus("Software Engineer",
        "Active");
    projectTableModel.setProjects(project);
  }

  public void init() {
    studentProjectListView.addClickRowListener(new ClickRowListener());

    loadData();
    studentProjectListView.setVisible(true);
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
