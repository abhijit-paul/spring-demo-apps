package com.example.demoapp.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import com.example.demoapp.demo.dao.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoJSPController  {

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/demojsp")
    public String jspDispatcher(HttpServletRequest request, ModelMap model)   {
        User user = context.getBean("user", User.class);
        model.addAttribute("user", user);
        return "hello";
    }
}