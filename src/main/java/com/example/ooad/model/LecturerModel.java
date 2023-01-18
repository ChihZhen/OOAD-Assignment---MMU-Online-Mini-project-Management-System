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
public class LecturerModel extends Model<Lecturer> {

    public LecturerModel(LecturerRepository lecturerRepository) {
        super(lecturerRepository);
    }

    public DefaultComboBoxModel<String> getComboBox() {
        Vector<String> name = new Vector<String>();
        for (Lecturer l : list) {
            name.addElement(l.getFullName());
        }
        return new DefaultComboBoxModel<String>(name);
    }

    public Vector<String> getNameAndId() {
        Vector<String> data = new Vector<String>();
        for (Lecturer l : list) {
            data.addElement(l.getFullName() + " - " + l.getAccountId());
        }
        return data;
    }

}
