package com.example.ooad.view;

import javax.swing.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.ProjectModel;
import com.example.ooad.model.StudentModel;

import java.awt.*;
import java.awt.event.*;

@Component
public class CreateUserView extends JDialog implements Observer {

    private JTextField usernameInput;
    private JTextField idInput;
    private JComboBox<String> roleInput;
    private JButton submitButton;

    private StudentModel studentModel;

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(2, 2, 2, 2);
        constr.anchor = GridBagConstraints.CENTER;
        dialog.add(comp, constr);
    }

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height, int marginT,
            int marginR,
            int marginB, int marginL) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = GridBagConstraints.CENTER;
        dialog.add(comp, constr);
    }

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height, int marginT,
            int marginR,
            int marginB, int marginL, int anchor) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = anchor;
        dialog.add(comp, constr);
    }

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width, int height, int anchor) {
        GridBagConstraints constr = new GridBagConstraints();
        constr.gridx = x;
        constr.gridy = y;
        constr.gridheight = height;
        constr.gridwidth = width;
        // constr.insets = new Insets(marginT, marginL, marginB, marginR);
        constr.anchor = anchor;
        dialog.add(comp, constr);
    }

    // public CreateUserView(ProjectModel projectModel) {
    public CreateUserView(StudentModel studentModel) {

        this.studentModel = studentModel;
        studentModel.registerObserver(this);

        this.setModal(true);
        this.setTitle("Create User");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);
        // this.addWindowListener(new WindowAdapter() {
        // public void windowClosed(WindowEvent e) {
        // // update();
        // // projectModel.reset();
        // }
        // });

        JLabel usernameLabel = new JLabel("Username");
        add(this, usernameLabel, 0, 0, 1, 1, 0, 15, 0, 0, GridBagConstraints.BASELINE);

        usernameInput = new JTextField();
        usernameInput.setPreferredSize(new Dimension(200, 22));
        usernameInput.setMinimumSize(new Dimension(200, 22));
        add(this, usernameInput, 1, 0, 1, 1);

        JLabel idTitle = new JLabel("Id");
        add(this, idTitle, 0, 1, 1, 1, GridBagConstraints.BASELINE);

        idInput = new JTextField();
        idInput.setPreferredSize(new Dimension(200, 22));
        idInput.setMinimumSize(new Dimension(200, 22));
        add(this, idInput, 1, 1, 1, 1, 20, 0, 20, 0, GridBagConstraints.BASELINE);

        JLabel roleTitle = new JLabel("Role");
        add(this, roleTitle, 0, 2, 1, 1, GridBagConstraints.BASELINE);

        roleInput = new JComboBox<String>(
                new String[] { "Lecturer", "Admin", "Student" });
        roleInput.setPreferredSize(new Dimension(200, 22));
        roleInput.setMinimumSize(new Dimension(200, 22));
        add(this, roleInput, 1, 2, 1, 1, 0, 0, 20, 0);

        submitButton = new JButton("Submit");
        add(this, submitButton, 1, 3, 1, 1, 30, 0, 0, 0, GridBagConstraints.LINE_END);
        this.setVisible(true);
    }

    // public static void main(String[] args) {
    // new CreateUserView();
    // }

    public void addClickSubmitListener(ActionListener Listener) {
        submitButton.addActionListener(Listener);
    }

    public void setStudentModel() {
        studentModel.setAccountId(idInput.getText());
        studentModel.setFullName(getName());
        studentModel.setRole(roleInput.getSelectedItem().toString());
        // studentModel.setStatus(statusInput.getSelectedItem().toString());
    }

    public void update() {
        // titleInput.setText(projectModel.getTitle());
        // descriptionInput.setText(projectModel.getDescription());
        // specializationInput.setSelectedIndex(0);
        // statusInput.setSelectedIndex(0);
    }

    // public void setEditable(boolean editable) {
    // titleInput.setEditable(editable);
    // descriptionInput.setEditable(editable);
    // specializationInput.setEditable(editable);
    // statusInput.setEditable(editable);
    // }
}
