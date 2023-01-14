package com.example.ooad.view;

import javax.swing.*;
import org.springframework.stereotype.Component;

import com.example.ooad.model.ProjectListModel;
import com.example.ooad.utils.GridBagAdder;

import java.awt.*;
import java.awt.event.*;

@Component
public class StudentProjectListView extends JFrame implements Observer {
  private JTable projectTable;
  private ProjectListModel projectListModel;

  public StudentProjectListView(ProjectListModel projectListModel) {
    this.projectListModel = projectListModel;
    this.projectListModel.registerObserver(this);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setPreferredSize(new Dimension(1440, 900));
    this.setMinimumSize(new Dimension(1440, 900));

    JLabel welcomeLabel = new JLabel("Welcome Back Student");
    GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().width(2).marginB(25)
        .anchor(GridBagConstraints.LINE_START).build();
    this.add(welcomeLabel, gridCtr.getConstraint());

    JLabel projectLabel = new JLabel("Project");
    GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setY(1).width(2).marginB(25).build();
    this.add(projectLabel, gridCtr_2.getConstraint());

    projectTable = new JTable(this.projectListModel.getTableModel());
    JScrollPane tableContainer = new JScrollPane(projectTable);
    tableContainer.setPreferredSize(new Dimension(896, 432));
    tableContainer.setMinimumSize(new Dimension(896, 432));
    tableContainer.setMaximumSize(new Dimension(896, 432));
    GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setY(3).width(1).build();
    this.add(tableContainer, gridCtr_4.getConstraint());
  }

  public void addClickRowListener(MouseListener listener) {
    projectTable.addMouseListener(listener);
  }

  public void update() {

  }
}