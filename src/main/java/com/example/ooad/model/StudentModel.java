package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Student;
import com.example.ooad.repository.StudentRepository;

@Component
public class StudentModel extends Model<Student> {
    private StudentRepository repository;

    public StudentModel(StudentRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void loadBySpecializationAndProjectIsNull(String specialization) {
        setList(repository.findBySpecializationAndProjectIsNull(specialization));
        notifyObservers(this);
    }

    public Vector<Vector<String>> getIdAndName() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (Student student : list) {
            data.add(new Vector<String>() {
                {
                    add(student.getAccountId());
                    add(student.getFullName());
                }
            });
        }
        return data;
    }
}
