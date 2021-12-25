package com.example.udemyCourse.springBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/hello-World")
    public String helloWorld(){
    return "Hello World";
    }
}
