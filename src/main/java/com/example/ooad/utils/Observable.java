package com.example.ooad.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.ooad.model.IModel;

public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<Observer<T>>();

    public void registerObserver(Observer<T> observer) {
        observers.add(observer);
    };

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers(T model) {
        for (Observer<T> observer : observers) {
            observer.update(this, model);
        }
    }
}