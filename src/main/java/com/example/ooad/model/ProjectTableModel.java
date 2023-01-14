package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.ProjectModel;
import com.example.ooad.view.Observer;

@Component
public class ProjectTableModel extends Observable {
    // private List<Observer> observers = new ArrayList<Observer>();
    private static DefaultTableModel tableModel = new DefaultTableModel();

    public ProjectTableModel() {
        // this.TableModel = new DefaultTableModel();
    }

    // public void registerObserver(Observer observer) {
    // observers.add(observer);
    // }

    // public void removeObserver(Observer observer) {
    // observers.remove(observer);
    // }

    // public void notifyObservers() {
    // for (Observer observer : observers) {
    // observer.update();
    // }
    // }

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

    public DefaultTableModel getTableModel() {
        return this.tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void setData(List<ProjectModel> projects) {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
            data.add(project.toVector());
        }
        tableModel.setDataVector(data, header);
        notifyObservers();
    }
}
