package com.example.ooad.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.model.IModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

@Component
public class LecturerAssignStudentView extends JDialog implements Observer<IModel> {

    private StudentModel studentModel;
    private JButton selectButton;
    private JTable studentTable;
    private Vector<String> header = new Vector<String>() {
        {
            add("Student Id");
            add("Student Name");
        }
    };

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

    public static void add(JDialog dialog, JComponent comp, int x, int y, int width,
            int height, int marginT,
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

    public LecturerAssignStudentView(StudentModel studentModel) {
        this.studentModel = studentModel;
        this.studentModel.registerObserver(this);

        this.setModal(true);
        this.setTitle("Assign Student");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);


        studentTable = new JTable();

        JScrollPane tableContainer = new JScrollPane(studentTable);
        tableContainer.setPreferredSize(new Dimension(400, 432));
        tableContainer.setMinimumSize(new Dimension(400, 432));
        tableContainer.setMaximumSize(new Dimension(400, 432));

        add(this, tableContainer, 0, 1, 2, 1);

        selectButton = new JButton("Select");
        add(this, selectButton, 1, 2, 1, 1, 15, 0, 0, 0, GridBagConstraints.BASELINE_TRAILING);
    }

    public JButton getSelectButton() {
        return this.selectButton;
    }

    public void setSelectButton(JButton selectButton) {
        this.selectButton = selectButton;
    }

    public JTable getStudentTable() {
        return this.studentTable;
    }

    public void setStudentTable(JTable studentTable) {
        this.studentTable = studentTable;
    }

    // public static void main(String[] args) {
    // new AssignStudentView();
    // }

    public void update(Observable<IModel> _observable, IModel model) {
        System.out.println("lecturerassignstudent.update >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(studentModel.getIdAndName());

        studentTable.setModel(new DefaultTableModel(studentModel.getIdAndName(), header));
    };
}
