package com.example.ooad.utils;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<Observer<T>>();

    public void registerObserver(Observer<T> observer) {
        observers.add(observer);
    };

    public void removeObserver(Observer<T> observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer<T> observer : observers) {
            observer.update(this);
        }
    }
}