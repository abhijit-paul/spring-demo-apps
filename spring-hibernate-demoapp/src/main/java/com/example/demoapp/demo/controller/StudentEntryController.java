package com.example.demoapp.demo.controller;

import java.util.Date;

import com.example.demoapp.demo.model.Student;
import com.example.demoapp.demo.model.StudentDAO;
import com.example.demoapp.demo.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentEntryController  {

    @Autowired
    private StudentDAO dao;

    @RequestMapping("/")
    public String jspDispatcher(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            ModelMap model)  {
        User u = new User(
            firstName+" "+lastName,
            "Description",
            firstName+"."+lastName+"@hello.com",
            new Date());
        Student stu = new Student(
            firstName, lastName,
            firstName.toLowerCase()+"."+lastName.toLowerCase()+"@blippar.com",
            new Date(),
            u);
        dao.save(stu);
        return "Saved Student "+stu;
    }
}