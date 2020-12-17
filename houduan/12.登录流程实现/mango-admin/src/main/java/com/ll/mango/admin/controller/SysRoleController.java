package com.ll.mango.admin.controller;

import com.ll.mango.admin.constants.SysConstants;
import com.ll.mango.admin.dao.SysRoleMapper;
import com.ll.mango.admin.po.SysRole;
import com.ll.mango.admin.po.SysRoleMenu;
import com.ll.mango.admin.service.impl.SysRoleServiceImpl;
import com.ll.mango.core.http.HttpResult;
import com.ll.mango.core.page.PageRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/12/5 0005 下午 20:17
 */
@RestController
@RequestMapping("role")
public class SysRoleController {
    private static Logger logger = Logger.getLogger(SysRoleController.class);
    @Autowired
    private SysRoleServiceImpl sysRoleService;
@Autowired
private  SysRoleMapper sysRoleMapper;
    @PostMapping("/save")
    public HttpResult save(@RequestBody SysRole record) {
        logger.info("根据角色信息保存角色数据开始");
        SysRole sysRole = sysRoleService.findById(record.getId());
        if (sysRole != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                return HttpResult.error("超级管理员不允许修改!");
            }
        }
        // 新增角色
        if ((record.getId() == null || record.getId() == 0) && !sysRoleService.findByName(record.getName()).isEmpty()) {
            return HttpResult.error("角色名已存在!");
        }
        return HttpResult.ok(sysRoleService.save(record));
    }
    @PostMapping("/delete")
    public HttpResult delete(@RequestBody List<SysRole> records) {
        logger.info("根据角色集合信息删除角色数据开始");
        return HttpResult.ok(sysRoleService.delete(records));
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        logger.info("分页查询角色信息");
        logger.error("请求参数是：" + pageRequest.toString());
        return HttpResult.ok(sysRoleService.findPage(pageRequest));
    }
    @PostMapping("/findAll")
    public HttpResult findAll() {
        logger.info("查询角色信息");
        return HttpResult.ok(sysRoleService.findAll());
    }
    @PostMapping("/findRoleMenus")
    public HttpResult findRoleMenus(@RequestParam Long roleId) {
        logger.info("查询角色菜单");
        return HttpResult.ok(sysRoleService.findRoleMenus(roleId));
    }
    @PostMapping(value="/saveRoleMenus")
    public HttpResult saveRoleMenus(@RequestBody List<SysRoleMenu> records) {
        for(SysRoleMenu record:records) {
            logger.info("保存角色菜单");
            SysRole sysRole = sysRoleMapper.selectByPrimaryKey(record.getRoleId());
            if(SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，不允许修改
                return HttpResult.error("超级管理员拥有所有菜单权限，不允许修改！");
            }
        }
        return HttpResult.ok(sysRoleService.saveRoleMenus(records));
    }
}
