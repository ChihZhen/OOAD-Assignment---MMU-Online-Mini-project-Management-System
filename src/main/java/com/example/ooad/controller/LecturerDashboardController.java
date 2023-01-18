package com.example.ooad.controller;

import javax.swing.*;

import java.awt.event.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import com.example.ooad.model.*;
import com.example.ooad.view.*;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

@Controller
public class LecturerDashboardController implements IController {
    private LecturerDashboardView view;
    private ProjectModel projectModel;

    @Autowired
    private LecturerAddProjectController addProjectController;

    @Autowired
    private LecturerEditProjectController editProjectController;

    @Autowired
    private LecturerAssignStudentController assignStudentController;

    @Autowired
    @Lazy
    private LoginController loginController;

    public LecturerDashboardController(LecturerDashboardView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;

        view.addClickRowListener(new TableRowListener());
        view.addClickTableButtonListener(new TableButtonListener());
        view.addClickButtonListener(new AddProjectButtonListener());
        view.addClickLogoutButtonListener(new LogoutButtonListener());
        // init();
        // projectListView.setVisible(true);
    }

    public void show() {
        // User user = OoadApplication.getLoginUser();
        // projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
        projectModel.loadLecturerData();

        // System.out.println(projectModel.getList());
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    private class TableRowListener implements MouseListener {

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

    private class TableButtonListener implements TableButtonPressedHandler {
        @Override
        public void onButtonPress(int row, int column) {
            // TODO Auto-generated method stub
            // System.out.println(row + " " + column);
            projectModel.setCurrent(row);
            if (column == 4) {
                // String specialization =
                // projectTableModel.getProject(row).getSpecialization();
                assignStudentController.show();

            } else if (column == 5) {
                // System.out.print(projectModel.getCurrent().getTitle());
                editProjectController.show();
            } else if (column == 6) {
                JFrame jf = new JFrame();
                int result = JOptionPane.showConfirmDialog(jf, "Are you want to delete project?", "Delete Project",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    projectModel.delete(projectModel.getCurrent());
                    // projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
                    projectModel.loadLecturerData();

                }
            }

        }
    }

    private class AddProjectButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            addProjectController.show();
            // projectView.setEnabled(false);
        }
    }

    private class LogoutButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            loginController.show();
            hide();
            projectModel.setAuthUser(null);
            // OoadApplication.setLoginUser(null);

        }
    }

    // private class ClickAssignButtonListener implements TableButtonPressedHandler
    // {

    // @Override
    // public void onButtonPress(int row, int column) {
    // // TODO Auto-generated method stub
    // System.out.println(row + " " + column);
    // }
    // }
}

// class AddProjectListener implements
