package com.kuzmenko.marksystem.dao;

import com.kuzmenko.marksystem.model.Subject;
import com.kuzmenko.marksystem.util.HibernateAnnotationUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SubjectDAOImpl extends HibernateAnnotationUtil implements SubjectDAO {

    @Override
    public void add(Subject subject) {
        getSession();
        Transaction tr = session.beginTransaction();
        session.save(subject);
        tr.commit();
        System.out.println("Subject saved!");
        closeSession();
    }

    @Override
    public List<Subject> getAll() {
        getSession();
        Query query = session.createQuery("from Subject");
        List<Subject> subjects = query.list();
        System.out.println("Subjects got!");
        closeSession();
        return subjects;
    }

    @Override
    public Subject getById(Integer id) {
        getSession();
        Subject subject = session.get(Subject.class, id);
        System.out.println("Subject got!");
        closeSession();
        return subject;
    }

    @Override
    public void update(Subject subject) {
        getSession();
        Transaction tr = session.beginTransaction();
        session.update(subject);
        tr.commit();
        System.out.println("Subject updated!");
        closeSession();
    }

    @Override
    public void remove(Subject subject) {
        getSession();
        Transaction tr = session.beginTransaction();
        session.delete(subject);
        tr.commit();
        System.out.println("Subject removed!");
        closeSession();
    }

    @Override
    public void removeById(Integer id) {
        getSession();
        Transaction tr = session.beginTransaction();
        session.remove(id);
        tr.commit();
        System.out.println("Subject removed!");
        closeSession();
    }
}
