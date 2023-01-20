package com.example.ooad.controller;

// ============= CONTROLLER
import org.springframework.stereotype.Controller;
// ============= VIEW
import com.example.ooad.view.AdminProjectDetailView;

@Controller
public class AdminProjectDetailController implements IController {
  // ========================= Variables
  private AdminProjectDetailView view;

  // ========================= Constructor
  public AdminProjectDetailController(AdminProjectDetailView view) {
    this.view = view;

  }

  // Reset the view by removing the content of the content panel,
  // Revalidate and repaint it
  // finally call the displayComponent() to render the component out
  public void resetView() {
    view.getContentPane().removeAll();
    view.getContentPane().revalidate();
    view.getContentPane().repaint();
    view.displayComponent();
  }

  // Set the admin project detail view to visible
  public void show() {
    view.setVisible(true);
  }

  // Set the admin project detail view to non-visible
  public void hide() {
    view.setVisible(false);
  }

}
