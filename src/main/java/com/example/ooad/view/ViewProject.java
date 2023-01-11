package com.example.ooad.view;

import javax.swing.*;
import javax.swing.table.*;

import com.example.ooad.view.Component.TableButton;

import java.awt.*;

public class ViewProject extends JFrame {
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

    public ViewProject() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1440, 900));
        this.setMinimumSize(new Dimension(1440, 900));

        JLabel welcomeLabel = new JLabel("Welcome Back");
        add(this, welcomeLabel, 0, 0, 1, 1, 0, 0, 25, 0, GridBagConstraints.LINE_START);

        JLabel projectLabel = new JLabel("Project");
        add(this, projectLabel, 0, 1, 1, 1, 0, 0, 25, 0);

        String[][] data = {
                { "OS", "Computer Science", "Q1", "ASSIGN", "EDIT", "DELETE" },
                { "OOAD", "Data Science", "Q2", "ASSIGN", "EDIT", "DELETE" }
        };

        // Column Names
        String[] header = { "Title", "Specialization", "Created By", "", "", "" };

        JTable projectTable = new JTable(data, header);

        TableColumn assignColumn = projectTable.getColumnModel().getColumn(3);
        TableButton assignButtons = new TableButton(new Color(23, 121, 233));

        assignButtons.addHandler(new TableButton.TableButtonPressedHandler() {

            @Override
            public void onButtonPress(int row, int column) {
                // TODO Auto-generated method stub
                // JOptionPane.showMessageDialog(frame, row)
                System.out.println(row);

            }
        });

        assignColumn.setCellRenderer(assignButtons);
        assignColumn.setCellEditor(assignButtons);

        TableColumn editColumn = projectTable.getColumnModel().getColumn(4);
        TableButton editButtons = new TableButton(new Color(241, 143, 5));

        editButtons.addHandler(new TableButton.TableButtonPressedHandler() {

            @Override
            public void onButtonPress(int row, int column) {
                // TODO Auto-generated method stub
                // JOptionPane.showMessageDialog(frame, row)
                System.out.println(row);

            }
        });

        editColumn.setCellRenderer(editButtons);
        editColumn.setCellEditor(editButtons);

        TableColumn deleteColumn = projectTable.getColumnModel().getColumn(5);
        TableButton deleteButtons = new TableButton(new Color(241, 95, 95));

        deleteButtons.addHandler(new TableButton.TableButtonPressedHandler() {

            @Override
            public void onButtonPress(int row, int column) {
                // TODO Auto-generated method stub
                // JOptionPane.showMessageDialog(frame, row)
                System.out.println(row);

            }
        });

        deleteColumn.setCellRenderer(deleteButtons);
        deleteColumn.setCellEditor(deleteButtons);

        JScrollPane tableContainer = new JScrollPane(projectTable);
        tableContainer.setPreferredSize(new Dimension(896, 432));
        tableContainer.setMinimumSize(new Dimension(896, 432));
        tableContainer.setMaximumSize(new Dimension(896, 432));
        // tableContainer.add(projectTable);

        add(this, tableContainer, 0, 3, 1, 1);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new ViewProject();
    }
}
