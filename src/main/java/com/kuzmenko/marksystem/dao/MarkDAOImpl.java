package com.kuzmenko.marksystem.dao;

import com.kuzmenko.marksystem.model.Mark;
import com.kuzmenko.marksystem.util.HibernateAnnotationUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class MarkDAOImpl extends HibernateAnnotationUtil implements MarkDAO {

    @Override
    public void add(Mark mark) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        session.save(mark);
        tr.commit();
        System.out.println("Mark saved!");
    }

    @Override
    public List<Mark> getAll() {
        session = getSession();
        Query query = session.createQuery("from Mark");
        List<Mark> marks = query.list();
        System.out.println("Marks got!");
        return marks;
    }

    @Override
    public Mark getById(Integer id) {
        session = getSession();
        Mark mark = session.get(Mark.class, id);
        System.out.println("Mark got!");
        return mark;
    }

    @Override
    public void update(Mark mark) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        session.update(mark);
        tr.commit();
        System.out.println("Mark updated!");
    }

    @Override
    public void remove(Mark mark) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        session.delete(mark);
        tr.commit();
        System.out.println("Mark removed!");
    }

    @Override
    public void removeById(Integer id) {
        session = getSession();
        Transaction tr = session.beginTransaction();
        Mark mark = session.load(Mark.class, id);
        session.delete(mark);
        tr.commit();
        System.out.println("Mark removed!");
    }
}

