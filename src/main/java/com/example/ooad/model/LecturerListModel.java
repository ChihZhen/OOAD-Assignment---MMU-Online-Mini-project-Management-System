package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class LecturerListModel extends Observable {
    private List<LecturerModel> lecturers = new ArrayList<LecturerModel>();
    private static DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();

    public LecturerListModel() {
    }

    public LecturerModel getLecturer(int index) {
        return lecturers.get(index);
    }

    public void addLecturer(LecturerModel lecturer) {
        lecturers.add(lecturer);
    }

    public List<LecturerModel> getLecturer() {
        return lecturers;
    }

    public void setLecturers(List<LecturerModel> lecturers) {
        this.lecturers = lecturers;
        ArrayList<String> data = new ArrayList<String>();
        comboBoxModel.removeAllElements();
        for (LecturerModel lecturer : lecturers) {
            data.add(lecturer.getFullName());
        }
        comboBoxModel.removeAllElements();
        comboBoxModel.addAll(data);
        notifyObservers();
    }

    public DefaultComboBoxModel<String> getComboBox() {
        return this.comboBoxModel;
    }

}
