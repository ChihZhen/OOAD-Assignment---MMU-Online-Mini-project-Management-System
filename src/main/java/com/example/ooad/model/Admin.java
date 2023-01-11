package com.example.ooad.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Admin extends User {
    @OneToMany(mappedBy = "admin")
    private List<Project> projects = new ArrayList<Project>();
}