package com.hyen.boot2simplelogin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping(value = "hi")
    public String welcome(){
        return "login/login";
    }
}
