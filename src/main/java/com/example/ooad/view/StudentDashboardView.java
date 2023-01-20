package com.example.ooad.view;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Project;
import com.example.ooad.model.IModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;

@Component
public class StudentDashboardView extends JFrame implements Observer<IModel> {
  private JTable projectTable;
  private JButton logoutButton;
  private ProjectModel projectModel;

  private JTabbedPane tp = new JTabbedPane();
  private JTextField projectInput = new JTextField();
  private JTextField titleInput = new JTextField();
  private JTextArea descriptionInput = new JTextArea();
  private JTextField specializationInput = new JTextField();
  private JTextField assignorInput = new JTextField();

  JPanel panel = new JPanel();
  JPanel innerPanel = new JPanel();
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

  public void addClickLogoutButtonListener(ActionListener listener) {
    logoutButton.addActionListener(listener);
  }

  public StudentDashboardView(ProjectModel projectModel) {
    this.projectModel = projectModel;
    this.projectModel.registerObserver(this);
    panel.setLayout(new GridBagLayout());
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    this.setPreferredSize(new Dimension(1440, 900));
    this.setMinimumSize(new Dimension(1440, 900));
    innerPanel.setLayout(new GridBagLayout());
    logoutButton = new JButton("Logout");
    GridBagAdder gridCtr1 = new GridBagAdder.GridBagAdderBuilder().setX(1)
        .anchor(GridBagConstraints.BASELINE_TRAILING).build();
    this.add(logoutButton, gridCtr1.getConstraint());
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

    GridBagAdder gridCtr_6 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2)
        .anchor(GridBagConstraints.LINE_START).build();

    // ===== Project Label
    JLabel projectIdLabel = new JLabel("Project ID");
    GridBagAdder gridCtr_id = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();
    innerPanel.add(projectIdLabel, gridCtr_id.getConstraint());

    // ===== Project Input
    projectInput = new JTextField();
    projectInput.setPreferredSize(new Dimension(200, 22));
    projectInput.setMinimumSize(new Dimension(200, 22));
    projectInput.setEditable(false);
    GridBagAdder gridCtr_input = new GridBagAdder.GridBagAdderBuilder().setX(1).build();
    innerPanel.add(projectInput, gridCtr_input.getConstraint());

    // ===== Title Label
    JLabel titleLabel = new JLabel("Title");
    GridBagAdder gridCtr_title = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(1).marginT(20)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();
    innerPanel.add(titleLabel, gridCtr_title.getConstraint());

    // ===== Title Input
    titleInput = new JTextField("");
    titleInput.setPreferredSize(new Dimension(200, 22));
    titleInput.setMinimumSize(new Dimension(200, 22));
    titleInput.setEditable(false);
    GridBagAdder gridCtr_title_input = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(20).build();
    innerPanel.add(titleInput, gridCtr_title_input.getConstraint());

    // ===== Specialization Title
    JLabel specializationTitle = new JLabel("Specialization");
    GridBagAdder gridCtr_3 = new GridBagAdder.GridBagAdderBuilder().setY(2)
        .marginR(15).build();
    innerPanel.add(specializationTitle, gridCtr_3.getConstraint());

    // ===== Specialization Input
    specializationInput = new JTextField("");
    specializationInput.setPreferredSize(new Dimension(200, 22));
    specializationInput.setMinimumSize(new Dimension(200, 22));
    specializationInput.setEditable(false);
    GridBagAdder gridCtr_special_input = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginT(20).marginB(20)
        .build();
    innerPanel.add(specializationInput, gridCtr_special_input.getConstraint());

    // ===== Description Title
    JLabel descriptionTitle = new JLabel("Description");
    GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setY(3)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    innerPanel.add(descriptionTitle, gridCtr_7.getConstraint());

    // ===== Description Input
    descriptionInput = new JTextArea();
    descriptionInput.setPreferredSize(new Dimension(200, 84));
    descriptionInput.setMinimumSize(new Dimension(200, 84));
    descriptionInput.setEditable(false);
    GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).build();
    innerPanel.add(descriptionInput, gridCtr_8.getConstraint());

    // ===== Assignor Label
    JLabel assignorLabel = new JLabel("Assignor");
    GridBagAdder gridCtr_9 = new GridBagAdder.GridBagAdderBuilder().setY(4).marginT(20).marginB(20)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    innerPanel.add(assignorLabel, gridCtr_9.getConstraint());

    // ===== Assignor Input
    assignorInput = new JTextField();
    assignorInput.setPreferredSize(new Dimension(200, 22));
    assignorInput.setMinimumSize(new Dimension(200, 22));
    assignorInput.setEditable(false);
    GridBagAdder gridCtr_10 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(4).marginT(20).marginB(20).build();
    innerPanel.add(assignorInput, gridCtr_10.getConstraint());
    panel.add(innerPanel);
    tp.setBounds(50, 50, 200, 200);
    tp.addTab("View Projects", tableContainer);
    tp.addTab("Assigned to me", panel);
    this.add(tp, gridCtr_6.getConstraint());
  }

  public void update(Observable<IModel> _observable, IModel model) {
    projectTable.setModel(new DefaultTableModel(projectModel.getStudentData(), header));

    Project project = projectModel.getCurrent();
    System.out.println("project ---------------->" + project);
    if (project == null) {
      panel.remove(innerPanel);
      panel.add(l);
      return;
    }
    panel.add(innerPanel);
    panel.remove(l);
    projectInput.setText(project.getId().toString());
    titleInput.setText(project.getTitle());
    specializationInput.setText(project.getSpecialization());
    descriptionInput.setText(project.getDescription());
    assignorInput.setText(project.getLecturer().getFullName());
  }

  public JTable getProjectTable() {
    return this.projectTable;
  }

  public void setProjectTable(JTable projectTable) {
    this.projectTable = projectTable;
  }

  public JButton getLogoutButton() {
    return this.logoutButton;
  }

  public void setLogoutButton(JButton logoutButton) {
    this.logoutButton = logoutButton;
  }

  public ProjectModel getProjectModel() {
    return this.projectModel;
  }

  public void setProjectModel(ProjectModel projectModel) {
    this.projectModel = projectModel;
  }

  public JPanel getPanel() {
    return this.panel;
  }

  public void setPanel(JPanel panel) {
    this.panel = panel;
  }

  public JLabel getL() {
    return this.l;
  }

  public void setL(JLabel l) {
    this.l = l;
  }

  public Vector<String> getHeader() {
    return this.header;
  }

  public void setHeader(Vector<String> header) {
    this.header = header;
  }

}