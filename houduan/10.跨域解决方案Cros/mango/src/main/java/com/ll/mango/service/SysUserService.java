package com.ll.mango.service;

import com.ll.mango.entity.SysUser;

import java.util.List;

public interface SysUserService{
    /**
     * 查询全部用户信息
     * @return
     */
    List<SysUser> findAll();


}
