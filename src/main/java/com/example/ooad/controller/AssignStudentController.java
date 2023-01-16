package com.example.ooad.controller;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import com.example.ooad.model.ProjectListModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentListModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.repository.StudentRepository;
import com.example.ooad.view.AssignStudentView;
import com.example.ooad.view.ProjectView;

import java.awt.event.*;

@Controller
public class AssignStudentController {
    private StudentRepository studentRepository;
    private AssignStudentView assignStudentView;
    private StudentListModel studentListModel;
    private ProjectListController projectListController;
    private ProjectModel project;

    private ProjectRepository projectRepository;

    public AssignStudentController(StudentRepository studentRepository, AssignStudentView assignStudentView,
            StudentListModel studentListModel, ProjectRepository projectRepository,
            @Lazy ProjectListController projectListController) {
        this.assignStudentView = assignStudentView;
        this.studentListModel = studentListModel;
        this.studentRepository = studentRepository;
        this.projectListController = projectListController;
        this.projectRepository = projectRepository;
        // init();

        assignStudentView.addClickSelectButtonListener(new ClickSelectButtonListener());

    }

    // public void init() {
    // assignStudentView.addClickSelectButtonListener(new
    // ClickSelectButtonListener());
    // }

    public void show(ProjectModel project) {
        this.project = project;
        loadData(project.getSpecialization());
        assignStudentView.setVisible(true);
    }

    public void hide() {
        assignStudentView.setVisible(false);
    }

    public void loadData(String specialization) {
        List<StudentModel> students = studentRepository.findStudentBySpecializationAndProject(specialization, null);
        studentListModel.setStudents(students);
        // assignStudentView.addClickSelectButtonListener(new
        // ClickSelectButtonListener());
    }

    class ClickSelectButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // createUserView.setProjectModel();
            // studentListModel.
            int row = assignStudentView.getSelectedRow();

            if (row == -1) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please select a student",
                        "No Selection", 2, null);
            } else {
                StudentModel student = studentListModel.getStudent(row);
                project.setStudent(student);
                projectRepository.save(project);
                projectListController.loadData();
                assignStudentView.dispose();
            }
        }
    }
}
