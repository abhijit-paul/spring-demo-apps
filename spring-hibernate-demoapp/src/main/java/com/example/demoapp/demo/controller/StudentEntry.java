package com.example.demoapp.demo.controller;

import javax.validation.Valid;

import com.example.demoapp.demo.model.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/v1")
public class StudentEntry    {

    @RequestMapping("/saveStudent")
    public String jspDispatcher(
            @Valid @ModelAttribute("student") Student student,
            BindingResult validationResult,
            Model model)   {
        if(validationResult.hasErrors())    {
            model.addAttribute("status", "Validation failed");
            return "studententry";
        }
        else {
            model.addAttribute("status", "Failed");
            return "studententry";
        }
    }
}
