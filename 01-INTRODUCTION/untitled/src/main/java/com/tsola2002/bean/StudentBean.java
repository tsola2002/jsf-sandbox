package com.tsola2002.bean;

import com.tsola2002.entity.Student;
import com.tsola2002.service.StudentService;
import jakarta.faces.view.ViewScoped;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
//import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

//@Named
@ViewScoped
public class StudentBean implements Serializable {
    private Student student = new Student();

    private List<Student> students;

    private StudentService service = new StudentService();

    @PostConstruct
    public void init() {

        students = service.list();

    }

    public void save() {

        if (student.getId() == null)
            service.save(student);
        else
            service.update(student);

        student = new Student();

        students = service.list();

    }

    public void edit(Student s) {

        student = s;

    }

    public void delete(Student s) {

        service.delete(s);

        students = service.list();

    }

    public Student getStudent() {

        return student;

    }

    public void setStudent(Student student) {

        this.student = student;

    }

    public List<Student> getStudents() {

        return students;

    }
}
