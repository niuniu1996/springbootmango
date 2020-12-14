package com.ll.mango.admin.controller;

import com.ll.mango.admin.constants.SysConstants;
import com.ll.mango.admin.po.SysUser;
import com.ll.mango.admin.service.SysUserService;
import com.ll.mango.admin.util.PasswordUtils;
import com.ll.mango.common.utils.FileUtils;
import com.ll.mango.core.http.HttpResult;
import com.ll.mango.core.page.PageRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

//被RestController注解的接口控制器默认使用JSON格式交互，返回JSON结果
@RestController
@RequestMapping("user")
public class SysUserController {
    private static Logger logger = Logger.getLogger(SysUserController.class);
    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有用户
     *
     * @return
     */
    @PostMapping("/findAll")
    public Object findAll() {
        logger.info("查询用户表所有用户");
        return sysUserService.findAll();
    }

    /**
     * 分页查询用户信息
     *
     * @param pageRequest
     * @return
     */
    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        logger.info("分页查询用户信息");
        logger.error("请求参数是：" + pageRequest.toString());
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    /**
     * 根据用户名得到SysUser信息
     *
     * @param name
     * @return
     */
    @PostMapping("/findByName")
    public HttpResult findByName(@RequestBody String name) {
        logger.info("根据用户名" + name + "模糊得到List<SysUser>信息");
        return HttpResult.ok(sysUserService.findByName(name));
    }

    /**
     * @param pageRequest
     * @param res
     */
    @PostMapping("/exportExcelUser")
    public void exportExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        logger.info("导出excel报表开始");
        logger.info("创建用户信息excel文件");
        File file = sysUserService.creatUserExcelFile(pageRequest);
        logger.info("下载文件");
        FileUtils.downloadFile(res, file, file.getName());
    }

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysUser record) {
        logger.info("根据用户信息保存用户数据开始");
        SysUser user = sysUserService.findById(record.getId());
        if (user != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(user.getName())) {
                return HttpResult.error("超级管理员不允许被修改!");
            }
        }
        if (record.getPassword() != null) {
            String salt = PasswordUtils.getSalt();
            if (user == null) {
                // 新增用户
                //通过用户名完整匹配查询
                if (sysUserService.findByWholeName(record.getName()) != null) {
                    return HttpResult.error("用户名已存在!");
                }
                String password = PasswordUtils.encode(record.getPassword(), salt);
                record.setSalt(salt);
                record.setPassword(password);
            } else {
                // 修改用户, 且修改了密码
                if (!record.getPassword().equals(user.getPassword())) {
                    String password = PasswordUtils.encode(record.getPassword(), salt);
                    record.setSalt(salt);
                    record.setPassword(password);
                }
            }
        }
        return HttpResult.ok(sysUserService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody List<SysUser> records) {
        logger.info("根据用户集合信息删除用户数据开始");
        for (SysUser record : records) {
            SysUser sysUser = sysUserService.findById(record.getId());
            if (sysUser != null && SysConstants.ADMIN.equalsIgnoreCase(sysUser.getName())) {
                return HttpResult.error("超级管理员不允许删除!");
            }
        }
        return HttpResult.ok(sysUserService.delete(records));
    }
    @PostMapping(value="/findPermissions")
    public HttpResult findPermissions(@RequestParam String name) {
        logger.info("根据用户名"+name+"查找菜单权限列表");
        return HttpResult.ok(sysUserService.findPermissions(name));
    }
    @PostMapping(value="/findUserRoles")
    public HttpResult findUserRoles(@RequestParam Long userId) {
        logger.info("根据用户id"+userId+"查找用户角色列表");
        return HttpResult.ok(sysUserService.findUserRoles(userId));
    }
}
