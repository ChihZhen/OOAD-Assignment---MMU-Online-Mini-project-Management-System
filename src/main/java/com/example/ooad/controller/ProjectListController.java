package com.example.ooad.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.expression.spel.ast.Assign;
import org.springframework.stereotype.Controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectListView;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.event.*;

@Controller
public class ProjectListController {
    private ProjectListView projectView;
    private ProjectListModel projectTableModel;
    private ProjectRepository projectRepository;
    private ProjectController projectController;
    private AssignStudentController assignStudentController;
    // private ProjectDetailController projectDetailController;

    // public ProjectController() {
    // }

    public ProjectListController(ProjectListView projectView, ProjectListModel projectTableModel,
            ProjectRepository projectRepository, ProjectController projectController,
            AssignStudentController assignStudentController) {
        this.projectView = projectView;
        this.projectTableModel = projectTableModel;
        this.projectRepository = projectRepository;
        this.projectController = projectController;
        this.assignStudentController = assignStudentController;
        // this.projectDetailController = projectDetailController;

        init();
        projectView.setVisible(true);

    }

    public void loadData() {
        List<ProjectModel> projects = projectRepository.findAll();
        projectTableModel.setProjects(projects);
    }

    public void init() {
        projectView.addClickRowListener(new ClickRowListener());
        projectView.addClickTableButtonListener(new ClickTableButtonListener());
        projectView.addClickButtonListener(new ClickAddProjectButtonListener());

        loadData();
        projectView.setVisible(true);
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
                String specialization = projectTableModel.getProject(row).getSpecialization();
                assignStudentController.show(specialization);

            } else if (column == 5) {
                projectController.showEditProject(row);
            } else if (column == 6) {

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
