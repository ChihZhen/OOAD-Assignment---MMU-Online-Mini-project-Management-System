package com.example.ooad.controller;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.Project;
import com.example.ooad.model.ProjectTableModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.ProjectView;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.event.*;

@Controller
public class ProjectController {
    private ProjectView projectView;
    private DefaultTableModel projectTableModel;
    private ProjectRepository projectRepository;

    public ProjectController() {
    }

    public ProjectController(ProjectView projectView, ProjectTableModel projectTableModel,
            ProjectRepository projectRepository) {
        this.projectView = projectView;
        this.projectTableModel = projectTableModel.getTableModel();
        this.projectRepository = projectRepository;

        init();
    }

    public void init() {
        projectView.addClickRowListener(new ClickRowListener());

        projectView.addClickTableButtonListener(new ClickTableButtonListener());

        List<Project> projects = projectRepository.findAll();
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (Project project : projects) {
            data.add(project.toVector());
        }
        // String[][] d = {
        // projectsData
        // }
        Vector<String> header = new Vector<String>() {
            {
                add("id");
                add("title");
                add("specialization");
                add("");
                add("");
                add("");
            }
        };

        Vector<Vector<String>> v = new Vector<Vector<String>>();
        v.add(new Vector<String>() {
            {
                add("1");
                add("Os");
                add("Data Science");
                add("Assign");
                add("Delete");
                add("Edit");

            }
        });
        projectTableModel.setDataVector(v,
                header);

        projectView.refresh();
    }

    // public addButton() {
    // if (projectTableModel)
    class ClickRowListener implements MouseListener {

        @Override

        public void mouseClicked(MouseEvent e) {
            // TableModel tableModel = projectView.getTableModel();
            // TableModel tableModel = projectView.getTableModel();
            System.out.println(projectTableModel.getRowCount());
            System.out.println("hi table");
            projectTableModel.setValueAt("hi", 0, 0);

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

    class ClickTableButtonListener implements TableButtonPressedHandler {

        @Override
        public void onButtonPress(int row, int column) {
            // TODO Auto-generated method stub
            System.out.println(row + " " + column);

        }
    }

    // class ClickEditButtonListener implements TableButtonPressedHandler {

    // @Override
    // public void onButtonPress(int row, int column) {
    // // TODO Auto-generated method stub
    // System.out.println(row + " " + column);

    // }
    // }

    // class ClickAssignButtonListener implements TableButtonPressedHandler {

    // @Override
    // public void onButtonPress(int row, int column) {
    // // TODO Auto-generated method stub
    // System.out.println(row + " " + column);
    // }
    // }
}

// class AddProjectListener implements
