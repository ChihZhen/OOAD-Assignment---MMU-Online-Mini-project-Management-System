package com.example.ooad.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.OoadApplication;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectListView;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.event.*;

@Controller
public class ProjectListController {
    private ProjectListView projectListView;
    private ProjectListModel projectTableModel;
    private ProjectRepository projectRepository;
    private ProjectController projectController;
    private AssignStudentController assignStudentController;

    public ProjectListController(ProjectListView projectListView, ProjectListModel projectTableModel,
            ProjectRepository projectRepository, ProjectController projectController,
            AssignStudentController assignStudentController) {
        this.projectListView = projectListView;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepository;
        this.projectController = projectController;
        this.assignStudentController = assignStudentController;

        init();
        projectListView.setVisible(true);

    }

    public void loadData() {
        List<ProjectModel> projects = projectRepository.findAll();
        projectTableModel.setProjects(projects);
        // projectView.addClickButtonListener(new ClickAddProjectButtonListener());
    }

    public void init() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        loadData();
        projectListView.addClickRowListener(new ClickRowListener());
        projectListView.addClickTableButtonListener(new ClickTableButtonListener());
        projectListView.addClickButtonListener(new ClickAddProjectButtonListener());

        // loadData();
        projectListView.setVisible(true);
        // projectView.setVisible(true);
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
            System.out.println(row + " " + column);

            if (column == 4) {
                // String specialization =
                // projectTableModel.getProject(row).getSpecialization();
                assignStudentController.show(projectTableModel.getProject(row));

            } else if (column == 5) {
                projectController.showEditProject(row);
            } else if (column == 6) {
                JFrame jf = new JFrame();
                int result = JOptionPane.showConfirmDialog(jf, "Are you want to delete proejct?", "Delete Project",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    projectRepository.delete(projectTableModel.getProject(row));
                    loadData();
                }
            }

        }
    }

    private class ClickAddProjectButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            projectController.showAddProject();
            // projectView.setEnabled(false);
        }
    }

    private class ClickLogoutButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            OoadApplication.setLoginUser(null);

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
