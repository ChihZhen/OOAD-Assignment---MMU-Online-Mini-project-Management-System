package com.example.ooad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.example.ooad.OoadApplication;

@Component
public class ProjectListModel extends Observable {

    private List<ProjectModel> projects = new ArrayList<ProjectModel>();
    private static DefaultTableModel lecturertableModel = new DefaultTableModel();
    // private static DefaultTableModel studentTableModel = new DefaultTableModel();
    private OoadApplication ooadApplication;
    private UserModel authUser;

    private String reportData;

    public ProjectModel getProject(int index) {
        return projects.get(index);
    }

    public List<ProjectModel> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectModel> projects) {
        this.projects = projects;
        notifyObservers();
    }

    public Vector<Vector<String>> getLecturerData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
            data.add(project.getLecturerVector());
        }
        return data;
    }

    public Vector<Vector<String>> getStudentData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
            data.add(project.getStudentVector());
        }
        return data;
    }

    public Vector<Vector<String>> getAdminData() {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        for (ProjectModel project : projects) {
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
        for (ProjectModel project : projects) {
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
        for (ProjectModel project : projects) {
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
        for (ProjectModel project : projects) {
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
        for (ProjectModel project : projects) {
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
        for (ProjectModel project : projects) {
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
        for (ProjectModel project : projects) {
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
