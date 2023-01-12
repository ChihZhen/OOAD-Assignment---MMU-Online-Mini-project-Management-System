package com.example.ooad.controller;

import com.example.ooad.model.*;
import com.example.ooad.repository.UserRepository;
import com.example.ooad.view.LoginView;

import java.awt.event.*;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

    private LoginView loginView;
    private UserRepository userRepository;

    @Autowired
    public LoginController(LoginView loginView, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.loginView = loginView;
        this.loginView.addSubmitEventListener(new SubmitListener());
    }

    public void show() {
        loginView.setVisible(true);
    }

    class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("HI");

            Hashtable<String, String> loginForm = loginView.getLoginForm();
            User user = userRepository.findByAccountId(loginForm.get("id"));
            System.out.println(userRepository);
            System.out.println(loginForm.get("id"));
            System.out.println(loginForm.get("password"));

            if (user == null) {
                JFrame jf = new JFrame();
                // loginView.add(new JOptionPane(jf,"Account not found"));
                JOptionPane.showMessageDialog(jf, "Acc", "Account not found", 0, null);
                // loginView.setVisible(true);
                System.out.println("Account not found");
            } else if (user.getPassword() == loginForm.get("password")) {
                loginView.add(new JOptionPane("password not correct"));
                System.out.println("password not correct");

            }

        }
    }

}
