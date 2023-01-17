package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Lecturer;
import com.example.ooad.repository.LecturerRepository;

@Component
public class LecturerModel extends Model<Lecturer, LecturerModel> {
    private List<Lecturer> lecturers = new ArrayList<Lecturer>();
    // private static DefaultComboBoxModel<String> comboBoxModel = new
    // DefaultComboBoxModel<String>();

    public LecturerModel(LecturerRepository lecturerRepository) {
        super(lecturerRepository);
    }

    public Lecturer getLecturer(int index) {
        return lecturers.get(index);
    }

    public void addLecturer(Lecturer lecturer) {
        lecturers.add(lecturer);
    }

    public List<Lecturer> getLecturer() {
        return lecturers;
    }

    // public void setLecturers(List<Lecturer> lecturers) {
    // this.lecturers = lecturers;
    // ArrayList<String> data = new ArrayList<String>();
    // comboBoxModel.removeAllElements();
    // for (Lecturer lecturer : lecturers) {
    // data.add(lecturer.getFullName());
    // }
    // comboBoxModel.removeAllElements();
    // comboBoxModel.addAll(data);
    // notifyObservers();
    // }

    public DefaultComboBoxModel<String> getComboBox() {
        Vector<String> name = new Vector<String>();
        for (Lecturer l : list) {
            name.addElement(l.getFullName());
        }
        return new DefaultComboBoxModel<String>(name);
    }

}
