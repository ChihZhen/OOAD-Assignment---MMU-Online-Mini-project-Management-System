package com.example.ooad.controller;

import javax.swing.*;

import java.awt.event.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

// ============= MODEL
import com.example.ooad.model.*;
// ============= VIEW
import com.example.ooad.view.*;
// ============= COMPONENT
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

@Controller
public class LecturerDashboardController implements IController {
    // ========================= Variables
    private LecturerDashboardView view;
    private ProjectModel projectModel;

    @Autowired
    private LecturerAddProjectController addProjectController;

    @Autowired
    private LecturerEditProjectController editProjectController;

    @Autowired
    private LecturerAssignStudentController assignStudentController;

    @Autowired
    @Lazy
    private LoginController loginController;

    // ========================= Constructor
    public LecturerDashboardController(LecturerDashboardView view, ProjectModel projectModel) {
        this.view = view;
        this.projectModel = projectModel;
        // Initialize the event listener for the lecturer dashboard
        view.addClickRowListener(new TableRowListener());
        view.addClickTableButtonListener(new TableButtonListener());
        view.addClickButtonListener(new AddProjectButtonListener());
        view.addClickLogoutButtonListener(new LogoutButtonListener());

    }

    // This will return all the projects by the lecturer
    // and the the view to be visible
    public void show() {

        projectModel.loadLecturerData();

        view.setVisible(true);
    }

    // This will set the view to non-visible
    public void hide() {
        view.setVisible(false);
    }

    private class TableRowListener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        public void mouseEntered(MouseEvent e) {

        }

        public void mouseExited(MouseEvent e) {

        }

        public void mousePressed(MouseEvent e) {

        }

        public void mouseReleased(MouseEvent e) {

        }
    }

    // This will trigger when the button on the table is clicked
    private class TableButtonListener implements TableButtonPressedHandler {
        @Override
        public void onButtonPress(int row, int column) {

            // Set the current selected project
            projectModel.setCurrent(row);
            if (column == 4) {
                // Show the assign student window if the assign
                // button is clicked
                assignStudentController.show();

            } else if (column == 5) {

                // Show the edit project window if the edit
                // button is clicked
                editProjectController.show();
            } else if (column == 6) {
                // Prompt a confirm dialog for delete when the
                // delete button is clicked
                // and delete it from database if user proceed to click on confirm
                JFrame jf = new JFrame();
                int result = JOptionPane.showConfirmDialog(jf, "Are you want to delete project?", "Delete Project",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    projectModel.delete(projectModel.getCurrent());

                    projectModel.loadLecturerData();

                }
            }

        }
    }

    // This will trigger when the add project button is clicked
    private class AddProjectButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // Call the show() function from add project controller
            addProjectController.show();

        }
    }

    // This will trigger when the logout button is clicked
    private class LogoutButtonListener implements ActionListener {

        @Override
        // Show the login screen
        // hide the current screen
        // set the current authenticated user to null
        public void actionPerformed(ActionEvent e) {
            loginController.show();
            hide();
            projectModel.setAuthUser(null);

        }
    }

}
