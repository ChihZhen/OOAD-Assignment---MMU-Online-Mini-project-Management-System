package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.ProjectModel;
import com.example.ooad.model.AddProjectModel;
import com.example.ooad.model.ProjectTableModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AddProjectView;
import com.example.ooad.view.ProjectView;

import java.awt.event.*;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

@Controller
public class AddProjectController {
    private AddProjectView addProjectView;
    // private AddProjectModel addProjectModel;
    private ProjectRepository projectRepository;
    private ProjectTableModel projectTableModel;

    public void show() {
        addProjectView.setVisible(true);
    }

    public AddProjectController(AddProjectView addProjectView,
            ProjectRepository projectRepsitory, ProjectTableModel projectTableModel) {
        this.addProjectView = addProjectView;

        this.projectTableModel = projectTableModel;
        // this.addProjectModel = addProjectModel;
        this.projectRepository = projectRepsitory;

        init();
    }

    private void init() {
        addProjectView.addClickSubmitListener(new ClickSubmitButtonListener());
        // show();
        // addProjectView.setVisible(true);
    }

    class ClickSubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            AddProjectModel addProjectModel = addProjectView.getAddProjectModel();

            if (addProjectModel.isValid()) {
                ProjectModel p = new ProjectModel(addProjectModel.getTitle(),
                        addProjectModel.getDescription(),
                        addProjectModel.getStatus(), addProjectModel.getSpecialization());
                projectRepository.save(p);
                List<ProjectModel> projects = projectRepository.findAll();
                projectTableModel.setData(projects);
                addProjectModel.reset();
                // addProjectView.setVisible(false);
                // addProjectView.repaint();
                // addProjectView.revalidate();
            } else {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf, "Please fill in all the field", "Invalid Field", 2, null);
            }
            System.out.println("clickbuttonlistener");
        }
    }
}
