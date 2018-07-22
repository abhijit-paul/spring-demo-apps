package com.example.demoapp.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Required;

@Entity
@Table(name="user")
public class User   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String occupation;

    @Email
    @Column
    private String email;

    @Column(name="join_date")
    @Temporal(TemporalType.DATE)
    private Date joinDate;

    public User() {
    }

    public User(String name, String occupation, String email, Date joinDate)   {
        this.name = name;
        if(null != email)   {
            this.email = email;
        }
        this.occupation = occupation;
        this.joinDate = joinDate;
    }

    @Override
    public String toString() {
        return name+" : " + email + " : " + occupation;
    }

    @Required
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }
}
