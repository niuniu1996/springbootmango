package com.ll.mango.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping(value = "/hello")
    public Object hello() {
        return "Hello liu&xiao!";
    }
}