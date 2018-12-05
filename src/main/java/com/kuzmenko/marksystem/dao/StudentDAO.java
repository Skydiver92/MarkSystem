package com.kuzmenko.marksystem.dao;

        import com.kuzmenko.marksystem.model.Student;

        import java.util.List;

public interface StudentDAO {

    //create
    void add(Student student);

    //read
    List<Student> getAll();

    Student getById(Integer id);

    //update
    void update(Student student);

    //delete
    void remove(Student student);

    void removeById(Integer id);

}
