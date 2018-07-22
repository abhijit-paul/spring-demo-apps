package com.example.demoapp.demo;

import org.springframework.stereotype.Component;

@Component
public class HittingSkill implements Skill  {
    public String display()    {
        return "Throw a ball in the air and hit it to go up at 45";
    }
}