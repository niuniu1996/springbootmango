package com.ll.mango.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @PostMapping(value="/hello")
    public Object hello() {
        return "Hello liu&xiao!";
    }
    
}