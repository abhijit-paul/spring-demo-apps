package com.example.demoapp.demo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/v2")
public class DemoLoginAnnotateRQPrm {

    @RequestMapping("/login")
    public String jspDispatch(
            @RequestParam("name") String name,
            @RequestParam("password") String pass,
            Model model)  {
        if (("abhijit".equalsIgnoreCase(name) || "paul".equalsIgnoreCase(name)) &&
                "local123".equalsIgnoreCase(pass))  {
            model.addAttribute("status", "success");
            return "loggedin";
        }
        else {
            model.addAttribute("status", "Failed");
            return "signin-error";
        }
    }
}