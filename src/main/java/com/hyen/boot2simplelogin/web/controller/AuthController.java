package com.hyen.boot2simplelogin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping(value = "/")
    public String login(){
        return "login/login";
    }

    @GetMapping(value = "welcome")
    public String welocome(){
        return "login/welcome";
    }

}
