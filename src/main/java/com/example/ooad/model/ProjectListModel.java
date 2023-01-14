package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class ProjectListModel extends Observable {

    private List<ProjectModel> projects = new ArrayList<ProjectModel>();
    private static DefaultTableModel tableModel = new DefaultTableModel();

    Vector<String> header = new Vector<String>() {
        {
            add("Id");
            add("Title");
            add("Specialization");
            add("Status");
            add("Student");
            add("Action");
            add("");
        }
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
            data.add(project.toVector());
        }
        tableModel.setDataVector(data, header);
        notifyObservers();
    }

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }
}
