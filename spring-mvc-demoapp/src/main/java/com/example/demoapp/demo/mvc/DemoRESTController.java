package com.example.demoapp.demo.mvc;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRESTController {

    @RequestMapping("/demorest/{name}")
    public String restDispatcher(@PathVariable("name") String name)  {
        return "Hello "+Character.toUpperCase(name.charAt(0)) + name.substring(1);
    }
}