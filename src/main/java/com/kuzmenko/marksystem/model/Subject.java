package com.kuzmenko.marksystem.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "subject")
    private String subject;
    @Column(name = "teacherfirstname")
    private String teacherFirstName;
    @Column(name = "teacherlastname")
    private String teacherLastName;
    @Column(name = "enteryear")
    private Integer enterYear;
    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Mark> marks;

    public Subject() {
    }

    public Subject(String subject, String teacherFirstName, String teacherLastName, Integer enterYear) {
        this.subject = subject;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.enterYear = enterYear;
    }

    public Subject(Integer id, String subject, String teacherFirstName, String teacherLastName, Integer enterYear) {
        this.id = id;
        this.subject = subject;
        this.teacherFirstName = teacherFirstName;
        this.teacherLastName = teacherLastName;
        this.enterYear = enterYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public Integer getEnterYear() {
        return enterYear;
    }

    public void setEnterYear(Integer enterYear) {
        this.enterYear = enterYear;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", teacherFirstName='" + teacherFirstName + '\'' +
                ", teacherLastName='" + teacherLastName + '\'' +
                ", enterYear=" + enterYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject1 = (Subject) o;
        return Objects.equals(id, subject1.id) &&
                Objects.equals(subject, subject1.subject) &&
                Objects.equals(teacherFirstName, subject1.teacherFirstName) &&
                Objects.equals(teacherLastName, subject1.teacherLastName) &&
                Objects.equals(enterYear, subject1.enterYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subject, teacherFirstName, teacherLastName, enterYear);
    }
}
