package com.example.ooad.view.Component;

import java.awt.*;
import javax.swing.*;


public class Report extends JPanel {
    private JTextArea jta;

    public Report() throws HeadlessException {
        setLayout(new FlowLayout());

        jta = new JTextArea(11, 30);
        JScrollPane JSCPane = new JScrollPane(
                jta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(JSCPane);
        JSCPane.setPreferredSize(new Dimension(672, 300));

        Font f = new Font("Verdana", Font.PLAIN, 16);
        jta.setFont(f);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
    }

    public void setData(String data) {
        jta.setText(data);
    }
}
