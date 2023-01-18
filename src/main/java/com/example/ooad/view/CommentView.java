package com.example.ooad.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;
import com.example.ooad.model.AdminModel;
import com.example.ooad.model.CommentModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class CommentView extends JDialog implements Observer {
  private JTextArea commentsInput;
  public int inc = 6;
  private ProjectModel projectModel;
  private CommentModel commentModel;
  private JButton submitButton;

  public CommentView(ProjectModel projectModel, CommentModel commentModel) {
    this.projectModel = projectModel;
    this.commentModel = commentModel;
    projectModel.registerObserver(this);
    commentModel.registerObserver(this);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setSize(432, 600);
    this.setResizable(false);
    this.setTitle("Add Comments");
    this.addWindowListener(new WindowAdapter() {
      public void windowClosed(WindowEvent e) {
        // update();
        commentModel.reset();
      }
    });

    // ===== Description Title
    JLabel commentsLabel = new JLabel("Comments");
    GridBagAdder gridCtr_7 = new GridBagAdder.GridBagAdderBuilder().setX(0).setY(0).marginB(20)
        .anchor(GridBagConstraints.BASELINE_LEADING).build();
    this.add(commentsLabel, gridCtr_7.getConstraint());

    commentsInput = new JTextArea();
    commentsInput.setPreferredSize(new Dimension(200, 84));
    commentsInput.setMinimumSize(new Dimension(200, 84));
    GridBagAdder gridCtr_8 = new GridBagAdder.GridBagAdderBuilder().setY(1).build();
    this.add(commentsInput, gridCtr_8.getConstraint());

    submitButton = new JButton("Submit");
    GridBagAdder gridCtr = new GridBagAdder.GridBagAdderBuilder().setY(2).marginT(30)
        .anchor(GridBagConstraints.LINE_START).build();
    this.add(submitButton, gridCtr.getConstraint());

  }

  public void addClickSubmitListener(ActionListener Listener) {
    submitButton.addActionListener(Listener);
  }

  public CommentModel getComment() {
    AdminModel admin = (AdminModel) OoadApplication.getLoginUser();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    CommentModel commentModel = new CommentModel(dtf.format(now), this.projectModel,
        commentsInput.getText(), admin);
    return commentModel;
  }

  public void setProject(ProjectModel project) {
    this.projectModel = project;
  }

  public void update() {
    this.commentsInput.setText("");
  }

}
