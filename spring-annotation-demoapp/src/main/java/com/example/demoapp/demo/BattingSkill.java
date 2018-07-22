package com.example.demoapp.demo;

import org.springframework.stereotype.Component;

@Component
public class BattingSkill implements Skill  {
    public String display()    {
        return "Stroke practice a hanging ball for half an hour";
    }
}