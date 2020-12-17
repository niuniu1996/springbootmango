package com.ll.mango.controller;


import com.ll.mango.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//被RestController注解的接口控制器默认使用JSON格式交互，返回JSON结果
@RestController
@RequestMapping("user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

}
