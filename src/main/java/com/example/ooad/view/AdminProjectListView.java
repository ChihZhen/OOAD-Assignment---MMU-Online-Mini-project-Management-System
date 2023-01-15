package com.example.ooad.view;

import javax.swing.*;
import javax.swing.table.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.ProjectListModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.view.Component.TableButton;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.*;
import java.awt.event.*;

@Component
public class AdminProjectListView extends JFrame implements Observer {
    // private ProjectListModel projectListModel;
    private JButton logoutButton;
    private JTable projectTable;
    private JButton createUserButton;
    private JButton addProjectButton;
    private TableButton assignButtons = new TableButton(new Color(23, 121, 233));
    private TableButton editButtons = new TableButton(new Color(241, 143, 5));
    private TableButton deleteButtons = new TableButton(new Color(241, 95, 95));

    // public AdminProjectListView(ProjectListModel projectListModel) {
    public AdminProjectListView() {

        // this.projectListModel = projectListModel;
        // this.projectListModel.registerObserver(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1440, 900));
        this.setMinimumSize(new Dimension(1440, 900));

        JLabel welcomeLabel = new JLabel("Welcome Back");
        GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().width(2).marginB(25)
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
        this.add(tableContainer, gridCtr_4.getConstraint());
        // this.setVisible(true);

    }

    public void addClickRowListener(MouseListener listener) {
        projectTable.addMouseListener(listener);
    }

    public void addClickTableButtonListener(TableButtonPressedHandler listener) {
        assignButtons.addHandler(listener);
        editButtons.addHandler(listener);
        deleteButtons.addHandler(listener);
    }

    public void addClickButtonListener(ActionListener listener) {
        addProjectButton.addActionListener(listener);
    }

    public void update() {
        // System.out.println(projectListModel.getTableModel().getRowCount());
        // System.out.println("update");

        // if (projectListModel.getTableModel().getRowCount() > 0) {
        // for (int i = 0; i < projectListModel.getTableModel().getRowCount(); i++) {
        // assignButtons.setButtonText(i, projectListModel.getTableModel().getValueAt(i,
        // 4).toString());
        // }
        // TableColumn assignColumn = projectTable.getColumnModel().getColumn(4);
        // assignColumn.setCellRenderer(assignButtons);
        // assignColumn.setCellEditor(assignButtons);

        // // editButtons = new TableButton(new Color(241, 143, 5));
        // TableColumn editColumn = projectTable.getColumnModel().getColumn(5);
        // editColumn.setCellRenderer(editButtons);
        // editColumn.setCellEditor(editButtons);

        // // deleteButtons = new TableButton(new Color(241, 95, 95));
        // TableColumn deleteColumn = projectTable.getColumnModel().getColumn(6);
        // deleteColumn.setCellRenderer(deleteButtons);
        // deleteColumn.setCellEditor(deleteButtons);
        // }
    }

    public static void main(String[] args) {
        new AdminProjectListView();
    }
}
