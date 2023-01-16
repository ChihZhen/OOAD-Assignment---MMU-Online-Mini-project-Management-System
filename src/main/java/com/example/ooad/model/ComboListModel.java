package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

@Component
public class ComboListModel extends Observable {
    private List<String> data = new ArrayList<String>();
    private static DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();

    public void setComboList(List<String> data) {
        this.data = data;
        comboBoxModel.removeAllElements();
        comboBoxModel.addAll(data);
        notifyObservers();
    }

    public DefaultComboBoxModel<String> getComboBox() {
        return this.comboBoxModel;
    }

}