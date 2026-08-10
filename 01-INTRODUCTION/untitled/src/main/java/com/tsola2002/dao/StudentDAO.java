package com.tsola2002.dao;

import com.tsola2002.entity.Student;
import com.tsola2002.repository.JpaUtil;


import javax.persistence.EntityManager;
import java.util.List;

public class StudentDAO {

    public void save(Student student){

        EntityManager em= JpaUtil.getEntityManager();

        em.getTransaction().begin();

        em.persist(student);

        em.getTransaction().commit();

        em.close();

    }

    public List<Student> findAll(){

        EntityManager em=JpaUtil.getEntityManager();

        return em.createQuery("from Student",Student.class)
                .getResultList();

    }

    public void update(Student student){

        EntityManager em=JpaUtil.getEntityManager();

        em.getTransaction().begin();

        em.merge(student);

        em.getTransaction().commit();

        em.close();

    }

    public void delete(Student student) {

        EntityManager em = JpaUtil.getEntityManager();

        em.getTransaction().begin();

        Student s = em.merge(student);

        em.remove(s);

        em.getTransaction().commit();

        em.close();
    }
}
