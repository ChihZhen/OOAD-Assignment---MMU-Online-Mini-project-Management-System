package com.example.ooad.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.example.ooad.entity.Project;
import com.example.ooad.entity.Student;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.view.LecturerAssignStudentView;
import com.example.ooad.view.LecturerAddProjectView;

import java.awt.event.*;

@Controller
public class LecturerAssignStudentController {
    // private StudentRepository studentRepository;
    private LecturerAssignStudentView view;
    private StudentModel studentModel;
    // private LecturerDashboardController projectListController;
    // private Project project;
    private ProjectModel projectModel;

    // private ProjectRepository projectRepository;

    public LecturerAssignStudentController(LecturerAssignStudentView view, ProjectModel projectModel,
            StudentModel studentModel) {
        this.view = view;
        this.projectModel = projectModel;
        this.studentModel = studentModel;
        // this.studentRepository = studentRepository;
        // this.projectListController = projectListController;
        // this.projectRepository = projectRepository;
        // init();

        view.getSelectButton().addActionListener(new SelectButtonListener());
        // assignStudentView.addClickSelectButtonListener(new
        // ClickSelectButtonListener());

    }

    // public void init() {
    // assignStudentView.addClickSelectButtonListener(new
    // ClickSelectButtonListener());
    // }

    public void show() {
        Project project = projectModel.getCurrent();
        studentModel.loadBySpecialization(project.getSpecialization());
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }


    class SelectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // int row = view.getSelectedRow();
            int row = view.getStudentTable().getSelectedRow();

            if (row == -1) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please select a student",
                        "No Selection", 2, null);
            } else {
                Student student = studentModel.get(row);
                projectModel.getCurrent().setStudent(student);
                projectModel.save();
                projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
                // project.setStudent(student);
                // projectRepository.save(project);
                // projectListController.loadData();
                view.dispose();
            }
        }
    }
}
