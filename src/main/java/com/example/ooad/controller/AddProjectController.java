package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.entity.Project;
import com.example.ooad.model.AddProjectModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AddProjectView;

import java.awt.event.*;

@Controller
public class AddProjectController {
    private AddProjectView addProjectView;
    // private AddProjectModel addProjectModel;
    private ProjectRepository projectRepository;

    public AddProjectController(AddProjectView addProjectView,
            ProjectRepository projectRepsitory) {
        this.addProjectView = addProjectView;
        // this.addProjectModel = addProjectModel;
        this.projectRepository = projectRepsitory;

        init();
    }

    private void init() {
        addProjectView.addClickSubmitListener(new ClickSubmitButtonListener());
        addProjectView.setVisible(true);
    }

    class ClickSubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            AddProjectModel addProjectModel = addProjectView.getAddProjectModel();
            Project p = new Project(addProjectModel.getTitle(),
                    addProjectModel.getDescription(),
                    addProjectModel.getStatus(), addProjectModel.getSpecialization());
            projectRepository.save(p);
            System.out.println("clickbuttonlistener");
        }
    }
}
