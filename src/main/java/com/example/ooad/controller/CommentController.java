package com.example.ooad.controller;

import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// ============= ENTITY
import com.example.ooad.entity.*;
// ============= MODEL
import com.example.ooad.model.CommentModel;
import com.example.ooad.model.ProjectModel;
// ============= VIEW
import com.example.ooad.view.CommentView;
// ============= CONTROLLER
import org.springframework.stereotype.Controller;

@Controller
public class CommentController implements IController {
  // ========================= Variables
  private CommentView view;
  private ProjectModel projectModel;
  private CommentModel commentModel;

  // ========================= Constructor
  public CommentController(CommentView view, ProjectModel projectModel, CommentModel commentModel) {
    this.view = view;
    this.projectModel = projectModel;
    this.commentModel = commentModel;
    // Initialize the event listener for the submit button
    this.view.getSubmitButton().addActionListener(new SubmitButtonListener());

  }

  // This will trigger when the submit button is clicked
  class SubmitButtonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      // Get the current authenticated / logged-in user
      Admin admin = (Admin) commentModel.getAuthUser();
      // Get the current Date and time
      LocalDateTime now = LocalDateTime.now();
      // Format the date and time
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
      // Create a comment Instance that will be used later on to save
      Comment comment = new Comment(dtf.format(now), view.getCommentsInput().getText(), projectModel.getCurrent(),
          admin);
      // Save the comment to the database
      commentModel.create(comment);
      // Find all projects
      projectModel.loadAdminData();
      // Clean up the view by disposing it
      view.dispose();

    }
  }

  // This will set the view to visible
  public void show() {
    view.setVisible(true);
  }

  // This will set the view to non-visible
  public void hide() {
    view.setVisible(false);
  }

}
