package com.example.ooad.model;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class ProjectTableModel {
    private static DefaultTableModel TableModel = new DefaultTableModel();

    public ProjectTableModel() {
        // this.TableModel = new DefaultTableModel();
    }

    public DefaultTableModel getTableModel() {
        return this.TableModel;
    }

    public void setTableModel(DefaultTableModel TableModel) {
        this.TableModel = TableModel;
    }
}
