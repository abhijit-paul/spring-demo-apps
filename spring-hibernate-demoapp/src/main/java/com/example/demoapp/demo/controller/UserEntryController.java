package com.example.demoapp.demo.controller;

import java.util.Optional;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.example.demoapp.demo.model.User;
import com.example.demoapp.demo.model.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.dao.IncorrectResultSizeDataAccessException;


@RestController
public class UserEntryController    {

    @Autowired
    @Qualifier("userDAO")
    private UserDAO dao;

    @RequestMapping("/createuser/{username}")
    public String createUser(
            @PathVariable("username") String username,
            @RequestParam("occupation") String occupation,
            @RequestParam("useremail") Optional<String> useremail,
            @RequestParam("joinDate") Optional<String> joinDate,
            ModelMap model) {
        Date d = null;
        DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
        if(joinDate.isPresent())    {
            try {
                d = dF.parse(joinDate.get());
            }
            catch(ParseException pEx)   {
                pEx.printStackTrace();
                d = new Date();
            }
        }
        else {
            d = new Date();
        }

        User u = new User(
            username,
            occupation,
            useremail.isPresent() ? useremail.get() : null,
            d
        );
        dao.save(u);
        return "Created User: "+u.toString();
    }

    @RequestMapping("/getuserbyid/{id}")
    public User getUserById(
            @PathVariable("id") String id,
            ModelMap model) {
        return dao.getById(Integer.parseInt(id));
    }

    @RequestMapping("/getuserbyemail")
    public List<User> getUserByEmail(
            @RequestParam("email") String email,
            @RequestParam("id") Optional<String> id,
            ModelMap model) {

        List<User> users;

        if (id.isPresent()) {
            try {
                users = Arrays.asList(dao.getByEmailAndId(
                    email,
                    Integer.parseInt(id.get())
                ));
            }
            catch(NullPointerException npEx)    {
                users = new ArrayList<User>();
            }
        }

        try {
            users = Arrays.asList(dao.getByEmail(email));
        }
        catch (NullPointerException npEx)   {
            users = new ArrayList<>();
        }
        catch(IncorrectResultSizeDataAccessException irEx)  {
            List<User> allUsers = dao.getAllByEmail(email);
            users = allUsers;
        }
        catch (Exception ex)    {
            users = new ArrayList<>();
        }
        return users;
        /*return ResponseEntity
            .ok()
            .cacheControl(CacheControl.maxAge(100, TimeUnit.SECONDS))
            .body(users);*/
    }

    @RequestMapping("/updateuseremail/{id}")
    public String updateUserEmailById(
            @PathVariable("id") String id,
            @RequestParam("email") String email,
            ModelMap model) {
        User u = dao.getById(Integer.parseInt(id));
        u.setEmail(email);
        dao.update(u);
        return "Updated to " + u.toString();
    }

    @RequestMapping("/deleteuser/{id}")
    public String deleteUserById(
            @PathVariable("id") String id,
            ModelMap model) {
        try {
            User u = dao.getById(Integer.parseInt(id));
            dao.delete(u);
            return "Deleted this user " + u.toString();
        }
        catch(IllegalArgumentException ieEx)    {
            return "IL User not found";
        }
    }

    @GetMapping("/publish/{message}")
    public String postMessage(@PathVariable("message") final String message)    {
        return "Publish success";
    }
}