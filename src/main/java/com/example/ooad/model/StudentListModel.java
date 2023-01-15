package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class StudentListModel extends Observable {
    private List<StudentModel> students = new ArrayList<StudentModel>();
    private static DefaultTableModel tableModel = new DefaultTableModel();

    public StudentListModel() {
    }

    public StudentModel getStudent(int index) {
        return students.get(index);
    }

    public void addProject(StudentModel studentModel) {
        students.add(studentModel);
    }

    public List<StudentModel> getStudents() {
        return students;
    }

    // public void setStudents(List<StudentModel> Students) {
    // this.students = students;
    // }

    Vector<String> header = new Vector<String>() {
        {
            add("Id");
            add("Student Id");
            add("Student Name");
        }
    };

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setStudents(List<StudentModel> students) {
        this.students = students;
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (StudentModel student : students) {
            data.add(student.toVector());
        }
        tableModel.setDataVector(data, header);
        notifyObservers();
    }

    public void setData(List<StudentModel> students) {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (StudentModel student : students) {
            data.add(student.toVector());
        }
        tableModel.setDataVector(data, header);
        notifyObservers();
    }
}
