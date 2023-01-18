package com.example.ooad.model;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Project")
@Component
public class ProjectModel extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, description, status, specialization;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private LecturerModel lecturer;

    @OneToOne
    private StudentModel student;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project")
    private List<CommentModel> comments;

    public ProjectModel() {
    }

    public ProjectModel(String title, String description, String status, String specialization) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.specialization = specialization;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getSpecialization() {
        return this.specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<CommentModel> getComments() {
        return this.comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public LecturerModel getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(LecturerModel lecturer) {
        this.lecturer = lecturer;
    }

    public StudentModel getStudent() {
        return this.student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public Vector<String> getLecturerVector() {
        Vector<String> data = new Vector<>();
        data.add(Long.toString(id));
        data.add(title);
        data.add(specialization);
        data.add(status);
        if (student == null) {
            data.add("ASSIGN");
        } else {
            data.add(student.getFullName());
        }
        data.add("EDIT");
        data.add("DELETE");
        return data;
    }

    public Vector<String> getStudentVector() {
        Vector<String> data = new Vector<>();
        if (this.id == null) {
            return data;
        }
        data.add(this.id.toString());
        data.add(this.title);
        data.add(this.specialization);
        if (this.lecturer == null) {
            data.add("-");
        } else {
            data.add(this.lecturer.getFullName());
        }
        data.add(this.description);
        return data;
    }

    public Vector<String> getAdminVector() {
        Vector<String> data = new Vector<>();
        data.add(Long.toString(id));
        data.add(this.title);
        data.add(this.specialization);
        data.add(this.status);
        if (this.lecturer == null) {
            data.add("-");
        } else {
            data.add(this.lecturer.getFullName());
        }
        if (student == null) {
            data.add("-");
        } else {
            data.add(student.getFullName());
        }
        data.add("COMMENT");
        data.add("DELETE");
        return data;
    }

    public boolean isValid() {
        return !(title.isBlank() | description.isBlank());
    }

    public String toReportStr() {
        String data = new String();
        data += "ID: " + this.getId().toString() + "\n";
        data += "TITLE: " + this.getTitle() + "\n";
        data += "SPECIALIZATION: " + this.getSpecialization() + "\n";
        data += "DESCRIPTION: " + this.getDescription() + "\n";
        data += "STATUS: " + this.getStatus() + "\n";
        // data += "LECTURER: " + this.getCreator().getFullName() + " (" +
        // this.getCreator().getAccountId() + ")\n";
        // data += "STUDENT: " + this.getStudent().getFullName() + " (" +
        // this.getCreator().getAccountId() + ")\n";

        // if (comments.size() == 0) {
        // data += "COMMENT: - \n";

        // } else {
        // data += "COMMENT:\n";
        // for (CommentModel comment : comments) {
        // data += "\t" + comment.getAdmin().getFullName() + " (" +
        // comment.getAdmin().getAccountId() + "): "
        // + comment.getComment() + ")\n";
        // }
        // }
        return data;
    }

    public void set(ProjectModel project) {

        if (project != null) {
            this.id = project.getId();
            this.title = project.getTitle();
            this.description = project.getDescription();
            this.status = project.getStatus();
            this.specialization = project.getSpecialization();
            this.student = project.getStudent();
            this.lecturer = project.getLecturer();
            this.comments = project.getComments();
        }
        notifyObservers();
    }

    public void reset() {
        this.id = null;
        this.title = null;
        this.description = null;
        this.specialization = "Computer Science";
        this.status = "Active";
        this.student = null;
        this.lecturer = null;
        this.comments = null;
        notifyObservers();
    }

}
