package com.example.ooad.view.Component;

import javax.swing.*;
import java.awt.*;

import com.example.ooad.utils.GridBagAdder;

public class ReportTab extends JPanel {
    Report report;
    JComboBox<String> selection;
    JButton generateButton;

    public ReportTab() {
        this.setLayout(new GridBagLayout());
        report = new Report();
        selection = new JComboBox<String>();
        generateButton = new JButton("Generate");
        GridBagAdder gridCtr;

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(4).build();
        this.add(selection, gridCtr.getConstraint());

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setX(6).build();
        this.add(generateButton, gridCtr.getConstraint());

        gridCtr = new GridBagAdder.GridBagAdderBuilder().setY(1).width(7).build();
        this.add(report, gridCtr.getConstraint());
        this.setVisible(true);
    }

    public void setData(String data) {
        report.setData(data);
    }

    public void setCombo(DefaultComboBoxModel<String> model) {
        selection.setModel(model);
    }

    public JButton getGenerateButton() {
        return generateButton;
    }

    public JComboBox<String> getSelection() {
        return selection;
    }

    public static void main(String[] args) {
        new ReportTab();
    }

}
