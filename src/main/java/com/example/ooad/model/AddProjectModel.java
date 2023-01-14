package com.example.ooad.model;


import org.springframework.stereotype.Component;

@Component
public class AddProjectModel extends Observable {
    private String title, description;
    private String specialization = "Computer Science";
    private String status = "Active";

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isValid() {
        return !(title.isBlank() | description.isBlank());
    }

    public void reset() {
        title = null;
        description = null;
        specialization = "Computer Science";
        status = "Active";
        notifyObservers();
    }

}
