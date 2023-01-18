package com.example.ooad.controller;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.CommentModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.repository.CommentRepository;
import com.example.ooad.view.AdminProjectDetailView;
import com.example.ooad.view.CommentView;

import java.awt.event.*;

@Controller
public class CommentController {
  private CommentView commentView;
  private ProjectModel projectModel;
  private CommentModel commentModel;
  private CommentRepository commentRepo;
  private AdminProjectDetailView adminProjectDetailView;

  public CommentController(CommentView commentView, ProjectModel projectModel, CommentModel commentModel,
      CommentRepository commentRepo, AdminProjectDetailView adminProjectDetailView) {
    this.commentView = commentView;
    this.projectModel = projectModel;
    this.commentModel = commentModel;
    this.commentRepo = commentRepo;
    this.adminProjectDetailView = adminProjectDetailView;
    // this.projectModel = projectModel;
    // this.projectTableModel = projectTableModel;
    // this.projectRepository = projectRepository;
    init();
  }

  private void init() {
    commentView.addClickSubmitListener(new ClickSubmitButtonListener());
    // show();
    // createUserView.setVisible(true);
    // createUserView.setModal(true);
  }

  class ClickSubmitButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

      commentRepo.save(commentView.getComment());
      commentModel.reset();
      adminProjectDetailView.getContentPane().removeAll();
      adminProjectDetailView.getContentPane().removeAll();
      adminProjectDetailView.getContentPane().revalidate();
      adminProjectDetailView.getContentPane().repaint();
      adminProjectDetailView.comp();
      commentView.dispose();

    }
  }

  public void show(ProjectModel project) {
    projectModel.set(project);
    commentView.setProject(project);
    commentView.setVisible(true);
  }

}
