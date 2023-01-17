package com.example.ooad.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Project;
import com.example.ooad.entity.User;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.LecturerDashboardView;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.event.*;

@Controller
public class LecturerDashboardController {
    private LecturerDashboardView view;
    private ProjectModel projectModel;

    // @Autowired
    // private ProjectRepository projectRepository;

    // @Autowired
    // private LecturerRepository lecturerRepository;
    // private OoadApplication ooadApplication;
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

        // this.projectController = projectController;
        // this.assignStudentController = assignStudentController;
        // this.ooadApplication = ooadApplication;

        view.addClickRowListener(new ClickRowListener());
        view.addClickTableButtonListener(new ClickTableButtonListener());
        view.addClickButtonListener(new ClickAddProjectButtonListener());
        view.addClickLogoutButtonListener(new ClickLogoutButtonListener());
        // init();
        // projectListView.setVisible(true);
    }

    // public void loadData() {
    // // List<ProjectModel> projects = projectRepository.findAll();
    // User user = OoadApplication.getLoginUser();
    // // List<Project> projects = lecturerRepository
    // // .findOneById(user.getId()).getProjects();
    // // projectTableModel.setProjects(projects);

    // // projectView.addClickButtonListener(new ClickAddProjectButtonListener());
    // }

    // public void init() {
    // System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    // loadData();
    // projectListView.addClickRowListener(new ClickRowListener());
    // projectListView.addClickTableButtonListener(new ClickTableButtonListener());
    // projectListView.addClickButtonListener(new ClickAddProjectButtonListener());
    // // loadData();

    // // loadData();
    // // projectListView.setVisible(true);
    // // projectView.setVisible(true);
    // }

    public void show() {
        // User user = OoadApplication.getLoginUser();
        projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
        // System.out.println(projectModel.getList());
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

    private class ClickTableButtonListener implements TableButtonPressedHandler {
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
                    projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
                }
            }

        }
    }

    private class ClickAddProjectButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            addProjectController.show();
            // projectView.setEnabled(false);
        }
    }

    private class ClickLogoutButtonListener implements ActionListener {

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
