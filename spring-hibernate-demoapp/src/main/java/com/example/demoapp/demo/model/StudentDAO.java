package com.example.demoapp.demo.model;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;

@Repository
@Transactional(
    isolation=Isolation.READ_COMMITTED,
    propagation=Propagation.REQUIRED,
    rollbackFor={Exception.class, NullPointerException.class})
public class StudentDAO   {

    @Autowired
    @Qualifier("sessionFactory")
    private LocalSessionFactoryBean sessionFact;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(LocalSessionFactoryBean sessFactBean) {
        this.sessionFact = sessFactBean;
    }

    public Session getSession() {
        return sessionFact.getObject().getCurrentSession();
    }

    public void save(Student stu)   {
        getSession().save(stu);
    }

    public void delete(Student stu) {
        getSession().delete(stu);
    }

    @SuppressWarnings("unchecked")
    public List<Student> getAllStudents()   {
        return getSession().createQuery("from Student").list();
    }

    public Student getByEmail(String email)   {
        return (Student)getSession().createQuery(
            "from Student where email = :email"
        ).setParameter("email", email)
        .uniqueResult();
    }
}