package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ooad.entity.User;
import com.example.ooad.utils.Observable;

// import org.springframework.data.jpa.repository.Repository;

public abstract class Model<T> extends Observable<IModel> implements IModel {
    public static User authUser;

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
        notifyObservers(this);
    }

    public void setCurrent(T t) {
        current = t;
        notifyObservers(this);
    }

    public List<T> getList() {
        return this.list;
    }

    public void setList(List<T> list) {
        this.list = list;
        // this.list.clear();
        // this.list.addAll(list);
        notifyObservers(this);
    }

    public void load() {
        setList(repository.findAll());
        System.out.println(list);
    }

    public void save() {
        repository.save(current);
    }

    public void create(T t) {
        repository.save(t);
    }

    public void update(T t) {
        repository.save(t);
    }

    public void delete(T t) {
        repository.delete(t);
    }

    public void delete(int i) {
        repository.delete(list.get(i));
    }

    public void clear() {
        list.clear();
        current = null;
        notifyObservers(this);
    }

    public User getAuthUser() {
        return authUser;
    }

    public void setAuthUser(User user) {
        authUser = user;
    }
}
