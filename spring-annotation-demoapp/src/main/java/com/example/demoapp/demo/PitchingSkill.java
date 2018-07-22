package com.example.demoapp.demo;

import org.springframework.stereotype.Component;

@Component
public class PitchingSkill implements Skill {

    public String display()  {
        return "Throw a putshot on a marked target in a wall";
    }
}