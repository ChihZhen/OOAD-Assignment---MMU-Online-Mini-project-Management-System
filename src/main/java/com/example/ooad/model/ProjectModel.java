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
import com.example.ooad.entity.User;
import com.example.ooad.repository.ProjectRepository;
// import com.example.ooad.repository.StudentRepository;

@Component
public class ProjectModel extends Model<Project, ProjectModel> {

    // private List<Project> projects = new ArrayList<Project>();
    // private static DefaultTableModel lecturertableModel = new
    // DefaultTableModel();
    // private static DefaultTableModel studentTableModel = new DefaultTableModel();
    // private OoadApplication ooadApplication;
    // private User authUser;

    private String reportData;

    private ProjectRepository repository;

    public ProjectModel(ProjectRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public void loadBySpecialization(String specialization) {
        setList(repository.findBySpecialization(specialization));
    }

    public void loadByLecturerId(Long id) {
        setList(repository.findByLecturerId(id));
    }

    // public Project getProject(int index) {
    // return projects.get(index);
    // }

    // public List<Project> getProjects() {
    // return projects;
    // }

    // public void setProjects(List<Project> projects) {
    // this.projects = projects;
    // notifyObservers();
    // }

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
        // String data = new String();
        // for (ProjectModel project : projects) {
        // data += project.toReportStr();
        // data += "\n";
        // }
        return reportData;

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
        notifyObservers();

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
        notifyObservers();

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
        notifyObservers();

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
        notifyObservers();
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
        notifyObservers();
    }

    public void setAllReport() {
        String data = new String();
        for (Project project : list) {
            data += project.toReportStr();
            data += "\n";
        }
        reportData = data;
        notifyObservers();
    }

    public void resetReport() {
        reportData = "";
        notifyObservers();
    }

}
