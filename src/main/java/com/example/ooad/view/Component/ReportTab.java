package com.example.ooad.view.Component;

import javax.swing.*;
import java.awt.*;

import com.example.ooad.model.IModel;
import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;

public class ReportTab extends JPanel {
    protected ProjectModel projectModel;
    protected JPanel report;
    protected JComboBox<String> selectionInput;
    protected JButton generateButton;
    protected JTextArea reportTextArea;

    // public ReportTab(ProjectModel projectModel) {
    // this.projectModel = projectModel;
    // this.projectModel.registerObserver(this);
    // selectionInput = new JComboBox<String>();
    // init();
    // }

    public ReportTab(String[] selection) {
        // this.projectModel.registerObserver(this);
        if (selection == null) {
            selectionInput = new JComboBox<String>();
            selectionInput.setVisible(false);
        } else {
            selectionInput = new JComboBox<String>(selection);
        }
        init();

    }

    private void init() {
        this.setLayout(new GridBagLayout());
        // selectionInput = new JComboBox<String>();
        generateButton = new JButton("Generate");
        GridBagAdder gridCtr;

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(3).build();
        this.add(selectionInput, gridCtr.getConstraint());

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(6).anchor(GridBagConstraints.BASELINE_TRAILING).build();
        this.add(generateButton, gridCtr.getConstraint());

        reportTextArea = new JTextArea(11, 30);
        Font f = new Font("Verdana", Font.PLAIN, 16);
        reportTextArea.setFont(f);
        reportTextArea.setLineWrap(true);
        reportTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(reportTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(672, 300));

        report = new JPanel(new FlowLayout());
        report.add(scrollPane);

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setY(1).width(7).build();
        this.add(report, gridCtr.getConstraint());
        // this.setVisible(true);
    }

    // public void setData(String data) {
    // report.setData(data);
    // }

    // public void setCombo(DefaultComboBoxModel<String> model) {
    // selectionInput.setModel(model);
    // }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JComboBox<String> getSelection() {
        return selectionInput;
    }

    public ProjectModel getProjectModel() {
        return this.projectModel;
    }

    public void setProjectModel(ProjectModel projectModel) {
        this.projectModel = projectModel;
    }

    public JPanel getReport() {
        return this.report;
    }

    public void setReport(JPanel report) {
        this.report = report;
    }

    public JComboBox<String> getSelectionInput() {
        return this.selectionInput;
    }

    public void setSelectionInput(JComboBox<String> selectionInput) {
        this.selectionInput = selectionInput;
    }

    public void setGenerateButton(JButton generateButton) {
        this.generateButton = generateButton;
    }

    public JTextArea getReportTextArea() {
        return this.reportTextArea;
    }

    public void setReportTextArea(JTextArea reportTextArea) {
        this.reportTextArea = reportTextArea;
    }

    // public void update(Observable<IModel> _observable, IModel model) {
    // System.out.print("reportabl.update");
    // if (model instanceof ProjectModel) {
    // System.out.print("reporttab.update.if");
    // reportTextArea.setText(projectModel.getReportData());
    // }
    // }

    // public static void main(String[] args) {

    // // new ReportTab(new String[] { "report", "hahaa" });
    // }

}
