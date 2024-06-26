package com.example.ooad.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import java.util.*;

import jakarta.persistence.*;

@Entity
@Table(name = "Project")
@Component
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title, description, status, specialization;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

    @OneToOne
    private Student student;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Comment> comments;

    public Project() {
    }

    public Project(String title, String description, String status, String specialization, Lecturer lecturer) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.specialization = specialization;
        this.lecturer = lecturer;
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

    public String toReportStr() {
        String data = new String();
        data += "ID: " + this.getId().toString() + "\n";
        data += "TITLE: " + this.getTitle() + "\n";
        data += "SPECIALIZATION: " + this.getSpecialization() + "\n";
        data += "DESCRIPTION: " + this.getDescription() + "\n";
        data += "STATUS: " + this.getStatus() + "\n";

        if (this.getLecturer() != null) {
            data += "LECTURER: " + this.getLecturer().getFullName() + " (" +
                    this.getLecturer().getAccountId() + ")\n";
        } else {
            data += "LECTURER: -\n";
        }
        if (this.getStudent() != null) {
            data += "STUDENT: " + this.getStudent().getFullName() + " (" +
                    this.getStudent().getAccountId() + ")\n";
        } else {
            data += "STUDENT: -\n";
        }
        if (comments.size() == 0) {
            data += "COMMENT: - \n";

        } else {
            data += "COMMENT:\n";
            for (Comment comment : comments) {
                data += "\t" + comment.getAdmin().getFullName() + " (" +
                        comment.getAdmin().getAccountId() + "): "
                        + comment.getMessage() + ")\n";
            }
        }
        return data;
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

    public List<Comment> getComments() {
        return this.comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Lecturer getLecturer() {
        return this.lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
