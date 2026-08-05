package com.tsola2002.service;

import com.tsola2002.dao.StudentDAO;
import com.tsola2002.entity.Student;

import java.util.List;

public class StudentService {

    StudentDAO dao=new StudentDAO();

    public void save(Student student){

        dao.save(student);

    }

    public void update(Student student){

        dao.update(student);

    }

    public void delete(Student student){

        dao.delete(student);

    }

    public List<Student> list(){

        return dao.findAll();

    }

}
