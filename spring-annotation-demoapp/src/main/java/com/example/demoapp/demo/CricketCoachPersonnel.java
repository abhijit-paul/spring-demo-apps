package com.example.demoapp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CricketCoachPersonnel implements CoachPersonnel    {

    @Value("${cricketcoach.name}")
    private String name;

    @Value("${cricketcoach.houseNumber}")
    private int houseNumber;

    @Value("${cricketcoach.houseStreet}")
    private String houseStreet;

    @Value("${cricketcoach.phoneNumbers}")
    private String[] phoneNumbers;

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
    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumbers[0];
    }
}