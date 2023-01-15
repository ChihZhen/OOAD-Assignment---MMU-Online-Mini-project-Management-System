package com.example.ooad.controller;

import com.example.ooad.view.AdminProjectDetailView;
import java.awt.event.*;
import java.util.List;

public class AdminProjectDetailController {
  private AdminProjectDetailView adminProjectDetailView;

  public AdminProjectDetailController(AdminProjectDetailView adminProjectDetailView) {
    this.adminProjectDetailView = adminProjectDetailView;
  }

  public void init() {

    // loadData();az
    // studentProjectListView.setVisible(true);
  }

  public void show() {

    adminProjectDetailView.setVisible(true);
  }

}
