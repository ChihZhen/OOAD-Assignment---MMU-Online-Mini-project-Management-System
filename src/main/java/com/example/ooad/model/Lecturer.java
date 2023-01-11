package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Lecturer extends User {
    @OneToMany(mappedBy = "lecturer")
    private List<Project> projects = new ArrayList<Project>();

    public List<Project> getProjects() {
        return this.projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}