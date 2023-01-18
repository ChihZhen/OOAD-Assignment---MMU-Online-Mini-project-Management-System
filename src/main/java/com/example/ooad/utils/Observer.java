package com.example.ooad.utils;

import com.example.ooad.model.IModel;

public interface Observer<T> {
    public void update(Observable<T> observable, T model);
}