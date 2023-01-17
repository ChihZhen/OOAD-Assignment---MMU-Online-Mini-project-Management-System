package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Student;
import com.example.ooad.repository.StudentRepository;

@Component
public class StudentModel extends Model<Student, StudentModel> {
    // private List<Student> students = new ArrayList<Student>();
    // private static DefaultTableModel tableModel = new DefaultTableModel();
    private StudentRepository repository;

    public StudentModel(StudentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    // public Student getStudent(int index) {
    // return students.get(index);
    // }

    // public void addStudent(Student studentModel) {
    // students.add(studentModel);
    // }

    // public List<Student> getStudents() {
    // return students;
    // }

    public void loadBySpecialization(String specialization) {
        repository.findBySpecialization(specialization);
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

    // public DefaultTableModel getTableModel() {
    // return this.tableModel;
    // }

    // public void setTableModel(DefaultTableModel tableModel) {
    // this.tableModel = tableModel;
    // }

    // public void setStudents(List<Student> students) {
    // this.students = students;
    // Vector<Vector<String>> data = new Vector<Vector<String>>();
    // for (Student student : students) {
    // data.add(student.toVector());
    // }
    // tableModel.setDataVector(data, header);
    // notifyObservers();
    // }

    // public void setData(List<Student> students) {
    // Vector<Vector<String>> data = new Vector<Vector<String>>();
    // for (Student student : students) {
    // data.add(student.toVector());
    // }
    // tableModel.setDataVector(data, header);
    // notifyObservers();
    // }
}
