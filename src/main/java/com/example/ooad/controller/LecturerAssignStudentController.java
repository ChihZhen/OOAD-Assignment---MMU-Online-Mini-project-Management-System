package com.example.ooad.controller;

import javax.swing.*;

import java.awt.event.*;

import org.springframework.stereotype.*;

import com.example.ooad.entity.*;
import com.example.ooad.model.*;
import com.example.ooad.view.*;

@Controller
public class LecturerAssignStudentController implements IController {
    private LecturerAssignStudentView view;
    private ProjectModel projectModel;
    private StudentModel studentModel;

    // private ProjectRepository projectRepository;

    public LecturerAssignStudentController(LecturerAssignStudentView view, ProjectModel projectModel,
            StudentModel studentModel) {
        this.view = view;
        this.projectModel = projectModel;
        this.studentModel = studentModel;

        view.getSelectButton().addActionListener(new SelectButtonListener());
    }


    public void show() {
        view.setVisible(true);
        Project project = projectModel.getCurrent();
        studentModel.loadBySpecialization(project.getSpecialization());
    }

    public void hide() {
        view.setVisible(false);
    }

    class SelectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
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
                // projectModel.loadByLecturerId(projectModel.getAuthUser().getId());
                projectModel.loadLecturerData();

                view.dispose();
            }
        }
    }
}
