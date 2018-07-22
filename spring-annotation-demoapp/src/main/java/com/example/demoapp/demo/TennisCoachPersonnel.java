package com.example.demoapp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TennisCoachPersonnel implements CoachPersonnel    {

    @Value("${tenniscoach.name}")
    private String name;

    @Value("${tenniscoach.houseNumber}")
    private int houseNumber;

    @Value("${tenniscoach.houseStreet}")
    private String houseStreet;

    private String phoneNumber;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String getHouseStreet() {
        return houseStreet;
    }

    @Override
    @Autowired
    @Value("${tenniscoach.phoneNumbers}")
    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumber = phoneNumbers[0];
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
}