package com.example.ooad.view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;

import org.springframework.stereotype.Component;

import com.example.ooad.model.CommentModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

@Component
public class AdminProjectDetailView extends JDialog implements Observer {

  private JTextField titleInput;
  private JTextField specializationInput;
  private JTextField statusInput;
  private JTextArea descriptionInput;
  public int inc = 6;
  private ProjectModel projectModel;
  private Vector<String> comments = new Vector<String>() {
    {
      add("asdfasdf");
      add("second comment");
      add("third comments");
    }

  };

  public AdminProjectDetailView(ProjectModel projectModel) {
    this.projectModel = projectModel;
    projectModel.registerObserver(this);
    // this.setModal(true);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setSize(432, 600);
    this.setResizable(false);
    this.setTitle("View Project Detail");
    this.addWindowListener(new WindowAdapter() {
      public void windowClosed(WindowEvent e) {
        // update();
        projectModel.reset();
      }
    });

    // ===== Title Label
    JLabel titleLabel = new JLabel("Title");
    GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0)
        .width(1).height(1).anchor(GridBagConstraints.BASELINE_LEADING).build();

    this.add(titleLabel, gridCtr.getConstraint());

    // ===== Title Input
    titleInput = new JTextField("Title");
    titleInput.setPreferredSize(new Dimension(200, 22));
    titleInput.setMinimumSize(new Dimension(200, 22));
    titleInput.setEditable(false);
    GridBagAdder gridCtr_2 = new GridBagAdder.GridBagAdderBuilder().setX(1).build();
    this.add(titleInput, gridCtr_2.getConstraint());

    // ===== Specialization Title
    JLabel specializationTitle = new JLabel("Specialization");
    GridBagAdder gridCtr_3 = new GridBagAdder.GridBagAdderBuilder().setY(1).marginT(20).marginB(20)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(specializationTitle, gridCtr_3.getConstraint());

    // ===== Specialization Input
    specializationInput = new JTextField("Software Engineer");
    specializationInput.setPreferredSize(new Dimension(200, 22));
    specializationInput.setMinimumSize(new Dimension(200, 22));
    specializationInput.setEditable(false);
    GridBagAdder gridCtr_4 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(20).marginB(20).build();
    this.add(specializationInput, gridCtr_4.getConstraint());

    // ===== Status Title
    JLabel statusTitle = new JLabel("Status");
    GridBagAdder gridCtr_5 = new GridBagAdder.GridBagAdderBuilder().setY(2)
        .anchor(GridBagConstraints.BASELINE_LEADING)
        .build();
    this.add(statusTitle, gridCtr_5.getConstraint());
    // ===== Status Input
    statusInput = new JTextField("Active");
    statusInput.setEditable(false);
    statusInput.setPreferredSize(new Dimension(200, 22));
    statusInput.setMinimumSize(new Dimension(200, 22));
    GridBagAdder gridCtr_6 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(2).marginB(20).build();
    this.add(statusInput, gridCtr_6.getConstraint());

    // ===== Description Title
    JLabel descriptionTitle = new JLabel("Description");
    GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setY(3)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(descriptionTitle, gridCtr_7.getConstraint());

    descriptionInput = new JTextArea("Description");
    descriptionInput.setPreferredSize(new Dimension(200, 84));
    descriptionInput.setEditable(false);
    descriptionInput.setMinimumSize(new Dimension(200, 84));
    GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(3).marginB(20).build();
    this.add(descriptionInput, gridCtr_8.getConstraint());

    JLabel commentLabel = new JLabel("Comments");
    GridBagAdder gridCtr_9 = new GridBagAdder.GridBagAdderBuilder().setY(4).marginB(15)
        .anchor(GridBagConstraints.BASELINE_LEADING)
        .build();
    this.add(commentLabel, gridCtr_9.getConstraint());
    // JLabel nameInput;
    JPanel commentSection = new JPanel();
    commentSection.setLayout(new GridBagLayout());
    JScrollPane scrollable = new JScrollPane();
    for (int i = 0; i < comments.size(); i++) {
      System.out.println(inc);
      JTextField message = new JTextField(comments.get(i));
      JLabel name = new JLabel("Jason");
      JTextField time = new JTextField("12-03-2022 17:25:30");
      time.setPreferredSize(new Dimension(200, 22));
      time.setEditable(false);
      time.setMinimumSize(new Dimension(200, 22));
      time.setEditable(false);

      message.setEditable(false);
      message.setPreferredSize(new Dimension(200, 22));
      message.setMinimumSize(new Dimension(200, 22));
      message.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      time.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      Font newTextFieldFont = new Font(time.getFont().getName(), time.getFont().getStyle(), 10);
      time.setFont(newTextFieldFont);
      GridBagAdder gridCtr_com_2 = new GridBagAdder.GridBagAdderBuilder().setY((inc))
          .anchor(GridBagConstraints.BASELINE_LEADING).build();
      inc++;

      GridBagAdder gridCtr_com_3 = new GridBagAdder.GridBagAdderBuilder().setY(inc).marginB(5).build();
      inc++;

      GridBagAdder gridCtr_com = new GridBagAdder.GridBagAdderBuilder().setY(inc).marginB(20).build();
      this.add(name, gridCtr_com_2.getConstraint());
      this.add(message, gridCtr_com.getConstraint());
      this.add(time, gridCtr_com_3.getConstraint());
      inc++;
    }
    GridBagAdder comment_grid = new GridBagAdder.GridBagAdderBuilder().setY(5).marginB(15)
        .anchor(GridBagConstraints.BASELINE_LEADING)
        .build();
    // commentSection.add(scrollable, comment_grid.getConstraint());
    scrollable.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

    this.setVisible(true);
  }

  public void update() {
    // titleInput.setText(projectModel.getTitle());
    // descriptionInput.setText(projectModel.getDescription());
    // specializationInput.setSelectedItem(projectModel.getSpecialization());
    // statusInput.setSelectedItem(projectModel.getStatus());
    titleInput.setText("Title 1");
    descriptionInput.setText("asdfasdf");
    specializationInput.setText("Software Engineer");
    statusInput.setText("Active");
  }
}
