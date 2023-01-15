package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;

@Component
public class ProjectListModel extends Observable {

    private List<ProjectModel> projects = new ArrayList<ProjectModel>();
    private static DefaultTableModel lecturertableModel = new DefaultTableModel();
    // private static DefaultTableModel studentTableModel = new DefaultTableModel();
    private OoadApplication ooadApplication;
    private UserModel authUser;

    public ProjectModel getProject(int index) {
        return projects.get(index);
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
        notifyObservers();
    }

    public Vector<Vector<String>> getLecturerData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
            data.add(project.getLecturerVector());
        }
        return data;
    }

    public Vector<Vector<String>> getStudentData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
            data.add(project.getStudentVector());
        }
        return data;
    }
}
