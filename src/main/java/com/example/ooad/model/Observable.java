package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.example.ooad.view.Observer;

public class Observable {
    // public DefaultTableModel getTableModel();

    // public T getData();

    private List<Observer> observers = new ArrayList<Observer>();

    public void registerObserver(Observer observer) {
        observers.add(observer);
    };

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

}