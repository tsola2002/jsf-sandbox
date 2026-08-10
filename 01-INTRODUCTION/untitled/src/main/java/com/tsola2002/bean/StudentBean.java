package com.tsola2002.bean;

import com.tsola2002.entity.Student;
import com.tsola2002.service.StudentService;


import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "studentBean")
@ViewScoped
public class StudentBean implements Serializable {
    private Student student = new Student();

    private List<Student> students;

    private StudentService service = new StudentService();


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
