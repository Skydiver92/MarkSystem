package com.kuzmenko.marksystem.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "mark")
public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer mark;
    private String date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_student")
    private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_subject")
    private Subject subject;

    public Mark() {
    }

    public Mark(Integer mark, String date, Student student, Subject subject) {
        this.mark = mark;
        this.date = date;
        this.student = student;
        this.subject = subject;
    }

    public Mark(Integer id, Integer mark, String date, Student student, Subject subject) {
        this.id = id;
        this.mark = mark;
        this.date = date;
        this.student = student;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", mark=" + mark +
                ", date='" + date + '\'' +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark1 = (Mark) o;
        return Objects.equals(id, mark1.id) &&
                Objects.equals(mark, mark1.mark) &&
                Objects.equals(date, mark1.date) &&
                Objects.equals(student, mark1.student) &&
                Objects.equals(subject, mark1.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mark, date, student, subject);
    }
}
