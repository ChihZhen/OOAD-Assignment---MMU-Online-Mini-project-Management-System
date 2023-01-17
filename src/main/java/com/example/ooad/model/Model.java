package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ooad.utils.Observable;

// import org.springframework.data.jpa.repository.Repository;

public abstract class Model<T> extends Observable {
    List<T> list = new ArrayList<T>();
    T current = null;
    JpaRepository<T, Long> repository;

    public Model(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    public T get(int i) {
        return list.get(i);
    }

    public T getCurrent() {
        return current;
    }

    public void setCurrent(int index) {
        current = list.get(index);
        notifyObservers();
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list.clear();
        this.list.addAll(list);
        notifyObservers();
    }

    public void load() {
        setList(repository.findAll());
        System.out.println(list);
    }

    public void save() {
        repository.save(current);
        load();
    }

    // public void save(T t) {
    // repository.save(t);
    // load();
    // }

    public void create(T t) {
        repository.save(t);
        load();
    }

    public void update(T t) {
        repository.save(t);
        load();
    }

    public void delete(T t) {
        repository.delete(t);
        load();
    }

    public void delete(int i) {
        repository.delete(list.get(i));
        load();
    }

}
