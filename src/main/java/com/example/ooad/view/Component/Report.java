package com.example.ooad.view.Component;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Report extends JPanel {
    private JTextArea jta;

    public Report() throws HeadlessException {
        // super(title);
        // Sample 01: Set Size and Position
        // setBounds(100, 100, 672, 300);
        // Container ControlHost = getContentPane();
        setLayout(new FlowLayout());

        // Sample 02: Create Text Area
        jta = new JTextArea(11, 30);
        JScrollPane JSCPane = new JScrollPane(
                jta,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(JSCPane);
        JSCPane.setPreferredSize(new Dimension(672, 300));

        // Sample 04c: JTextArea with with Word Wrap (Step Run 4)
        Font f = new Font("Verdana", Font.PLAIN, 16);
        jta.setFont(f);
        jta.setLineWrap(true);
        jta.setWrapStyleWord(true);
    }

    public void setData(String data) {
        jta.setText(data);
    }
}
