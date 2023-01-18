package com.example.ooad.controller;

import java.awt.event.*;

import org.springframework.stereotype.*;

import com.example.ooad.model.*;
import com.example.ooad.view.*;

@Controller
public class StudentDashboardController implements IController {
  private StudentDashboardView view;
  private ProjectModel projectModel;

  public StudentDashboardController(StudentDashboardView view, ProjectModel projectModel) {
    this.view = view;
    this.projectModel = projectModel;

    view.addClickRowListener(new ClickRowListener());
  }

  public void show() {
    projectModel.loadStudentData();
    view.setVisible(true);
  }

  public void hide() {
    view.setVisible(false);
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
