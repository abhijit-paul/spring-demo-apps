package com.example.demoapp.demo;

import org.springframework.stereotype.Component;

@Component
public class BowlingSkill implements Skill {
    public String display()    {
        return "Run 6 steps with acceleration of 2 m/s";
    }
}