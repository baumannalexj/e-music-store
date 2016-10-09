package com.hellospringdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Alexander on 009 10 9 2016 .
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

}
