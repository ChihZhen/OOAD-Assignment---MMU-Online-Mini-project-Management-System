package com.example.ooad.model;

import java.util.Vector;

import org.springframework.stereotype.Component;

import com.example.ooad.entity.Project;
import com.example.ooad.entity.Student;
import com.example.ooad.repository.ProjectRepository;

@Component
public class ProjectModel extends Model<Project> {

    private ProjectRepository repository;
    // private String reportData;

    public ProjectModel(ProjectRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void loadBySpecialization(String specialization) {
        setList(repository.findBySpecialization(specialization));
        // notifyObservers(this);
    }

    public void loadByStatus(String status) {
        setList(repository.findByStatus(status));
        // notifyObservers(this);
    }

    public void loadByComment(Boolean commented) {
        if (commented) {
            setList(repository.findByCommentsIsNotNull());
        } else {
            setList(repository.findByCommentsIsNull());
        }
        // notifyObservers(this);
    }

    public void loadByAssign(Boolean assigned) {
        if (assigned) {
            setList(repository.findByStudentIsNotNull());
        } else {
            setList(repository.findByStudentIsNull());
        }
        // notifyObservers(this);
    }

    public void loadByLecturerId(String id) {
        setList(repository.findByLecturerAccountId(id));
        // notifyObservers(this);
    }

    public void loadLecturerData() {
        setList(repository.findByLecturerAccountId(authUser.getAccountId()));
    }

    public void loadAdminData() {
        setList(repository.findAll());
    }

    public void loadStudentData() {
        current = ((Student) authUser).getProject();
        setList(repository.findBySpecializationAndStatus(((Student) authUser).getSpecialization(), "Active"));
    }

    public Vector<Vector<String>> getLecturerData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (Project project : list) {
            data.add(project.getLecturerVector());
        }
        return data;
    }

    public Vector<Vector<String>> getStudentData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (Project project : list) {
            data.add(project.getStudentVector());
        }
        return data;
    }

    public Vector<Vector<String>> getAdminData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (Project project : list) {
            data.add(project.getAdminVector());
        }
        return data;
    }

    public String getReportData() {
        String data = new String();
        for (Project project : list) {
            data += project.toReportStr();
            data += "\n";
        }
        return data;
    }

    // public void clear() {
    // list.clear();
    // current = null;
    // notifyObservers(this);
    // }

}
