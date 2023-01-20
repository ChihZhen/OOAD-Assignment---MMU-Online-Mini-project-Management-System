package com.example.ooad.view;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.table.*;

import org.springframework.stereotype.Component;

import com.example.ooad.model.IModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.utils.GridBagAdder;
import com.example.ooad.utils.Observable;
import com.example.ooad.utils.Observer;

@Component
public class LecturerAssignStudentView extends JDialog implements Observer<IModel> {

    private StudentModel studentModel;
    private JButton selectButton;
    private JTable studentTable;
    private Vector<String> header = new Vector<String>() {
        {
            add("Student ID");
            add("Student Name");
        }
    };

    public LecturerAssignStudentView(StudentModel studentModel) {
        this.studentModel = studentModel;
        this.studentModel.registerObserver(this);

        this.setModal(true);
        this.setTitle("Assign Student");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new GridBagLayout());
        this.setSize(432, 600);
        this.setResizable(false);

        GridBagAdder gridBagAdder;

        studentTable = new JTable();

        JScrollPane tableContainer = new JScrollPane(studentTable);
        tableContainer.setPreferredSize(new Dimension(400, 432));
        tableContainer.setMinimumSize(new Dimension(400, 432));
        tableContainer.setMaximumSize(new Dimension(400, 432));
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().width(2).build();

        this.add(tableContainer, gridBagAdder.getConstraint());

        selectButton = new JButton("Select");
        gridBagAdder = new GridBagAdder.GridBagAdderBuilder().setX(1).setY(1).marginT(15)
                .anchor(GridBagConstraints.BASELINE_TRAILING).build();

        this.add(selectButton, gridBagAdder.getConstraint());
    }

    public void update(Observable<IModel> _observable, IModel model) {
        if (model instanceof StudentModel) {
            studentTable.setModel(new DefaultTableModel(studentModel.getIdAndName(), header));
        }
    };

    // Getter and Setter
    public StudentModel getStudentModel() {
        return this.studentModel;
    }

    public void setStudentModel(StudentModel studentModel) {
        this.studentModel = studentModel;
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

    public Vector<String> getHeader() {
        return this.header;
    }

    public void setHeader(Vector<String> header) {
        this.header = header;
    }

}
