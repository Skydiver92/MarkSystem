package com.kuzmenko.marksystem;

import com.kuzmenko.marksystem.dao.MarkDAOImpl;
import com.kuzmenko.marksystem.dao.StudentDAOImpl;
import com.kuzmenko.marksystem.dao.SubjectDAOImpl;
import com.kuzmenko.marksystem.model.Mark;
import com.kuzmenko.marksystem.model.Student;
import com.kuzmenko.marksystem.model.Subject;

public class Main {
    public static void main(String[] args) {

        StudentDAOImpl studentDAO = new StudentDAOImpl();
        SubjectDAOImpl subjectDAO = new SubjectDAOImpl();
        MarkDAOImpl markDAO = new MarkDAOImpl();
        studentDAO.getSessionFactory();


        Subject math = new Subject("Math", "Boris", "Jonson", 2012);
        Subject physic = new Subject("Physic", "Peter", "Backer", 2011);
        Subject english = new Subject("English", "Mari", "Popins", 2014);
        Subject chemistry = new Subject("Chemistry", "Harry", "Potter", 2017);
        Subject physculture = new Subject("Fizculture", "Boris", "Ivanov", 2016);
        subjectDAO.getSessionFactory();
        subjectDAO.getSession();
        subjectDAO.add(math);
        subjectDAO.add(physic);
        subjectDAO.add(english);
        subjectDAO.add(chemistry);
        subjectDAO.add(physculture);

        Student student1 = new Student("Anton", "Kuzmenko", "1992-01-30", 1, 'M');
        Student student2 = new Student("Boris", "Petrov", "1991-03-22", 2, 'M');
        Student student3 = new Student("Jon", "Newman", "1990-01-10", 3, 'M');
        Student student4 = new Student("Sam", "Bang", "1992-03-13", 1, 'M');
        Student student5 = new Student("Vasia", "Pupcin", "1992-05-30", 1, 'M');
        Student student6 = new Student("Jane", "Mind", "1993-11-18", 1, 'F');
        Student student7 = new Student("Kate", "Midletone", "1992-02-20", 2, 'F');
        Student student8 = new Student("Sara", "Conor", "1992-07-24", 1, 'F');
        Student student9 = new Student("Anton", "Pertov", "1993-08-27", 1, 'M');
        Student student10 = new Student("Peter", "Skudra", "1989-012-30", 4, 'M');
        studentDAO.add(student1);
        studentDAO.add(student2);
        studentDAO.add(student3);
        studentDAO.add(student4);
        studentDAO.add(student5);
        studentDAO.add(student6);
        studentDAO.add(student7);
        studentDAO.add(student8);
        studentDAO.add(student9);
        studentDAO.add(student10);

        Mark m1 = new Mark(3, "2018-10-20", student1, math);
        Mark m2 = new Mark(5, "2018-10-19", student2, math);
        Mark m3 = new Mark(7, "2018-10-21", student2, math);
        Mark m4 = new Mark(9, "2018-10-21", student3, physic);
        Mark m5 = new Mark(9, "2018-10-21", student4, physculture);
        Mark m6 = new Mark(8, "2018-10-22", student6, english);
        Mark m7 = new Mark(7, "2018-10-20", student5, math);
        Mark m8 = new Mark(8, "2018-10-20", student8, english);
        Mark m9 = new Mark(8, "2018-10-19", student8, chemistry);
        Mark m10 = new Mark(10, "2018-10-22", student10, physculture);
        Mark m11 = new Mark(8, "2018-10-20", student9, physic);
        Mark m12 = new Mark(6, "2018-10-22", student9, physic);
        Mark m13 = new Mark(7, "2018-10-20", student1, math);
        markDAO.add(m1);
        markDAO.add(m2);
        markDAO.add(m3);
        markDAO.add(m4);
        markDAO.add(m5);
        markDAO.add(m6);
        markDAO.add(m7);
        markDAO.add(m8);
        markDAO.add(m9);
        markDAO.add(m10);
        markDAO.add(m11);
        markDAO.add(m12);
        markDAO.add(m13);


        //students
        System.out.println(studentDAO.getById(5).toString());

        for (Student st : studentDAO.getAll()) {
            System.out.println(st.toString());
        }

        studentDAO.update(new Student(1, "Oooowwwwwwo", "Bbbbbb", "1992-01-01", 2, 'M'));

        studentDAO.removeById(5);


        //marks

        System.out.println(markDAO.getById(5).toString());

        for (Mark mk : markDAO.getAll()) {
            System.out.println(mk.toString());
        }

        markDAO.update(new Mark(1,10, "2018-02-22",student1,math));

        markDAO.removeById(6);


        //subject

        System.out.println(subjectDAO.getById(5).toString());

        for (Subject sb : subjectDAO.getAll()) {
            System.out.println(sb.toString());
        }

        subjectDAO.update(new Subject(5,"Russian", "Ivanova", "Galina", 2013));

        markDAO.removeById(4);


        studentDAO.closeSession();

    }
}
