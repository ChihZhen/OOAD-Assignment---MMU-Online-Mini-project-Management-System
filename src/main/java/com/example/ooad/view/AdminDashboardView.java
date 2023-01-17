package com.example.ooad.view;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.table.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.ComboListModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;
import com.example.ooad.view.Component.Report;
import com.example.ooad.view.Component.ReportTab;
import com.example.ooad.view.Component.TableButton;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

@Component
public class AdminDashboardView extends JFrame implements Observer<ProjectModel> {
    private ProjectModel projectModel;
    private ComboListModel comboListModel;
    private JButton logoutButton;
    private JTable projectTable;
    private JButton createUserButton;
    private JButton addProjectButton;
    private Report allProjectReport;
    private ReportTab specializationTab;
    private ReportTab lecturerTab;
    private ReportTab statusTab;
    private ReportTab assignTab;
    private ReportTab commentTab;
    private List<ReportTab> reportTabs;
    private JTabbedPane mainTp;
    private JTabbedPane reportTp;
    private TableButton commentButtons = new TableButton(new Color(241, 143, 5));
    private TableButton deleteButtons = new TableButton(new Color(241, 95, 95));

    private Vector<String> header = new Vector<String>() {
        {
            add("ID");
            add("Title");
            add("Specialization");
            add("Status");
            add("Lecturer");
            add("Student");
            add(""); // comment
            add(""); // delete
        }
    };
    private DefaultTableModel tableModel = new DefaultTableModel(null, header);

    public AdminDashboardView(ProjectModel projectModel, ComboListModel comboListModel) {
        // public AdminProjectListView() {
        GridBagAdder gridCtr;
        this.projectModel = projectModel;
        this.projectModel.registerObserver(this);
        this.comboListModel = comboListModel;
        this.comboListModel.registerObserver(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1440, 900));
        this.setMinimumSize(new Dimension(1440, 900));

        JLabel welcomeLabel = new JLabel("Welcome Back");
        gridCtr = new GridBagAdder.GridBagAdderBuilder().width(2).marginB(25)
                .anchor(GridBagConstraints.LINE_START).build();
        this.add(welcomeLabel, gridCtr.getConstraint());

        logoutButton = new JButton("Logout");
        GridBagAdder gridCtr1 = new GridBagAdder.GridBagAdderBuilder().setX(1)
                .anchor(GridBagConstraints.BASELINE_TRAILING).build();
        this.add(logoutButton, gridCtr1.getConstraint());

        JLabel projectLabel = new JLabel("Project");
        GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setY(1).width(2).marginB(25)
                .build();
        this.add(projectLabel, gridCtr_2.getConstraint());

        createUserButton = new JButton("Create User");
        GridBagAdder grid = new GridBagAdder.GridBagAdderBuilder().setY(2).marginB(25)
                .anchor(GridBagConstraints.BASELINE_LEADING).build();
        this.add(createUserButton, grid.getConstraint());

        addProjectButton = new JButton("Add Project");
        GridBagAdder gridCtr_3 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginB(25)
                .anchor(GridBagConstraints.BASELINE_TRAILING).build();
        this.add(addProjectButton, gridCtr_3.getConstraint());

        // JTable projectTable = new JTable(data, header);
        // projectTable = new JTable(this.projectListModel.getTableModel());

