package com.example.ooad.view;

import java.awt.*;

import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.IModel;
import com.example.ooad.model.LecturerModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;
import com.example.ooad.view.Component.ReportTab;
import com.example.ooad.view.Component.TableButton;

@Component
public class AdminDashboardView extends JFrame implements Observer<IModel> {
    private ProjectModel projectModel;

    private LecturerModel lecturerModel;
    private JButton logoutButton;
    private JTable projectTable;
    private JButton createUserButton;
    private JButton addProjectButton;
    private ReportTab allProjectTab;
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

    public AdminDashboardView(ProjectModel projectModel, LecturerModel lecturerModel) {

        GridBagAdder gridCtr;
        this.projectModel = projectModel;
        this.lecturerModel = lecturerModel;
        this.projectModel.registerObserver(this);
        this.lecturerModel.registerObserver(this);

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

        projectTable = new JTable(tableModel);

        JScrollPane tableContainer = new JScrollPane(
                projectTable);
        tableContainer.setPreferredSize(new Dimension(896, 432));
        tableContainer.setMinimumSize(new Dimension(896, 432));
        tableContainer.setMaximumSize(new Dimension(896, 432));

        GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setY(3).width(2)
                .build();

        reportTp = new JTabbedPane();

        allProjectTab = new ReportTab(null);
        reportTp.add("All Projects", allProjectTab);
        specializationTab = new ReportTab(
                new String[] { "Software Engineer", "Data Science", "Game Development", "Cyber Security" });
        reportTp.add("By Specialization", specializationTab);

        lecturerTab = new ReportTab(new String[] {});
        reportTp.add("By Lecturer", lecturerTab);

        statusTab = new ReportTab(new String[] { "Active", "Inactive" });
        reportTp.add("By Status", statusTab);

        assignTab = new ReportTab(new String[] { "Assigned", "Unassigned" });
        reportTp.add("By Assign", assignTab);

        commentTab = new ReportTab(new String[] { "Commented", "Uncommented" });
        reportTp.add("By Comment", commentTab);

        reportTabs = new ArrayList<ReportTab>() {
            {
                add(allProjectTab);
                add(specializationTab);
                add(lecturerTab);
                add(statusTab);
                add(assignTab);
                add(commentTab);
            }
        };

        mainTp = new JTabbedPane();
        mainTp.add("Project", tableContainer);
        mainTp.add("Report", reportTp);

        // });

        this.add(mainTp, gridCtr_4.getConstraint());
        // this.setVisible(true);
    }

    public ProjectModel getProjectModel() {
        return this.projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }

    public LecturerModel getLecturerModel() {
        return this.lecturerModel;
    }

    public void setLecturerModel(LecturerModel lecturerModel) {
        this.lecturerModel = lecturerModel;
    }

    public ReportTab getAllProjectTab() {
        return this.allProjectTab;
    }

    public void setAllProjectTab(ReportTab allProjectTab) {
        this.allProjectTab = allProjectTab;
    }

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public ProjectModel getProjectListModel() {
        return this.projectModel;
    }

    public void setProjectListModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
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

    public ReportTab getSpecializationTab() {
        return this.specializationTab;
    }

    public void setSpecializationTab(ReportTab specializationTab) {
        this.specializationTab = specializationTab;
    }

    public ReportTab getLecturerTab() {
        return this.lecturerTab;
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

    public void update(Observable<IModel> Observable, IModel model) {

        if (model instanceof ProjectModel) {
            tableModel.setDataVector(projectModel.getAdminData(), header);

            if (projectModel.getList().size() > 0) {
                TableColumn commentColumn = projectTable.getColumnModel().getColumn(6);
                commentColumn.setCellRenderer(commentButtons);
                commentColumn.setCellEditor(commentButtons);

                TableColumn deleteColumn = projectTable.getColumnModel().getColumn(7);
                deleteColumn.setCellRenderer(deleteButtons);
                deleteColumn.setCellEditor(deleteButtons);
            }

            for (ReportTab rt : reportTabs) {
                rt.getReportTextArea().setText(projectModel.getReportData());
                rt.getReportTextArea().setCaretPosition(0);

            }
        } else if (model instanceof LecturerModel) {

            lecturerTab.getSelectionInput().setModel(new DefaultComboBoxModel<String>(lecturerModel.getNameAndId()));

        }
    }
}
