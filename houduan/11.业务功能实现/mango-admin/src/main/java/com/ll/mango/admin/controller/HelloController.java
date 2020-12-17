package com.ll.mango.admin.controller;


import com.ll.mango.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping(value="/hello")
    public Object hello() {
        return "Hello liu&xiao!";
    }

    /**
     * 调用关系，提供方-调用方类似功能
     * @return
     */
    @PostMapping(value="/MtO")
    public Object MtO() {
        return sysUserService.MtO();
    }



    
}