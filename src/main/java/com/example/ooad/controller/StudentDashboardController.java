package com.example.ooad.controller;

import java.awt.event.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.*;

import com.example.ooad.model.*;
import com.example.ooad.view.*;

@Controller
public class StudentDashboardController implements IController {
  private StudentDashboardView view;
  private ProjectModel projectModel;

  @Lazy
  @Autowired
  private LoginController loginController;
  private StudentModel studentModel;

  public StudentDashboardController(StudentDashboardView view, ProjectModel projectModel,
      StudentModel studentModel) {
    this.view = view;
    this.projectModel = projectModel;
    this.studentModel = studentModel;

    view.getLogoutButton().addActionListener(new LogoutButtonListener());
  }

  public void show() {
    projectModel.loadStudentData();
    view.setVisible(true);
  }

  public void hide() {
    view.setVisible(false);
  }

  private class LogoutButtonListener implements ActionListener {

    @Override
    // Show the login screen
    // hide the current screen
    // set the current authenticated user to null
    public void actionPerformed(ActionEvent e) {
      loginController.show();
      hide();
      studentModel.setAuthUser(null);

    }
  }

}
