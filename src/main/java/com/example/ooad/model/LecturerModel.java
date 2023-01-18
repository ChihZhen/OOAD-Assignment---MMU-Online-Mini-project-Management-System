package com.example.ooad.model;

import java.util.Vector;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Lecturer;
import com.example.ooad.repository.LecturerRepository;

@Component
public class LecturerModel extends Model<Lecturer> {

    public LecturerModel(LecturerRepository lecturerRepository) {
        super(lecturerRepository);
    }

    public Vector<String> getNameAndId() {
        Vector<String> data = new Vector<String>();
        for (Lecturer l : list) {
            data.addElement(l.getFullName() + " (" + l.getAccountId() + ")");
        }
        return data;
    }

}
