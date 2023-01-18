package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

// import com.example.ooad.OoadApplication;
import com.example.ooad.entity.Project;
import com.example.ooad.entity.Student;
import com.example.ooad.entity.User;
import com.example.ooad.repository.ProjectRepository;
// import com.example.ooad.repository.StudentRepository;

@Component
public class ProjectModel extends Model<Project> {

    private ProjectRepository repository;
    private String reportData;

    public ProjectModel(ProjectRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void loadBySpecialization(String specialization) {
        setList(repository.findBySpecialization(specialization));
        notifyObservers(this);

    }

    public void loadByStatus(String status) {
        setList(repository.findByStatus(status));
        notifyObservers(this);

    }

    public void loadByComment(Boolean commented) {
        if (commented) {
            setList(repository.findByCommentsIsNotNull());
        } else {
            setList(repository.findByCommentsIsNull());
        }
        notifyObservers(this);

    }

    public void loadByAssign(Boolean assigned) {
        if (assigned) {
            setList(repository.findByStudentIsNotNull());
        } else {
            setList(repository.findByStudentIsNull());
        }
        notifyObservers(this);

    }

    public void loadByLecturerId(String id) {
        System.out.println(id);
        setList(repository.findByLecturerAccountId(id));
        System.out.println(list);
        notifyObservers(this);
    }

    public void loadLecturerData() {
        setList(repository.findByLecturerId(authUser.getId()));
    }

    public void loadAdminData() {
        setList(repository.findAll());
    }

    public void loadStudentData() {
        setList(repository.findBySpecializationAndStatus(((Student) authUser).getSpecialization(), "Active"));
        current = ((Student) authUser).getProject();
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

    public void setReportByStatus(String status) {
        String data = new String();
        for (Project project : list) {
            if (project.getStatus().equals(status)) {
                data += project.toReportStr();
                data += "\n";
            }
        }
        reportData = data;
        notifyObservers(this);

        // return data;
    }

    public void setReportBySpecialization(String specialization) {
        String data = new String();
        for (Project project : list) {
            if (project.getSpecialization().equals(specialization)) {
                data += project.toReportStr();
                data += "\n";
            }
        }
        reportData = data;
        notifyObservers(this);

    }

    public void setReportByLecturer(String name) {
        String data = new String();
        for (Project project : list) {
            System.out.print(Objects.isNull(project.getLecturer()));
            if (!Objects.isNull(project.getLecturer())) {
                if (project.getLecturer().getFullName().equals(name)) {
                    data += project.toReportStr();
                    data += "\n";
                }
            }
        }
        reportData = data;
        notifyObservers(this);

    }

    public void setReportByAssign(String assign) {
        String data = new String();
        for (Project project : list) {
            if (assign.equals("Assigned")) {
                if (project.getStudent() != null) {
                    data += project.toReportStr();
                    data += "\n";
                }
            } else {
                if (project.getStudent() == null) {
                    data += project.toReportStr();
                    data += "\n";
                }

            }
        }
        reportData = data;
        notifyObservers(this);
    }

    public void setReportByComment(String comment) {
        String data = new String();
        for (Project project : list) {
            if (comment.equals("With Comment")) {
                if (project.getComments().size() != 0) {
                    data += project.toReportStr();
                    data += "\n";
                }
            } else {
                if (project.getComments().size() == 0) {
                    data += project.toReportStr();
                    data += "\n";
                }
            }
        }
        reportData = data;
        notifyObservers(this);
    }

    public void setAllReport() {
        String data = new String();
        for (Project project : list) {
            data += project.toReportStr();
            data += "\n";
        }
        reportData = data;
        notifyObservers(this);
    }

    public void resetReport() {
        reportData = "";
        notifyObservers(this);
    }

    public void clear() {
        list.clear();
        current = null;
        notifyObservers(this);
    }

}
