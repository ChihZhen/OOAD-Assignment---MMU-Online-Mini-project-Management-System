package com.example.ooad.view.Component;

import java.awt.*;

import javax.swing.*;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.utils.GridBagAdder;

import com.example.ooad.view.Component.ReportTab;

public class ReportTab extends JPanel {
    private ProjectModel projectModel;
    private JPanel report;
    private JComboBox<String> selectionInput;
    private JButton generateButton;
    private JTextArea reportTextArea;

    private JScrollPane scrollPane;

    public ReportTab(String[] selection) {

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
        reportTextArea.setEditable(false);

        scrollPane = new JScrollPane(reportTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(672, 300));

        report = new JPanel(new FlowLayout());
        report.add(scrollPane);

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setY(1).width(7).build();
        this.add(report, gridCtr.getConstraint());

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

    public JButton getGenerateButton() {
        return this.generateButton;
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

    public JScrollPane getScrollPane() {
        return this.scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

}
