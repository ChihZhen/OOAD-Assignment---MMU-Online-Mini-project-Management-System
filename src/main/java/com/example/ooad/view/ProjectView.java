package com.example.ooad.view;

import javax.swing.*;
import javax.swing.table.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.ProjectTableModel;
import com.example.ooad.view.Component.TableButton;
import com.example.ooad.view.Component.TableButton.TableButtonPressedHandler;

import java.awt.*;
import java.awt.event.*;

@Component
public class ProjectView extends JFrame implements Observer {
    // @Autowired(required = false)
    private ProjectTableModel projectTableModel;
    private static JTable projectTable;
    private JButton addProjectButton;
    private TableButton assignButtons = new TableButton(new Color(23, 121, 233));
    private TableButton editButtons = new TableButton(new Color(241, 143, 5));
    private TableButton deleteButtons = new TableButton(new Color(241, 95, 95));;

    public static void add(JFrame panel, JComponent comp, int x, int y, int width, int height) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(2, 2, 2, 2);
        constr.anchor = GridBagConstraints.CENTER;
        panel.add(comp, constr);
    }

    public static void add(JFrame panel, JComponent comp, int x, int y, int width, int height, int marginT, int marginR,
            int marginB, int marginL) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = GridBagConstraints.CENTER;
        panel.add(comp, constr);
    }

    public static void add(JFrame panel, JComponent comp, int x, int y, int width, int height, int marginT, int marginR,
            int marginB, int marginL, int anchor) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = anchor;
        panel.add(comp, constr);
    }

    public ProjectView(ProjectTableModel projectTableModel) {

        this.projectTableModel = projectTableModel;
        this.projectTableModel.registerObserver(this);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1440, 900));
        this.setMinimumSize(new Dimension(1440, 900));

        JLabel welcomeLabel = new JLabel("Welcome Back");
        add(this, welcomeLabel, 0, 0, 2, 1, 0, 0, 25, 0, GridBagConstraints.LINE_START);

        JLabel projectLabel = new JLabel("Project");
        add(this, projectLabel, 0, 1, 2, 1, 0, 0, 25, 0);

        addProjectButton = new JButton("Add Project");
        add(this, addProjectButton, 1, 2, 1, 1, 0, 0, 25, 0, GridBagConstraints.BASELINE_TRAILING);

        String[][] data = {
                { "OS", "Computer Science", "Q1", "ASSIGN", "EDIT", "DELETE" },
                { "OOAD", "Data Science", "Q2", "ASSIGN", "EDIT", "DELETE" }
        };

        // Column Names
        String[] header = { "Title", "Specialization", "Created By", "", "", "" };

        // JTable projectTable = new JTable(data, header);
        projectTable = new JTable(this.projectTableModel.getTableModel());

        System.out.println(projectTable.getModel().getRowCount());

        JScrollPane tableContainer = new JScrollPane(projectTable);
        tableContainer.setPreferredSize(new Dimension(896, 432));
        tableContainer.setMinimumSize(new Dimension(896, 432));
        tableContainer.setMaximumSize(new Dimension(896, 432));
        // tableContainer.add(projectTable);

        add(this, tableContainer, 0, 3, 2, 1);
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
        System.out.println(projectTableModel.getTableModel().getRowCount());
        System.out.println("update");

        if (projectTableModel.getTableModel().getRowCount() > 0) {
            TableColumn assignColumn = projectTable.getColumnModel().getColumn(4);
            assignColumn.setCellRenderer(assignButtons);
            assignColumn.setCellEditor(assignButtons);

            TableColumn editColumn = projectTable.getColumnModel().getColumn(5);
            editColumn.setCellRenderer(editButtons);
            editColumn.setCellEditor(editButtons);

            TableColumn deleteColumn = projectTable.getColumnModel().getColumn(6);
            deleteColumn.setCellRenderer(deleteButtons);
            deleteColumn.setCellEditor(deleteButtons);
        }
    }

    // public static void main(String[] args) {
    // new ProjectView();
    // }
}
