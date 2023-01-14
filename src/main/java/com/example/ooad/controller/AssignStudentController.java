package com.example.ooad.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.example.ooad.model.StudentListModel;
import com.example.ooad.model.StudentModel;
import com.example.ooad.repository.StudentRepository;
import com.example.ooad.view.AssignStudentView;

@Controller
public class AssignStudentController {
    private StudentRepository studentRepository;
    private AssignStudentView assignStudentView;
    private StudentListModel studentListModel;

    public AssignStudentController(StudentRepository studentRepository, AssignStudentView assignStudentView,
            StudentListModel studentListModel) {
        this.assignStudentView = assignStudentView;
        this.studentListModel = studentListModel;
        this.studentRepository = studentRepository;
    }

    public void init() {
        // ProjectView.
    }

    public void loadData(String specialization) {
        List<StudentModel> students = studentRepository.findStudentBySpecialization(specialization);
        studentListModel.setData(students);
    }

    public void show(String specialization) {
        loadData(specialization);
        assignStudentView.setVisible(true);
    }
}
