package com.example.demoapp.demo.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javassist.tools.web.BadHttpRequest;

@Aspect
@Component
public class UserLogin  {

    @Before("execution(public com.example.demoapp.demo.model.User getUserById(String, org.springframework.ui.ModelMap))")
    public void loginUser(JoinPoint jPoint) throws BadHttpRequest {
        String userId = jPoint.getArgs()[0].toString();
        if(!"8".equals(userId)) {
            throw new BadHttpRequest();
        }
    }

    @AfterReturning("execution(public com.example.demoapp.demo.model.User getUserById(String, org.springframework.ui.ModelMap))")
    public void returnAppropriateReturn(JoinPoint jPoint)   {
        System.out.println(
            "###########This user is returned " +
            jPoint.getArgs()[0].toString() +
            " ##############"
            );
    }
}