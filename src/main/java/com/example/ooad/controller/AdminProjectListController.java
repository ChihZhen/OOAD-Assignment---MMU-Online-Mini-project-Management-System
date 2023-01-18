package com.example.ooad.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.OoadApplication;
import com.example.ooad.model.ComboListModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.repository.LecturerRepository;
import com.example.ooad.repository.ProjectRepository;
import com.example.ooad.view.AdminProjectListView;
import com.example.ooad.view.ProjectListView;
import com.example.ooad.view.Component.ReportTab;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.event.*;

@Controller
public class AdminProjectListController {
    private ProjectListModel projectTableModel;
    private ComboListModel comboListModel;
    private AdminProjectListView adminProjectListView;
    private OoadApplication ooadApplication;
    private ProjectController projectController;
    private AdminAddProjectController adminAddProjectController;
    private AdminProjectDetailController adminProjectDetailController;
    private CreateUserController createUserController;
    private LoginController loginController;
    private ProjectRepository projectRepository;
    private LecturerRepository lecturerRepository;
    private int tabIndex;
    private ReportTab tab;
    private CommentController commentController;

    public AdminProjectListController(ProjectListModel projectTableModel, ComboListModel comboListModel,
            AdminProjectListView adminProjectListView, OoadApplication ooadApplication,
            ProjectController projectController, AdminAddProjectController adminAddProjectController,
            CreateUserController createUserController, LoginController loginController,
            ProjectRepository projectRepository, LecturerRepository lecturerRepository,
            AdminProjectDetailController adminProjectDetailController,
            CommentController commentController) {
        this.projectTableModel = projectTableModel;
        this.comboListModel = comboListModel;
        this.adminProjectListView = adminProjectListView;
        this.ooadApplication = ooadApplication;
        this.projectController = projectController;
        this.adminAddProjectController = adminAddProjectController;
        this.createUserController = createUserController;
        this.loginController = loginController;
        this.projectRepository = projectRepository;
        this.lecturerRepository = lecturerRepository;
        this.adminProjectDetailController = adminProjectDetailController;
        this.commentController = commentController;

        adminProjectListView.addClickRowListener(new ClickRowListener());
        adminProjectListView.addClickTableButtonListener(new ClickTableButtonListener());
        adminProjectListView.addClickButtonListener(new ClickAddProjectButtonListener());
        adminProjectListView.addClickCreateUserButtonListener(new ClickCreateUserButtonListener());
        adminProjectListView.addClickLogoutButtonListener(new ClickLogoutButtonListener());
        adminProjectListView.addSelectTabListener(new SelectTabListener());
        adminProjectListView.addClickGenerateListener(new addClickGenerateListener());
        // adminProjectListView.setVisible(true);
    }

    public void show() {
        loadData();
        adminProjectListView.setVisible(true);
    }

    public void hide() {
        adminProjectListView.setVisible(false);
    }

    public void loadData() {
        List<ProjectModel> projects = projectRepository.findAll();
        projectTableModel.setProjects(projects);
    }

    // public void init() {
    // adminProjectListView.addClickRowListener(new ClickRowListener());
    // adminProjectListView.addClickTableButtonListener(new
    // ClickTableButtonListener());
    // adminProjectListView.addClickButtonListener(new
    // ClickAddProjectButtonListener());
    // adminProjectListView.addClickCreateUserButtonListener(new
    // ClickCreateUserButtonListener());
    // adminProjectListView.addClickLogoutButtonListener(new
    // ClickLogoutButtonListener());
    // adminProjectListView.addSelectTabListener(new SelectTabListener());
    // adminProjectListView.addClickGenerateListener(new
    // addClickGenerateListener());
    // adminProjectListView.setVisible(true);
    // loadData();
    // }

    private class addClickGenerateListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selection = adminProjectListView.getSelection(tabIndex);
            System.out.println(selection);
            System.out.println(selection == null);
            System.out.println(selection.equals(""));
            if (tabIndex == 0) {
                projectTableModel.setAllReport();
            } else if (selection.equals("")) {
                JFrame jf = new JFrame();
                JOptionPane.showMessageDialog(jf,
                        "Please select a field",
                        "No Selection", 2, null);
            } else if (tabIndex == 1) {
                projectTableModel.setReportBySpecialization(selection);
            } else if (tabIndex == 2) {
                projectTableModel.setReportByLecturer(selection);
            } else if (tabIndex == 3) {
                projectTableModel.setReportByStatus(selection);
            } else if (tabIndex == 4) {
                projectTableModel.setReportByAssign(selection);
            } else if (tabIndex == 5) {
                projectTableModel.setReportByComment(selection);
            }
        }

    }

    private class SelectTabListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            // TODO Auto-generated method stub
            tabIndex = ((JTabbedPane) e.getSource()).getSelectedIndex();
            String name = ((JTabbedPane) e.getSource()).getTitleAt(tabIndex);
            // System.out.println(index);
            System.out.println(name);
            projectTableModel.resetReport();
            if (name.equals("All Projects")) {
                projectTableModel.setAllReport();
                // projectTableModel.setProjects(projectRepository.findAll());

            } else if (name.equals("By Specialization")) {
                comboListModel.setComboList(new ArrayList<>() {
                    {
                        add("Software Engineer");
                        add("Data Science");
                        add("Game Development");
                        add("Cyber Security");
                    }
                });
            } else if (name.equals("By Lecturer")) {
                List<LecturerModel> lecturers = lecturerRepository.findAll();
                List<String> names = new ArrayList<String>();
                for (LecturerModel lecturer : lecturers) {
                    names.add(lecturer.getFullName());
                }
                comboListModel.setComboList(names);

            } else if (name.equals("By Status")) {
                comboListModel.setComboList(new ArrayList<>() {
                    {
                        add("Active");
                        add("Inactive");
                    }
                });
            } else if (name.equals("By Assign"))

            {
                comboListModel.setComboList(new ArrayList<>() {
                    {
                        add("Assigned");
                        add("Unassigned");
                    }
                });
            } else if (name.equals("By Comment")) {
                comboListModel.setComboList(new ArrayList<>() {
                    {
                        add("With Comment");
                        add("No Comment");
                    }
                });

            }
        }
    }

    private class ClickRowListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            // TableModel tableModel = projectView.getTableModel();
            // TableModel tableModel = projectView.getTableModel();
            // System.out.println(projectTableModel.getRowCount());
            // System.out.println("hi table ----------------->" + ((JTable)
            // e.getSource()).getSelectedRow());
            adminProjectDetailController.show(projectTableModel.getProject(((JTable) e.getSource()).getSelectedRow()));

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

    private class ClickTableButtonListener implements TableButtonPressedHandler {
        @Override
        public void onButtonPress(int row, int column) {
            if (column == 6) {
                commentController.show(projectTableModel.getProject(row));
                // projectController.showEditProject(row);
            } else if (column == 7) {
                JFrame jf = new JFrame();
                int result = JOptionPane.showConfirmDialog(jf, "Are you want to delete project?", "Delete Project",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (result == JOptionPane.YES_OPTION) {
                    projectRepository.delete(projectTableModel.getProject(row));
                    loadData();
                }
            }
        }
    }

    private class ClickAddProjectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            adminAddProjectController.show();
        }
    }

    private class ClickCreateUserButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createUserController.show();
        }
    }

    private class ClickLogoutButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            loginController.show();
            adminProjectListView.setVisible(false);
            OoadApplication.setLoginUser(null);
        }
    }
}