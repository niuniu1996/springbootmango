package com.ll.mango.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @PostMapping(value="/hello")
    public Object hello() {
        return "Hello liu&xiao!";
    }
    
}