package com.example.securityhibernate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/home")
    public String getHome(){
        return "home";
    }
    @RequestMapping("/hello")
    public String getHello(){
        return "hello";
    }
}
