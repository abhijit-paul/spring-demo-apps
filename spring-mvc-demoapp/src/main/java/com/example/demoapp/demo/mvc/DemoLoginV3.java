package com.example.demoapp.demo.mvc;

import javax.validation.Valid;

import com.example.demoapp.demo.dao.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/v3")
public class DemoLoginV3    {

    @RequestMapping("/login")
    public String jspDispatcher(
            @Valid @ModelAttribute("user") User user,
            BindingResult validationResult,
            Model model)   {
        if(validationResult.hasErrors())    {
            model.addAttribute("status", "Validation failed");
            return "hello";
        }
        if(("abhijit".equalsIgnoreCase(user.getName()) || "paul".equalsIgnoreCase(user.getName())) &&
                "local123".equalsIgnoreCase(user.getPassword()) )   {
            model.addAttribute("status", "success");
            return "loggedin-v3";
        }
        else {
            model.addAttribute("status", "Failed");
            return "signin-error";
        }
    }
}
