package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;

@Component
public class ProjectListModel extends Observable {

    private List<ProjectModel> projects = new ArrayList<ProjectModel>();
    private static DefaultTableModel tableModel = new DefaultTableModel();
    private UserModel authUser = OoadApplication.getLoginUser();

    public Vector<String> getHeader() {
        Vector<String> header = new Vector<>();
        header.add("Id");
        header.add("Specialization");
        header.add("Title");
        // if (authUser.getRole() == "Lecturer") {
        // header.add("Status");
        // header.add("Student");
        // header.add("Action");
        // header.add("");
        // return header;
        // }
        header.add("Status");
        header.add("Student");
        header.add("Action");
        header.add("");
        header.add("");
        return header;
    };

    public ProjectListModel() {
    }

    public ProjectModel getProject(int index) {
        return projects.get(index);
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
            data.add(project.getLecturerVector());
        }
        tableModel.setDataVector(data, getHeader());
        notifyObservers();
    }

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }
}
