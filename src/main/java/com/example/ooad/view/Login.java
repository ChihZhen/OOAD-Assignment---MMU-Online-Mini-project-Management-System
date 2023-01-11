package com.example.ooad.view;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public static void add(JPanel panel, JComponent comp, int x, int y, int width, int height) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(2, 2, 2, 2);
        constr.anchor = GridBagConstraints.CENTER;
        panel.add(comp, constr);
    }

    public static void add(JPanel panel, JComponent comp, int x, int y, int width, int height, int marginT, int marginR,
            int marginB, int marginL) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = GridBagConstraints.CENTER;
        panel.add(comp, constr);
    }

    public static void add(JPanel panel, JComponent comp, int x, int y, int width, int height, int marginT, int marginR,
            int marginB, int marginL, int anchor) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = anchor;
        panel.add(comp, constr);
    }

    public Login() {
        JLabel systemLabel1 = new JLabel("MMU Online");
        systemLabel1.setForeground(Color.white);
        systemLabel1.setFont(new Font("Source Code Pro", 1, 18));

        JLabel systemLabel2 = new JLabel("Mini Project");
        systemLabel2.setForeground(Color.white);
        systemLabel2.setFont(new Font("Source Code Pro", 1, 18));

        JLabel systemLabel3 = new JLabel("Management System");
        systemLabel3.setForeground(Color.white);
        systemLabel3.setFont(new Font("Source Code Pro", 1, 18));

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(87, 148, 195));
        leftPanel.setForeground(Color.WHITE);
        add(leftPanel, systemLabel1, 0, 0, 1, 1);
        add(leftPanel, systemLabel2, 0, 1, 1, 1);
        add(leftPanel, systemLabel3, 0, 2, 1, 1);

        JLabel formTitle = new JLabel("User Login");
        formTitle.setFont(new java.awt.Font("Arial", 1, 24));

        JLabel idLabel = new JLabel("ID");
        JTextField idInput = new JTextField();
        idInput.setPreferredSize(new Dimension(140, 22));

        JLabel passwordLabel = new JLabel("Password");
        JTextField passwordInput = new JTextField();
        passwordInput.setPreferredSize(new Dimension(140, 22));

        JButton loginButton = new JButton("Login");
        loginButton.setBackground(new Color(7, 80, 164));
        loginButton.setForeground(Color.white);

        JPanel rightPanel = new JPanel(new GridBagLayout());
        add(rightPanel, formTitle, 0, 0, 1, 1);
        add(rightPanel, idLabel, 0, 1, 1, 1, 75, 0, 0, 0, GridBagConstraints.LINE_START);
        add(rightPanel, idInput, 0, 2, 1, 1);
        add(rightPanel, passwordLabel, 0, 3, 1, 1, 15, 0, 0, 0, GridBagConstraints.LINE_START);
        add(rightPanel, passwordInput, 0, 4, 1, 1);
        add(rightPanel, loginButton, 0, 5, 1, 1, 50, 0, 0, 0);

        JSplitPane container = new JSplitPane();
        container.setPreferredSize(new Dimension(768, 432));
        container.setDividerLocation(384);
        container.setDividerSize(0);
        container.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(223, 223, 223), 1, true));
        container.setLeftComponent(leftPanel);
        container.setRightComponent(rightPanel);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setPreferredSize(new Dimension(1440, 900));
        this.setMinimumSize(new Dimension(1440, 900));

        this.add(container);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Login();
    }
}
