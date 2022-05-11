package com.example.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String clientPage(){//trang chủ đầu tiên nhìn thấy
        return "client/home";
    }
    @GetMapping("/login")
    public String loginPage() {
        return "client/login";
    }

    @GetMapping("/contact")
    public String contactPage() {
        return "client/contact";
    }
}
