package com.example.ooad.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import org.springframework.stereotype.Component;

import com.example.ooad.utils.GridBagAdder;

import java.awt.*;
import java.awt.event.*;

@Component
public class CommentView extends JDialog {
  private JTextArea commentsInput;

  private JButton submitButton;

  public CommentView() {

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

  public JTextArea getCommentsInput() {
    return this.commentsInput;
  }

  public void setCommentsInput(JTextArea commentsInput) {
    this.commentsInput = commentsInput;
  }

  public JButton getSubmitButton() {
    return this.submitButton;
  }

  public void setSubmitButton(JButton submitButton) {
    this.submitButton = submitButton;
  }

}
