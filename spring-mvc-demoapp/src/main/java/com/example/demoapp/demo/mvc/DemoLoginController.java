package com.example.demoapp.demo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class DemoLoginController    {

    @RequestMapping("/login")
    public String loginDispatcher(HttpServletRequest request, Model model)   {
        String name = request.getParameter("name");
        String pass = request.getParameter("password");
        if(("abhijit".equalsIgnoreCase(name) || "paul".equalsIgnoreCase(name)) &&
            "local123".equalsIgnoreCase(pass))    {
                model.addAttribute("status", "success");
                return "loggedin";
        }
        else {
            model.addAttribute("status", "Failed");
            return "signin-error";
        }
    }
}