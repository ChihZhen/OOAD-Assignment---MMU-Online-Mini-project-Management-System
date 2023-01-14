package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;

import com.example.ooad.view.Observer;

public class Observable {

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