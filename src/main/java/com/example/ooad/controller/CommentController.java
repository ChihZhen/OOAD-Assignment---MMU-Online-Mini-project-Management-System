package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.CommentModel;
import com.example.ooad.entity.*;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.view.AdminProjectDetailView;
import com.example.ooad.view.CommentView;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class CommentController implements IController {
  private CommentView view;
  private ProjectModel projectModel;
  private CommentModel commentModel;
  private AdminProjectDetailView adminProjectDetailView;

  public CommentController(CommentView view, ProjectModel projectModel, CommentModel commentModel,
      AdminProjectDetailView adminProjectDetailView) {
    this.view = view;
    this.projectModel = projectModel;
    this.commentModel = commentModel;
    this.adminProjectDetailView = adminProjectDetailView;

    this.view.getSubmitButton().addActionListener(new SubmitButtonListener());

  }

  class SubmitButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      Admin admin = (Admin) commentModel.getAuthUser();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      LocalDateTime now = LocalDateTime.now();
      Comment comment = new Comment(dtf.format(now), view.getCommentsInput().getText(), projectModel.getCurrent(),
          admin);

      commentModel.create(comment);
      projectModel.loadAdminData();
      // commentRepo.save(commentView.getComment());
      // commentModel.reset();

      // adminProjectDetailView.getContentPane().removeAll();
      // adminProjectDetailView.getContentPane().revalidate();
      // adminProjectDetailView.getContentPane().repaint();
      // adminProjectDetailView.comp();
      view.dispose();

    }
  }

  public void show() {
    view.setVisible(true);
  }

  public void hide() {
    view.setVisible(false);
  }

}
