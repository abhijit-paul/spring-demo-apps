package com.example.demoapp.demo.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="student")
public class Student    {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Email
    @NotNull
    private String email;

    @Column(name="join_date")
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return firstName+":"+lastName+":"+email;
    }

    public Student(String firstName, String lastName, String email, Date joinDate, User u) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.joinDate = joinDate;
        this.user = u;
    }

    public Student()    {

    }
}