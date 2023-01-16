package com.example.ooad.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;
import com.example.ooad.model.ProjectListModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.model.UserModel;
import com.example.ooad.utils.GridBagAdder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@Component
public class StudentProjectListView extends JFrame implements Observer {
  private JTable projectTable;
  private ProjectListModel projectListModel;
  private ProjectModel projectModel;
  JPanel panel = new JPanel();
  JLabel l = new JLabel("You are not assigned with any project yet.");

  private Vector<String> header = new Vector<String>() {
    {
      add("ID");
      add("Title");
      add("Specialization");
      add("Assignor");
      add("Description");

    }
  };

  public StudentProjectListView(ProjectListModel projectListModel, ProjectModel projectModel, StudentModel student) {
    this.projectListModel = projectListModel;
    this.projectModel = projectModel;
    this.projectModel.registerObserver(this);
    this.projectListModel.registerObserver(this);

    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setPreferredSize(new Dimension(1440, 900));
    this.setMinimumSize(new Dimension(1440, 900));

    JLabel welcomeLabel = new JLabel("Welcome Back Student ");
    GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().width(2).marginB(25)
        .anchor(GridBagConstraints.LINE_START).build();
    this.add(welcomeLabel, gridCtr.getConstraint());

    JLabel projectLabel = new JLabel("Project");
    GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setY(1).width(2).marginB(25).build();
    this.add(projectLabel, gridCtr_2.getConstraint());

    projectTable = new JTable();
    projectTable.setEnabled(false);
    projectTable.getTableHeader().setReorderingAllowed(false);
    JScrollPane tableContainer = new JScrollPane(projectTable);
    tableContainer.setPreferredSize(new Dimension(896, 432));
    tableContainer.setMinimumSize(new Dimension(896, 432));
    tableContainer.setMaximumSize(new Dimension(896, 432));
    GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setY(3).width(2).build();
    this.add(tableContainer, gridCtr_4.getConstraint());

    JTabbedPane tp = new JTabbedPane();

    GridBagAdder gridCtr_6 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2)
        .anchor(GridBagConstraints.LINE_START).build();
    tp.setBounds(50, 50, 200, 200);
    tp.addTab("View Projects", tableContainer);
    tp.addTab("Assigned to me", panel);
    this.add(tp, gridCtr_6.getConstraint());
  }

  public void addClickRowListener(MouseListener listener) {
    projectTable.addMouseListener(listener);
  }

  public void update() {
    System.out.println("Project-------------->" + projectModel.getId());
    projectTable.setModel(new DefaultTableModel(projectListModel.getStudentData(), header));
    if (projectModel.getId() == null) {
      panel.add(l);
      return;
    }

    panel.remove(l);
    panel.setLayout(new GridBagLayout());
    // ===== Project Label
    JLabel projectIdLabel = new JLabel("Project ID");
    GridBagAdder gridCtr_id = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();
    panel.add(projectIdLabel, gridCtr_id.getConstraint());

    // ===== Project Input
    JTextField projectInput = new JTextField(projectModel.getId().toString());
    projectInput.setPreferredSize(new Dimension(200, 22));
    projectInput.setMinimumSize(new Dimension(200, 22));
    projectInput.setEditable(false);
    GridBagAdder gridCtr_input = new GridBagAdder.GridBagAdderBuilder().setX(1).build();
    panel.add(projectInput, gridCtr_input.getConstraint());

    // ===== Title Label
    JLabel titleLabel = new JLabel("Title");
    GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(1).marginT(20)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();
    panel.add(titleLabel, gridCtr.getConstraint());

    // ===== Title Input
    JTextField titleInput = new JTextField(projectModel.getTitle());
    titleInput.setPreferredSize(new Dimension(200, 22));
    titleInput.setMinimumSize(new Dimension(200, 22));
    titleInput.setEditable(false);
    GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(20).build();
    panel.add(titleInput, gridCtr_2.getConstraint());

    // ===== Specialization Title
    JLabel specializationTitle = new JLabel("Specialization");
    GridBagAdder gridCtr_3 = new GridBagAdder.GridBagAdderBuilder().setY(2)
        .marginR(15).build();
    panel.add(specializationTitle, gridCtr_3.getConstraint());

    // ===== Specialization Input
    JTextField specializationInput = new JTextField(projectModel.getSpecialization());
    specializationInput.setPreferredSize(new Dimension(200, 22));
    specializationInput.setMinimumSize(new Dimension(200, 22));
    specializationInput.setEditable(false);
    GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginT(20).marginB(20).build();
    panel.add(specializationInput, gridCtr_4.getConstraint());

    // ===== Description Title
    JLabel descriptionTitle = new JLabel("Description");
    GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setY(3)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    panel.add(descriptionTitle, gridCtr_7.getConstraint());

    // ===== Description Input
    JTextArea descriptionInput = new JTextArea(projectModel.getDescription());
    descriptionInput.setPreferredSize(new Dimension(200, 84));
    descriptionInput.setMinimumSize(new Dimension(200, 84));
    descriptionInput.setEditable(false);
    GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).build();
    panel.add(descriptionInput, gridCtr_8.getConstraint());

    // ===== Assignor Label
    JLabel assignorLabel = new JLabel("Assignor");
    GridBagAdder gridCtr_9 = new GridBagAdder.GridBagAdderBuilder().setY(4).marginT(20).marginB(20)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    panel.add(assignorLabel, gridCtr_9.getConstraint());

    // ===== Assignor Input
    JTextField assignorInput = new JTextField(projectModel.getLecturer().getFullName());
    assignorInput.setPreferredSize(new Dimension(200, 22));
    assignorInput.setMinimumSize(new Dimension(200, 22));
    assignorInput.setEditable(false);
    GridBagAdder gridCtr_10 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).marginT(20).marginB(20).build();
    panel.add(assignorInput, gridCtr_10.getConstraint());
  }
}