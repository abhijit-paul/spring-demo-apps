package com.example.demoapp.demo.model;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Transactional(propagation=Propagation.REQUIRED)
public class UserDAO    {

    @Autowired
    @Qualifier("sessionFactory")
    private LocalSessionFactoryBean sessionBean;

    public Session getSession() {
        return sessionBean.getObject().getCurrentSession();
    }

    public void save(User u) {
        getSession().save(u);
    }

    public User getById(int id) {
        return getSession().get(User.class, id);
    }

    public User getByEmail(String email)  {
        return (User)getSession().createQuery(
            "from User where email = :email"
        ).setParameter("email", email)
        .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllByEmail(String email)  {
        return (List<User>)getSession().createQuery(
            "from User where email = :email"
        ).setParameter("email", email).getResultList();
    }

    public User getByEmailAndId(String email, int id)   {
        return (User)getSession().createQuery(
            "from User where email = :email and id = :id"
        ).setParameter("email", email)
        .setParameter("id", id)
        .uniqueResult();
    }

    public void update(User user)    {
        getSession().update(user);
    }

    public void delete(User user)   {
        getSession().delete(user);
    }
}