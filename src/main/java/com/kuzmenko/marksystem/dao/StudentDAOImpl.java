package com.kuzmenko.marksystem.dao;

import com.kuzmenko.marksystem.model.Student;
import com.kuzmenko.marksystem.util.HibernateAnnotationUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl extends HibernateAnnotationUtil implements StudentDAO {

    @Override
    public void add(Student student) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        session.save(student);
        tr.commit();
        System.out.println("Student saved!");
        closeSession();
    }

    @Override
    public List<Student> getAll() {
        session = getSession();
        Query query = session.createQuery("from Student");
        List<Student> students = query.list();
        System.out.println("Students got!");
        closeSession();
        return students;
    }

    @Override
    public Student getById(Integer id) {
        session = getSession();
        Student student = session.get(Student.class, id);
        System.out.println("Student got!");
        closeSession();
        return student;
    }

    @Override
    public void update(Student student) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        session.update(student);
        tr.commit();
        System.out.println("Student updated!");
        closeSession();
    }

    @Override
    public void remove(Student student) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        tr.commit();
        System.out.println("Student removed!");
        closeSession();
    }

    @Override
    public void removeById(Integer id) {
        getSession();
        Transaction tr = session.beginTransaction();
        Student student = session.load(Student.class, id);
        session.delete(student);
        tr.commit();
        System.out.println("Student removed!");
        closeSession();
    }
}
