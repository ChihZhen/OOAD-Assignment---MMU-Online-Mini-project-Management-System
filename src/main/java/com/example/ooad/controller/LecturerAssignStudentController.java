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
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.repository.StudentRepository;
import com.example.ooad.view.AssignStudentView;
import com.example.ooad.view.ProjectView;

import java.awt.event.*;

@Controller
public class LecturerAssignStudentController {
    // private StudentRepository studentRepository;
    private AssignStudentView assignStudentView;
    private StudentModel studentModel;
    private LecturerDashboardController projectListController;
    // private Project project;
    private ProjectModel projectModel;

    // private ProjectRepository projectRepository;

    public LecturerAssignStudentController(AssignStudentView assignStudentView,
            StudentModel studentModel, @Lazy LecturerDashboardController projectListController) {
        this.assignStudentView = assignStudentView;
        this.studentModel = studentModel;
        // this.studentRepository = studentRepository;
        this.projectListController = projectListController;
        // this.projectRepository = projectRepository;
        // init();

        assignStudentView.addClickSelectButtonListener(new ClickSelectButtonListener());

    }

    // public void init() {
    // assignStudentView.addClickSelectButtonListener(new
    // ClickSelectButtonListener());
    // }

    public void show(Project project) {
        // this.project = project;
        projectModel.load();
        // loadData(project.getSpecialization());
        assignStudentView.setVisible(true);
    }

    public void hide() {
        assignStudentView.setVisible(false);
    }

    // public void loadData(String specialization) {
    // List<Student> students =
    // studentRepository.findStudentBySpecializationAndProject(specialization,
    // null);
    // studentListModel.setStudents(students);
    // // assignStudentView.addClickSelectButtonListener(new
    // // ClickSelectButtonListener());
    // }

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
                Student student = studentModel.get(row);
                projectModel.getCurrent().setStudent(student);
                projectModel.save();
                // project.setStudent(student);
                // projectRepository.save(project);
                // projectListController.loadData();
                assignStudentView.dispose();
            }
        }
    }
}