        projectTable = new JTable(tableModel);
        // // projectTable.setEnabled(false);
        // projectTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane tableContainer = new JScrollPane(
                projectTable);
        tableContainer.setPreferredSize(new Dimension(896, 432));
        tableContainer.setMinimumSize(new Dimension(896, 432));
        tableContainer.setMaximumSize(new Dimension(896, 432));
        // tableContainer.add(projectTable);
        GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setY(3).width(2)
                .build();

        allProjectReport = new Report();

        reportTp = new JTabbedPane();
        reportTp.add("All Projects", allProjectReport);
        specializationTab = new ReportTab();
        lecturerTab = new ReportTab();
        statusTab = new ReportTab();
        assignTab = new ReportTab();
        commentTab = new ReportTab();

        reportTabs = new ArrayList<ReportTab>() {
            {
                add(specializationTab);
                add(lecturerTab);
                add(statusTab);
                add(assignTab);
                add(commentTab);
            }
        };

        reportTp.add("By Specialization", specializationTab);
        reportTp.add("By Lecturer", lecturerTab);
        reportTp.add("By Status", statusTab);
        reportTp.add("By Assign", assignTab);
        reportTp.add("By Comment", commentTab);

        mainTp = new JTabbedPane();
        mainTp.add("Project", tableContainer);
        mainTp.add("Report", reportTp);

        // });

        this.add(mainTp, gridCtr_4.getConstraint());
        // this.setVisible(true);

        projectModel.registerObserver(this);
    }

    public ProjectModel getProjectListModel() {
        return this.projectModel;
    }

    public void setProjectListModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }

    public ComboListModel getComboListModel() {
        return this.comboListModel;
    }

    public void setComboListModel(ComboListModel comboListModel) {
        this.comboListModel = comboListModel;
    }

    public JButton getLogoutButton() {
        return this.logoutButton;
    }

    public void setLogoutButton(JButton logoutButton) {
        this.logoutButton = logoutButton;
    }

    public JTable getProjectTable() {
        return this.projectTable;
    }

    public void setProjectTable(JTable projectTable) {
        this.projectTable = projectTable;
    }

    public JButton getCreateUserButton() {
        return this.createUserButton;
    }

    public void setCreateUserButton(JButton createUserButton) {
        this.createUserButton = createUserButton;
    }

    public JButton getAddProjectButton() {
        return this.addProjectButton;
    }

    public void setAddProjectButton(JButton addProjectButton) {
        this.addProjectButton = addProjectButton;
    }

    public Report getAllProjectReport() {
        return this.allProjectReport;
    }

    public void setAllProjectReport(Report allProjectReport) {
        this.allProjectReport = allProjectReport;
    }

    public ReportTab getSpecializationTab() {
        return this.specializationTab;
    }

    public void setSpecializationTab(ReportTab specializationTab) {
        this.specializationTab = specializationTab;
    }

    public ReportTab getLecturerTab() {
        return this.lecturerTab;
    }

    public void setLecturerTab(ReportTab lecturerTab) {
        this.lecturerTab = lecturerTab;
    }

    public ReportTab getStatusTab() {
        return this.statusTab;
    }

    public void setStatusTab(ReportTab statusTab) {
        this.statusTab = statusTab;
    }

    public ReportTab getAssignTab() {
        return this.assignTab;
    }

    public void setAssignTab(ReportTab assignTab) {
        this.assignTab = assignTab;
    }

    public ReportTab getCommentTab() {
        return this.commentTab;
    }

    public void setCommentTab(ReportTab commentTab) {
        this.commentTab = commentTab;
    }

    public List<ReportTab> getReportTabs() {
        return this.reportTabs;
    }

    public void setReportTabs(List<ReportTab> reportTabs) {
        this.reportTabs = reportTabs;
    }

    public JTabbedPane getMainTp() {
        return this.mainTp;
    }

    public void setMainTp(JTabbedPane mainTp) {
        this.mainTp = mainTp;
    }

    public JTabbedPane getReportTp() {
        return this.reportTp;
    }

    public void setReportTp(JTabbedPane reportTp) {
        this.reportTp = reportTp;
    }

    public TableButton getCommentButtons() {
        return this.commentButtons;
    }

    public void setCommentButtons(TableButton commentButtons) {
        this.commentButtons = commentButtons;
    }

    public TableButton getDeleteButtons() {
        return this.deleteButtons;
    }

    public void setDeleteButtons(TableButton deleteButtons) {
        this.deleteButtons = deleteButtons;
    }

    public Vector<String> getHeader() {
        return this.header;
    }

    public void setHeader(Vector<String> header) {
        this.header = header;
    }

    public void addSelectTabListener(ChangeListener listener) {
        mainTp.addChangeListener(listener);
        reportTp.addChangeListener(listener);
    }

    public void addClickGenerateListener(ActionListener listener) {
        for (ReportTab reportTab : reportTabs) {
            reportTab.getGenerateButton().addActionListener(listener);
        }
    }

    public String getSelection(int index) {
        // System.out.println("getselection:" + index);
        index = index - 1;
        reportTabs.get(index).getSelection().getSelectedItem();
        if (reportTabs.get(index).getSelection().getSelectedItem() == null) {
            return "";
        }
        return reportTabs.get(index).getSelection().getSelectedItem().toString();
        // if (index == 1) {
        // if (specializationTab.getSelection().getSelectedItem() == null) {
        // return "";
        // }
        // return specializationTab.getSelection().getSelectedItem().toString();
        // } else if (index == 2) {
        // if (lecturerTab.getSelection().getSelectedItem() == null) {
        // return "";
        // }
        // return lecturerTab.getSelection().getSelectedItem().toString();
        // } else if (index == 3) {
        // if (statusTab.getSelection().getSelectedItem() == null) {
        // return "";
        // }
        // return statusTab.getSelection().getSelectedItem().toString();

        // } else if (index == 4) {
        // if (assignTab.getSelection().getSelectedItem() == null) {
        // return "";
        // }
        // return assignTab.getSelection().getSelectedItem().toString();

        // } else if (index == 5) {
        // if (commentTab.getSelection().getSelectedItem() == null) {
        // return "";
        // }
        // return commentTab.getSelection().getSelectedItem().toString();

        // }
        // if (commentTab.getSelection().getSelectedItem() == null) {
        // return "";
        // }
        // return commentTab.getSelection().getSelectedItem().toString();
    }

    public void addClickRowListener(MouseListener listener) {
        projectTable.addMouseListener(listener);
    }

    public void addClickTableButtonListener(TableButtonPressedHandler listener) {
        commentButtons.addHandler(listener);
        deleteButtons.addHandler(listener);
    }

    public void addClickButtonListener(ActionListener listener) {
        addProjectButton.addActionListener(listener);
    }

    public void addClickCreateUserButtonListener(ActionListener listener) {
        createUserButton.addActionListener(listener);
    }

    public void addClickLogoutButtonListener(ActionListener listener) {
        logoutButton.addActionListener(listener);
    }

    public void update() {
        // projectTable.setModel(new
        // header));

        for (ReportTab reportTab : reportTabs) {
            reportTab.setData(projectModel.getReportData());
            reportTab.setCombo(comboListModel.getComboBox());
        }

        projectTable.setModel(new DefaultTableModel(projectModel.getAdminData(),
                header));

        allProjectReport.setData(projectModel.getReportData());
        // specializationTab.setData(projectListModel.getReportData());
        // specializationTab.setCombo(comboListModel.getComboBox());

    }

    public void update(Observable<ProjectModel> Observable) {
        // projectTable.setModel(new
        // DefaultTableModel(projectModel.getAdminData(),header)
        // header));
        tableModel.setDataVector(projectModel.getAdminData(), header);

        // DefaultTableModel = projectTable.getModel().g

        if (projectModel.getList().size() > 0) {
            TableColumn commentColumn = projectTable.getColumnModel().getColumn(6);
            commentColumn.setCellRenderer(commentButtons);
            commentColumn.setCellEditor(commentButtons);

            TableColumn deleteColumn = projectTable.getColumnModel().getColumn(7);
            deleteColumn.setCellRenderer(deleteButtons);
            deleteColumn.setCellEditor(deleteButtons);
        }
    }
}
