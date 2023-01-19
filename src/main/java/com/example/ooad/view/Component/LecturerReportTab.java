// package com.example.ooad.view.Component;

// import javax.swing.DefaultComboBoxModel;

// import com.example.ooad.entity.Project;
// import com.example.ooad.model.*;
// import com.example.ooad.utils.*;

// public class LecturerReportTab extends ReportTab {
// private LecturerModel lecturerModel;

// public LecturerReportTab(LecturerModel lecturerModel, ProjectModel
// projectModel) {
// super(projectModel);
// this.lecturerModel = lecturerModel;
// // selectionInput
// this.lecturerModel.registerObserver(this);
// }

// public void update(Observable<IModel> _observable, IModel model) {
// super.update(_observable, model);
// if (model instanceof LecturerModel) {
// System.out.println("lecturerReporttab.update
// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
// selectionInput.setModel(new
// DefaultComboBoxModel<String>(lecturerModel.getNameAndId()));
// }
// }
// }
