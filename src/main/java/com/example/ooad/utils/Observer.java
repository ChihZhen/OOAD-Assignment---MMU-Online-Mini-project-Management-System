package com.example.ooad.utils;

public interface Observer<T> {
    public void update(Observable<T> observable);
}