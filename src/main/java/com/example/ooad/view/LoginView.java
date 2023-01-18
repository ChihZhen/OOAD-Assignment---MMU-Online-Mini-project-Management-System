package com.example.ooad.view;

import java.awt.*;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.utils.GridBagAdder;

@Component
public class LoginView extends JFrame {
    private JTextField idInput;
    private JTextField passwordInput;
    private JButton loginButton;

    public LoginView() {
        GridBagAdder gridBagAdder;

        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(new Color(87, 148, 195));
        leftPanel.setForeground(Color.WHITE);

        Font font = new Font("Source Code Pro", 1, 18);

        JLabel systemLabel1 = new JLabel("MMU Online");
        systemLabel1.setForeground(Color.white);
        systemLabel1.setFont(font);

        JLabel systemLabel2 = new JLabel("Mini Project");
        systemLabel2.setForeground(Color.white);
        systemLabel2.setFont(font);

        JLabel systemLabel3 = new JLabel("Management System");
        systemLabel3.setForeground(Color.white);
        systemLabel3.setFont(font);

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().build();
        leftPanel.add(systemLabel1, gridBagAdder.getConstraint());
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(1).build();
        leftPanel.add(systemLabel2, gridBagAdder.getConstraint());
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(2).build();
        leftPanel.add(systemLabel3, gridBagAdder.getConstraint());

        JPanel rightPanel = new JPanel(new GridBagLayout());

        JLabel formTitle = new JLabel("User Login");
        formTitle.setFont(new java.awt.Font("Arial", 1, 24));

        JLabel idLabel = new JLabel("ID");

        idInput = new JTextField();
        idInput.setPreferredSize(new Dimension(140, 22));

        JLabel passwordLabel = new JLabel("Password");

        passwordInput = new JTextField();
        passwordInput.setPreferredSize(new Dimension(140, 22));

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(7, 80, 164));
        loginButton.setForeground(Color.white);

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().build();
        rightPanel.add(formTitle, gridBagAdder.getConstraint());

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(1).marginT(75).anchor(GridBagConstraints.LINE_START)
                .build();
        rightPanel.add(idLabel, gridBagAdder.getConstraint());

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(2).build();
        rightPanel.add(idInput, gridBagAdder.getConstraint());

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(3).marginT(15).anchor(GridBagConstraints.LINE_START)
                .build();
        rightPanel.add(passwordLabel, gridBagAdder.getConstraint());

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(4).build();
        rightPanel.add(passwordInput, gridBagAdder.getConstraint());

        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setY(5).marginT(50).build();
        rightPanel.add(loginButton, gridBagAdder.getConstraint());

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
    }

    public JButton getLoginButton() {
        return this.loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

    public JTextField getIdInput() {
        return this.idInput;
    }

    public void setIdInput(JTextField idInput) {
        this.idInput = idInput;
    }

    public JTextField getPasswordInput() {
        return this.passwordInput;
    }

    public void setPasswordInput(JTextField passwordInput) {
        this.passwordInput = passwordInput;
    }
}
