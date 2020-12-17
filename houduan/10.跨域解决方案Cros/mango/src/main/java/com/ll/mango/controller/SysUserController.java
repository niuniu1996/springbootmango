package com.ll.mango.controller;


import com.ll.mango.service.SysUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


//被RestController注解的接口控制器默认使用JSON格式交互，返回JSON结果
@RestController
@RequestMapping("user")
public class SysUserController {
    private static Logger logger = Logger.getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/findAll")
    public Object findAll() {
        logger.info("调用查询所有用户接口");
        return sysUserService.findAll();
    }

}
