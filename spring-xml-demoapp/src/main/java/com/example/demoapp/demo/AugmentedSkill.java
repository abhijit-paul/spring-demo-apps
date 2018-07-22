package com.example.demoapp.demo;

import java.util.EmptyStackException;

public class AugmentedSkill implements Skill {

    private String skillDescription;

    public AugmentedSkill(String skillDescription) {
        this.skillDescription = skillDescription;
    }

    public void alterSkillDescription(String skillDescription)   {
        this.skillDescription = skillDescription;
    }

    @Override
    public String display()  {
        if (null != skillDescription)   {
            return skillDescription;
        }
        else {
            throw new EmptyStackException();
        }
    }
}