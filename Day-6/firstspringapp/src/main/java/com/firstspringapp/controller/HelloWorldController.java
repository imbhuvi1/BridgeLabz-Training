package com.firstspringapp.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello World !";
    }

    @GetMapping("/hello/query")
    public String helloName(@RequestParam String name){
        return "Hello "+name;
    }

}
