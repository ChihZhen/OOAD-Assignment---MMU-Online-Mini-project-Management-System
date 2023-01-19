package com.example.ooad.controller;

import javax.swing.*;
import java.awt.event.*;
import org.springframework.stereotype.*;

// ============= ENTITY
import com.example.ooad.entity.*;
// ============= MODEL
import com.example.ooad.model.*;
// ============= VIEW
import com.example.ooad.view.*;

@Controller
public class LecturerAssignStudentController implements IController {
    // ========================= Variables
    private LecturerAssignStudentView view;
    private ProjectModel projectModel;
    private StudentModel studentModel;

    // ========================= Constructor
    public LecturerAssignStudentController(LecturerAssignStudentView view, ProjectModel projectModel,
            StudentModel studentModel) {
        this.view = view;
        this.projectModel = projectModel;
        this.studentModel = studentModel;
        // Initialize the event listener for the assign button
        view.getSelectButton().addActionListener(new SelectButtonListener());
    }

    // It will get the current project
    // It will load only the student that has not be assigned to a project yet
    // after that, set the view to be visible
    public void show() {
        Project project = projectModel.getCurrent();
        studentModel.loadBySpecializationAndProjectIsNull(project.getSpecialization());
        view.setVisible(true);
    }

    // Hide the view
    public void hide() {
        view.setVisible(false);
    }

    // This will trigger when user clicked on the select button
    class SelectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get the selected row
            int row = view.getStudentTable().getSelectedRow();
            // It will prompt a jframe if a student is not selected
            if (row == -1) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please select a student",
                        "No Selection", 2, null);
            } else {
                // otherwise get the student from the list by using the row number
                Student student = studentModel.get(row);
                // set the current project with the associated student
                projectModel.getCurrent().setStudent(student);
                // Save the update to database
                projectModel.save();
                // Get all projects again
                projectModel.loadLecturerData();

                // Clean up the view
                view.dispose();
            }
        }
    }
}
