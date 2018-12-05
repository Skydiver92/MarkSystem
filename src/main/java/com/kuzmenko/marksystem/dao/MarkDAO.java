package com.kuzmenko.marksystem.dao;

import com.kuzmenko.marksystem.model.Mark;

import java.util.List;

public interface MarkDAO {

    //create
    void add(Mark mark);

    //read
    List<Mark> getAll();

    Mark getById(Integer id);

    //update
    void update(Mark mark);

    //delete
    void remove(Mark mark);

    void removeById(Integer id);

}
