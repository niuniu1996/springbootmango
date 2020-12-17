package com.ll.mango.admin.service.impl;

import com.ll.mango.admin.constants.SysConstants;
import com.ll.mango.admin.dao.SysMenuMapper;
import com.ll.mango.admin.dao.SysRoleMapper;
import com.ll.mango.admin.dao.SysRoleMenuMapper;
import com.ll.mango.admin.po.SysMenu;
import com.ll.mango.admin.po.SysRole;
import com.ll.mango.admin.po.SysRoleMenu;
import com.ll.mango.admin.service.SysRoleService;
import com.ll.mango.core.page.MybatisPageHelper;
import com.ll.mango.core.page.PageRequest;
import com.ll.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 奥特曼
 * @version 1.0
 * @date 2020/12/5 0005 下午 20:30
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Override
    public int save(SysRole record) {
        if (sysRoleMapper.selectByPrimaryKey(record.getId()) == null) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("name");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysRoleMapper, "findPageByName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysRoleMapper);
    }

    @Override
    public List<SysRole> findByName(String name) {
        return sysRoleMapper.findByName(name);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.findAll();
    }

    @Override
    public List<SysRole> findPage() {
        return sysRoleMapper.findPage();
    }


    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if (sysRole != null) {
            if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
                // 如果是超级管理员，返回全部
                return sysMenuMapper.findAll();
            }
            return sysMenuMapper.findRoleMenus(roleId);
        }
        return null;
    }

    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if(records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        sysRoleMenuMapper.deleteByRoleId(roleId);
        for(SysRoleMenu record:records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }


}
