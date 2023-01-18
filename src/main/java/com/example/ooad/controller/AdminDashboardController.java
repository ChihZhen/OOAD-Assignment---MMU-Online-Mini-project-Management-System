package com.example.ooad.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AdminDashboardView;
import com.example.ooad.view.Component.ReportTab;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.event.*;

@Controller
public class AdminDashboardController {
    private AdminDashboardView view;
    private ProjectModel projectModel;
    private LecturerModel lecturerModel;
    // private ComboListModel comboListModel;
    private LoginController loginController;
    private AdminAddProjectController addProjectController;
    // private AdminAddProjectController adminAddProjectController;
    private AdminCreateUserController createUserController;
    // private ProjectRepository projectRepository;
    // private LecturerRepository lecturerRepository;
    // private int tabIndex;

    public AdminDashboardController(AdminDashboardView view, ProjectModel projectModel, LecturerModel lecturerModel,
            AdminAddProjectController addProjectController, AdminCreateUserController createUserController,
            LoginController loginController) {
        this.view = view;
        this.projectModel = projectModel;
        this.lecturerModel = lecturerModel;
        this.addProjectController = addProjectController;
        this.createUserController = createUserController;
        this.loginController = loginController;

        view.getProjectTable().addMouseListener(new TableListener());

        // adminProjectListView.addClickTableButtonListener(new
        // ClickTableButtonListener());
        view.getCommentButtons().addHandler(new TableButtonListener());
        view.getDeleteButtons().addHandler(new TableButtonListener());

        view.getAddProjectButton().addActionListener(new AddProjectButtonListener());
        view.getCreateUserButton().addActionListener(new CreateUserButtonListener());

        view.getLogoutButton().addActionListener(new LogoutButtonListener());

        // adminProjectListView.addSelectTabListener(new SelectTabListener());
        view.getMainTp().addChangeListener(new MainTpListener());
        view.getReportTp().addChangeListener(new ReportTpListener());

        // adminProjectListView.addClickGenerateListener(new
        // addClickGenerateListener());
        // for (ReportTab t : view.getReportTabs()) {
        // t.getGenerateButton().addActionListener(new GenerateButtonListener());
        // }
        view.getAllProjectTab().getGenerateButton().addActionListener(new AllProjectGenerateButton());
        view.getSpecializationTab().getGenerateButton().addActionListener(new SpecializationGenerateButton());
        view.getLecturerTab().getGenerateButton().addActionListener(new LecturerGenerateButton());
        view.getStatusTab().getGenerateButton().addActionListener(new StatusGenerateButton());
        view.getAssignTab().getGenerateButton().addActionListener(new AssignGenerateButton());
        view.getCommentTab().getGenerateButton().addActionListener(new CommentGenerateButton());
        // adminProjectListView.
        // adminProjectListView.setVisible(true);
    }

    public void show() {
        projectModel.load();
        view.setVisible(true);
    }

    public void hide() {
        view.setVisible(false);
    }

    // private class GenerateButtonListener implements ActionListener {
    // @Override
    // public void actionPerformed(ActionEvent e) {

    // // int index = view.getReportTp().getSelectedIndex();

    // int reportTpIndex = view.getReportTp().getSelectedIndex();
    // int selectionIndex =
    // view.getReportTabs().get(reportTpIndex).getSelection().getSelectedIndex();
    // // String selection = view.getSelection(tabIndex);
    // if (reportTpIndex == 0) {
    // projectModel.load();
    // // } else if (selection.equals("")) {
    // // JFrame jf = new JFrame();
    // // JOptionPane.showMessageDialog(jf,
    // // "Please select a field",
    // // "No Selection", 2, null);
    // } else if (reportTpIndex == 1) {
    // projectModel.load();
    // // projectModel.setReportBySpecialization(selection);
    // } else if (reportTpIndex == 2) {

    // // projectModel.setReportByLecturer(selection);
    // } else if (reportTpIndex == 3) {
    // // projectModel.setReportByStatus(selection);
    // } else if (reportTpIndex == 4) {
    // // projectModel.setReportByAssign(selection);
    // } else if (reportTpIndex == 5) {
    // // projectModel.setReportByComment(selection);
    // }
    // }

    // }

    private class AllProjectGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            // view.getAllProjectTab().getSelection().getSelectedIndex();
            projectModel.load();
        }
    }

    private class SpecializationGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            String specialization = view.getSpecializationTab().getSelection().getSelectedItem().toString();
            projectModel.loadBySpecialization(specialization);
        }
    }

    private class LecturerGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = view.getLecturerTab().getSelection().getSelectedIndex();
            // System.out.println(index);
            // System.out.println(index);
            System.out.println(lecturerModel.get(index).getId());
            System.out.println(lecturerModel.get(index).getAccountId());
            System.out.println(lecturerModel.get(index).getFullName());
            System.out.println(lecturerModel.get(index).getPassword());
            projectModel.loadByLecturerId(lecturerModel.get(index).getAccountId());
        }
    }

    private class StatusGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String status = view.getStatusTab().getSelection().getSelectedItem().toString();
            projectModel.loadByStatus(status);
            ;
        }
    }

    private class AssignGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String assign = view.getAssignTab().getSelection().getSelectedItem().toString();
            projectModel.loadByAssign(assign.equals("Assigned"));

        }
    }

    private class CommentGenerateButton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String comment = view.getCommentTab().getSelection().getSelectedItem().toString();
            projectModel.loadByComment(comment.equals("Commented"));
        }
    }

    private class MainTpListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            // TODO Auto-generated method stub
            int tabIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();

            // projectModel.resetReport();\
            if (tabIndex == 0) {
                // lecturerModel.load();
                projectModel.load();
            } else if (tabIndex == 1) {
                // lecturerModel.load();
                projectModel.clear();
            }
        }
    }

    private class ReportTpListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            int tabIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();
            projectModel.clear();
            // projectModel.resetReport();
            if (tabIndex == 2) {
                lecturerModel.load();
            }
        }
    }

    private class TableListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // TableModel tableModel = projectView.getTableModel();
            // TableModel tableModel = projectView.getTableModel();
            // System.out.println(projectTableModel.getRowCount());
            System.out.println("hi table");
            // projectTableModel.setValueAt("hi", 0, 0);

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

    private class TableButtonListener implements TableButtonPressedHandler {
        @Override
        public void onButtonPress(int row, int column) {
            if (column == 6) {
                // projectController.showEditProject(row);
            } else if (column == 7) {
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

    private class AddProjectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("addProjectButton");
            addProjectController.show();
        }
    }

    private class CreateUserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createUserController.show();
        }
    }

    private class LogoutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginController.show();
            view.setVisible(false);
            projectModel.setAuthUser(null);
        }
    }
}