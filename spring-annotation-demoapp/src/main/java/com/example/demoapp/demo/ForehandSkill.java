package com.example.demoapp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ForehandSkill implements Skill {

    @Value("right")
    private String handedness;

    public void setHandedness(String hand)  {
        this.handedness = hand;
    }

    public String getHandedness()   {
        return handedness;
    }

    public String getOppositeSide(String side) {
        if("right".equalsIgnoreCase(side)) {
            return "left";
        }
        else if("left".equalsIgnoreCase(side))  {
            return "right";
        }
        else {
            return "";
        }
    }

    @Override
    public String display()    {
        return String.join(" ",
            "Step to your", getOppositeSide(handedness),
            "and hit the ball from your", handedness
        );
    }
}