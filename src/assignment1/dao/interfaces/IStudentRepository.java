package assignment1.dao.interfaces;


import assignment1.Student;

import java.util.ArrayList;

public interface IStudentRepository {

    ArrayList<Student> all();
    Boolean create(Student student);
    Boolean update(Student student);
    Boolean delete(Student student);
}
