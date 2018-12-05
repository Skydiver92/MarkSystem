package com.kuzmenko.marksystem.dao;

import com.kuzmenko.marksystem.model.Subject;

import java.util.List;

public interface SubjectDAO {

    //create
    void add(Subject subject);

    //read
    List<Subject> getAll();

    Subject getById(Integer id);

    //update
    void update(Subject subject);

    //delete
    void remove(Subject subject);

    void removeById(Integer id);

}
