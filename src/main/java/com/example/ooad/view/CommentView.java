package com.example.ooad.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Admin;
import com.example.ooad.model.AdminModel;
import com.example.ooad.model.CommentModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.IModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observer;
import com.example.ooad.utils.Observable;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class CommentView extends JDialog {
  private JTextArea commentsInput;

  // private ProjectModel projectModel;
  // private CommentModel commentModel;
  private JButton submitButton;

  public CommentView() {
    // this.projectModel = projectModel;
    // this.commentModel = commentModel;
    // projectModel.registerObserver(this);
    // commentModel.registerObserver(this);
    this.setModal(true);
    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    this.setLayout(new GridBagLayout());
    this.setSize(432, 600);
    this.setResizable(false);
    this.setTitle("Add Comments");
    this.addWindowListener(new WindowAdapter() {
      public void windowClosed(WindowEvent e) {
        commentsInput.setText("");
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

  // public void addClickSubmitListener(ActionListener Listener) {
  // submitButton.addActionListener(Listener);
  // }

  // public Comment getComment() {
  // Admin admin = (Admin) projectModel.getAuthUser();
  // DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
  // LocalDateTime now = LocalDateTime.now();
  // Comment comment = new Comment(dtf.format(now), this.projectModel,
  // commentsInput.getText(), admin);
  // return comment;
  // }

  // public void setProject(ProjectModel project) {
  // this.projectModel = project;
  // }

  // public void update(Observable<IModel> _observerable, IModel model) {
  // if (model instanceof ProjectModel) {

  // }
  // this.commentsInput.setText("");
  // }

  public JTextArea getCommentsInput() {
    return this.commentsInput;
  }

  public void setCommentsInput(JTextArea commentsInput) {
    this.commentsInput = commentsInput;
  }

  // public ProjectModel getProjectModel() {
  // return this.projectModel;
  // }

  // public void setProjectModel(ProjectModel projectModel) {
  // this.projectModel = projectModel;
  // }

  // public CommentModel getCommentModel() {
  // return this.commentModel;
  // }

  // public void setCommentModel(CommentModel commentModel) {
  // this.commentModel = commentModel;
  // }

  public JButton getSubmitButton() {
    return this.submitButton;
  }

  public void setSubmitButton(JButton submitButton) {
    this.submitButton = submitButton;
  }

}
