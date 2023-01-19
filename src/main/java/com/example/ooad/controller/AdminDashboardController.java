package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// ============= MODEL
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
// ============= VIEW
import com.example.ooad.view.AdminDashboardView;
// ============= COMPONENT
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

@Controller
public class AdminDashboardController {

    // ========================= Variables
    private AdminDashboardView view;
    private ProjectModel projectModel;
    private LecturerModel lecturerModel;
    private LoginController loginController;
    private CommentController commentController;
    private AdminAddProjectController addProjectController;
    private AdminCreateUserController createUserController;
    private AdminProjectDetailController adminProjectDetailController;

    // ========================= Constructor
    public AdminDashboardController(AdminDashboardView view, ProjectModel projectModel, LecturerModel lecturerModel,
            AdminAddProjectController addProjectController, AdminCreateUserController createUserController,
            LoginController loginController, CommentController commentController,
            AdminProjectDetailController adminProjectDetailController) {
        this.view = view;
        this.projectModel = projectModel;
        this.lecturerModel = lecturerModel;
        this.addProjectController = addProjectController;
        this.createUserController = createUserController;
        this.commentController = commentController;
        this.loginController = loginController;
        this.adminProjectDetailController = adminProjectDetailController;

        // Initialize event listener to all the buttons inside the dashbaord view
        view.getProjectTable().addMouseListener(new TableListener());
        view.getCommentButtons().addHandler(new TableButtonListener());
        view.getDeleteButtons().addHandler(new TableButtonListener());
        view.getAddProjectButton().addActionListener(new AddProjectButtonListener());
        view.getCreateUserButton().addActionListener(new CreateUserButtonListener());
        view.getLogoutButton().addActionListener(new LogoutButtonListener());
        view.getMainTp().addChangeListener(new MainTpListener());
        view.getReportTp().addChangeListener(new ReportTpListener());
        view.getAllProjectTab().getGenerateButton().addActionListener(new AllProjectGenerateButton());
        view.getSpecializationTab().getGenerateButton().addActionListener(new SpecializationGenerateButton());
        view.getLecturerTab().getGenerateButton().addActionListener(new LecturerGenerateButton());
        view.getStatusTab().getGenerateButton().addActionListener(new StatusGenerateButton());
        view.getAssignTab().getGenerateButton().addActionListener(new AssignGenerateButton());
        view.getCommentTab().getGenerateButton().addActionListener(new CommentGenerateButton());

    }

    // It will get a list of projects and unhide the admin dashbord view
    public void show() {
        // Call the .findAll method and returns a list of projects
        projectModel.load();
        view.setVisible(true);
    }

    // Hide the admin dashboard project view
    public void hide() {
        view.setVisible(false);
    }

    // This will trigger when the generate all project report button is clicked
    private class AllProjectGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            projectModel.load();
        }
    }

    // This will trigger when the generate by specialization report button is
    // clicked
    private class SpecializationGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            String specialization = view.getSpecializationTab().getSelection().getSelectedItem().toString();
            projectModel.loadBySpecialization(specialization);
        }
    }

    // This will trigger when the generate by lecturer report button is
    // clicked
    private class LecturerGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getLecturerTab().getSelection().getSelectedIndex();

            projectModel.loadByLecturerId(lecturerModel.get(index).getAccountId());
        }
    }

    // This will trigger when the generate by status report button is
    // clicked
    private class StatusGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String status = view.getStatusTab().getSelection().getSelectedItem().toString();
            projectModel.loadByStatus(status);
            ;
        }
    }

    // This will trigger when the generate by assign report button is
    // clicked
    private class AssignGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String assign = view.getAssignTab().getSelection().getSelectedItem().toString();
            projectModel.loadByAssign(assign.equals("Assigned"));

        }
    }

    // This will trigger when the generate by comment report button is
    // clicked
    private class CommentGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comment = view.getCommentTab().getSelection().getSelectedItem().toString();
            projectModel.loadByComment(comment.equals("Commented"));
        }
    }

    // Main tab listener
    private class MainTpListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {

            int tabIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();

            if (tabIndex == 0) {

                projectModel.load();
            } else if (tabIndex == 1) {

                projectModel.clear();
            }
        }
    }

    // Report tab listener
    private class ReportTpListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int tabIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();
            projectModel.clear();

            if (tabIndex == 2) {
                lecturerModel.load();
            }
        }
    }

    // Dashboard table listener
    private class TableListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // Reset the project detail view
            adminProjectDetailController.resetView();
            // Set the current selected project
            projectModel.setCurrent(((JTable) e.getSource()).getSelectedRow());
            // Show the project detail view dialog
            adminProjectDetailController.show();

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
            // When the COMMENT button is clicekd
            if (column == 6) {
                // Set the current project
                projectModel.setCurrent(row);
                // Open the comment dialog
                commentController.show();

                // Delete the project
            } else if (column == 7) {
                // Pop up a JFrame and confirm with user if they really want to delete the
                // project
                JFrame jf = new JFrame();
                int result = JOptionPane.showConfirmDialog(jf, "Are you want to delete project?", "Delete Project",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    projectModel.delete(projectModel.get(row));
                    projectModel.loadAdminData();
                }
            }
        }
    }

    // This will trigger when the user click on the add project button
    // on the admin dashboard
    private class AddProjectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the add project view;
            addProjectController.show();
        }
    }

    // This will trigger when the user click on the create user button
    // on the admin dashboard
    private class CreateUserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Show the create user view
            createUserController.show();
        }
    }

    // This will trigger when the user click on the Logout button
    // on the admin dashboard
    private class LogoutButtonListener implements ActionListener {
        @Override
        // Show the login page and set the current page to non-visible
        // Reset the current logged-in user to null
        public void actionPerformed(ActionEvent e) {
            loginController.show();
            view.setVisible(false);
            projectModel.setAuthUser(null);
        }
    }
}